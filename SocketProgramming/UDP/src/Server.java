import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server
{
    public static void main(String[] name)
    {
        try
        {
            DatagramSocket socket = new DatagramSocket(9090);

            byte[] reciveData = new byte[1024];

            byte[] sendData = new byte[1024];

            while(true)
            {
                DatagramPacket recievePacket = new DatagramPacket(reciveData, reciveData.length);

                socket.receive(recievePacket);

                int length = recievePacket.getLength();
                String recievedData = new String(recievePacket.getData(), 0, length);

                System.out.println(recievedData);

                InetAddress address = recievePacket.getAddress();

                int port = recievePacket.getPort();


                String datatosend = "Hello client!";

                sendData = datatosend.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, port);

                socket.send(sendPacket);


            }

        } catch(SocketException e)
        {
            throw new RuntimeException(e);
        } catch(IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
