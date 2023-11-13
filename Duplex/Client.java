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
            while(true){
                String str= sc.nextLine();
                pw.println(str);
                String op = (String) br.readLine();
                System.out.println("Server: "+op);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}