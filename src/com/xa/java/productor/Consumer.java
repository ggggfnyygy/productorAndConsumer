package com.xa.java.productor;

import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

/**
 * 消费者：不断的消费，直到没资源可消费，等资源，再次消费
 */
public class Consumer extends Thread{
    private Queue queue;
    public Consumer(Queue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            synchronized (queue){
                while (queue.size() == 0){
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int num = (int) queue.poll();
                System.out.println("consumer消费：" + num);
                queue.notify();
            }
        }
    }
}
