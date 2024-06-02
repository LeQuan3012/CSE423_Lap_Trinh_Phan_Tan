import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {
    //    private static String url = "failover://tcp://localhost:8161";
    private static String url = "failover://tcp://localhost:61616";
//    private static String url = "tcp://localhost:61616";

    private static String subject = "TestQueue1";

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(subject);
        MessageProducer producer = session.createProducer(destination);
        try {
            int msgTemp = 0;
            while (true) {
                msgTemp++;
                String msg = "TextMessage - " + String.valueOf(msgTemp);
                TextMessage message = session.createTextMessage(msg);
                producer.send(message);
                System.out.println(" "+msg + ": has been sent");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
