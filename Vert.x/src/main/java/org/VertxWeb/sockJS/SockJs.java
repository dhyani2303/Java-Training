package org.VertxWeb.sockJS;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;
import io.vertx.ext.web.handler.sockjs.SockJSHandlerOptions;


public class SockJs
{
    public static void main(String[] args)
    {
        var vertx = Vertx.vertx();

       var server = vertx.createHttpServer();

       var router = Router.router(vertx);

       var sockOptions = new SockJSHandlerOptions().setHeartbeatInterval(2000);

        var sockjs = SockJSHandler.create(vertx,sockOptions);

        router.route("/eventbus/*").subRouter(sockjs.socketHandler(socket->{

       socket.handler(buffer -> {

          var message = buffer.toString() + "from server";

           System.out.println("Received from client "+ buffer.toString());

           socket.write(message);
       });
        }));


      server.requestHandler(router).listen(8000);

    }
}
