
package TH2;


public class CountingSemaphore {
    int value;

    public CountingSemaphore(int value) {
        this.value = value;
    }
    
    public synchronized void P() throws InterruptedException{
        while(value==0){
            this.wait();
        }
        value--;
    }
    public synchronized void V() throws InterruptedException{
        value++;
        notify();
    }
}
