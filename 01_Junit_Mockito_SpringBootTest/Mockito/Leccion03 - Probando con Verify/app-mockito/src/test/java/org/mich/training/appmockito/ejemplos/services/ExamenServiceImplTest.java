package org.mich.training.appmockito.ejemplos.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mich.training.appmockito.ejemplos.models.Examen;
import org.mich.training.appmockito.ejemplos.repositories.ExamenRepository;
import org.mich.training.appmockito.ejemplos.repositories.ExamenRepositoryImpl;
import org.mich.training.appmockito.ejemplos.repositories.ExamenRepositoryOtro;
import org.mich.training.appmockito.ejemplos.repositories.PreguntaRepository;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ExamenServiceImplTest {

    ExamenRepository repository;
    ExamenService service;
    PreguntaRepository preguntaRepository;

    @BeforeEach
    void setUp() {
        this.repository = mock(ExamenRepositoryOtro.class);
        this.preguntaRepository = mock(PreguntaRepository.class);
        this.service = new ExamenServiceImpl(repository, preguntaRepository);
    }

    @Test
    void findExamenPorNombre() {

        when(repository.findAll()).thenReturn(Datos.EXAMENES);

        Optional<Examen> examen = service.findExamenPorNombre("Matematicas");

        //Pruebas
        assertTrue(examen.isPresent());
        assertEquals(5L, examen.orElseThrow().getId());
        assertEquals("Matematicas", examen.orElseThrow().getNombre());
    }

    @Test
    void findExamenPorNombreListaVacia() {
        //Usamos una lista vacia, sin depender de clases externas
        List<Examen> datos = Collections.emptyList();
        when(repository.findAll()).thenReturn(datos);

        Optional<Examen> examen = service.findExamenPorNombre("Matematicas");

        //Al solamente estar probando que la lista sea vacía, el resto de pruebas no tiene sentido
        assertFalse(examen.isPresent());

    }

    @Test
    void testPreguntasExamen() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntaRepository.findPreguntasPorExamenID(anyLong())).thenReturn(Datos.PREGUNTAS);
        //Uso de anyLong -> expresion para cualquier valor long
        // Cualquier ID de tipo LONG para los examenes

        Examen examen = service.findExamenPorNombreConPreguntas("Matematicas");
        assertEquals(5, examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("Aritmetica"));
    }

    //Leccion03: Verificando que se ejecutó un método de nuestro mock con Verify
    @Test
    void testPreguntasExamenVerify() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntaRepository.findPreguntasPorExamenID(anyLong())).thenReturn(Datos.PREGUNTAS);
        //Uso de anyLong -> expresion para cualquier valor long
        // Cualquier ID de tipo LONG para los examenes

        Examen examen = service.findExamenPorNombreConPreguntas("Matematicas");
        assertEquals(5, examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("Aritmetica"));

        //Verificamos que del objeto repository se llamó al metodo a findAll() (falla si no lo hizo)
        verify(repository).findAll();

        //Verificamos si existe el examen de Matematicas
        verify(preguntaRepository).findPreguntasPorExamenID(examen.getId());
    }

    //Cuando la lista es vacía
    @Test
    void testNoExisteExamenVerify() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntaRepository.findPreguntasPorExamenID(anyLong())).thenReturn(Datos.PREGUNTAS);

        Examen examen = service.findExamenPorNombreConPreguntas("Matematicas");
        assertNotNull(examen);

        //Verificamos que del objeto repository se llamó al metodo a findAll() (falla si no lo hizo)
        verify(repository).findAll();

        //Verificamos si existe el examen de Matematicas
        verify(preguntaRepository).findPreguntasPorExamenID(examen.getId());
    }

















































}