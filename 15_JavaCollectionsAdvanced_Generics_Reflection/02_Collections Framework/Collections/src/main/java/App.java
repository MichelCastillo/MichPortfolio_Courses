import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class App {

    static class Persona{

        private String nombre;
        private String apellido;
        private Queue<Tarea> tareas; // QUEUE
        private Tarea currentTarea;
        private State _state = State.OCIOSO;

        public Persona(String nombre, String apellido, Queue<Tarea> tareas) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.tareas = tareas;
            this.currentTarea = tareas.poll();
        }

        public State get_state() {
            return _state;
        }

        public void set_state(State _state) {
            this._state = _state;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public Tarea getCurrentTarea() {
            return tareas.poll();
        }

        public void setCurrentTarea(Tarea currentTarea) {
            this.currentTarea = currentTarea;
        }

        private synchronized void trabajar(){

            while (tareas.peek() != null) {
                //sleep
                try {
                    System.out.println(this.getApellido() + ", " + this.getNombre() + " comencé mi tarea: " + this.getCurrentTarea().getDescripcion() + " en el piso " + this.currentTarea.get_piso().getNumero());
                    this._state = State.TRABAJANDO;
                    Thread.sleep((long) currentTarea.getDuracion()*1000);

                    if (tareas.peek() != null){
                        System.out.println(this.getApellido() + ", " + this.getNombre() + " terminé mi tarea. Moviéndome a la siguiente: " + this.tareas.peek().getDescripcion());
                        this._state = State.TRANSICION;
                        Thread.sleep((long) this.get_state().getGap() * 1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(this.getApellido() + ", " + this.getNombre() + " terminé mi turno.");
            this._state = State.OCIOSO;
        }

        @Override
        public String toString() {
            return "Persona{" +
                    "nombre='" + nombre + '\'' +
                    ", apellido='" + apellido + '\'' +
                    ", tareas=" + tareas +
                    ", currentTarea=" + currentTarea +
                    ", _state=" + _state +
                    '}';
        }
    }

    enum State{

        TRABAJANDO("Trabajando..."),
        OCIOSO("Ocio..."),
        TRANSICION("Cambiando de tarea.");

        private String descripcion;
        private int gap;

        State(String descripcion) {
            this.descripcion = descripcion;
            this.gap = (int) (Math.random() * 11 + 1);;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public int getGap() {
            return gap;
        }
    }

    static class Tarea {

        private String descripcion;
        private double duracion; // measured in hours
        private Piso _piso;

        public Tarea(String descripcion, double duracion, Piso _piso) {
            this.descripcion = descripcion;
            this.duracion = duracion;
            this._piso = _piso;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public double getDuracion() {
            return duracion;
        }

        public void setDuracion(double duracion) {
            this.duracion = duracion;
        }

        public Piso get_piso() {
            return _piso;
        }

        public void set_piso(Piso _piso) {
            this._piso = _piso;
        }

        @Override
        public String toString() {
            return "Tarea{" +
                    "descripcion='" + descripcion + '\'' +
                    ", duracion=" + duracion +
                    ", _piso=" + _piso +
                    '}';
        }
    }

    static class Piso{

        private int numero;

        public Piso(int numero) {
            this.numero = numero;
        }

        public int getNumero() {
            return numero;
        }

        @Override
        public String toString() {
            return "Piso{" +
                    "numero=" + numero +
                    '}';
        }
    }

    static class Edificio{

        private List<Piso> pisos;

        public Edificio(List<Piso> pisos) {
            this.pisos = new ArrayList<>();
        }
    }

    static class PersonaThread extends Thread{
        private Persona persona;

        public PersonaThread(Persona persona){
            this.persona = persona;
        }

        @Override
        public void start(){
            System.out.println("Starting thread for:" + this.persona.toString() + " - " + this.getName());

            while (this.persona.get_state().equals(App.State.TRANSICION) || this.persona.get_state().equals(App.State.TRABAJANDO)){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            super.start();
        }

        @Override
        public void run() {
            this.persona.trabajar();
        }

    }

    public static void main(String[] args) {

        Piso piso1 = new Piso(1);
        Piso piso2 = new Piso(2);
        Piso piso3 = new Piso(3);

        List<Piso> pisos = new ArrayList<>();
        pisos.add(piso1);
        pisos.add(piso2);
        pisos.add(piso3);

        Edificio edificio = new Edificio(pisos);

        Tarea programar = new Tarea("Programar Java", 3, piso1);
        Tarea meeting = new Tarea("Atender Call", 2, piso2);
        Tarea jugar = new Tarea("Recreacion", 3, piso3);
        Tarea comer = new Tarea("Comer", 1, piso3);

        List<Tarea> tareas = Arrays.asList(programar, meeting, jugar, comer);

        List<String> nombres = Arrays.asList("Andrea", "David", "Candelaria", "Mich", "Ignacio", "Agustin");
        List<String> apellidos = Arrays.asList("Castillo", "Perez", "Juarez", "Lanaro", "Chao", "Miclniezuk");

        List<Persona> personas = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < (int) (Math.random() * 8 + 1); i++) {
            Queue<Tarea> tareasP = new LinkedList<>();
            for (int j = 0; j < 4; j++) {
                tareasP.add(tareas.get((int) (Math.random() * 3 + 1)));
            }
            Persona persona = new Persona(nombres.get((int) (Math.random() * 5 + 1)), apellidos.get((int) (Math.random() * 5 + 1)), tareasP);

            personas.add(persona);
            threads.add(new PersonaThread(persona));
        }

        threads.forEach(Thread::start);

    }

    }




