import java.io.*;
import java.util.*;
import java.net.*;

public class Client {
    public static void main(String[] args){
        try{
            Socket s = new Socket("localhost",6666);
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
            Scanner sc = new Scanner(System.in);
            String req,res;
            while(true){
                System.out.print("Enter IP Address: ");
                req = sc.nextLine();
                pw.println(req);
                res = br.readLine();
                System.out.println("Associated MAC Address: "+res);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
