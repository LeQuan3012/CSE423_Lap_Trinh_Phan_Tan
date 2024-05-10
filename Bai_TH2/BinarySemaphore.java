
package TH2;


public class BinarySemaphore {
    boolean value;

    public BinarySemaphore(boolean value) {
        this.value = value;
    }
    public synchronized void P() throws InterruptedException{
        while(value==false){
            this.wait();
        }
        value=false;
    }
    public synchronized void V(){
        value = true;
        notify();
    }
}
