package org.example.Verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Context;
import io.vertx.core.Promise;

public class Verticle extends AbstractVerticle
{
    public void start(Promise<Void> startPromise)
    {



        vertx.setPeriodic(1000,id->{




            System.out.println("Hello " + Thread.currentThread());
        });

        Context ctx = vertx.getOrCreateContext();

        System.out.println(ctx.isEventLoopContext());

        ctx.runOnContext(res->{
            System.out.println("Context thread "+ Thread.currentThread());
        });


        startPromise.complete();
        
//        System.out.println("MyVerticle has started");
//
//        System.out.println(Thread.currentThread());
//
//        vertx.setPeriodic(1000,res->
//        {
//            System.out.println("Response "+res);
//            System.out.println("Hello"+ res + Thread.currentThread());
//        });
//
//        vertx.setPeriodic(1000,res->
//        {
//            System.out.println("Another periodic "+ res + " "+ Thread.currentThread());
//        });
    }

    public void stop(Promise<Void> stopPromise)
    {

        System.out.println("MyVerticle stopped");

        stopPromise.complete();
    }
    }

