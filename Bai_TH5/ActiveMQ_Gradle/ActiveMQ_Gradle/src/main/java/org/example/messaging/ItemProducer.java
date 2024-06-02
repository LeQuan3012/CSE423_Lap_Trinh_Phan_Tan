package org.example.messaging;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.example.models.Item;

import javax.jms.*;

public class ItemProducer implements AutoCloseable{
    private static String baseUrl;
    private ConnectionFactory connectionFactory;
    private Connection connection;
    private Session session;
    private Queue queue;
    private MessageProducer producer;
    private String error;
    private boolean inError;
    private static ItemProducer instance;

    public ItemProducer(String brokerURL,String queueName) {
        baseUrl = brokerURL;
        connectionFactory = new ActiveMQConnectionFactory(brokerURL);
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
            producer = session.createProducer(queue);
        } catch (Exception e) {
            inError = true;
            error = e.getMessage();
            return;
        }
    inError = false;
    }

    private void publish(Item item){
        try {
            var msg = session.createObjectMessage(item.id);
            msg.setIntProperty("item_id", item.id);
            msg.setStringProperty("title", item.title);
            producer.send(msg);
        } catch (Exception e) {
            inError = true;
            error = e.getMessage();
        }

    }

    @Override
    public void close(){
        try {
            producer.close();
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
        instance = new ItemProducer(baseUrl, queueName);
    }

    public static void terminate(){
        instance.close();
    }

    public static void  add (Item item){
        instance.publish(item);
    }
}
