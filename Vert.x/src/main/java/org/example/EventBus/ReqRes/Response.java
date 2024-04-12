package org.example.EventBus.ReqRes;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

import static org.example.EventBus.Main.LOGGER;

public class Response extends AbstractVerticle
{
    public void start()
    {
        EventBus eventBus = vertx.eventBus();
        DeliveryOptions options = new DeliveryOptions();

        options.addHeader("header","header-info").setSendTimeout(5000);

        JsonObject jsonObject = new JsonObject();

        jsonObject.put("name","Dhyani");

        vertx.setPeriodic(2000, id-> {

            eventBus.<String>request("my.address", jsonObject, options, ar -> {
                if(ar.succeeded())
                {
                    Message<String> response = ar.result();

                    JsonObject receivedMessage = new JsonObject(String.valueOf(response.body()));

                    LOGGER.info("Received response {}", receivedMessage.getString("message"));


                }
                else
                {
                    LOGGER.error("{}", ar.cause());
                }
            });
        });
    }
}
