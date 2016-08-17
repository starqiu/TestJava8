package concurrency;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * Created by starqiu on 16-8-15.
 */
public class ProducerConsumer {
    public static Integer MAX_COUNT = 10;
    public static void main(String[] args) {
        Integer product = Double.valueOf(Math.random()*ProducerConsumer.MAX_COUNT).intValue();
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(ProducerConsumer.MAX_COUNT);
        Thread productThread1 = new Thread(new Producer(queue),"productThread1");
        productThread1.setName("name");
        Thread productThread2 = new Thread(new Producer(queue),"productThread2");
//        ThreadGroup productGroup = new ThreadGroup("productGroup");
//        productGroup.enumerate(new Thread[]{productThread1,productThread2});
        Thread consumerThread1 = new Thread(new Consumer(queue),"consumerThread1");
        Thread consumerThread2 = new Thread(new Consumer(queue),"consumerThread2");
//        ThreadGroup consumerGroup = new ThreadGroup("consumerGroup");
//        consumerGroup.enumerate(new Thread[]{consumerThread1,consumerThread2});


        final ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("Orders-%d")
                .build();

        ExecutorService es = Executors.newCachedThreadPool(threadFactory);
        es.execute(productThread1);
        es.execute(productThread2);
        es.execute(consumerThread1);
        es.execute(consumerThread2);

        es.shutdown();
    }
}

class Producer implements Runnable{
    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Integer max = 1000;
        for (int i = 1; i < max ; i++) {
            try {
                Thread.sleep(1);
                System.out.println(Thread.currentThread().getName() + "　produce " + i);
                queue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{
    BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Integer cur;
        while (true){
            try {
                cur = queue.poll(10,TimeUnit.MILLISECONDS);
                if (null == cur){
                    System.out.println(Thread.currentThread().getName() + "　no product");
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "　consume " + cur);
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}