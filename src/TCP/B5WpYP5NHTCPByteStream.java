package TCP;


import java.util.*;
import java.io.*;
import java.net.*;

public class B5WpYP5NHTCPByteStream {

    public static boolean checkPrime(String s){

        int a = Integer.parseInt(s);
        if(a == 1 || a == 0) return false;
        int b = (int) Math.sqrt(a);

        for(int i = 2; i <= b; i++){
            if(a % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2206);

        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        String ma = "B22DCCN096;5WpYP5NH";

        out.write(ma.getBytes());
        out.flush();

        byte[] buffer = new byte[1024];

        int len = in.read(buffer);
        String data = new String(buffer, 0, len);
        String ss[] = data.split(",");
        int result = 0;
        for(String x : ss){
            if(checkPrime(x)) result += Integer.parseInt(x);
        }
        System.out.println(result);

        out.write(String.valueOf(result).getBytes());
        out.flush();

        in.close();
        out.close();
        socket.close();
    }
}
