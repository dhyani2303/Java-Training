package org.VertxWeb.sockJS;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;
import io.vertx.ext.web.handler.sockjs.SockJSHandlerOptions;

public class EventBus
{
    public static void main(String[] args)
    {
        var vertx = Vertx.vertx();

        var router = Router.router(vertx);

        var options = new SockJSHandlerOptions().setRegisterWriteHandler(true);

        var sockjs = SockJSHandler.create(vertx,options);

      

        router.route("/eventbus/*").subRouter(sockjs.socketHandler(socket->{
            socket.handler(buffer ->{


                vertx.eventBus().send(socket.writeHandlerID(),buffer);

                System.out.println("Message sent "+ buffer.toString());

            });

        }));
        vertx.eventBus().consumer("test",res->{
            System.out.println("Event bus "+ res.body().toString());

        });

        vertx.createHttpServer().requestHandler(router).listen(8000);



    }
}
