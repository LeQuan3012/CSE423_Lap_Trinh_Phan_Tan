/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
import java.rmi.Naming;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("number of array size: ");
            int n = scanner.nextInt();

            int[] numbers = new int[n];

            System.out.println("enter element...");
            for (int i = 0; i < n; i++) {
                System.out.print("element of " + (i + 1) + ": ");
                numbers[i] = scanner.nextInt();
            }

            MyService myService = 
                    (MyService) Naming.lookup("rmi://192.168.181.29:1099/MyService");

            int primes = myService.findPrimes(numbers);

            System.out.println("amount of number lucky: "+primes);
           
            
            // Đóng Scanner
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}