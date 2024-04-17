package org.VertxWeb;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.FileUpload;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

import java.nio.Buffer;
import java.util.List;

public class BodyHandling
{
    public static void main(String[] args)
    {

        Vertx vertx = Vertx.vertx();

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router.route().handler(BodyHandler.create().setBodyLimit(1024 * 1024));

        router.post("/upload").handler(ctx -> {

            System.out.println(ctx.fileUploads().size());

            ctx.response().end("Data received");

        });

        router.route().failureHandler(ctx -> {

            ctx.response().end("Request body is too large");
        });

        server.requestHandler(router).listen(8000);
    }
}
