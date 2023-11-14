import java.io.*;
import java.util.*;
import java.net.*;

public class Server {
    public static void main(String[] args){
        try{
		ServerSocket ss = new ServerSocket(6666);
		System.out.println("Server ready to connect...");
		Socket s = ss.accept();
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter File Name: ");
		String str = sc.nextLine();
        pw.println(str);
		FileReader fr = new FileReader(str);
        BufferedReader br = new BufferedReader(fr);
        System.out.println("File Content: ");
        String line;
        while((line = br.readLine()) != null){
            pw.println(line);
            System.out.println(line);
        }
        fr.close();
        pw.println("-1");
	}
    catch(Exception e){
        System.out.println(e);
    }
    }
}
