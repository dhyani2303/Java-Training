package org.VertxWeb;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.ResponseContentTypeHandler;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.handler.TimeoutHandler;

public class StaticResources
{
    public static void main(String[] args)
    {
        Vertx vertx = Vertx.vertx();

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router.route().handler(TimeoutHandler.create(2000)).handler(ResponseContentTypeHandler.create());

        router.route("/").handler(ctx->{

        });

        router.get("/test").handler(ctx ->
                ctx.json(new JsonObject().put("message","hello"))
        );


        router.route("/public/*").handler(StaticHandler.create("public").setIndexPage("index.html").setCachingEnabled(false));




        server.requestHandler(router).listen(8000);

    }
}
