package org.VertxWeb;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import netscape.javascript.JSObject;

public class SimpleResponses
{
    public static void main(String[] args)
    {
        Vertx vertx=Vertx.vertx();

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router.get("/").respond(ctx-> Future.succeededFuture(new JsonObject().put("Hello","World")));

        server.requestHandler(router).listen(8000);

        router.get("/about").respond(
                ctx->ctx.response().putHeader("Content-Type","text/plain").end("About me")
        );
    }

}
