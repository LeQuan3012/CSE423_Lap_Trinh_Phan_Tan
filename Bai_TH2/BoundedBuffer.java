
package TH2;


public class BoundedBuffer {
    final int size = 5;
    int[] buffer = new int[size];
    int inBuf = 0;
    int outBuf = 0;

    BinarySemaphore mutex = new BinarySemaphore(true);
    CountingSemaphore isEmpty = new CountingSemaphore(0);
    CountingSemaphore isFull = new CountingSemaphore(size);

    public void deposit(int value) throws InterruptedException {
        isFull.P();
        mutex.P();
        buffer[inBuf] = value;
        inBuf = (inBuf + 1) % size;
        mutex.V();
        isEmpty.V();
    }

    public int fetch() throws InterruptedException {
        int value;
        isEmpty.P();
        mutex.P();
        value = buffer[outBuf];
        outBuf = (outBuf + 1) % size;
        buffer[outBuf] = 0;
        mutex.V();
        isFull.V();
        return value;
    }
}
