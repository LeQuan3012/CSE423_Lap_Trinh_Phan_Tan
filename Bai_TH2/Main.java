
package TH2;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int luongdoc, luongghi;
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap so luong doc: ");
        luongdoc = scan.nextInt();
        System.out.print("Nhap so luong ghi: ");
        luongghi = scan.nextInt();
        
        BoundedBuffer buffer = new BoundedBuffer();
        Procedure ghi[]=new Procedure[luongghi];
        Consumer doc[] = new Consumer[luongdoc];
        
        for(int i=0; i<luongdoc; i++){
            doc[i] = new Consumer(i,buffer);
        }
        for(int i=0; i<luongghi; i++){
            ghi[i] = new Procedure(i,buffer);
        }
    }
    
}
