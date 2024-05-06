/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SoChinhPhuong;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class SoCP{
    
    public static void main(String[] args) {
        int[] A = new int[200];
        Random random = new Random();
        for(int i=0; i<A.length; i++){
           A[i] = random.nextInt(1000)+1;
        }
        
        int soluong;
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap so luong luong: ");
        soluong = scan.nextInt();
        CountCP f[] = new CountCP[soluong];

        for(int i = 0; i < soluong; i++){
            int start = i * (A.length / soluong);
            int end = (i + 1) * (A.length / soluong) - 1;
            f[i] = new CountCP(i+1,A, start, end);
          
        }
        for(int i = 0; i < soluong; i++){
            f[i].start();
        }
        for(int i = 0; i < soluong; i++){
            try{
                f[i].join();
            }catch(InterruptedException e){}
        }
        int sum=0;
        for(int i=0; i<soluong; i++){
            sum += f[i].countCP();
            System.out.println("luong "+f[i].Name()+": "+f[i].countCP());
        }
        System.out.println("Nhieu luong co tat ca: "+sum+" so CP");
        
        
        int k=0;
        for(int i=0; i<200; i++){
            for(int j=1; j<Math.sqrt(A[i])+1;j++){
                if(j*j == A[i]){
                    k++;
                }
            }
        }
        System.out.println("\nMot luong chay co "+k+" so CP");
        
    }
    
}
