package jUnit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private Calculadora calculadora;
    private Calculadora calculadora2;
    private static Calculadora calculadoraStatic;

    @BeforeAll
    public static void beforeAllTest(){

        calculadoraStatic = new Calculadora();
        System.out.println("@beforeAllTest -> setUp()");
    }



    @BeforeEach
    public void setUp(){
        calculadora = new Calculadora();
        System.out.println("@BeforeEach -> setUp()");
    }

    @AfterEach
    public void tearDown(){
        calculadora = null;
        System.out.println("@BeforeEach -> tearDown()");
    }

    @Test
    public void calculatorNotNullTest(){

        assertNotNull(calculadora,"La calculadora tiene que estar instanciada.");
        System.out.println("@Test -> calculadoraNotNullTest");
    }

    @Test
    public void calculatorNullTest(){
        assertNull(calculadora2);
        System.out.println("@Test -> calculadoraNullTest");
    }

    @Test
    public void sumarAssertTest(){
        Calculadora calculadoraAssert = new Calculadora();
        //1.setUp
        int resultadoEsperado = 30;
        int resultadoActual;
        //2.Action
         resultadoActual = calculadoraAssert.sumar(10,50);
        //3.Assert
        assertEquals(resultadoEsperado,resultadoActual,"FALLO EL TEST.");
    }

    @Test
    public void assertTypesTest() {
        assertTrue(2 == 1);
        assertTrue(1 == 1);

        Calculadora cal3 = new Calculadora();
        Calculadora cal4 = new Calculadora();

        assertNull(cal3);
        assertNotNull(cal4);

        assertSame(calculadora, calculadora2);

        assertEquals("alberto","alber","TE FALLO EL STRING.");
        assertEquals(1,1.4,0.5);
    }

    @Test
    public void addValidInput(){
        assertEquals(11,calculadora.sumar(7,4));
    }

    @Test
    public void subValidInput(){
        assertEquals(-10,calculadora.restar(15,4));
    }

    @Test
    public void divideInputValid(){
        assertEquals(2,calculadora.dividir(10,3));
    }
    @Test
    public void divideInputValidByZero(){
        assertEquals(2,calculadora.divideByZero(10,0));
        fail("fallo detectado manualmente");
    }
    @Test
    public void ejemploThrow(){
        assertThrows(ArithmeticException.class,()->calculadora.divideByZero(2,0),"Nose puede dividir por 0.");
    }
//    @Disable("por que quiero")
    @Test
    @DisplayName("Metodo ejemplo")
    public void ejemplo(){

        assertEquals(2,calculadora.dividir(5,0));
    }

    @Test
    public void addAssertAllTest(){

        assertAll(
            ()->assertEquals(30,calculadora.sumar(10,20)),
            ()->assertEquals(2,calculadora.sumar(10,20)),
            ()->assertEquals(9,calculadora.sumar(10,20))
        );
    }

     class Nested{
        @Test
        public void ejemplo1(){
            assertEquals(2,calculadora.dividir(10,3));
        }
        @Test
        public void ejemplo2(){
            assertEquals(2,calculadora.dividir(10,3));
        }
        @Test
        public void ejemplo3(){
            assertEquals(2,calculadora.dividir(10,3));
        }
    }

    @AfterAll
    public static void afterAllTest(){

        calculadoraStatic = null;
        System.out.println("@afterAllTest -> afterAllTest()");
    }

    @ParameterizedTest(name = "{index} => a={0} , b={1} , sum={2}")
    @MethodSource("addProviderData") //ESTO PUEDE SER EL CONSUMO DE UNA BASE DE DATOS, METODO etc.
    public void addParametrizedTest(int a , int b , int sum){
        assertEquals(sum,calculadora.sumar(a,b));

    }

    private static Stream<Arguments> addProviderData(){
        return Stream.of(
            Arguments.of(6,2,8),
            Arguments.of(-6,2,8),
        Arguments.of(6,2,50));
    }



    @Test
    public void timeOutTest(){
        assertTimeout(Duration.ofMillis(500), ()->{
            calculadora.longTaskOperation();
        });
    }

}