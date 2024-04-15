package org.example.UDP;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.datagram.DatagramSocket;
import io.vertx.core.datagram.DatagramSocketOptions;

public class Sender
{
    public static void main(String[] args)
    {
        Vertx vertx = Vertx.vertx();

        DatagramSocket socket = vertx.createDatagramSocket(new DatagramSocketOptions());

        Buffer buffer = Buffer.buffer("Message");

        vertx.setPeriodic(2000,id-> {
            socket.send(buffer, 1234, "localhost", result -> {
                if(result.succeeded())
                {
                    System.out.println("Sent Successfully");
                }
                else
                {
                    System.out.println("Some error occurred " + result.cause());
                }
            });
        });



    }

}
