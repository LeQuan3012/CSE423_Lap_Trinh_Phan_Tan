/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyService extends Remote {
    int findPrimes(int[] numbers) throws RemoteException;
    String getA(String hi)throws RemoteException;
}