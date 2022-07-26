package org.mich.junit5app.ejemplos.models;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import static java.util.Arrays.*;
import static org.junit.jupiter.api.Assertions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CuentaTest {

    Cuenta cuenta;

    @Test
    void testNombreCuenta() {

        this.cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
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
        assertNotNull(cuenta.getSaldo());

        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());

        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);

        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @BeforeEach
    void initMetodoTest(){
        this.cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        System.out.println("Iniciando el método de prueba.. - BeforeEach");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Finalizando el método de prueba... - AfterEach");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Inicializando el test - BeforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finalizando el test - AfterAll");
    }

    //Leccion12: Test condicionales - @EnabledOnOs,
    // @EnabledOnJre, @EnabledIfSystemProperty, etc

    //EnabledOnOs
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testSoloWindows() {

    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
    void testSoloLinuxMac() {
    }

    //@DisabledOnOs -> no se ejecuta en cierto OS
    @Test
    @DisabledOnOs(OS.WINDOWS)
    void testNoWindows() {
    }

    //Chequeamos nuestras properties
    @Test
    void imprimirSystemProperties(){
        Properties properties = System.getProperties();
        properties.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    //@EnabledOnJre -> ejecución dependiendo de la version de Java
    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void testSoloJDK8() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_14)
    void testSoloJDK14(){
    }

    //@DisabledOnJre
    @Test
    @DisabledOnJre(JRE.JAVA_8)
    void testNoJDK8() {
    }

    @Test
    @DisabledOnJre(JRE.JAVA_14)
    void testNoJDK14() {
    }

    @Test
    @EnabledIfSystemProperty(named = "java.version", matches = ".*14.*")//Expresion regular
    void testJavaVersion(){
        //@EnabledIfSystemProperty(named = "java.specification.version", matches = "14.0.2+12-46")
    }

    //Deshabilitar si tenemos arquitectura 32 bits
    @Test
    @DisabledIfSystemProperty(named = "os.arch", matches = ".*32.*")
    void testSolo64bits() {
    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    void testNo64bits() {
    }

    @Test
    @EnabledIfSystemProperty(named = "user.name", matches = "luismichel.castillo")
    void testUsername() {
    }

    //Ejecutando dependiendo el entorno

    @Test
    @EnabledIfSystemProperty(named = "ENV", matches = "test")
    void testSoloDesarrollo() {
        //Debemos de agregar la configuracion ENV - -DENV=dev
    }
}