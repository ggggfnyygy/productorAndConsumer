package com.xa.java.test;


import com.xa.java.consumer.Productor;
import com.xa.java.productor.Consumer;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        Queue queue = new LinkedList();

        Productor productor = new Productor(queue);
        productor.start();

        for (int i = 0; i < 5; i++){
            Consumer consumer = new Consumer(queue);
            consumer.start();
        }
    }
}
