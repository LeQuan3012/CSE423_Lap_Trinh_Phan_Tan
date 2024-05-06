/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SoChinhPhuong;
import java.time.LocalTime;
/**
 *
 * @author ADMIN
 */
public class CountCP extends Thread{
    private int name;
    private int A[];
    private int start;
    private int end;
    private int count=0;

    public CountCP(int name,int[] A, int start, int end) {
        this.name = name;
        this.A = A;
        this.start = start;
        this.end = end;
    }
    @Override
    public void run(){
        for(int i=start; i<end; i++){
            for(int j=1; j<Math.sqrt(A[i])+1;j++){
                if(j*j == A[i]){
                    count++;
                    System.out.println("Time cua luong "+name+": "+ LocalTime.now());
                    System.out.println("T"+Name() +"   "+A[i]);
                    
                }
            }
        }
    }
    public int countCP(){
        return count;
    }

    public int Name() {
        return name;
    }
}
