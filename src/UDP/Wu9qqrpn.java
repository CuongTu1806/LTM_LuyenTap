/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.util.*;
import java.net.*;
import java.io.*;
public class Wu9qqrpn {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = Inet4Address.getByName("203.162.10.109");
        int port = 2207;
        
        String code  = ";B22DCCN096;wu9qqrpn";
        DatagramPacket dpSendCode = new DatagramPacket(code.getBytes(), code.length(), ip, port);
        socket.send(dpSendCode);
        
        byte[] buffer = new byte[1024];
        
        DatagramPacket dpReceive = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpReceive);
        
        String fullData = new String(dpReceive.getData());
        String[] ss = fullData.split(";");
        int n = Integer.parseInt(ss[1]);
        int k = Integer.parseInt(ss[2]);
        String rq = ss[0];
        String data = ss[3].trim();
        
        
        String[] sss = data.split(",");
        int len = sss.length;
        List<Integer> l = new ArrayList<>();
        
        for(String x : sss) l.add(Integer.valueOf(x));
        String result = rq + ";";
        List<String> lmax = new ArrayList<>();
        int max = 0;
        for(int i = 0; i <= len - k; i++){
            max = l.get(i);
            for(int j = i + 1; j < i + k; j++){
                if(l.get(j) > max) max = l.get(j);
            }
            lmax.add(String.valueOf(max));
        }
        result += String.join(",", lmax);
        System.out.println(result);
        
        DatagramPacket dpSendResult = new DatagramPacket(result.getBytes(), result.length(),ip, port);
        socket.send(dpSendResult);
        
        socket.close();
    }
}
