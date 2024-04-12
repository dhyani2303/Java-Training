package org.example.TCP;

import io.vertx.core.Vertx;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.NetServerOptions;

public class Server
{
    public static void main(String[] args)
    {
        Vertx vertx = Vertx.vertx();

        NetServerOptions options = new NetServerOptions().setHost("localhost").setPort(8080);

        NetServer netServer = vertx.createNetServer(options);

        netServer.connectHandler(socket -> {

            System.out.println("New Connection from " + socket.remoteAddress());

            socket.handler(buffer -> {

                System.out.println("Received from client " + buffer.toString());

                socket.write("Hello client");
            });
            socket.exceptionHandler(exception -> {

                System.err.println("Exception occurred: " + exception.getCause());
            });

            socket.closeHandler(v -> {

                System.out.println("Connection closed");
            });
        });


        //port and host can be set in this manner as well.
        // netServer.listen(8080,"localhost",handler);

        netServer.listen(result -> {
            if(result.succeeded())
            {
                //actualport is used when we have used 0 as port i.e. random port number is selected
                System.out.println("Server is listening on " + netServer.actualPort());

                System.out.println("TCP server started and listening");
            }
            else
            {
                System.out.println("Failed to start TCP server " + result.cause());
            }
        });

    }
}
