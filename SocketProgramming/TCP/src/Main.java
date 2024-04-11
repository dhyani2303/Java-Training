import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        //        //65535 is the maximum port value i can assign.This program gives list of all the ports that are open.
        //        int port = 1;
        //        while(port < 65535)
        //        {
        //            try
        //            {
        //                // creation of server socket
        //                ServerSocket serverSocket = new ServerSocket(port);
        //
        //
        //            } catch(IOException e)
        //            {
        //                System.out.println("Port" + port + " is open");
        //            }
        //            port++;

        try
        {
            // creation of server socket
            ServerSocket serverSocket = new ServerSocket(3030);

            //waiting for client
            boolean stop = false;


            // the while loop lets us accept multiple clients bt they are not accepted simultaneously.
            //            while(!stop)
            //            {
            System.out.println("Server is waiting for clients...");


            Socket socket = serverSocket.accept();

            //message for client from server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("hello client");

            //reading from client
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String clientInput = input.readLine();

            System.out.println(clientInput);

            input.close();

            out.close();

            socket.close();
            //            }

            serverSocket.close();

        } catch(IOException e)
        {
            System.out.println("Port is open");
        }


    }
}

