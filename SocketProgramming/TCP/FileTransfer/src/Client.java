import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client
{
    public static void main(String[] args)
    {

        try
        {
            InetAddress address = InetAddress.getByName("localhost");

            Socket socket = new Socket(address, 3030);

        } catch(UnknownHostException e)
        {
            throw new RuntimeException(e);

        } catch(IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
