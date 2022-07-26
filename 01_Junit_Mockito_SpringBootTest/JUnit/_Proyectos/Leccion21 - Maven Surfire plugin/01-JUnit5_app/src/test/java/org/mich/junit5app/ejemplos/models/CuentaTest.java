package org.mich.junit5app.ejemplos.models;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mich.junit5app.ejemplos.exceptions.DineroInsuficienteException;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CuentaTest {

    Cuenta cuenta;

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

    @Nested
    @DisplayName("Probando OperacionesTest class")
    class OperacionesTest {
        //Leccion15: Clases anidadas con Nested

        //Creamos una clase SistemaOperativoTest para adjuntar todos los test de este tipo

        Cuenta cuenta;

        private TestInfo testInfo;
        private TestReporter testReporter;

        //Incluimos TestInfo y TestReporter de la Leccion19
        @BeforeEach
        void initMetodoTest(TestInfo testInfo, TestReporter testReporter){
            this.cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
            this.testInfo = testInfo;
            this.testReporter = testReporter;
            //con esto habilitamos a todos los metodos test a acceder a estos valores
            System.out.println("Iniciando el método de prueba.. - BeforeEach");
            System.out.println("Ejecutando: " + testInfo.getDisplayName() + " - " + testInfo.getTestMethod().orElse(null).getName()
                    + " con las etiquetas: " + testInfo.getTags());

            //Usando el TestReporter para imprimir informacion en el log de JUnit
            testReporter.publishEntry("JUNIT LOG: Ejecutando: " + testInfo.getDisplayName() + " - " + testInfo.getTestMethod().orElse(null).getName()
                    + " con las etiquetas: " + testInfo.getTags());
        }

        @AfterEach
        void tearDown() {
            System.out.println("Finalizando el método de prueba... - AfterEach");
        }

        @Tag("cuenta")
        @Test
        void testNombreCuenta() {

            System.out.println(testInfo.getTags());
            if (testInfo.getTags().contains("cuenta")){
                System.out.println("Identificamos la etiqueta cuenta en testNombreCuenta()");
            }

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

        @Tag("cuenta")
        @Test
        void testSaldoCUenta() {
            assertNotNull(cuenta.getSaldo());

            assertEquals(1000.12345, cuenta.getSaldo().doubleValue());

            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);

            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        //Leccion14: Test condicional con Assumtions programaticamente
        //Con estos test, podemos probar x codigo, si x ejemplo, un servidor está
        //arriba. Si no lo está, no tiene sentido probarlo.
        @Tag("banco")
        @Test
        @DisplayName("Test Saldo Cuenta Dev")
        void testSaldoCuentaDev() {
            boolean esDev = "dev".equals(System.getProperty("ENV"));

            assumeTrue(esDev);
            //True: lo que está debajo se ejecuta
            //False: lo que esta abajo no se ejecuta, pero la prueba no tira error.
            // Solo se deshabilita

            assertNotNull(cuenta.getSaldo());

            assertEquals(1000.12345, cuenta.getSaldo().doubleValue());

            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);

            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        //Queremos que se ejecute un bloque de codigo, y no todo si no se
        // cumple el assume
        @Test
        @DisplayName("Test Saldo Cuenta Dev 2")
        void testSaldoCuentaDev2() {
            boolean esDev = "dev".equals(System.getProperty("ENV"));

            assumingThat(esDev, () -> {
                //True: lo que está debajo se ejecuta
                //False: lo que esta abajo no se ejecuta, pero la prueba no tira error.
                // Solo se deshabilita

                assertNotNull(cuenta.getSaldo());

                assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
            });

            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);

            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        //También se nos permite agregar BeforeEach y AfterEach dentro de estas clases
        //NO se permite agregar beforeAll y AfterAll
        //Se permite agregar el DisplayName
    }

    @Nested
    class SistemasOperativosTest {
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
    }

    @Tag("java")
    @Nested
    class JavaVersionTest{
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
    }

    @Nested
    class SystemPropertiesTest {
        //Chequeamos nuestras properties
        @Test
        void imprimirSystemProperties(){
            Properties properties = System.getProperties();
            properties.forEach((k, v) -> System.out.println(k + " : " + v));
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
    }

    @Nested
    class VariableAmbienteTest {
        //Ejecutando dependiendo el entorno

        @Test
        @EnabledIfSystemProperty(named = "ENV", matches = "test")
        void testSoloDesarrollo() {
            //Debemos de agregar la configuracion ENV - -DENV=dev
        }

        //Lección13: Ejecuciones de test condicionales con @EnabledIfEnvironmentVariable
        @Test
        void imprimirVariablesAmbiente() {
            Map<String, String> getenv = System.getenv();
            getenv.forEach((k, v) -> System.out.println(k + " : " + v));
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "JAVA_HOME", matches = ".*jdk-14.0.2.*")
        void testJavaHome(){
        }

        //Test numero de procesadores
        @Test
        @EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSORS", matches = "8")
        void testNroProcesadores(){

        }

        //Agregamos nuestras propias variables para probar
        @Test
        @EnabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "dev")
        void testEnv(){
            //Agregamos ENVIRONMENT=dev en las configuraciones de RUN
        }

        @Test
        @DisabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "prod")
        void testEnvNoProd(){
            //Agregamos ENVIRONMENT=dev en las configuraciones de RUN
        }
    }

    @Nested
    class PruebasRepeatedTest {
        //Leccion 16: Repitiendo pruebas con RepeatedTest

        //Este enfoque por lo general se utiliza para ciertos métodos que tengan un componente de
        // aleatoriedad en su composición. Lo unico que debemos hacer es cambiar
        // @Test por @RepeatedTest

        @DisplayName("Probando testDebitoCuentaRepetir!")
        @RepeatedTest(value = 5, name = "{displayName} - Repeticion numero {currentRepetition} de {totalRepetitions}") //repito 5 veces - Mensaje personalizado
        void testDebitoCuentaRepetir(RepetitionInfo info) throws DineroInsuficienteException {
            //la variable info viene por ID desde el RepeatedTest (son las variables que usamos entre {})
            if (info.getCurrentRepetition() == 3){
                System.out.println("Probando repetición numero " + info.getCurrentRepetition());
            }

            cuenta.debito(new BigDecimal(100));
            assertNotNull(cuenta.getSaldo());
            assertEquals(900, cuenta.getSaldo().intValue());
            assertEquals("900.12345", cuenta.getSaldo().toPlainString());
        }
    }

    @Nested
    class PruebasParametrizadasTest {


        //Leccion 17: Escribiendo pruebas parametrizadas con ParameterizedTest
        // Guarda cierta similitud con RepeatedTest
        // En este caso, vamos a repetir el test una X cantidad de veces, pero
        //  con informacion previa que la pasamos parametrizada, ya sea mediante notacion
        //  o un método, archivo plano, etc

        //Usando @ValueSource con arreglo de String
        @ParameterizedTest(name = "Numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @ValueSource(strings = {"100", "200", "500", "700", "1000.12345"}) //Usaremos estos parámetros
        void testDebitoCuentaParametrizadoStrings(String monto) throws DineroInsuficienteException {
            //El parámetro monto es el que se inyecta desde el ValueSource
            cuenta.debito(new BigDecimal(monto)); //Podemos parametrizar ese parametro
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        //Usando @ValueSource con arreglo de Int
        @ParameterizedTest(name = "Numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @ValueSource(doubles = {100, 200, 500, 700, 1000}) //Usaremos estos parámetros
        void testDebitoCuentaParametrizadoInt(double monto) throws DineroInsuficienteException {
            //El parámetro monto es el que se inyecta desde el ValueSource
            cuenta.debito(new BigDecimal(monto)); //Podemos parametrizar ese parametro
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        //Usando CsvSource
        @ParameterizedTest(name = "Numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvSource({"1,100", "2,200", "3,500", "4,700", "5,1000.12345"})
        void testDebitoCuentaParametrizadoStringsCSV(String index, String monto) throws DineroInsuficienteException {
            //El parámetro index y monto vienen del CsvSource respectivamente
            System.out.println(index + " -> " + monto);
            cuenta.debito(new BigDecimal(monto)); //Podemos parametrizar ese parametro
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        //Usando CsvFileSource
        @ParameterizedTest(name = "Numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvFileSource(resources = "/data.csv") //apunta a la carpeta main/java/resources
        void testDebitoCuentaParametrizadoStringsCSVFile(String monto) throws DineroInsuficienteException {
            //El parámetro monto viene del CsvSource respectivamente
            cuenta.debito(new BigDecimal(monto)); //Podemos parametrizar ese parametro
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        //Usando MethodSource
        @ParameterizedTest(name = "Numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @MethodSource("montoList")
        @Disabled
        void testDebitoCuentaParametrizadoStringsMethod(String monto) throws DineroInsuficienteException {
            //El parámetro monto viene del CsvSource respectivamente
            cuenta.debito(new BigDecimal(monto)); //Podemos parametrizar ese parametro
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        //Usando CsvSource con distintos parámetros
        @ParameterizedTest(name = "Numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvSource({"200,100, John, Andres", "250,200, Pepe, Pepe", "300,300, maria, Maria", "510,500,Pepa,Pepa", "750,700,Lucas,Luca", "1000.12345,1000.12345,Cata,Cata"})
        void testDebitoCuentaParametrizadoStringsCSV2(String saldo, String monto, String esperado, String actual) throws DineroInsuficienteException {
            //El parámetro index y monto vienen del CsvSource respectivamente
            System.out.println(saldo + " -> " + monto);
            cuenta.setSaldo(new BigDecimal(saldo));
            cuenta.debito(new BigDecimal(monto)); //Podemos parametrizar ese parametro

            cuenta.setPersona(actual);

            assertNotNull(cuenta.getSaldo());
            assertNotNull(cuenta.getPersona());
            assertEquals(esperado, actual);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        //Usando CsvFileSource
        @ParameterizedTest(name = "Numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvFileSource(resources = "/data2.csv") //apunta a la carpeta main/java/resources
        void testDebitoCuentaParametrizadoStringsCSVFile2(String saldo, String monto, String esperado, String actual) throws DineroInsuficienteException {
            //El parámetro index y monto vienen del CsvSource respectivamente
            System.out.println(saldo + " -> " + monto);
            cuenta.setSaldo(new BigDecimal(saldo));
            cuenta.debito(new BigDecimal(monto)); //Podemos parametrizar ese parametro

            cuenta.setPersona(actual);

            assertNotNull(cuenta.getSaldo());
            assertNotNull(cuenta.getPersona());
            assertEquals(esperado, actual);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }
    }

    static List<String> montoList() {
        return Arrays.asList("100", "200", "500", "700", "1000.12345");
    }

    //Leccion 18: Categorizando test con @Tag
    // puede aplicar a test individuales, o bien a clases
    // anidadas, donde aplicaria a cada uno de los métodos que la
    // componen

    //Nos permite ejecutar pruebas de forma selectiva. "Ejecutar las pruebas con X etiquetas".
    //Podemos agregar mas de una etiqueta para un mismo elemento
    //Cómo ejecutamos nuestras etiquetas?
    //Config -> editar configuracion -> Click en Class -> Tags -> agregamos el nombre del tag -> Apply
    @Tag("csv")
    @Tag("param")
    @Nested
    @Disabled
    class PruebasParametrizadasTestTag {

        //Leccion 17: Escribiendo pruebas parametrizadas con ParameterizedTest
        // Guarda cierta similitud con RepeatedTest
        // En este caso, vamos a repetir el test una X cantidad de veces, pero
        //  con informacion previa que la pasamos parametrizada, ya sea mediante notacion
        //  o un método, archivo plano, etc

        //Usando @ValueSource con arreglo de String
        @ParameterizedTest(name = "Numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @ValueSource(strings = {"100", "200", "500", "700", "1000.12345"}) //Usaremos estos parámetros
        void testDebitoCuentaParametrizadoStrings(String monto) throws DineroInsuficienteException {
            //El parámetro monto es el que se inyecta desde el ValueSource
            cuenta.debito(new BigDecimal(monto)); //Podemos parametrizar ese parametro
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        //Usando @ValueSource con arreglo de Int
        @ParameterizedTest(name = "Numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @ValueSource(doubles = {100, 200, 500, 700, 1000}) //Usaremos estos parámetros
        void testDebitoCuentaParametrizadoInt(double monto) throws DineroInsuficienteException {
            //El parámetro monto es el que se inyecta desde el ValueSource
            cuenta.debito(new BigDecimal(monto)); //Podemos parametrizar ese parametro
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        //Usando CsvSource
        @ParameterizedTest(name = "Numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvSource({"1,100", "2,200", "3,500", "4,700", "5,1000.12345"})
        void testDebitoCuentaParametrizadoStringsCSV(String index, String monto) throws DineroInsuficienteException {
            //El parámetro index y monto vienen del CsvSource respectivamente
            System.out.println(index + " -> " + monto);
            cuenta.debito(new BigDecimal(monto)); //Podemos parametrizar ese parametro
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        //Usando CsvFileSource
        @ParameterizedTest(name = "Numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvFileSource(resources = "/data.csv") //apunta a la carpeta main/java/resources
        void testDebitoCuentaParametrizadoStringsCSVFile(String monto) throws DineroInsuficienteException {
            //El parámetro monto viene del CsvSource respectivamente
            cuenta.debito(new BigDecimal(monto)); //Podemos parametrizar ese parametro
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        //Usando MethodSource
        @ParameterizedTest(name = "Numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @MethodSource("montoList")
        @Disabled
        void testDebitoCuentaParametrizadoStringsMethod(String monto) throws DineroInsuficienteException {
            //El parámetro monto viene del CsvSource respectivamente
            cuenta.debito(new BigDecimal(monto)); //Podemos parametrizar ese parametro
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        //Usando CsvSource con distintos parámetros
        @ParameterizedTest(name = "Numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvSource({"200,100, John, Andres", "250,200, Pepe, Pepe", "300,300, maria, Maria", "510,500,Pepa,Pepa", "750,700,Lucas,Luca", "1000.12345,1000.12345,Cata,Cata"})
        void testDebitoCuentaParametrizadoStringsCSV2(String saldo, String monto, String esperado, String actual) throws DineroInsuficienteException {
            //El parámetro index y monto vienen del CsvSource respectivamente
            System.out.println(saldo + " -> " + monto);
            cuenta.setSaldo(new BigDecimal(saldo));
            cuenta.debito(new BigDecimal(monto)); //Podemos parametrizar ese parametro

            cuenta.setPersona(actual);

            assertNotNull(cuenta.getSaldo());
            assertNotNull(cuenta.getPersona());
            assertEquals(esperado, actual);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        //Usando CsvFileSource
        @ParameterizedTest(name = "Numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvFileSource(resources = "/data2.csv") //apunta a la carpeta main/java/resources
        void testDebitoCuentaParametrizadoStringsCSVFile2(String saldo, String monto, String esperado, String actual) throws DineroInsuficienteException {
            //El parámetro index y monto vienen del CsvSource respectivamente
            System.out.println(saldo + " -> " + monto);
            cuenta.setSaldo(new BigDecimal(saldo));
            cuenta.debito(new BigDecimal(monto)); //Podemos parametrizar ese parametro

            cuenta.setPersona(actual);

            assertNotNull(cuenta.getSaldo());
            assertNotNull(cuenta.getPersona());
            assertEquals(esperado, actual);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }
    }

    // Leccion 19: Inyección de Dependencias en JUnit y Componentes TestInfo y TestReporter
    // TestInfo: implementacion de una interfaz que contiene toda la información de nuestra prueba unitaria
    //  Incluyendo el método, la clase a la que pertenece, lo que contiene el @DisplayName y sus tags
    // TestReporter: componente de JUnit que nos permite registrar en el log alguna información que nos sea
    //  de utilidad

    // Dónde se pueden usar? en cualquier método @Test o bien en los @BeforeEach y @AfterEach

    @Tag("cuenta")
    @Tag("cuenta_otro_tag")
    @Test
    @DisplayName("Probando nombre de la cuenta")
    void testNombreCuentaIDTestInfoTestReporter(TestInfo testInfo, TestReporter testReporter) {
        System.out.println("Ejecutando: " + testInfo.getDisplayName() + " - " + testInfo.getTestMethod().orElse(null).getName()
                + " con las etiquetas: " + testInfo.getTags());
        //Podemos mover esto al beforeEach para que se ejecute en todos los metodos Test

        String esperado = "Andres";
        String real = cuenta.getPersona();

        assertNotNull(real, () -> "La cuenta no puede ser nula");
        assertEquals(esperado, real, () -> "El nombre de la cuenta no es el que se esperaba - Se esperaba :" + esperado
                + " sin embargo fue: " + real);
        assertTrue(real.equals("Andres"), () -> "Nombre de la cuenta esperada debe ser igual a la real");

    }

    // Leccion 20: Timeout en JUnit5

    @Nested
    @Tag("timeout")
    class EjemploTimeoutTest {
        @Test
        @Timeout(5) //Int - 5 segundos
        void pruebaTimeout() throws InterruptedException {
            TimeUnit.SECONDS.sleep(4); //hacemos demorar la execución 6 segundos
        }

        @Test
        @Timeout(value = 5000, unit = TimeUnit.MILLISECONDS) //500 Milisegundos
        void pruebaTimeout2() throws InterruptedException {
            TimeUnit.SECONDS.sleep(4); //hacemos demorar la execución 6 segundos
        }

        @Test
        void testTimeoutAssertions() {
            assertTimeout(Duration.ofSeconds(5), () -> {
                TimeUnit.SECONDS.sleep(4);
            });
        }
    }


}




