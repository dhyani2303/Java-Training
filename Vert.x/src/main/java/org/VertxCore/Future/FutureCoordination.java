package org.VertxCore.Future;

import io.vertx.core.CompositeFuture;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.net.NetClient;
import io.vertx.core.net.NetServer;

public class FutureCoordination
{
    public static void main(String[] args)
    {
        Vertx vertx = Vertx.vertx();

        HttpServer httpServer = vertx.createHttpServer();

        httpServer.requestHandler(request->{
            request.response().end("Hello from HTTP server!");
        });
        NetServer netServer = vertx.createNetServer();

        netServer.connectHandler(netSocket ->
        {
            netSocket.write("Hello from server");

            netServer.close();
        });

        Future<HttpServer> httpServerFuture = httpServer.listen(8000);

        Future<NetServer> netServerFuture = netServer.listen(8000);

        Future<CompositeFuture> compositeFuture = Future.all(httpServerFuture,netServerFuture);

        compositeFuture.onComplete(ar->{
            if(ar.succeeded())
            {
                CompositeFuture result = ar.result();

                System.out.println("Successful");
            }
            else
            {
                System.out.println(ar.cause());

            }
        });
    }
}
