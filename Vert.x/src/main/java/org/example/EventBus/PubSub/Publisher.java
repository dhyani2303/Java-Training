package org.example.EventBus.PubSub;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.MessageProducer;

import static org.example.EventBus.Main.LOGGER;

public class Publisher extends AbstractVerticle
{
    public void start()
    {
        EventBus eventBus = vertx.eventBus();

        MessageProducer<String> producer = eventBus.publisher("title");

        vertx.setPeriodic(5000,id->{

          
            String message = "Hello everyone";

            producer.write(message);

            LOGGER.info("Message published {}",message);
        });


    }

}
