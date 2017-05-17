
package prueba_udp_recu;

import java.net.DatagramSocket;
import java.net.SocketException;


public class Cliente {
    static final String HOST = "localhost";
    static final int PORT = 5487;

    public Cliente() throws SocketException {
        
        //Creem el socket del client.
        DatagramSocket socket = new DatagramSocket(PORT);
        
        
        
    }

}
