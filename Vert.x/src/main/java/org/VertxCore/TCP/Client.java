package org.VertxCore.TCP;

import io.vertx.core.Vertx;
import io.vertx.core.net.NetClient;
import io.vertx.core.net.NetClientOptions;
import io.vertx.core.net.NetSocket;

public class Client
{
    public static void main(String[] args)
    {
        Vertx vertx = Vertx.vertx();

        NetClientOptions options = new NetClientOptions().setReconnectAttempts(5).setReconnectInterval(500);

        NetClient client = vertx.createNetClient(options);

        client.connect(8080, "localhost", result -> {
            if(result.succeeded())
            {
                System.out.println("Connected to server");

                NetSocket socket = result.result();

                socket.write("Hello server");

                socket.handler(buffer -> {

                    System.out.println("Received from server :" + buffer.toString());
                });

                socket.exceptionHandler(exception -> {

                    System.err.println("Exception occurred: " + exception.getCause());
                });
            }
            else
            {
                System.out.println("Failed to connect to server :" + result.cause());
            }
        });
    }
}
