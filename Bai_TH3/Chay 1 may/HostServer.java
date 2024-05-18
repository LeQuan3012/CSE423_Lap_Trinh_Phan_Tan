/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestTH3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class HostServer {
    public static void main(String[] args) {
        DatagramPacket datapacket, returnpacket;
        int port = 2024;
        int len = 1024;
        try{
            DatagramSocket datasocket = new DatagramSocket(port);
            byte[] buf = new byte[len];
            while(true){
                try{
                    datapacket = new DatagramPacket(buf, buf.length);
                    datasocket.receive(datapacket);
                    String str = new String(datapacket.getData());
                    String[] parts = str.trim().split("\\s+");
        
                    // Lưu các phần tử vào danh sách
                    List<Integer> list = new ArrayList<>();
                    for (String part : parts) {
                        list.add(Integer.parseInt(part));
                    }
                    Collections.sort(list);
                    String kq="";
                    for(int i=0; i<list.size(); i++){
                        kq += " "+list.get(i);
                    }
                    
                    System.out.println("Server-Receive data from client: IP"+datapacket.getAddress()+" - "+datapacket.getPort()+" - "+kq+" - length "+str.length());
                    
                    byte[] buff = new byte[len];
                    buff = kq.getBytes();
                    returnpacket = new DatagramPacket(buff, buff.length, datapacket.getAddress(), datapacket.getPort());
                    datasocket.send(returnpacket);
                }
                catch(IOException ex){
                    System.err.println(ex);
                }
                
            }
        }
        catch(SocketException e){
            System.err.println(e);
        }
        
    }
}
