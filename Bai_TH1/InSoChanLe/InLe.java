/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InSoChanLe;

/**
 *
 * @author ADMIN
 */
public class InLe extends Thread{
    public void run(){
        for(int i=1; i<=100; i++){
            if(i%2!=0){
                System.out.print(" "+i);
            }
        }
        System.out.print("\n");
    }
}
