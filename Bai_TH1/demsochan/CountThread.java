/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demsochan;

/**
 *
 * @author ADMIN
 */
public class CountThread extends Thread{
    private int A[];
    private int start;
    private int end;
    private int count=0;

    public CountThread(int[] A, int start, int end) {
        this.A = A;
        this.start = start;
        this.end = end;
    }
    @Override
    public void run(){
        for(int i=start; i<end; i++){
            if(A[i]%2==0){
                count++;
            }
        }
    }
    
    public int getCount(){
        return this.count;
    }
}
