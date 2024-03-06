import jUnit5.Calculadora;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureCalculatorTest {

    private TemperatureCalculator temperatureCalculator;


        @BeforeEach
        public void setUp(){
           temperatureCalculator = new TemperatureCalculator();
            System.out.println("@BeforeEach -> setUp()");
        }

        @AfterEach
        public void tearDown(){
         temperatureCalculator = null;
            System.out.println("@BeforeEach -> tearDown()");
        }

        @Test
        public void testFarenheit(){

            assertEquals(-9.4,temperatureCalculator.toFarenheit(-12),0.01);
        }
    }