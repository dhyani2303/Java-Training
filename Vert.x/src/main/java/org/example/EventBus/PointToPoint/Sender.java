package org.example.EventBus.PointToPoint;

import static org.example.EventBus.Main.LOGGER;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import io.vertx.core.eventbus.MessageProducer;
import io.vertx.core.json.JsonObject;


public class Sender extends AbstractVerticle
{
    public void start()
    {
        EventBus eventBus = vertx.eventBus();


        JsonObject jsonObject = new JsonObject();

        jsonObject.put("message","Hello from sender");

        vertx.setPeriodic(10000,id->{

            eventBus.send("address",jsonObject);


            LOGGER.info("Sending message {}",jsonObject);


        });

    }

}
