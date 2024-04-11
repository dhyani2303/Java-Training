package org.example.Verticle;

import io.vertx.core.AbstractVerticle;

import static org.example.Verticle.Main.LOGGER;

public class WorkerVerticle extends AbstractVerticle
{
    public void start()
    {
        vertx.setPeriodic(5000, id -> {

            try
            {




                Thread.sleep(1000);

                LOGGER.info("Up {}", id);

            } catch(InterruptedException e)
            {
                LOGGER.error("Oops", e);
            }
        });
    }
}
