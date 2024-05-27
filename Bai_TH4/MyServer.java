import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;

public class MyServer {
    public static void main(String[] args) {
        try {
            // Khởi động RMI Registry từ mã Java
            LocateRegistry.createRegistry(1099);
            MyService primeService = new MyServiceImpl();
            Naming.rebind("rmi://192.168.181.176:1099/MyService", primeService);
            System.out.println("MyService is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
