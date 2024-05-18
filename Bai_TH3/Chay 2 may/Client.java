
package TH3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class Client {
    public static void main(String args[]) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        Random r = new Random();
        InetAddress IPAddress = InetAddress.getByName("192.168.13.189"); 
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        int m=0;
        
        while (m<10) {
            System.out.print("Client - Input data:");
            String mang="";
            for(int i=0; i<10; i++){
                 mang += " "+r.nextInt(10)+1;
            }
            sendData = mang.getBytes();
            System.out.println(mang);
            
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9000); 
            clientSocket.send(sendPacket);
            
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            
            
            String sentence1 = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println( sentence1);
            m++;
        }
        
        clientSocket.close();
    }
}
