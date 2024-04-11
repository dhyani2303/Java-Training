package Threads;

import java.util.concurrent.Executors;

class Task implements Runnable{

    public void run()
    {
        System.out.println("Thread name:"+ Thread.currentThread().getName());
    }

}

// public class ExecutorService {
//     public static void main(String[] args) {
//         ExecutorService executorService = (ExecutorService) Executors.newFixedThreadPool(3);

//         // Submit tasks to the thread pool
//         for (int i = 1; i <= 5; i++) {
//             final int taskId = i;
//             executorService.(() -> {
//                 System.out.println("Task " + taskId + " executed by thread: " + Thread.currentThread().getName());
//             });
//         }

     
//     }
// }
