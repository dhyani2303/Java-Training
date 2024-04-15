package org.VertxCore.Verticle;

import io.vertx.core.AbstractVerticle;

import static org.VertxCore.Verticle.Main.LOGGER;

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
