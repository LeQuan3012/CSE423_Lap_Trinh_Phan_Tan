package org.example;

import org.example.messaging.ItemProducer;
import org.example.models.Item;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = "tcp://192.168.0.103:61616";
        String queueName = "LeQuan2";
        ItemProducer.initialize(url, queueName );

        Item item = new Item("Some items");
        if (ItemProducer.inError()){
            System.out.println(ItemProducer.Error());
        }else {
            ItemProducer.add(item);
            System.out.println("Item added to queue");
            if (ItemProducer.inError()){
                System.out.println(ItemProducer.Error());
            }
        }

        for (int j = 0; j<2; j++){
            System.out.print("Nhap so: ");
            int m = sc.nextInt();
            item = new Item(m+"");
            ItemProducer.add(item);
        }

        ItemProducer.terminate();

    }
}