/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestTH3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Random;

/**
 *
 * @author ADMIN
 */
public class HostClient {
    public static void main(String[] args) {
        String hostname;
        Random r = new Random();
        int port = 2024;
        int len = 1024;
        DatagramPacket sPacket, rPacket;
        if(args.length>0){
            hostname = args[0];
        }
        else{
            hostname = "localhost";
        }
        try{
            InetAddress ia = InetAddress.getByName(hostname);
            DatagramSocket datasocket = new DatagramSocket();
            
            BufferedReader stdinp = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                try {
                    System.out.print("Client - Input data:");
                    String mang="";
                    for(int i=0; i<10; i++){
                        mang += " "+r.nextInt(10)+1;
                    }
                    System.out.println(mang);
                    byte[] buffer = new byte[mang.length()];
                    buffer = mang.getBytes();
                    sPacket = new DatagramPacket(buffer, buffer.length, ia, port);
                    datasocket.send(sPacket);
                    
                    byte[] rbuff = new byte[len];
                    rPacket = new DatagramPacket(rbuff, rbuff.length);
                    datasocket.receive(rPacket);
                    
                    String retstring = new String(rPacket.getData(),0,rPacket.getLength());
                    System.out.println("Server - Received data from server: "+retstring);
                } catch (IOException m) {
                    System.err.println(m);
                }
                
                
            }
        }
        catch(UnknownHostException e){
            System.err.println(e);
        }
        catch(SocketException ex){
            System.err.println(ex);
        }
        
        
    }
}
