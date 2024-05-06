/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TimFibo;

/**
 *
 * @author ADMIN
 */
public class timFibo extends Thread{
    private int kq;
    private int n;
    public timFibo(int n){
        this.n = n;
    }
    public void run(){
        if(n<=1){
            kq=n;
            return;
        }
        else{
            int Pre= 0;
            int Cur=1;
            for(int i=2; i<n; i++){
                int temp = Pre+Cur;
                Pre = Cur;
                Cur = temp;
            }
            kq=Cur;
        }
    }
    private int getKq()
    {
        return kq;
    } 
    public static void main(String[] args) {
        timFibo a = new timFibo(7);
        a.start();
        try{
            a.join();
        }
        catch(InterruptedException e){}
        System.out.println(a.getKq());
    }
}
