package org.example;

import org.example.messaging.ItemConsumer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String url = "tcp://192.168.0.103:61616";
        String queueName = "LeQuan2";
        ItemConsumer.initialize(url, queueName );

        int c;
        try {
            c = System.in.read();
            //System.out.println(c);
        } catch (IOException e) {
        }

        ItemConsumer.terminate();
    }
}