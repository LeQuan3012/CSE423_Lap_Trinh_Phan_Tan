package org.example.messaging;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.example.models.Item;

import javax.jms.*;

public class ItemConsumer implements AutoCloseable{
    private String baseUrl;
    private ConnectionFactory connectionFactory;
    private Connection connection;
    private Session session;
    private Queue queue;
    private MessageConsumer consumer;
    private String error;
    private boolean inError;


    private static ItemConsumer instance;

    public ItemConsumer(String brokerURL, String queueName) {
        baseUrl = brokerURL;
        connectionFactory = new ActiveMQConnectionFactory(baseUrl);
        try {
            connection = connectionFactory.createConnection();
            connection.start();
        } catch (Exception e) {
           inError = true;
           error = e.getMessage();
           return;
        }

        try {
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        } catch (Exception e) {
            inError = true;
            error = e.getMessage();
            return;
        }

        try {
            queue = session.createQueue(queueName);
        } catch (Exception e) {
            inError = true;
            error = e.getMessage();
            return;
        }

        try {
            consumer = session.createConsumer(queue);
            consumer.setMessageListener(message -> {
                try {
                    int itemId = message.getIntProperty("item_id");
                    String itemTitle = message.getStringProperty("title");
                    Item  i = new Item(itemId, itemTitle);
                    if((Integer.parseInt(i.title) %2 == 0)){
                        System.out.println(i.title+ " la so chan");
                    }
                    else {
                        System.out.println(i.title + " la so le");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            });
        } catch (Exception e) {
            inError = true;
            error = e.getMessage();
            return;
        }
    inError = false;
    }

    @Override
    public void close(){
        try {
            consumer.close();
            session.close();
            connection.close();
        } catch (Exception e) {}
    }

    public static boolean inError(){
       return instance.inError;
    }

    public static String Error(){
        return instance.error;
    }

    public static void initialize(String baseUrl, String queueName){
        instance = new ItemConsumer(baseUrl, queueName);
    }

    public static void terminate(){
        instance.close();
    }

}
