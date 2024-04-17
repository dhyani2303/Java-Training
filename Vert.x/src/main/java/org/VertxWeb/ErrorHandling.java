package org.VertxWeb;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

public class ErrorHandling
{
    public static void main(String[] args)
    {

        Vertx vertx = Vertx.vertx();

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router.get("/path1").handler(ctx -> {
            throw new RuntimeException("something happened");
        });

        router.get("/path2").handler(ctx -> {

            ctx.fail(401);
        }).failureHandler(ctx -> {
            ctx.response().setStatusCode(ctx.statusCode()).end("Oopss failed in path 2");
        });


        //this is a generic failure handler i.e it is for every path since path is not specified in get() method.

        router.get().failureHandler(ctx -> {

            ctx.response().setStatusCode(ctx.statusCode()).end("Failed in path");
        });


        server.requestHandler(router).listen(8000);
    }
}
