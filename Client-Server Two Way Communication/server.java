
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6666);
        Socket s = ss.accept();

        while(true){
            DataInputStream dis = new DataInputStream(null);
            String messageFromClient = dis.readUTF();
            
            System.out.println("Client : " + messageFromClient);
            
            if(messageFromClient.equals("Exit")){
                break;
             }

             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             DataOutputStream dos = new DataOutputStream(s.getOutputStream());
             String messageToClient = br.readLine();

             dos.writeUTF(messageToClient);

             if(messageToClient.equals("Exit")){
                break;
             }

        }
    }
}
