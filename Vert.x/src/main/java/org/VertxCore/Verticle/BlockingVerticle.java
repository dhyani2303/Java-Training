package org.VertxCore.Verticle;

import io.vertx.core.AbstractVerticle;

public class BlockingVerticle extends AbstractVerticle
{
    public void start()
    {
        vertx.setTimer(1000, id -> {
          while(true);
        });

    }
}
