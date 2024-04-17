package org.VertxWeb;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

public class RouteHandler
{
    public static void main(String[] args)
    {
        Vertx vertx = Vertx.vertx();

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        Route route = router.route("/");

        route.putMetadata("metadata-key",123).handler(ctx->{

            HttpServerResponse response = ctx.response();

            response.setChunked(true);

            response.write("Hello from route 1\n");

            ctx.vertx().setTimer(10000,id->{
               ctx.next();
            });
        });

        route.handler(ctx->{

            HttpServerResponse response = ctx.response();

            response.write("Hello from route 2\n");

           ctx.response().end();
        });

        server.requestHandler(router).listen(8000);


    }
}
