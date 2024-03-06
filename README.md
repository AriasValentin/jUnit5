# jUnit5
Curso De jUnit5.

1.entrar a la clase, goTO --> test, crea clase especifica para el test.
2.Crear metodo propio dentro de la clase generada en la carpeta test, con la etiqueta @Test.
3. run "calculatorTest"
4. verde ok, rojo problemas..
5.@BeforeEach --> Metodos con esta etiqueta se ejecutan antes que cualquier otro.

# @AfterEach --> para liberar recursos.
6. tener en cuenta que el beforeEach y Aftereach se ejecutan antes y despues de cada metodo test en particular!!

# el metodo -> assertEquals() permite comparar 2 estados.  EJ --> assertEquals(resultadoEsperado,resultadoActual)
# TIP -> tener solo un metodo assert en cada metodo.

# assertEquals() , con msj, sin msj tiene varios parametros. EJ --> assertEquals(resultadoEsperado,resultadoActual,"mensaje pred")
# assertEquals(1,1.4,0.5); expected-actual-delta.
# assertEquals(1,1.6,0.5); --> falla!!
# assertTrue() ->  assertTrue(2 == 1);
# assertSame() -> Si son el mismo objeto.
# assertNotSame() -> Si no son el mismo.

# metodo fail() -> fail("msj personalizado dependiendo el error captado por assert";
#assertThrows -> Exception dentro del metodo @Test.

EJ:
   @Test
    public void ejemploThrow(){
        assertThrows(ArithmeticException.class,()->calculadora.divideByZero(2,0),"Nose puede dividir por 0.");
    }

# @Disable("")
# DisplayName ("mensaje de metodo, cambia al original creado.")

# assertAll --> permite ejecutar todos los assert puestos , por mas que fallen.
EJ->
    @Test
    public void addAssertAllTest(){

        assertAll(
            ()->assertEquals(30,calculadora.sumar(10,20)),   ----------------------------> ESTO ES DESPRECIABLE, YA QUE UNA BUENA PRACTICA ES TESTEAR UNA COSA A LA VEZ !!
            ()->assertEquals(2,calculadora.sumar(10,20)),
            ()->assertEquals(9,calculadora.sumar(10,20))
        );
 # @BeforeAll --> se ejecuta antes que todo siempre. -> sirve mucho para testera bdd o cosas super necesarias antes de realizar otras operaciones.
