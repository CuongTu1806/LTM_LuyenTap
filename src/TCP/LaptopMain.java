/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.util.*;
import java.net.*;
import java.io.*;
import TCP.Laptop;
public class LaptopMain {
    public static String fixName(String name){
        String[] ss = name.split("\\s++");
        int len = ss.length;
        String tmp = ss[0];
        ss[0] = ss[len - 1];
        ss[len - 1] = tmp;
        String res = String.join(" ", ss);
        return res;
    }
    
    public static int fixQuantity(int q){     
        return Integer.parseInt(new StringBuilder(String.valueOf(q)).reverse().toString());

    }
    
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        
        String ma = "B22DCCN096;CeGzFSSK";
        
        out.writeObject(ma);
        out.flush();
        
        Laptop laptop = (Laptop) in.readObject();
        System.out.println(laptop);
        
        laptop.name = fixName(laptop.name);
        laptop.quantity = fixQuantity(laptop.quantity);
        
        out.writeObject(laptop);
        out.flush();
        
        in.close();
        out.close();
        socket.close();
    }
}
