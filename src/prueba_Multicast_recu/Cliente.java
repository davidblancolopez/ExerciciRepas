package prueba_Multicast_recu;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Cliente {

    private static final int PORT = 5487;
    private static final String HOST = "231.0.0.8";

    public Cliente() throws IOException {
        //Creem el socket.
        MulticastSocket socket = new MulticastSocket(PORT);
        
        //Creem la direcció.
        InetAddress address = InetAddress.getByName(HOST);
        
        String cadena = null;
        
        //Fem que el socket s'uneixi al grup.
        socket.joinGroup(address);
        do{
            //Creem el array que rebra les dades.
            byte[] missatge = new byte[512];
            
            //Creem el DatagramPacket per rebre dades.
            DatagramPacket dp = new DatagramPacket(missatge, missatge.length);
            
            //Rebem el missatge.
            socket.receive(dp);
            
            //Creem un array per guardar el missatge amb el mateix tamany que el que rebem.
            byte[] dades2 = new byte[dp.getLength()];
            
            //Copiem el contingut en el segon array.
            System.arraycopy(missatge, 0, dades2, 0, dp.getLength());
            
            //Passem el contingut del array a String.
            cadena = new String(dades2);
            
            //Imprimim el contingut del String.
            System.out.println(dades2);
            
            
        }while(!cadena.equals("exit"));
        //Deixem el grup.
        socket.leaveGroup(address);
    }
    
    
}
