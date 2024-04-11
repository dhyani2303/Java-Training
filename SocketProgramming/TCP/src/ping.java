import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ping
{
    public static void main(String[] args)
    {
        try
        {
            // the below statement will return true only when ran in linux as root.
            //   System.out.println(inetAddress.isReachable(1000));

            // InetAddress inetAddress = InetAddress.getByName("google.com");

            //   String hostAddress = inetAddress.getHostAddress();

            String hostAddress = "10.20.40.128";

            Process p = Runtime.getRuntime().exec("ping -c 3 " + hostAddress);

            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            p.getErrorStream();

            String commandReader = "";

            boolean isReachable = true;

            while((commandReader = reader.readLine()) != null)
            {
                //  System.out.println(commandReader);

                if(commandReader.contains("Network is unreachable"))
                {
                    isReachable = false;
                    break;
                }
            }

            if(isReachable)
            {
                System.out.println("Host is reachable");
            }
            else
            {
                System.out.println("Host is unreachable");
            }
        } catch(UnknownHostException e)
        {
            throw new RuntimeException(e);
        } catch(IOException e)
        {
            throw new RuntimeException(e);
        }


    }
}
