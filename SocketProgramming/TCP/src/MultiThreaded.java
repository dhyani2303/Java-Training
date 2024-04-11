import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


class ClientThread extends Thread
{

    private Socket socket = new Socket();

    ClientThread(Socket socket)
    {
        this.socket = socket;
    }

    public void run()
    {
        try
        {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("The client connected is " + socket.getInetAddress());

            out.println("Hello client");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println(input.readLine());

            out.close();

            input.close();

            socket.close();

        } catch(IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}

public class MultiThreaded
{
    public static void main(String[] args)
    {
        boolean stop = false;
        try
        {


            ServerSocket serverSocket = new ServerSocket(3030);

            while(!stop)
            {
                System.out.println("Server is waiting for client...");

                // InetAddress Class is used to get ip address and host name of the clients.It is also used in socket

                //                InetAddress inetAddress = InetAddress.getLocalHost();
                //                System.out.println(inetAddress);


                Socket socket = serverSocket.accept();


                System.out.println("Client got connected");

                ClientThread thread = new ClientThread(socket);

                thread.start();
            }

            serverSocket.close();
        } catch(IOException e)
        {
            System.out.println("Port is open");
        }
    }
}
