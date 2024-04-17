package org.VertxWeb;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

public class SubRouters
{
    public static void main(String[] args)
    {
        Vertx vertx = Vertx.vertx();

        HttpServer server = vertx.createHttpServer();

        Router router1 = Router.router(vertx);

        Router router2=Router.router(vertx);

        router1.route("/api/*").subRouter(router2);

        router1.get("/about").handler(ctx->{

            ctx.response().putHeader("Context-Type","text/html").end("<h1>Welcome to about us from router 1</h1>");
        });

        router2.get("/").handler(ctx->{
            ctx.response().end("<h1>Welcome to home page from router 2</h1>");
        });

        router2.get("/about").handler(ctx->{
            ctx.response().end("<h1>Welcome to about page from router 2</h1>");
        });

        server.requestHandler(router1).listen(8000);
    }
}
