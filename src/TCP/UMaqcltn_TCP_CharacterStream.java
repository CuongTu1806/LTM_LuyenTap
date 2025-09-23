package TCP;

import java.io.*;
import java.net.*;
import java.util.*;

public class UMaqcltn_TCP_CharacterStream {

    public static String RLE(String s){
        int count = 1;
        int length = s.length();
        String result = "";
        for(int i = 0; i < length - 1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                count ++;
            }
            else {
                result += s.charAt(i) + ((count > 1) ? String.valueOf(count) : "");
                count = 1;
            }
        }
        if(s.charAt(length - 1) != s.charAt(length - 2)) result += s.charAt(length - 1);
        return result + " ";
    }

    public static void main(String[] args) throws Exception{

        Socket socket = new Socket("203.162.10.109", 2208);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String ma = "B22DCCN096;uMaqcltn";

        out.write(ma);
        out.newLine();
        out.flush();

        String s = in.readLine().trim();
        String[] ss = s.split("\\s++");

        String result ="";
        for(String tmp : ss){
           StringBuilder bd = new StringBuilder(tmp);
           result += RLE(bd.reverse().toString());
        }
        System.out.println(result);

        out.write(result);
        out.newLine();
        out.flush();

        in.close();
        out.close();
        socket.close();
    }
}
