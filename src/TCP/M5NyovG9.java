/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.util.*;
import java.net.*;
import java.io.*;

public class M5NyovG9 {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2207);
        
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        String ma = "B22DCCN096;m5NyovG9";
        
        out.writeUTF(ma);
        out.flush();
        
        int l = in.readInt();
       
        
        String r = "";
        Long t = 0L;
        while(l > 0){
            r += String.valueOf(l % 2);
            l = l / 2;
        }
        r = new StringBuilder(r).reverse().toString();
        System.out.println(r);
        
        out.writeUTF(r);
        out.flush();
        
        in.close();
        out.close();
        socket.close();
    }
}
