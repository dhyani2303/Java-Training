import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

class ServerReader extends Thread
{


    Socket socket = new Socket();


    ServerReader(Socket socket)
    {
        this.socket = socket;
    }


    public void run()
    {
        BufferedReader serverreader = null;
        try
        {

            serverreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverResponse;
            while((serverResponse = serverreader.readLine()) != null)
            {
                if(serverResponse.equals("exit"))
                {

                    break;
                }
                System.out.println(serverResponse);


            }

            socket.close();


        } catch(IOException e)
        {
            System.out.println(e.toString());
        }


    }
}

public class Client
{
    public static void main(String[] args)
    {
        Socket socket = null;

        BufferedReader consoleReader = null;

        PrintWriter writer = null;

        ServerReader serverReader = null;


        try
        {
            InetAddress address = InetAddress.getByName("localhost");

            socket = new Socket(address, 3030);

            consoleReader = new BufferedReader(new InputStreamReader(System.in));

            writer = new PrintWriter(socket.getOutputStream(), true);

            serverReader = new ServerReader(socket);

            serverReader.start();


            String consoleline = "";

            while((consoleline = consoleReader.readLine()) != null)
            {

                if(consoleline.equals("exit"))
                {

                    break;
                }
                writer.println(consoleline);


            }


        } catch(UnknownHostException e)
        {
            throw new RuntimeException(e);

        } catch(IOException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            try
            {


                if(consoleReader != null)
                    consoleReader.close();
                if(writer != null)
                    writer.close();
                // Wait for serverReader thread to finish


            } catch(IOException e)
            {
                throw new RuntimeException(e);
            }

        }

    }
}
