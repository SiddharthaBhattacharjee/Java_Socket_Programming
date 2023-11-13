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
            while(true){
                String op = (String) br.readLine();
                System.out.println("Client: "+op);
                String str= sc.nextLine();
                pw.println(str);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
