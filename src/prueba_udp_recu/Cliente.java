
package prueba_udp_recu;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Cliente {
    static final String HOST = "localhost";
    static final int PORT = 5487;
    Scanner lector = new Scanner(System.in);
    
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        
        //Creem el socket del client.
        DatagramSocket socket = new DatagramSocket(PORT);
        
        //Introduim e missatge que enviarem.
        String mensaje = "AAA";
        
        //Passem el missatge a bytes per a enviar-lo.
        byte [] cadena = new byte[1000];
        cadena = mensaje.getBytes();
        
        //
        InetAddress host = InetAddress.getByName(HOST);
        
        //Creem el DtagramPacket per rebre el missatge.
        DatagramPacket dp = new DatagramPacket(cadena, mensaje.length(), host, PORT);
        
        //Enviem el missatge.
        socket.send(dp);
        
        //Creem el array on es guardara la resposta.
        byte [] cadena2 = new byte[1000];
        
        //Creem el datagrampacket
        DatagramPacket dp2 = new DatagramPacket (cadena2,cadena2.length);
        
        //Rebem el missatge de resposta.
        socket.receive(dp2);
        
        //Tanquem recursos.
        socket.close();

    }

}
