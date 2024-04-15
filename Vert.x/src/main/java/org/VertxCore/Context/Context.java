package org.VertxCore.Context;

import io.vertx.core.Vertx;

import static org.VertxCore.Verticle.Main.LOGGER;

public class Context
{
    public static void main(String[] args)
    {
        Vertx vertx = Vertx.vertx();

      io.vertx.core.Context ctx = vertx.getOrCreateContext();

      ctx.runOnContext(v->{
          LOGGER.info("Task executed on context thread");
      });

      ctx.executeBlocking(res->
      {
          try
          {
              LOGGER.info("Blocking the task");

              Thread.sleep(4000);
          }
          catch(InterruptedException e)
          {
              LOGGER.error(e.getMessage());
          }

          LOGGER.info("Blocking Completed");

      });


    }
}
