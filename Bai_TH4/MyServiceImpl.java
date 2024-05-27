import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class MyServiceImpl extends UnicastRemoteObject implements MyService {

    protected MyServiceImpl() throws RemoteException {
        super();
    }
    private int[] mayman = {4,5,6,7};
    private int dem=0;
    @Override
    public int findPrimes(int[] numbers) throws RemoteException {
        List<Integer> primes = new ArrayList<>();
        System.out.println("Hi");
        for(int i=0; i<numbers.length; i++){
            for(int j=0; j<mayman.length; j++){
                if(numbers[i]==mayman[j]){
                    dem++;
                }
            }
        }
        return dem;
    }

    @Override
    public String getA(String hi) {
        return "Server "+hi;
    }

}