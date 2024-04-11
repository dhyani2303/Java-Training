import java.util.function.Function;

class Function1
{
    public static void main(String[] args)
    {
        Function<Integer,String> getInt=t->t*10 + " data multiplied by 10"; //Function<parameter type,retun type>

        System.out.println(getInt.apply(2));


    }
}