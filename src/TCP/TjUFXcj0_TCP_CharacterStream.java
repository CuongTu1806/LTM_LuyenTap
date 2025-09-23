/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.util.*;
import java.net.*;
import java.io.*;

public class TjUFXcj0_TCP_CharacterStream{
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2208);
        
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        String ma = "B22DCCN096;tjUFXcj0";
        
        out.write(ma);
        out.newLine();
        out.flush();
        
        String s = in.readLine().trim();
        
 
//        String s = "giHgWHwkLf0Rd0.io, I7jpjuRw13D.io, wXf6GP3KP.vn, MdpIzhxDVtTFTF.edu, TUHuMfn25chmw.vn, HHjE9.com, 4hJld2m2yiweto.vn, y2L4SQwH.vn, s2aUrZGdzS.com, 4hXfJe9giAA.edu";
        s = s.replaceAll(",", " ");
        String ss[] = s.split("\\s++");
        
        String result = "";
        for(String tmp : ss){
            result.join(", ", tmp);
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
