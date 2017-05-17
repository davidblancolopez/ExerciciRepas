
package prueba.tcp.recu;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;


public class TCPCliente {
    String hostname;
    int port;
    Scanner lector = new Scanner(System.in);

    public TCPCliente() throws IOException {
        //Creamos el socket
        Socket socket = new Socket(hostname, port);
        
        //Creamos los recursos.
        DataOutputStream ots = new DataOutputStream(socket.getOutputStream());
        BufferedReader buffer = new BufferedReader(new InputStreamReader(socket.getInputStream()) {});
        
        String msg = lector.next();
        
        //Enviamos el mensaje.
        ots.writeInt(Integer.parseInt(msg));
        
        //Recibimos el mensaje de respuesta del servidor.
        String resposta = buffer.readLine();
        
        //Cerramos recursos.
        ots.close();
        buffer.close();
        socket.close();
    }
    
}
