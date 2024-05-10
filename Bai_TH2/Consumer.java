/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TH2;
import java.time.LocalTime;

/**
 *
 * @author ADMIN
 */
public class Consumer implements Runnable{
    int id;
    BoundedBuffer b = null;
    public Consumer (int id,BoundedBuffer init){
        this.id = id;
        this.b = init;
        new Thread(this).start();
    }

    @Override
    public void run() {
        int item=0;
        String kq="";
        while(true){
            try {
                item = b.fetch();
            } catch (InterruptedException ex) {}
            if(item %2==0){
                kq="So chan";
            }
            else{
                kq="So le";
            }
            System.out.println("-R"+id+": "+item+"-"+kq+" - "+LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {}
        }
    }
    
}
