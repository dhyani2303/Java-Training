package org.example.EventBus.ReqRes;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

import static org.example.EventBus.Main.LOGGER;

public class Request extends AbstractVerticle
{
    public void start()
    {
        EventBus eventBus = vertx.eventBus();

        eventBus.consumer("my.address",this::handleRequest);


    }

    private  void handleRequest(Message<JsonObject> request)
    {
        LOGGER.info("Received request: {}",request.body().getString("name"));

        JsonObject response = new JsonObject();

        response.put("message","Hello "+ request.body().getString("name") + "!");

        request.reply(response);
    }
}
