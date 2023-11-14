import java.io.*;
import java.util.*;
import java.net.*;



public class Server {
    public static void main(String[] args){
        try{
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("Server waiting to connect...");
            Socket s = ss.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String command = br.readLine();
            Runtime R = Runtime.getRuntime();
            Process P = R.exec(command);
            System.out.println("Command "+command+" executed successfully with output : "+P);
            s.close();
            ss.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
