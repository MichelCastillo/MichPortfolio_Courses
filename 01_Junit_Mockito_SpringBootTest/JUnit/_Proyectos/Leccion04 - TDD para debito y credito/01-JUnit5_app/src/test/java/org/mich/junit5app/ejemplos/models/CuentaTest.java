package org.mich.junit5app.ejemplos.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    //Leccion01
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

        //Chequeamos que no obtengamos un null
        assertNotNull(cuenta.getSaldo());

        //Verificamos si esta correcto, transformando un BigDecimal a Double
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());

        //Chequeamos que el saldo nunca sea negativo
        //Usamos la constante BigDecima.ZERO
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);

        //Negamos la expresion de arriba
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    //Leccion02
    @Test
    void testReferenciaCuenta() {
        //Comparando dos objetos cuenta por referencia y NO por valor
        Cuenta cuenta1 = new Cuenta("John", new BigDecimal("8900.9997"));
        Cuenta cuenta2 = new Cuenta("John", new BigDecimal("8900.9997"));

        //Realizamos la comparacion con assertNotEquals
        //assertNotEquals(cuenta2, cuenta1);//true -> false al implementar el metodo equals

        //Comparamos con assertEquals
        assertEquals(cuenta2, cuenta1); //false -> true al implementar el método equals en Cuenta

        //Para poder implementar la comparacion por valor y NO por referencia,
        // debemos implementar el método equals en la clase Cuenta


    }

    //Leccion03
    @Test
    void testDebitoCuenta() {
        Cuenta cuenta = new Cuenta("John", new BigDecimal("1000.12345"));

        cuenta.debito(new BigDecimal(100));

        //Chequeamos que no obtengamos un null
        assertNotNull(cuenta.getSaldo());

        //Chequeamos que la resta se efectue
        assertEquals(900, cuenta.getSaldo().intValue());//devolvemos solo la parte entera del bigDecimal

        //Probamos contra un String
        assertEquals("900.12345", cuenta.getSaldo().toEngineeringString());
    }

    @Test
    void testCreditoCuenta() {
        Cuenta cuenta = new Cuenta("John", new BigDecimal("1000.12345"));

        cuenta.credito(new BigDecimal(100));

        //Chequeamos que no obtengamos un null
        assertNotNull(cuenta.getSaldo());

        //Chequeamos que la resta se efectue
        assertEquals(1100, cuenta.getSaldo().intValue());//devolvemos solo la parte entera del bigDecimal

        //Probamos contra un String
        assertEquals("1100.12345", cuenta.getSaldo().toEngineeringString());
    }
}