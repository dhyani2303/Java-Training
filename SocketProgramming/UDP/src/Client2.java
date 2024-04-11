import java.io.IOException;
import java.net.*;

public class Client2
{
    public static void main(String[] args)
    {
        try
        {
            // DatagramSocket clientSocket = new DatagramSocket();

            // 0 repersents that randomly port will be selected
            DatagramSocket clientSocket = new DatagramSocket(0);

            byte[] sendData = new byte[1024];

            byte[] recieveData = new byte[1024];

            InetAddress serverAddress = InetAddress.getByName("localhost");


            String data = "Hello Server!";

            sendData = data.getBytes();

            boolean stop = false;

            while(!false)
            {

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9090);

                clientSocket.send(sendPacket);
            }


        } catch(SocketException e)
        {
            throw new RuntimeException(e);
        } catch(UnknownHostException e)
        {
            throw new RuntimeException(e);
        } catch(IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}

