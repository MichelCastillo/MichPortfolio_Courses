package org.mich.junit5app.ejemplos.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void testNombreCuenta() {

        //Instanciamos la clase que queremos probar
        //Cuenta cuenta = new Cuenta();
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        //cuenta.setPersona("Andres");

        //Declaramos lo que queremos probar
        String nombreEsperado = "Andres";
        String nombreReal = cuenta.getPersona();

        //Empezamos a probar a través del método estático de la clase Assertion
        Assertions.assertEquals(nombreEsperado, nombreReal);

        //Usamos Assertions.assertTrue
        Assertions.assertTrue(nombreEsperado.equals(nombreReal));
    }

    @Test
    void testSaldoCUenta() {
        //Creamos el objeto cuenta
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));

        //Verificamos si esta correcto, transformando un BigDecimal a Double
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());

        //Chequeamos que el saldo nunca sea negativo
        //Usamos la constante BigDecima.ZERO
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);

        //Negamos la expresion de arriba
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }
}