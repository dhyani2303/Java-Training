package org.example.EventBus.ReqRes;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;

import static org.example.EventBus.Main.LOGGER;

public class Response extends AbstractVerticle
{
    public void start()
    {
        EventBus eventBus = vertx.eventBus();

        vertx.setPeriodic(2000, id-> {

            eventBus.<String>request("my.address", "Dhyani", ar -> {
                if(ar.succeeded())
                {
                    Message<String> response = ar.result();

                    LOGGER.info("Received response {}", response.body());


                }
                else
                {
                    LOGGER.error("{}", ar.cause());
                }
            });
        });
    }
}
