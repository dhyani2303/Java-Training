package org.VertxCore.JSON;

import io.vertx.core.Vertx;
import io.vertx.core.impl.ConcurrentHashSet;
import io.vertx.core.json.JsonObject;

import java.util.*;
import java.util.concurrent.*;

public class Example1
{
    public static void main(String[] args)
    {
        Vertx vertx = Vertx.vertx();

        vertx.eventBus().consumer("test", jsonObjectMessage -> {
            var handler = jsonObjectMessage.body().toString();

            System.out.println(handler);
        });
        vertx.eventBus().consumer("test", jsonObjectMessage -> {
            var handler = jsonObjectMessage.body().toString();

            System.out.println(handler);
        });
        vertx.eventBus().consumer("test", jsonObjectMessage -> {
            var handler = jsonObjectMessage.body().toString();

            System.out.println(handler);
        });

        HashSet data = new HashSet<>();
        var linkedHashSet = new LinkedHashSet<>();
        var concurrentHashSet = new ConcurrentHashSet<>();

        var array = new String[]{"1", "2", "3"};

        var arrayList = new ArrayList<>();

        var linkedList = new LinkedList<>();
        
        var copyOnWriteArraySet= new CopyOnWriteArraySet<>();
        var copyOnWriteArrayList= new CopyOnWriteArrayList<>();


        var map = new HashMap<>();
        var concurrentMap = new ConcurrentHashMap<>();

        var stack = new Stack<>();

        var arrayBlockingQueue = new ArrayBlockingQueue<>(5);
        var priorityQueue = new PriorityQueue<>();
        var linkedBlockingQueue = new LinkedBlockingQueue<>(6);
        var arrayDeque = new ArrayDeque<>();

        concurrentMap.put("123", 123);

        concurrentHashSet.add(1);

        copyOnWriteArraySet.add(1);
        copyOnWriteArrayList.add(1);

        linkedHashSet.add(1);
        linkedHashSet.add(2);
        linkedHashSet.add(3);

        linkedBlockingQueue.add(1);
        linkedBlockingQueue.add(2);
        linkedBlockingQueue.add(3);

        arrayDeque.add(1);
        arrayDeque.add(2);
        arrayDeque.add(3);


        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);

        arrayBlockingQueue.add(1);
        arrayBlockingQueue.add(2);
        arrayBlockingQueue.add(3);

        stack.add(1);
        stack.add(2);
        stack.add(3);

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        data.add("12345,Name");

        data.add("1234,Anything");

        map.put("key", data);

        // arrays  are not supported by json but can be passed directly
        //vertx.eventBus().publish("test",new JsonObject().put("key",array));
        // vertx.eventBus().publish("test",array);

        // both are supported
        //        vertx.eventBus().publish("test",new JsonObject().put("key",concurrentMap));
        //        vertx.eventBus().publish("test",concurrentMap);

        //concurrentHashSet are supported neither by json nor vertx event bus
        // vertx.eventBus().publish("test",new JsonObject().put("key",concurrentHashSet));
        // vertx.eventBus().publish("test",concurrentHashSet);

       //copy on write not supported by JSON
       // vertx.eventBus().publish("test",new JsonObject().put("key",copyOnWriteArraySet));
     //   vertx.eventBus().publish("test",copyOnWriteArraySet);

        //CopyOnWriteArrayList is supported by both
        vertx.eventBus().publish("test",new JsonObject().put("key",copyOnWriteArrayList));
          vertx.eventBus().publish("test",copyOnWriteArrayList);


        // LinkedHashSet not supported by JSON
        //  vertx.eventBus().publish("test",new JsonObject().put("key",linkedHashSet));
        //  vertx.eventBus().publish("test",linkedHashSet);

        // arrayDeque is not supported by Json
        // vertx.eventBus().publish("test",new JsonObject().put("key",arrayDeque));
        // vertx.eventBus().publish("test",arrayDeque);

        // vertx.eventBus().publish("test",new JsonObject().put("key",map));
        // the above is invalid but the below is valid
        //  vertx.eventBus().publish("test",map);


        // vertx.eventBus().publish("test",new JsonObject().put("key",data));
        // the above is invalid but the below is valid
        //  vertx.eventBus().publish("test",data);


        //arrayblockingqueue is not supported by json but it can be passed directly
        //   vertx.eventBus().publish("test",new  JsonObject().put("key",arrayBlockingQueue));
        //   vertx.eventBus().publish("test",arrayBlockingQueue);


        //linked blocking queue not supported by Json but can be passed directly
        //   vertx.eventBus().publish("test",new  JsonObject().put("key",linkedBlockingQueue));
        //  vertx.eventBus().publish("test",linkedBlockingQueue);

        //Priority Queue are not supported by json but can be passed directly
        //  vertx.eventBus().publish("test",new  JsonObject().put("key",priorityQueue));
        //  vertx.eventBus().publish("test",priorityQueue);

        // both stack passing ways are working
        //        vertx.eventBus().publish("test",new  JsonObject().put("key",stack));
        //        vertx.eventBus().publish("test",stack);


        // both the arraylist passing ways are valid
        //        vertx.eventBus().publish("test",new JsonObject().put("key",arrayList));
        //         vertx.eventBus().publish("test",arrayList);


        // linkedlist ways are also working
        //        vertx.eventBus().publish("test",new JsonObject().put("key",linkedList));
        //
        //        vertx.eventBus().publish("test",linkedList);


        vertx.close();


    }
}
