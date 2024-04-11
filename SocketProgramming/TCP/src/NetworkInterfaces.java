import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class NetworkInterfaces
{
    public static void main(String[] args)
    {

        try
        {

            InetAddress address = InetAddress.getByName("10.20.40.128");

            //three methods
            //1.getByInetAddress()
            //2.getByName()
            //3.getByNetworkInterface()

            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(address);

            if(networkInterface != null)
            {
                System.out.println(networkInterface.getName());

                System.out.println(networkInterface.getSubInterfaces());

            }
            else
            {
                System.out.println("Interface not found");
            }
        } catch(UnknownHostException e)
        {
            throw new RuntimeException(e);
        } catch(SocketException e)
        {
            throw new RuntimeException(e);
        }

    }
}
