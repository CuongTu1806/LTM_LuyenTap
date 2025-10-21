/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.OutputStream;
import java.net.Socket;
import java.io.*;
import java.net.*;
import java.util.LinkedHashSet;
import java.util.Set;
public class QCMa2ZF0 {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2208);
        
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        String ma = "B22DCCN096;qCMa2ZF0";
        
        out.write(ma);
        out.newLine();
        out.flush();
        
        String s = in.readLine().trim();
        System.out.println(s);
        
        s = s.replaceAll("[^a-zA-Z]","");
        Set<Character> set = new LinkedHashSet<>();
        for(char c : s.toCharArray()) set.add(c);
        
        String result = "";
        for(char c : set) result += c;
        
        System.out.println(result);
        
        out.write(result);
        out.newLine();
        out.flush();
        
        out.close();
        in.close();
        socket.close(); 
        
    }
}
