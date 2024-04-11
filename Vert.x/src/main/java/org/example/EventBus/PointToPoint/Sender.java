package org.example.EventBus.PointToPoint;

import static org.example.EventBus.Main.LOGGER;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import io.vertx.core.eventbus.MessageProducer;



public class Sender extends AbstractVerticle
{
    public void start()
    {
        EventBus eventBus = vertx.eventBus();

        MessageProducer<String> producer = eventBus.sender("address");


        vertx.setPeriodic(10000,id->{
            String message = "Hello from sender";

            LOGGER.info("Sending message {}",message);

            producer.write(message);
        });

    }

}
