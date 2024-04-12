package org.example.EventBus;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main
{
    public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args)
    {
        Vertx vertx = Vertx.vertx();

        DeploymentOptions deployementOptions = new DeploymentOptions().setInstances(2);


//
//        vertx.deployVerticle("org.example.EventBus.PointToPoint.Sender", res -> {
//            if(res.succeeded())
//            {
//                System.out.println("Sender deployed successfully");
//            }
//            else
//            {
//                System.out.println(res.cause());
//            }
//        });
//        vertx.deployVerticle("org.example.EventBus.PointToPoint.Reciever", deployementOptions, res -> {
//            if(res.succeeded())
//            {
//                System.out.println("Receiver deployed successfully");
//            }
//            else
//            {
//                System.out.println(res.cause());
//            }
//        });
//
        vertx.deployVerticle("org.example.EventBus.ReqRes.Request", deployementOptions, res -> {
            if(res.succeeded())
            {
                System.out.println("RequestVerticle deployed successfully");
            }
            else
            {
                System.out.println(res.cause());
            }
        });
        vertx.deployVerticle("org.example.EventBus.ReqRes.Response", res -> {
            if(res.succeeded())
            {
                System.out.println("ResponseVerticle deployed successfully");
            }
            else
            {
                System.out.println(res.cause());
            }
        });

//        vertx.deployVerticle("org.example.EventBus.PubSub.Publisher",deployementOptions,res->
//        {
//            if(res.succeeded())
//            {
//                System.out.println("Publisher deployed successfully");
//            }
//            else {
//                System.out.println(res.cause());
//            }
//        });
//        vertx.deployVerticle("org.example.EventBus.PubSub.Subscriber",deployementOptions,res->{
//            if(res.succeeded())
//            {
//                System.out.println("Subscriber deployed successfully");
//            }
//            else {
//                System.out.println(res.cause());
//            }
//        });
    }
}
