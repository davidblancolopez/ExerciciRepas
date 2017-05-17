package prueba.tcp.recu;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public TCPServer() throws IOException {
        //Se crea el server socket.
        ServerSocket ssocket = new ServerSocket();

        while (true) {
            //Creamos el socket para aceptar las conexiones. 
            Socket accept = ssocket.accept();

            //Creamos recursos para leer y escribir.
            DataOutputStream otc = new DataOutputStream(accept.getOutputStream());
            DataInputStream buffer = new DataInputStream(accept.getInputStream());

            //Leemos el mensaje q le llega.
            int msg = buffer.readInt();

            System.out.println(msg);
            
            //Respondemos enviando el mismo mensaje.
            otc.writeBytes(msg + "/n");
            
            buffer.close();
            otc.close();
            ssocket.close();
        }

    }

}
