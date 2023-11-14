import java.net.*;
import java.util.*;
import java.io.*;

public class Server {
    public static void main(String[] args){
        try{
            String map[][] = {{"128.0.0.1","4A:2B:1F:01"},{"128.0.0.2","4A:2B:20:02"},{"128.0.0.3","4A:2B:21:03"}};
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("Waiting to connect...");
            Socket s = ss.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
            String req;
            Boolean flag;
            while(true){
                req = br.readLine();
                System.out.println("Received Request : "+req);
                flag = true;
                for(int i=0;i<map.length;i++){
                    if(req.equals(map[i][0])){
                        System.out.println("Sent Response : "+map[i][1]);
                        pw.println(map[i][1]);
                        flag = false;
                    }
                }
                if(flag){
                    System.out.println("Address Not Found!");
                    pw.println("Address not found!");
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
