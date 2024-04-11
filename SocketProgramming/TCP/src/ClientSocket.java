import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket
{
    public static void main(String[] args)
    {
        try
        {
            InetAddress inetAddress = InetAddress.getByName("localhost");

            Socket socket = new Socket(inetAddress, 3030);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println(in.readLine());

            out.println("Hello server");

            in.close();

            out.close();

            socket.close();

        } catch(UnknownHostException e)
        {

            System.out.println(e.toString());
        } catch(IOException e)
        {
            System.out.println(e.toString());
        } catch(Exception e)
        {
            System.out.println(e.toString());
        }

    }
}
