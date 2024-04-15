package org.VertxCore.EventBus.PubSub;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;

import static org.VertxCore.EventBus.Main.LOGGER;

public class Publisher extends AbstractVerticle
{
    public void start()
    {
        EventBus eventBus = vertx.eventBus();

        JsonObject jsonObject = new JsonObject();

        jsonObject.put("message","Hello everyone");




        vertx.setPeriodic(5000,id->{

            eventBus.publish("title",jsonObject);

            LOGGER.info("Message published {}",jsonObject);
        });


    }

}
