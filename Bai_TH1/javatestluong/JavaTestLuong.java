/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javatestluong;

/**
 *
 * @author ADMIN
 */
public class JavaTestLuong extends Thread{
    String name;
    public JavaTestLuong(String a){
        this.name = a;
    }
    @Override
    public void run() {
        System.out.println(name+": Hello world");
    }
    
    public static void main(String[] args){
        JavaTestLuong f1 = new JavaTestLuong("63KTPM2");
        JavaTestLuong f2 = new JavaTestLuong("63KTPM1");
        f1.start();
        f2.start();
    }
    
}
