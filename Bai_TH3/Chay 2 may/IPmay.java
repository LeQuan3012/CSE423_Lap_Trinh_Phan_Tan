
package TH3;

import java.net.*;

public class IPmay {
    public static void main(String[] args) {
        try {
            // Lấy địa chỉ IP của máy cục bộ
            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("Địa chỉ IP của máy cục bộ: " + localAddress.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
