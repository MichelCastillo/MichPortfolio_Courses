package org.mich.training.appmockito.ejemplos.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mich.training.appmockito.ejemplos.models.Examen;
import org.mich.training.appmockito.ejemplos.repositories.ExamenRepository;
import org.mich.training.appmockito.ejemplos.repositories.ExamenRepositoryImpl;
import org.mich.training.appmockito.ejemplos.repositories.ExamenRepositoryOtro;
import org.mich.training.appmockito.ejemplos.repositories.PreguntaRepository;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExamenServiceImplTest {

    @Mock
    ExamenRepository repository;

    @Mock
    PreguntaRepository preguntaRepository;

    @InjectMocks
    ExamenServiceImpl service;

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
        List<Examen> datos = Collections.emptyList();
        when(repository.findAll()).thenReturn(datos);

        Optional<Examen> examen = service.findExamenPorNombre("Matematicas");
        assertFalse(examen.isPresent());
    }

    @Test
    void testPreguntasExamen() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntaRepository.findPreguntasPorExamenID(anyLong())).thenReturn(Datos.PREGUNTAS);

        Examen examen = service.findExamenPorNombreConPreguntas("Matematicas");
        assertEquals(5, examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("Aritmetica"));
    }

    @Test
    void testPreguntasExamenVerify() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntaRepository.findPreguntasPorExamenID(anyLong())).thenReturn(Datos.PREGUNTAS);

        Examen examen = service.findExamenPorNombreConPreguntas("Matematicas");
        assertEquals(5, examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("Aritmetica"));

        verify(repository).findAll();

        verify(preguntaRepository).findPreguntasPorExamenID(examen.getId());
    }

    @Test
    void testNoExisteExamenVerify() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntaRepository.findPreguntasPorExamenID(anyLong())).thenReturn(Datos.PREGUNTAS);

        Examen examen = service.findExamenPorNombreConPreguntas("Matematicas");
        assertNotNull(examen);

        verify(repository).findAll();

        verify(preguntaRepository).findPreguntasPorExamenID(examen.getId());
    }

    @Test
    void testGuardarExamen() {
        //Given
        Examen newExamen = Datos.EXAMEN;
        newExamen.setPreguntas(Arrays.asList("pregunta1", "pregunta2", "pragunta3"));

        when(repository
                .guardar(any(Examen.class)))
                .thenReturn(Datos.EXAMEN);

        //When
        Examen examen = service.guardar(newExamen);

        //Then
        assertNotNull(examen.getId());
        assertEquals(8L, examen.getId());
        assertEquals("Fisica", examen.getNombre());

        verify(repository).guardar(any(Examen.class));
        verify(preguntaRepository).guardarVarias(anyList());
    }

    @Test
    void testGuardarExamenIDAutoincremental() {
        Examen newExamen = Datos.EXAMEN;
        newExamen.setPreguntas(Datos.PREGUNTAS);

        when(repository
                .guardar(any(Examen.class)))
                .then(new Answer<Examen>() {
                    Long secuencia = 8L;

                    @Override
                    public Examen answer(InvocationOnMock invocationOnMock) throws Throwable {
                        Examen examen = invocationOnMock.getArgument(0); //El examen que pasamos en el guardar
                        examen.setId(secuencia++);
                        return examen;
                    }
                });

        Examen examen = service.guardar(newExamen);

        assertNotNull(examen.getId());
        assertEquals(8L, examen.getId());
        assertEquals("Fisica", examen.getNombre());

        verify(repository).guardar(any(Examen.class));
        verify(preguntaRepository).guardarVarias(anyList());
    }

    @Test
    void testManejoException() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntaRepository
                .findPreguntasPorExamenID(anyLong())).thenThrow(IllegalArgumentException.class);

        Exception matematicas = assertThrows(IllegalArgumentException.class, () -> {
            service.findExamenPorNombreConPreguntas("Matematicas");
        });

        assertEquals(IllegalArgumentException.class, matematicas.getClass());

        verify(repository).findAll();
        verify(preguntaRepository).findPreguntasPorExamenID(anyLong());
    }

    //Leccion 08: Argument matchers - Validaciones personalizadas de nuestros argumentos
    // Nos permite validar que los parámetros que le pasamos a un método, coinciden con los declarados en el mock
    // Nos sirve para asegurarnos que los argumentos se pasen al mock

    @Test
    void testArgumentMatchers() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntaRepository.findPreguntasPorExamenID(anyLong())).thenReturn(Datos.PREGUNTAS);
        service.findExamenPorNombreConPreguntas("Matematicas");

        verify(repository).findAll();
        verify(preguntaRepository).findPreguntasPorExamenID(argThat(arg -> arg != null && arg.equals(5L)));
        //De esa manera no solamente verificamos que se haya ejecutado el método findPreguntasPorExamenID, sino
        // que también personalizamos los chequeos de los argumentos que se usaron durante su ejecucion

        //Otra forma:
        verify(preguntaRepository).findPreguntasPorExamenID(eq(5L));

        // Distinto de null y que acepte cualquier valor mayor a 5
        verify(preguntaRepository).findPreguntasPorExamenID(argThat(arg -> arg != null && arg >= 5L));
    }

    //Argument Matchers pero con clases
    @Test
    void testArgumentMatchersClaseInner() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntaRepository.findPreguntasPorExamenID(anyLong())).thenReturn(Datos.PREGUNTAS);
        service.findExamenPorNombreConPreguntas("Matematicas");

        verify(repository).findAll();
        verify(preguntaRepository).findPreguntasPorExamenID(argThat(new MiArgsMatchers()));
    }

    public static class MiArgsMatchers implements ArgumentMatcher<Long> {

        private long aLong;

        @Override
        public boolean matches(Long aLong) {
            this.aLong = aLong;
            return aLong != null && aLong > 0;
        }

        @Override
        public String toString() {
            return "Esto es un mensaje personalizado de error. - " +
                    "Valor del argumento recibido: " + this.aLong;
        }
    }

    @Test
    void testArgumentMatchersLambda() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntaRepository.findPreguntasPorExamenID(anyLong())).thenReturn(Datos.PREGUNTAS);
        service.findExamenPorNombreConPreguntas("Matematicas");

        verify(repository).findAll();
        verify(preguntaRepository).findPreguntasPorExamenID(argThat(argument -> argument != null && argument > 5L));
        //La desventaja de esta implementacion, es que no podemos implementar el mensaje personalizado
        //Dado que la expresión lambda solo puede implementar el método matches
    }
}