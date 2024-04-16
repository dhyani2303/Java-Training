package org.VertxWeb;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

import java.sql.SQLOutput;

public class BlockingHandler
{
    public static void main(String[] args)
    {
        Vertx vertx = Vertx.vertx();

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);




        router.route().handler(ctx->{
            String response = "Hello there";

            ctx.response().putHeader("Content-Length", String.valueOf(response.length())).write(response);


        });
        router.route().blockingHandler(ctx->
        {
            try
            {
                Thread.sleep(2000);

                System.out.println("Thread came out of sleep");

                String response = "Thread came out of sleep";

                ctx.response().putHeader("Content-Length", String.valueOf(response.length())).end(response);



            } catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        },false);

        server.requestHandler(router).listen(8000);
    }
}
