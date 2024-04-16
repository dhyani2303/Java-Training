package org.VertxWeb;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

public class HttpMethods
{
    public static void main(String[] args)
    {
        Vertx vertx = Vertx.vertx();

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

       router.get("/resources").handler(ctx->{
           JsonObject jsonObject = new JsonObject();

           jsonObject.put("id","1").put("name","resource-1");
           ctx.response().setStatusCode(200).putHeader("Content-Type","application/json")
                   .end(jsonObject.toString());

       });

        router.post("/resources").handler(ctx->{

            JsonObject jsonObject = new JsonObject();

         ctx.request().bodyHandler(buffer -> System.out.println(buffer.toJsonObject()));

            jsonObject.put("id","1").put("name","resource-1");

            ctx.response().setStatusCode(200).putHeader("Content-Type","application/json").end();

        });

        router.put("/resources/:resourceId").handler(ctx->{

            String resourceId = ctx.pathParam("resourceId");

            System.out.println(resourceId);

            ctx.request().bodyHandler(buffer -> {

             String updatedName = buffer.toJsonObject().getString("name");

                ctx.response().putHeader("Content-Type","application/json");

                ctx.json(new JsonObject().put("id",resourceId).put("name",updatedName));

            });




        });


        server.requestHandler(router).listen(8000);
    }


}
