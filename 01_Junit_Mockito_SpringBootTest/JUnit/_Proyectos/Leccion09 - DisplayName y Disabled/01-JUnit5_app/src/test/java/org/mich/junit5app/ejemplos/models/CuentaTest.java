package org.mich.junit5app.ejemplos.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mich.junit5app.ejemplos.exceptions.DineroInsuficienteException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.*;
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
    void testDebitoCuenta() throws DineroInsuficienteException {
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

    //Leccion04
    @Test
    void testDineroInsuficienteException() {
        Cuenta cuenta = new Cuenta("John", new BigDecimal("1000.12345"));

        //Verificamos si descontando mas de lo que tiene, deberia tirar la excepcion creada
        Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
            cuenta.debito(new BigDecimal(1500));
        });
        //el assertThrows va a devolver una excepcion si corresponde.
        // aputarmos esa excepcion para comparar el mensaje que recibimos a ver si es el correcto
        String actual = exception.getMessage();
        String esperado = "Dinero Insuficiente";

        //Chequeamos
        assertEquals(esperado, actual);

    }

    //Leccion05

    @Test
    void testTransferirDineroCuentas() throws DineroInsuficienteException {
        Cuenta cuenta1 = new Cuenta("John", new BigDecimal("3000.12345"));
        Cuenta cuenta2 = new Cuenta("Andres", new BigDecimal("2000.12345"));

        Banco banco = new Banco();
        banco.setNombre("Banco");

        //Llamamos la método transferir
        banco.transferir(cuenta2, cuenta1, new BigDecimal(1500));

        //Comprobamos que se le haya restado el monto a la cuenta2
        assertEquals("500.12345", cuenta2.getSaldo().toPlainString());

        //Comprobamos que se le haya sumado ese monto a la cuenta 1
        assertEquals("4500.12345", cuenta1.getSaldo().toPlainString());
    }

    //Leccion06
    @Test
    void testRelacionBancoCuentas() throws DineroInsuficienteException {
        Cuenta cuenta1 = new Cuenta("John", new BigDecimal("3000.12345"));
        Cuenta cuenta2 = new Cuenta("Andres", new BigDecimal("2000.12345"));

        Banco banco = new Banco();
        banco.setNombre("Banco");
        banco.agregarCuentas(new ArrayList<>(asList(cuenta1, cuenta2)));

        //Llamamos la método transferir
        banco.transferir(cuenta2, cuenta1, new BigDecimal(1500));

        //Comprobamos que se le haya restado el monto a la cuenta2
        assertEquals("500.12345", cuenta2.getSaldo().toPlainString());

        //Comprobamos que se le haya sumado ese monto a la cuenta 1
        assertEquals("4500.12345", cuenta1.getSaldo().toPlainString());

        //Probamos la relacion del Banco que deberia tener 2 cuentas
        assertEquals(2, banco.getCuentas().size());

        //Probamos que las cuentas tengan asociado ese banco
        assertEquals("Banco", cuenta1.getBanco().getNombre());
        assertEquals("Banco", cuenta2.getBanco().getNombre());

        //Probamos que el Banco tenga una cuenta cuyo nombre sea Andres
        assertEquals("Andres", banco.getCuentas()
                .stream().filter(cuenta -> cuenta
                        .getPersona().equals("Andres"))
                .findFirst().get().getPersona());

        //Probamos mediante assertTrue que el banco tenga una cuenta Andres
        assertTrue(banco.getCuentas().stream()
                .anyMatch(c -> c.getPersona().equals("Andres")));
    }

    //Leccion07: Uso de AssertAll
    //Con este método agrupamos varios asserts y en caso de que algunos fallen
    //estos se van a mostrar en el reporte
    @Test
    void testRelacionBancoCuentasAssertAll() throws DineroInsuficienteException {
        Cuenta cuenta1 = new Cuenta("John", new BigDecimal("3000.12345"));
        Cuenta cuenta2 = new Cuenta("Andres", new BigDecimal("2000.12345"));

        Banco banco = new Banco();
        banco.setNombre("Banco");
        banco.agregarCuentas(new ArrayList<>(asList(cuenta1, cuenta2)));

        banco.transferir(cuenta2, cuenta1, new BigDecimal(1500));

        //Este método AssertAll utiliza expresiones lambda (una x cada assert que querramos probar
        //No llevan parametros
        //En caso de que varias fallen, se van a mostrar explicitamente cada una en el reporte
        assertAll(() -> {
            assertEquals("500.12345", cuenta2.getSaldo().toPlainString());
        }, () -> {
            assertEquals("4500.12345", cuenta1.getSaldo().toPlainString());
        }, () -> {
            assertEquals(2, banco.getCuentas().size());
        }, () -> {
            assertEquals("Banco", cuenta1.getBanco().getNombre());
        }, () -> {
            assertEquals("Banco", cuenta2.getBanco().getNombre());
        }, () -> {
            assertEquals("Andres", banco.getCuentas()
                    .stream().filter(cuenta -> cuenta
                            .getPersona().equals("Andres"))
                    .findFirst().get().getPersona());
        }, () -> {
            assertTrue(banco.getCuentas().stream()
                    .anyMatch(c -> c.getPersona().equals("Andres")));
        });
    }

    //Leccion08: Agregando mensajes de falla en los métodos assertions
    @Test
    void testNombreCuentaMensajes() {

        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));

        String nombreEsperado = "Andres";
        String nombreReal = cuenta.getPersona();

        //Una de las formas es agregando el mensaje como un parametro al final de cada assertion
        assertNotNull(cuenta, "La cuenta no puede ser nula");
        //Pero esto implica que, aunque no se use, JUnit cree una instancia de este String
        //Pera poder evitar eso podemos usar una function que solamente se cree cuando se encuentre un error

        //Usamos expresiones lambda como funciones
        assertNotNull(cuenta, () -> "La cuenta no puede ser nula");
        Assertions.assertEquals(nombreEsperado, nombreReal, () -> "El nombre de la cuenta no es el que se esperaba");
        Assertions.assertTrue(nombreEsperado.equals(nombreReal), () -> "El nombre de la cuenta esperada debe ser igual a la real");
        //Aunque visualmente no se note, estos objetos functions, solamente se van a crear
        //cuando fallen los assertionsy no siempre
    }

    //Lección09: Uso de DisplayName y Disabled

    //DisplayName
    @Test
    @DisplayName("Probando nombre de la cuenta")
    //Con este tag identificamos en el reporte, qué metodo test estamos ejecutando
    void testNombreCuentaDisplayName() {

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

    //Disabled:
    //Este tag sirve para deshabilitar la ejecución de un método mientras,
    //desarrollamos el código
    @Test
    @Disabled
    void testRelacionBancoCuentasDisabled() throws DineroInsuficienteException {
        fail(); //Con esto forzamos a este metodo a fallar (Método estatico de la clase Assertions)
        Cuenta cuenta1 = new Cuenta("John", new BigDecimal("3000.12345"));
        Cuenta cuenta2 = new Cuenta("Andres", new BigDecimal("2000.12345"));

        Banco banco = new Banco();
        banco.setNombre("Banco");
        banco.agregarCuentas(new ArrayList<>(asList(cuenta1, cuenta2)));

        banco.transferir(cuenta2, cuenta1, new BigDecimal(1500));

        assertEquals("500.12345", cuenta2.getSaldo().toPlainString());
        assertEquals("4500.12345", cuenta1.getSaldo().toPlainString());

        assertEquals(2, banco.getCuentas().size());

        assertEquals("Banco", cuenta1.getBanco().getNombre());
        assertEquals("Banco", cuenta2.getBanco().getNombre());

        assertEquals("Andres", banco.getCuentas()
                .stream().filter(cuenta -> cuenta
                        .getPersona().equals("Andres"))
                .findFirst().get().getPersona());

        assertTrue(banco.getCuentas().stream()
                .anyMatch(c -> c.getPersona().equals("Andres")));
    }
    //También podríamos evitar que este método se ejecute sacándole
    // el método @Test, pero así no aparecería en el reporte.
    //Con disabled, aparecerá pero no se ejecutará






































}