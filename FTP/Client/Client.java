import java.net.*;
import java.util.*;
import java.io.*;

public class Client {
    public static void main(String[] args){
        try{
            Socket s = new Socket("localhost",6666);
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String name = br.readLine();
            FileWriter fw = new FileWriter(name);
            System.out.println("File Content:");
            String line;
            while(true){
                line = br.readLine();
                if(line == "-1"){
                    break;
                }
                System.out.println(line);
                fw.append(line+"\n");
                fw.flush();
            }
            fw.close();
            s.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
