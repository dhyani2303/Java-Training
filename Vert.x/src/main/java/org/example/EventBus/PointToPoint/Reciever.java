package org.example.EventBus.PointToPoint;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;

import static org.example.EventBus.Main.LOGGER;

public class Reciever extends AbstractVerticle
{
    public void start()
    {
        EventBus eventBus = vertx.eventBus();

        eventBus.consumer("address", this::handleMessage);
    }

    private void handleMessage(Message<String> message)
    {

        LOGGER.info("Received message: {} ", message.body());
    }

}
