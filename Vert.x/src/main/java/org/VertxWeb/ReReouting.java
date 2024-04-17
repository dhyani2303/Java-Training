package org.VertxWeb;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

public class ReReouting
{
    public static void main(String[] args)
    {
        Vertx vertx = Vertx.vertx();

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router.route("/").handler(ctx->{
           ctx.response().putHeader("Content-Type","text/html").end("<h1>Welcome to home page</h1>");

        });

        router.route("/about").handler(ctx->{
            ctx.response().putHeader("Content-Type","text/html").end("<h1>About our company</h1>");

        });
        router.route("/contact").handler(ctx->{
            ctx.response().putHeader("Content-Type","text/html").end("<h1>Contact us</h1>");

        });
        router.route("/home").handler(ctx->{
          ctx.reroute("/");

        });
        router.route("/info").handler(ctx->{
            ctx.reroute("/about");

        });
        router.route("/feedback").handler(ctx->{
            ctx.reroute("/contact");

        });



        server.requestHandler(router).listen(8000);
    }

}
