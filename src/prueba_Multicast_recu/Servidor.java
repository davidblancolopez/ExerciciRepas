
package prueba_Multicast_recu;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;


public class Servidor {
    private static final int PORT = 5487;
    private static final String HOST = "231.0.0.8";

    public Servidor() throws IOException {
        
        //Es crea el socket per e rebre dades.
        MulticastSocket socket = new MulticastSocket(PORT);
        
        //Creem una adreça amb la ip de HOST.
        InetAddress address = InetAddress.getByName(HOST);
        
        //Creem un array per guardar el missatge d'entrada.
        byte [] missatge = new byte [1000];
        
        // Creem un DatagramPacket per rebre les dades.
        DatagramPacket dp = new DatagramPacket(missatge, missatge.length, address, PORT);
        
        //Variable String per ficar el missatge.
        String cadena = null;
        
        //Bucle per a escoltar tota la estona mentres que el missatge no indica que pari (exit).
        do{
            //Creem el missatge a enviar.
            cadena = "PEPEPEEPE";
            //Pasem el missatge a bytes.
            missatge = cadena.getBytes();
            //Fiquem el missatge al DatagramPacket.
            dp.setData(missatge);
            //Indiquem la llargaria del missatge.
            dp.setLength(missatge.length);
            //Enviem el missatge.
            socket.send(dp);
            
        }while(!cadena.equals("exit"));
    }
    
    
}
