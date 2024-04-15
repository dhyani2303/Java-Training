package org.VertxCore.Verticle;

import static org.VertxCore.Verticle.Main.LOGGER;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Promise;


public class ExecuteBlockingVerticle extends AbstractVerticle
{
    public void start()
    {
        vertx.setPeriodic(5000, id -> {
            vertx.executeBlocking(this::blockingCode, this::resultHandler);
            ;
        });

    }

    public void blockingCode(Promise<String> promise)
    {
        try
        {

            Thread.sleep(4000);

            LOGGER.info("Done");

            promise.complete("Ok!");

        } catch(InterruptedException e)
        {

            LOGGER.error("Error occurred {} ",e.getMessage());

            promise.fail(e);

        }

    }

    public void resultHandler(AsyncResult ar)
    {

        if(ar.succeeded())
        {

            LOGGER.info("Blocking code result {}", ar.result());


        }
        else
        {
            LOGGER.error("Error occured {}", ar.cause());


        }

    }
}

