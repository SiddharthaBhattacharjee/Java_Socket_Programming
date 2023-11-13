import java.io.*;
import java.net.*;


public class Client{
    public static void main(String[] args){
        try{
            Socket s = new Socket("localhost",6666);
            DataOutputStream ds = new DataOutputStream(s.getOutputStream());
            ds.writeUTF("Hello World!");
            ds.flush();
            ds.close();
            s.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}