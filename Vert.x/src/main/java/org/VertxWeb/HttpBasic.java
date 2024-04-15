package org.VertxWeb;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

public class HttpBasic
{
    public static void main(String[] args)
    {
        Vertx vertx = Vertx.vertx();
        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router.route("/").handler(ctx->{

            HttpServerResponse response = ctx.response();

            response.putHeader("content-type","text/plain");

            response.end("Helloo");
        });

        server.requestHandler(router).listen(8000);

    }

}
