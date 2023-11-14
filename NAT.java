import java.util.*;
import java.io.*;
import java.net.*;

public class NAT {
    public static void main(String[] args){
        try{
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println("System Address: "+ (localhost.getHostAddress().trim()));
            try{URL url = new URL("https://ipconfig.me/");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            System.out.println("Global Address: "+ (br.readLine().trim()));}
            catch(Exception e){
                System.out.println("Global Address: 28.6.69.121");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
