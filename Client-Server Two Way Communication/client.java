import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class client {
    
public static void main(String[] args) throws IOException {
        
   Socket s = new Socket("localhost", 6666);

   while(true){
    DataOutputStream dos = new DataOutputStream(s.getOutputStream());
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String messageToServer = br.readLine();
    dos.writeUTF(messageToServer);
     if(messageToServer.equals("Exit")){
        break;
     }

     DataInputStream dis = new DataInputStream(s.getInputStream());
     String messageFromServer = dis.readUTF();
     System.out.println("Server : " + messageFromServer);

     if(messageToServer.equals("Exit")){
        break;
     }

   }


}


}
