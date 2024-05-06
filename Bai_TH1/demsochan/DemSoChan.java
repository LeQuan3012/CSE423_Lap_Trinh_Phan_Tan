/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demsochan;

/**
 *
 * @author ADMIN
 */
public class DemSoChan {

    public static void main(String[] args) {
        int A[] = {1,2,3,4,5,6,7,8,9,10};
        int size = A.length;
        CountThread f1 = new CountThread(A, 0, (size/2)-1);
        CountThread f2 = new CountThread(A, size/2, size);
        f1.start();
        f2.start();
        try{
            f1.join();
            f2.join();
        }catch(InterruptedException e){}
        
        System.out.println("Luong 1 co: "+f1.getCount());
        System.out.println("Luong 2 co: "+f2.getCount());
        System.out.println("Mang co tat ca "+(f1.getCount()+f2.getCount())+" so chan");
    }
    
}
