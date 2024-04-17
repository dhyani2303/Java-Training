package org.VertxWeb;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.FileSystem;
import io.vertx.core.file.OpenOptions;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

public class HelperFunction
{
    public static void main(String[] args)
    {
        Vertx vertx = Vertx.vertx();

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        FileSystem fileSystem = vertx.fileSystem();

        router.route(HttpMethod.GET, "/download").handler(ctx -> {

            fileSystem.open("/home/dhyani/IdeaProjects/Java-Training/Vert.x/example.txt", new OpenOptions(), result -> {

                if(result.succeeded())
                {
                    result.result().read(Buffer.buffer(), 0, 0, 100, ar -> {

                        if(ar.succeeded())
                        {
                            Buffer buffer = ar.result();

                            //to download the file
                            //   ctx.attachment("example.txt").end(buffer);

                            ctx.end(buffer);
                        }
                        else
                        {
                            Buffer buffer = Buffer.buffer("Unable to download file");


                            ctx.response().end(buffer);
                        }

                    });
                }
            });
        });

        router.route(HttpMethod.GET, "/youtube/:query").handler(ctx -> {

            String query = ctx.pathParam("query");

            if(query != null && !query.isEmpty())

                ctx.redirect("https://www.youtube.com/results?search_query=" + query);

            

        });

        server.requestHandler(router).listen(8000);

    }
}
