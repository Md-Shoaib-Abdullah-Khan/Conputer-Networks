
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SMTP_Email_send {

    public static void main(String[] args) throws IOException, InterruptedException {
        String username = "czIwMTA5NzYxMzVAcnUuYWMuYmQ=";
        String password = "TXVydWJiYmlpaSBVaHV1dXUgVWhoaGhodXV1dQ==";

        SSLSocket s = (SSLSocket)SSLSocketFactory.getDefault().createSocket("smtp.gmail.com", 465);
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        send("EHLO smtp.gmail.com\r\n", dos);
        for(int i=0;i<8;i++)
            System.out.println(br.readLine());
        
        send("AUTH LOGIN\r\n", dos);
        System.out.println(br.readLine());

        send(username + "\r\n", dos);
        System.out.println(br.readLine());

        send(password + "\r\n", dos);
        System.out.println(br.readLine());

        send("MAIL FROM:<s2010976135@ru.ac.bd>\r\n", dos);
        System.out.println(br.readLine());

        send("RCPT TO:<mdshoaib.a.khan@gmail.com>\r\n", dos);
        System.out.println(br.readLine());

        send("DATA\r\n", dos);
        System.out.println(br.readLine());

        send("From: Abul\r\n", dos);
        send("To: Babul\r\n", dos);
        send("Subject: Hudai kotha\r\n", dos);
        send("Kire kamos asos?\r\n", dos);
        send(".\r\n", dos);
        System.out.println(br.readLine());

        send("OUIT\r\n", dos);
        System.out.println(br.readLine());
    }
    public static void send(String message, DataOutputStream dos) throws IOException, InterruptedException{
        dos.writeBytes(message);
        Thread.sleep(1000);
    }
}