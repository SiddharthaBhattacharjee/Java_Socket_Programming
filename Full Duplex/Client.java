import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Client{
    public static void main(String[] args){
        try{
            Socket s = new Socket("localhost",6666);
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            Scanner sc= new Scanner(System.in);
            Thread readT = new Thread(()->{
                while(true){
                    String str = sc.nextLine();
                    pw.println(str);
                }
            });
            Thread writeT = new Thread(()->{
                while(true){
                    try{
                        String str2 = (String) br.readLine();
                        System.out.println("Server: "+str2);
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    
                }
            });
            readT.start();
            writeT.start();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}