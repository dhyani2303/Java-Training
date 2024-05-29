import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.example.Operations;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

//junit 5
public class OperationsTest
{
    Operations operations;

    String env = "dev";

    @BeforeEach
    public void beforeEach()
    {
        operations = new Operations();

        System.out.println("Before each executed");
    }

    @BeforeAll
    public static void beforeAll()
    {

        System.out.println("Execution of before All method");
    }

    @AfterEach
    public void afterEach()
    {

        System.out.println("After each executed");
    }

    @AfterAll
    public static void afterAll()
    {

        System.out.println("Execution of after all method");
    }


    @Test
    public void divideTest()
    {

        //if the first assert fails then the second won't be executed. in order to execute both of them we use assertAll
      // assertTrue(operations.divide(10,3));
       //assertTrue(operations.divide(10,2));


        assertAll(
               ()-> assertTrue(operations.divide(10,2)),
                         ()->   assertTrue(operations.divide(10,2))
        );
    }


    //the test case will fail if the exception is not thrown.
    @Test
    public void throwsArithmeticException()
    {
        Executable executable = ()-> operations.divide(10,0);

        assertThrows(ArithmeticException.class,executable);
    }


    //@ValueSource is used only for a single value i.e. our num2 is already pre-defined
    //to give two values, we use @CsvSource (Comma Seperated Values (csv))
    @ParameterizedTest
    @ValueSource(ints ={10,20,30})
    public void parameterisedDivideTest(int number1)
    {
        int num2 = 2;

        assertTrue(operations.divide(number1,num2));

    }

    @ParameterizedTest( name = "number1={0}, number2={1}")
     @CsvSource(value =  {"10, 2","20, 4","30, 3"})
    public void parameterisedDivideTest(int number1,int number2)
    {
        assertTrue(operations.divide(number1,number2));

    }

    @Test
    public void timeoutTest()
    {
        //if the assumption is false then the unit test case will be skipped
        assumeTrue(this.env.equals("production"));

        Executable executable = ()-> operations.divide(10,2);

        assertTimeout(Duration.ofNanos(1),executable);
    }





}
