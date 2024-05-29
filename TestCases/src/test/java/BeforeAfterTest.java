import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


//junit 4
public class BeforeAfterTest
{

    //@Before and @After methods will be executed before and after the completion of each test case respectively.

    //@BeforeClass is executed only once i.e. before any of the test cases are ran. it should be static.

    @BeforeClass
    public static void beforeClass()
    {

        System.out.println("Before class method");
    }

    @Before
    public void before()
    {
        System.out.println("Before method");
    }

    @After
    public void after()
    {

        System.out.println("After method executed");
    }
    @Test
    public void test1()
    {

        System.out.println("Test1 executed");
    }

    @Test
    public void test2()
    {

        System.out.println("Test2 executed");
    }
}
