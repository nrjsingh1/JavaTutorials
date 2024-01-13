package MultiThreading.ProducerConsumer;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Producer {
    //if queue is not full , add items to the queue
    static int sizeOfQueue= 100000;
    static Queue<Integer> queue = new LinkedBlockingQueue<>(sizeOfQueue);



    static Runnable produce = () -> {
        int i =0;
        while (true){
            if(queue.size()<sizeOfQueue){
                queue.offer(i);
                System.out.println("added item in the queue - "+ i++ +" "+ Thread.currentThread().getName());
            }
            else {
                try {
                    System.out.println("halting production for sometime "+ Thread.currentThread().getName());
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
//            try {
//                TimeUnit.MILLISECONDS.sleep(1001);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    };


   static Runnable consume = () -> {
        while (true){
            if(!queue.isEmpty()){
                int k = queue.poll();
                System.out.println("consumed item from the queue - "+ k +" "+ Thread.currentThread().getName());
            }else {
                try {
                    System.out.println("halting consumption for sometime "+ Thread.currentThread().getName());
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
//            try {
//                TimeUnit.MILLISECONDS.sleep(1001);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    };

    static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        executorService.submit(consume);
        executorService.submit(produce);
        executorService.shutdown();
    }
}
