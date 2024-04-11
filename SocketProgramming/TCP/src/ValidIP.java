import java.net.InetAddress;

public class ValidIP
{
    public static void main(String[] args)
    {

        System.out.println(validIpAddress("10.20.40.329"));

    }

    public static boolean validIpAddress(String ipAddress)
    {
        String[] numbers = ipAddress.split("\\.");

        if(numbers.length != 4)
            return false;

        for(String s : numbers)
        {
            int i = Integer.parseInt(s);

            if(i < 0 || i > 255)
                return false;
        }
        return true;
    }
}
