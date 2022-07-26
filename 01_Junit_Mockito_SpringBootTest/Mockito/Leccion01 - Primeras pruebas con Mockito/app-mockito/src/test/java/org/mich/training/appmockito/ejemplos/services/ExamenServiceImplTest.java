package org.mich.training.appmockito.ejemplos.services;

import org.junit.jupiter.api.Test;
import org.mich.training.appmockito.ejemplos.models.Examen;
import org.mich.training.appmockito.ejemplos.repositories.ExamenRepository;
import org.mich.training.appmockito.ejemplos.repositories.ExamenRepositoryImpl;
import org.mich.training.appmockito.ejemplos.repositories.ExamenRepositoryOtro;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ExamenServiceImplTest {

    @Test
    void findExamenPorNombre() {

        //A este método lo creamos directamente haciendo Ctrl + Enter ->
        // create Test desde la clase servicio

        //Ya que tenemos la lista, mockeamos el repositorio
        ExamenRepository repository = mock(ExamenRepositoryOtro.class);
        ExamenService service = new ExamenServiceImpl(repository);
        //En caso de que queramos devolver una lista vacia, debemos usar mockito
        // dado que dependemos del contenido de nuestra fuente de datos
        List<Examen> datos = Arrays.asList(new Examen(5L, "Matematicas"),
                new Examen(6L, "Lengua"),
                new Examen(7L, "Historia"));

        //Cuando se invoque findAll del repositorio, devolvemos la lista datos que creamos justo arriba
        when(repository.findAll()).thenReturn(datos);

        Optional<Examen> examen = service.findExamenPorNombre("Matematicas");
        //Inlcusive usando ExamenRepositoryOtro, el test pasa dado que nunca se llama el método de esa clase
        // sino que se usa la implementación del Mock

        //Pruebas
        assertTrue(examen.isPresent());
        assertEquals(5L, examen.orElseThrow().getId());
        assertEquals("Matematicas", examen.orElseThrow().getNombre());

        //NOTA: no se puede hacer un mock de cualquier metodo, solo los publicos y default (o package)

    }

    @Test
    void findExamenPorNombreListaVacia() {

        ExamenRepository repository = mock(ExamenRepositoryOtro.class);
        ExamenService service = new ExamenServiceImpl(repository);

        //Usamos una lista vacia, sin depender de clases externas
        List<Examen> datos = Collections.emptyList();
        when(repository.findAll()).thenReturn(datos);

        Optional<Examen> examen = service.findExamenPorNombre("Matematicas");

        assertTrue(examen.isPresent());
        assertEquals(5L, examen.orElseThrow().getId());
        assertEquals("Matematicas", examen.orElseThrow().getNombre());

    }














}