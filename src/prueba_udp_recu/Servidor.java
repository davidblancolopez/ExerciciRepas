
package prueba_udp_recu;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.SocketException;


public class Servidor {
    static int port = 5487;

    public Servidor() throws SocketException, IOException {
        //Creamos el socket. 
        DatagramSocket ssocket = new DatagramSocket(port);
        
        //Creamos la cadena donde se almacenara el mensaje.
        byte [] cadena = new byte[1000];
        
        while(true){
            //Creamos el datagramPacket que recibe el mensaje.
            DatagramPacket dp = new DatagramPacket(cadena, cadena.length);
            
            //Es rep el missatge amb el datagramSocket passant per parametre el datagramPacket.
            ssocket.receive(dp);
            //Rebem el missatge en bytes.
            byte[] frase = dp.getData();
            //Traduim el missatge de bytes a String.
            String frase2 = new String (frase);
            
            //Fiquem el missatge en un nou array de bytes que enviarem com a resposta.
            byte [] frase3 = frase2.getBytes();
            
            //Creem el DatagramPacket que servira per a enviar la resposta al client.
            DatagramPacket dp2 = new DatagramPacket(frase3, frase3.length, dp.getAddress(), dp.getPort());
            
            //Enviem la resposta.
            ssocket.send(dp);
            
            //Tanquem recurs.
            ssocket.close();
        }
    }
    
    
}
