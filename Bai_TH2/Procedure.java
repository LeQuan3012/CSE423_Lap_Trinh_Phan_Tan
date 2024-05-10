
package TH2;

import java.util.Random;
import java.time.LocalTime;

public class Procedure implements Runnable{
    int id;
    BoundedBuffer b = null;
    public Procedure (int id,BoundedBuffer init){
        this.id = id;
        this.b = init;
        new Thread(this).start();
    }
    
    public void run() {
        int item;
        Random r = new Random();
        while(true){
            item = r.nextInt(1000)+1;
            System.out.println("W"+id+": "+item+" - "+LocalTime.now());
            try {
                b.deposit(item);
            } catch (InterruptedException ex) {}
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
            }
            
        }
    }
    
}
