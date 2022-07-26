package Challenges;

import java.util.*;

public class CodeChallenge {

    /*
    * Notas:
    * 1- Se asumió que solo va a existir una sola calle
    * 2- Cada calle va a tener la misma cantidad de carriles que de autos
    * 3- la velocidad de cada auto es constante y se adquiere aleatoriamente en cada arranque
    * 4- Se consideró la posibilidad de incluir a los Semáforos incluso dentro de las propias Cuadras, pero opté por excluirlos dado que no me parecía cohesivo.
    * */

    static class Auto{
        private String marca;
        private String modelo;
        private int metrosRecorridos = 0;
        private AutoEstado _state;

        public Auto(String marca, String modelo, AutoEstado _state) {
            this.marca = marca;
            this.modelo = modelo;
            this._state = _state;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public AutoEstado get_state() {
            return _state;
        }

        public void set_state(AutoEstado _state) {
            this._state = _state;
        }

        public int getMetrosRecorridos() {
            return metrosRecorridos;
        }

        public void setMetrosRecorridos(int metrosRecorridos) {
            this.metrosRecorridos = metrosRecorridos;
        }

        // Método que hace funcionar al vehículo
        public void circular(){
            this._state = AutoEstado.ANDANDO;
            this.metrosRecorridos = (int) (Math.random() * 2 + 1);
        }

        // Método que detiene al vehículo
        public void parar(){
            this._state = AutoEstado.PARADO;
            this.metrosRecorridos = 0;
        }

        @Override
        public String toString() {
            return "Auto{" +
                    "marca='" + marca + '\'' +
                    ", modelo='" + modelo + '\'' +
                    ", _state=" + _state +
                    '}';
        }

        //Método que iniciará el recorrido del auto a lo largo de la calle
        public synchronized void arrancar(Map<Cuadra, Semaforo> cuadraSemaforo) {
            // Para ello, el auto tendrá a disposición toda la información de la calle, respecto a las cuadras que la conforman y sus semáforos.
            for (Map.Entry<Cuadra, Semaforo> interseccion :
                    cuadraSemaforo.entrySet()) {

                // Durante cada cuadra, el auto circulará
                this.circular();

                int metrosRecorridos = this.metrosRecorridos;
                int alturaCuadra = interseccion.getKey().getLongitud();

                // Lo hará a lo largo de toda la cuadra
                while (alturaCuadra - metrosRecorridos >= 0){

                    System.out.println("Auto " + this.getModelo() + " - circulando por Cuadra " + interseccion.getKey().getId() + " en altura: " + ((interseccion.getKey().getId()*100) - alturaCuadra));
                    alturaCuadra -= metrosRecorridos;

                }

                //Cuando ya no queden métodos por recorrer dentro de la cuadra, el conductor mirará el semaforo que tiene en frente para comprobar su estado
                System.out.println("Auto " + this.getModelo() + " - parando en el Semaforo " + interseccion.getValue().getId());
                while (interseccion.getValue().get_state().equals(SemaforoEstado.ROJO)){
                    try {
                        if (this.get_state().equals(AutoEstado.ANDANDO)){
                            this.parar();
                        }
                        System.out.println("Auto " + this.getModelo() + " - esperando en el Semaforo " + interseccion.getValue().getId());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            //Una vez fuera superado el último semaforo de la calle, el automovil se irá de la misma.
            System.out.println("Auto " + this.getModelo() + " saliendo de la calle. ");
        }
    }

    static class Semaforo{
        private int id;
        private SemaforoEstado _state;
        private List<SemaforoEstado> states = Arrays.asList(SemaforoEstado.ROJO, SemaforoEstado.VERDE);

        public Semaforo(int id, SemaforoEstado _state) {
            this.id = id;
            this._state = _state;
        }

        public Semaforo(int id) {
            this.id = id;
            this._state = states.get(new Random().nextInt(states.size()));
        }

        public SemaforoEstado get_state() {
            return _state;
        }

        public void set_state(SemaforoEstado _state) {
            this._state = _state;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<SemaforoEstado> getStates() {
            return states;
        }

        public void setStates(List<SemaforoEstado> states) {
            this.states = states;
        }

        public SemaforoEstado changeState(){
            if (_state.equals(SemaforoEstado.ROJO)){
                return SemaforoEstado.VERDE;
            }
            return SemaforoEstado.ROJO;
        }

        // Método para arrancar el semáforo
        public synchronized void encender(){

            //Para simplificar el ejercicio, los semaforos van a funcionar solo por 100s, cambiando de estado cada 10s.
            int cant = 0;
            while(cant < 11){
                try {
                    Thread.sleep(10000);
                    this._state = changeState();
                    System.out.println("Cambiando Semaforo N° " + this.id + " a " + this._state);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cant++;
            }

        }

        @Override
        public String toString() {
            return "Semaforo{" +
                    "_state=" + _state +
                    '}';
        }
    }

    static class Calle{
        private String nombre;
        private int longitud;
        private List<Cuadra> cuadras;

        public Calle(String nombre) {
            int numeroCuadras = 10;
            this.nombre = nombre;
            this.cuadras = new ArrayList<>(numeroCuadras);

            for (int i = 0; i < numeroCuadras; i++) {
                cuadras.add(new Cuadra(i+1));
            }
        }

        public Calle(String nombre, int longitud) {
            int numeroCuadras = longitud / 100 ;
            this.nombre = nombre;
            this.cuadras = new ArrayList<>(numeroCuadras);

            for (int i = 0; i < numeroCuadras; i++) {
                cuadras.add(new Cuadra(i+1));
            }
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getLongitud() {
            return longitud;
        }

        public void setLongitud(int longitud) {
            this.longitud = longitud;
        }

        public List<Cuadra> getCuadras() {
            return cuadras;
        }

        public void setCuadras(List<Cuadra> cuadras) {
            this.cuadras = cuadras;
        }

        @Override
        public String toString() {
            return "Calle{" +
                    "nombre='" + nombre + '\'' +
                    ", longitud=" + longitud +
                    ", cuadras=" + cuadras +
                    '}';
        }
    }

    static class Cuadra{
        private int longitud;
        private int id;

        public Cuadra(int id, int longitud) {
            this.id = id;
            this.longitud = longitud;
        }

        public Cuadra(int id) {
            this.id = id;
            this.longitud = 100;
        }

        public int getLongitud() {
            return longitud;
        }

        public void setLongitud(int longitud) {
            this.longitud = longitud;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Cuadra{" +
                    "id=" + id +
                    ", longitud=" + longitud +
                    '}';
        }
    }

    static class AutoThread extends Thread{

        private Auto auto;
        private Map<Cuadra, Semaforo> cuadraSemaforo;

        public AutoThread(Auto auto) {
            this.auto = auto;
        }

        public AutoThread(Auto auto, Map<Cuadra, Semaforo> cuadraSemaforo) {
            this.auto = auto;
            this.cuadraSemaforo = cuadraSemaforo;
        }

        @Override
        public void start(){
            System.out.println("Starting car for " + this.auto + " - ThreadName: " + this.getName());
            super.start();
        }

        @Override
        public void run(){
            this.auto.arrancar(cuadraSemaforo);
        }


    }

    static class SemaforoThread extends Thread{
        private Semaforo semaforo;

        public SemaforoThread(Semaforo semaforo) {
            this.semaforo = semaforo;
        }

        @Override
        public void start(){
            System.out.println("Starting semaphore for " + this.semaforo + " - ThreadName: " + this.getName());
            super.start();

        }

        @Override
        public void run(){
            this.semaforo.encender();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Auto auto1 = new Auto("Audi", "A1", AutoEstado.PARADO);
        Auto auto2 = new Auto("Audi", "A2", AutoEstado.PARADO);
        Auto auto3 = new Auto("Audi", "A3", AutoEstado.PARADO);
        Auto auto4 = new Auto("Audi", "A4", AutoEstado.PARADO);
        Auto auto5 = new Auto("Audi", "A5", AutoEstado.PARADO);
        Auto auto6 = new Auto("Audi", "A6", AutoEstado.PARADO);

        List<Auto> autos = new ArrayList<>();
        autos.add(auto1);
        autos.add(auto2);
        autos.add(auto3);
        autos.add(auto4);
        autos.add(auto5);
        autos.add(auto6);

        Calle calle = new Calle("Calle Falsa");

        List<Semaforo> semaforos = new ArrayList<>();
        List<Thread> semaforosThread = new ArrayList<>();

        Map<Cuadra, Semaforo> cuadraSemaforo = new LinkedHashMap<>();

        for (int i = 0; i < calle.getCuadras().size(); i++) {
            Semaforo s = new Semaforo(i+1);
            cuadraSemaforo.put(calle.cuadras.get(i), s);
            semaforosThread.add(new SemaforoThread(s));
        }

        List<AutoThread> autosThreads = new ArrayList<>();

        autos.forEach(auto -> {
            autosThreads.add(new AutoThread(auto, cuadraSemaforo));
        });

        semaforosThread.forEach(Thread::start);
        autosThreads.forEach(Thread::start);

    }


}

enum AutoEstado{
    ANDANDO,
    PARADO;
}

enum SemaforoEstado{
    ROJO(10),
    VERDE(10);

    private final int duracion;

    SemaforoEstado(int duracion) {
        this.duracion = duracion;
    }

    public int getDuracion() {
        return duracion;
    }
}
