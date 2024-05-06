/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InSoChanLe;

/**
 *
 * @author ADMIN
 */
public class ChanLe {
    public static void main(String[] args) {
        InChan chan = new InChan();
        InLe le = new InLe();
        Thread f1 = new Thread(chan);
        Thread f2 = new Thread(le);
        //chạy đan xen nhau
        f1.start();
        f2.start();
        
        //chạy chẵn xong rồi chạy lẻ
        f1.start();
        try{
            f1.join();
        }catch(InterruptedException e){}
        f2.start();
    }
}
