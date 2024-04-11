import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

class ClientHandler extends Thread
{
    private Socket socket;

    private PrintWriter writer;

    private static int clientCount = 0;

    private int clientId;

    private List<ClientHandler> clients;

    ClientHandler(Socket socket, List<ClientHandler> clients)
    {
        this.socket = socket;

        this.clients = clients;

        this.clientId = ++clientCount;
    }

    public void run()
    {
        try
        {
            writer = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader reader = new BufferedReader((new InputStreamReader(socket.getInputStream())));

            String clientInput;

            while((clientInput = reader.readLine()) != null)
            {
                if(clientInput.equals("exit"))
                {
                    break;
                }
                for(ClientHandler client : clients)
                {
                    if(client != this)
                    {
                        client.sendMessage("Client" + clientId + ": " + clientInput);
                    }
                }

            }
            clients.remove(this);

            reader.close();

            socket.close();
        } catch(IOException e)
        {
            throw new RuntimeException(e);
        }

    }

    public void sendMessage(String message)
    {
        writer.println(message);
    }
}

public class MultiThreadedServer
{
    public static void main(String[] args)

    {
        List<ClientHandler> clients = new ArrayList<>();
        try
        {
            ServerSocket serverSocket = new ServerSocket(3030);

            while(true)
            {
                Socket socket = serverSocket.accept();

                ClientHandler clientHandler = new ClientHandler(socket, clients);

                clients.add(clientHandler);

                clientHandler.start();
            }

        } catch(IOException e)
        {
            throw new RuntimeException(e);
        }

    }
}
