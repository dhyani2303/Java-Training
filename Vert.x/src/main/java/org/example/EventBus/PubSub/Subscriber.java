package org.example.EventBus.PubSub;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;

import static org.example.EventBus.Main.LOGGER;

public class Subscriber extends AbstractVerticle
{

    public void start()
    {
        EventBus eventBus = vertx.eventBus();

        eventBus.consumer("title",this::handleMessage);
    }
    private void handleMessage(Message<String> message)
    {
        LOGGER.info("Received Message {}",message.body());
    }


}
