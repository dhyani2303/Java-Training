package org.VertxWeb.sockJS;

import io.vertx.core.Vertx;
import io.vertx.ext.bridge.BridgeEventType;
import io.vertx.ext.bridge.PermittedOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.sockjs.SockJSBridgeOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;

public class EventBusBridge
{
    public static void main(String[] args)
    {
        var vertx = io.vertx.core.Vertx.vertx();

        var router = Router.router(vertx);

        var options = new SockJSBridgeOptions().addInboundPermitted(new PermittedOptions().setAddress("test")).addOutboundPermitted(new PermittedOptions().setAddress("add")).setPingTimeout(5000);

        var sockjs = SockJSHandler.create(vertx);

        router.route("/eventbus/*").subRouter(sockjs.bridge(options, be -> {

            System.out.println(be.type() + " " + be.getRawMessage());

            if(be.type() == BridgeEventType.PUBLISH)
            {
                System.out.println("This type is not allowed");

                be.complete(false);
            }
            if(be.type()==BridgeEventType.SOCKET_IDLE)
            {
                System.out.println("Ping message did not arrive");


            }
            be.complete(true);

        }));

        vertx.eventBus().consumer("test",message ->{

            System.out.println("Message received "+ message.body());
        });

//        vertx.eventBus().publish("test","Hello from publisher server");

        vertx.setPeriodic(5000,handler-> {
                    vertx.eventBus().send("add", "Hello from publisher server");
                });
        vertx.createHttpServer().requestHandler(router).listen(8000);
    }
}
