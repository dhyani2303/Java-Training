package org.VertxCore.FileSystem;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.AsyncFile;
import io.vertx.core.file.FileSystem;
import io.vertx.core.file.OpenOptions;



public class Main
{
    public static void main(String[] args)
    {
        Vertx vertx = Vertx.vertx();

        FileSystem fileSystem = vertx.fileSystem();


       fileSystem.open("example1.txt",new OpenOptions().setCreate(false),result->{
            if(result.succeeded())
            {
                System.out.println("File opened successfully");

                AsyncFile file = result.result();



                file.read(Buffer.buffer(),0,0,1024,ar->{
                    if(ar.succeeded())
                    {
                        System.out.println("Reading from file");

                        Buffer buffer = ar.result();

                        System.out.println(buffer.toString());

                        System.out.println("Reading completed");
                    }
                    else {
                        System.out.println("Unable to read the contents "+ ar.cause());
                    }

                });
            }
            else
            {
                System.out.println("Failed to open file " + result.cause());
            }
        });


//this method cannot be used for copying to the existing file
       fileSystem.copy("example.txt","les_miserables1.txt",ar->
       {
           if(ar.succeeded())
           {

               System.out.println("Copy has been successful");

           }
           else
           {
               System.out.println("Unable to copy the content "+ ar.cause());
           }
       });


        // to copy the content from one file to another file
        final AsyncFile output = vertx.fileSystem().openBlocking("plagiary.txt", new OpenOptions());

        fileSystem.open("les_miserables.txt", new OpenOptions())
                .compose(file -> file
                        .pipeTo(output)
                        .eventually(v -> file.close()))
                .onComplete(result -> {
                    if (result.succeeded()) {
                        System.out.println("Copy done");
                    } else {
                        System.err.println("Cannot copy file " + result.cause().getMessage());
                    }
                });
//
        fileSystem.exists("example1.txt").compose(exist->{
            if(exist)
            {
                return vertx.fileSystem().delete("example1.txt");
            }
            else
            {
                return Future.failedFuture("File does not exist ");
            }
        }).onComplete(result->{
            if(result.succeeded())
            {
                System.out.println("File deleted");
            }
            else {
                System.out.println("Cannot delete file "+ result.cause());
            }
        });
    }
}
