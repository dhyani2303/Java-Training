package org.VertxCore.Verticle;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.ThreadingModel;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args)
    {

        Vertx vertx = Vertx.vertx(new VertxOptions().setBlockedThreadCheckInterval(6000));

        DeploymentOptions deploymentOptions = new DeploymentOptions().setInstances(2);

        DeploymentOptions workerVerticleOptions = new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER).setInstances(2);


        vertx.setTimer(5000, id -> {
            System.out.println("Ran the program " + id);
        });

        vertx.deployVerticle("org.example.Verticle.WorkerVerticle", workerVerticleOptions);

        vertx.deployVerticle("org.example.Verticle.Verticle", deploymentOptions, res -> {
            if(res.succeeded())
            {


                System.out.println("Successful");
            }
            else
            {
                System.out.println("Unsuccessful");
            }
        });

//        vertx.deployVerticle("org.example.Verticle.ExecuteBlockingVerticle", res -> {
//            System.out.println(res.result());
//        });


        // vertx.deployVerticle(new BlockingVerticle());


    }
}