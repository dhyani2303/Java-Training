package org.VertxCore.EventBus.PointToPoint;

import static org.VertxCore.EventBus.Main.LOGGER;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import org.VertxCore.EventBus.Person;


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
