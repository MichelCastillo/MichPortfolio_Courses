package org.mich.junit5app.ejemplos.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

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
}