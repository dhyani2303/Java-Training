package org.example.HTTP;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;

public class Server
{
    public static void main(String[] args)
    {
        Vertx vertx = Vertx.vertx();

        HttpServerOptions options = new HttpServerOptions().setPort(8000).setHost("localhost");

        HttpServer httpServer = vertx.createHttpServer(options);

        httpServer.requestHandler(request->
        {

            if(request.path().equals("/"))
            {
                request.response().sendFile("src/main/resources/image.jpeg");
            }
            else
            {
                String responseBody = "<h1>Hii user<h1>";

                request.response().putHeader("Content-Length", String.valueOf(responseBody.length())).end(responseBody);
            }

            System.out.println(request.headers());

            System.out.println("Absolute uri " + request.absoluteURI() + " Path: "+ request.path() +  " Method: "+ request.method() + " Address " + request.remoteAddress());
        });

        httpServer.listen(result->
        {
            if(result.succeeded())
            {
                System.out.println("HTTP is listening");
            }
            else {
                System.out.println("Unable to start http server : "+ result.cause());
            }
        });


    }
    
}
