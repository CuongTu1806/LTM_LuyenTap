/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.util.*;
import java.net.*;
import java.io.*;

public class Jc3KA86z_TCP_ByteStream {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2206);
        
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        
        String ma = "B22DCCN096;Jc3KA86z";
        
        out.write(ma.getBytes());
        out.flush();
        
        byte buffer[] = new byte[1024];
        int len = in.read(buffer);
        
        String s = new String(buffer, 0, len).trim();
        s = s.replaceAll("\\|", " ");
        String ss[] = s.split("\\s++");
        Long sum = 0L;
        for(String tmp : ss) sum += Long.parseLong(tmp.trim());
        System.out.println(sum);
        
        out.write(String.valueOf(sum).getBytes());
        out.flush();
        
        in.close();
        out.close();
        socket.close();
    }
}
