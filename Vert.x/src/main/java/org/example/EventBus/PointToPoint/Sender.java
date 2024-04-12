package org.example.EventBus.PointToPoint;

import static org.example.EventBus.Main.LOGGER;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import io.vertx.core.eventbus.MessageProducer;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.example.EventBus.Person;


public class Sender extends AbstractVerticle
{
    public void start()
    {


        EventBus eventBus = vertx.eventBus();

        Person person = new Person();

        person.setName("Dhyani");

        person.setAge(21);


        JsonObject jsonObject = JsonObject.mapFrom(person);

        vertx.setPeriodic(10000,id->{

            eventBus.send("address",jsonObject);


            LOGGER.info("Sending message {}",jsonObject);


        });

    }

}
