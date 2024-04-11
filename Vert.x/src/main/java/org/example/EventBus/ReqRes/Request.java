package org.example.EventBus.ReqRes;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;

import static org.example.EventBus.Main.LOGGER;

public class Request extends AbstractVerticle
{
    public void start()
    {
        EventBus eventBus = vertx.eventBus();

        eventBus.consumer("my.address",this::handleRequest);


    }

    private  void handleRequest(Message<String> request)
    {
        LOGGER.info("Received request: {}",request.body());

        String response = "Hello, " + request.body() + "!";



        request.reply(response);
    }
}
