package org.VertxCore.UDP;

import io.vertx.core.Vertx;
import io.vertx.core.datagram.DatagramSocket;

public class Receiver
{
    public static void main(String[] args)
    {
        Vertx vertx=Vertx.vertx();

        DatagramSocket socket = vertx.createDatagramSocket();

        String reply = "Received message";

        socket.handler(packet->{
            System.out.println(packet.data() + " " + packet.sender());


        }).listen(1234,"localhost");


    }
}
