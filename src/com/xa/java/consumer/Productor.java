package com.xa.java.consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者
 * 不断的生产，当满足消费时，停止生产，等待市场需求
 */
public class Productor extends Thread{
    private Queue queue;
    public Productor(Queue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        int i = 0;
        while (true){
            synchronized (queue) {
                i++;
                while (queue.size() > 10) {
                    try{
                        queue.wait();
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
                queue.add(i);
                queue.notify();
            }
        }
    }

    public static void main(String[] args) {
        Queue queue = new LinkedList();
        Productor productor = new Productor(queue);
        productor.start();
    }
}
