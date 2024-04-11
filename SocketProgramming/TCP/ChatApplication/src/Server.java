import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ClientReader extends Thread
{
    Socket socket = new Socket();


    ClientReader(Socket socket)
    {
        this.socket = socket;

    }


    public void run()
    {

        {
            try
            {
                BufferedReader clientreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String consolereader = "";

                while((consolereader = clientreader.readLine()) != null)

                {
                    if(consolereader.equals("exit"))
                    {
                        break;
                    }
                    System.out.println("Client:" + consolereader);
                }

                clientreader.close();
                socket.close();

            } catch(IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }


}


public class Server
{
    public static void main(String[] args)
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(3030);

            System.out.println("Server is waiting for client...");
            
            boolean flag = true;
            while(flag)
            {

                Socket socket = serverSocket.accept();

                ClientReader reader = new ClientReader(socket);

                reader.start();


                BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                String consoleline = "";

                while((consoleline = consoleReader.readLine()) != null)
                {
                    if(consoleline.equals("exit"))
                    {
                        flag = false;
                        break;
                    }
                    writer.println("Server:" + consoleline);

                }

                consoleReader.close();

                writer.close();


            }
            serverSocket.close();

        } catch(IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
