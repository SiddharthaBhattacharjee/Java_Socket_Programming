import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args){
        try{
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("Server Listening....");
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String data = (String) dis.readUTF();
            System.out.println("Message: "+data);
            dis.close();
            s.close();
            ss.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
