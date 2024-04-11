import java.util.function.Predicate;

class Predicate1
{
    public static void main(String[] args)
{
     Predicate<String> checkLength=str->str.length()>5;  //checkLength is method name,str is variable
     System.out.println(checkLength.test("cabffgr")); // test is the method of predicate
}
}