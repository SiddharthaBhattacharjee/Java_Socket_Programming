import java.io.*;
import java.net.*;


public class Client{
    public static void main(String[] args){
        try{
            Socket s = new Socket("localhost",6666);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF("Whats the time?");
            dos.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            System.out.println(br.readLine());
            br.close();
            s.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}