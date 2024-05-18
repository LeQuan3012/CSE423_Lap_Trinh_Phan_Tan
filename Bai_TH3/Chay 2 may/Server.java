package TH3;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Server {
    public static void main(String args[]) throws Exception {
        //BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        
        DatagramSocket serverSocket = new DatagramSocket(9000);
        byte[] receiveData = new byte[1024];

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            
            String str = new String(receivePacket.getData());
            String[] parts = str.trim().split("\\s+");

            List<Integer> list = new ArrayList<>();
            for (String part : parts) {
                list.add(Integer.parseInt(part));
            }
            Collections.sort(list);
           // Collections.sort(list, Collections.reverseOrder());
            String kq = "";
            for (int i = 0; i < list.size(); i++) {
                kq += " " + list.get(i);
            }

            System.out.println("From Client: " + str);

            InetAddress clientIP = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            String send = "Server phan hoi: " + kq;
            byte[] sendData = send.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIP, clientPort);

            serverSocket.send(sendPacket);
            
            if (kq.equals("bye")) {
                break;
            }
        }
        serverSocket.close();
    }

}
