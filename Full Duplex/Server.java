import java.net.*;
import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class Server {
    public static void main(String[] args){
        try{
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("Server Listening....");
            Socket s = ss.accept();
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
                        System.out.println("Client: "+str2);
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
            System.out.println(e);
        }
    }
}
