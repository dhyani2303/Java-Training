package org.VertxCore.Future;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.file.FileProps;
import io.vertx.core.file.FileSystem;

public class FutureResults
{
    public static void main(String[] args)
    {
        Vertx vertx = Vertx.vertx();

        add(2,3).onComplete(result->{

            if(result.succeeded())
            {
                System.out.println(result.result());
            }
            else
            {
                System.out.println(result.cause());
            }
        });
    }
    
    static Future<Integer> add(int a,int b)
    {
        Promise<Integer> promise = Promise.promise();

        Vertx.vertx().setTimer(1000,id->{

            promise.complete(a+b);
        });

        return  promise.future();
    }
}
