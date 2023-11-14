import java.io.*;
import java.util.*;
import java.net.*;

public class Client {
    public static void main(String[] args){
        try{
            Socket s = new Socket("localhost",6666);
            PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Command: ");
            String command = sc.nextLine();
            pw.println(command);
            System.out.println("Command sent successfully!");
            sc.close();
            s.close();
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
    
}
