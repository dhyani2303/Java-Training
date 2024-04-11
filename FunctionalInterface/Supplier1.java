import java.util.function.Supplier;

class Supplier1
{
    public static void main(String[] args)
    {
        Supplier<Double> getRandomDouble=()->Math.random(); // Supplier<datatype> 
        System.out.println(getRandomDouble.get());
    }
}