package org.example.EventBus.PointToPoint;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;
import netscape.javascript.JSObject;
import org.example.EventBus.Person;

import static org.example.EventBus.Main.LOGGER;

public class Reciever extends AbstractVerticle
{
    public void start()
    {
        EventBus eventBus = vertx.eventBus();

        eventBus.consumer("address", this::handleMessage);
    }

    private void handleMessage(Message<JsonObject> message)
    {
        Person personFromJson = message.body().mapTo(Person.class);

        LOGGER.info("Received message: {} ", personFromJson.getAge() + " " + personFromJson.getName());
    }

}
