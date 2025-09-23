/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TCP;

import java.util.*;
import java.io.*;
import java.net.*;

public class TCP_Dang1 {

   // Dạng 1: đọc ghi dữ liệu bằng outputStream và inputStream
    public static void main(String[] args) throws Exception{
        
        Socket socket = new Socket("203.162.10.109 ", 2206);
        
        InputStream in = socket.getInputStream();
        
        OutputStream out = socket.getOutputStream();
        
        String msv = "B22DCCN096;macauhoi";
        
        //gửi msv lên server, dạng byte
        out.write(msv.getBytes());
        out.flush();
        
        //server cũng gửi về mảng byte => tọa mảng byte để nhận data server gửi về
        byte buffer[] = new byte[1024];
        int len = in.read(buffer); //  độ lớn của mảng byte
        String s = new String(buffer, 0, len); // 0 là vị trí bắt đầu, len là độ lớn cần lấy
        // ví dụ bài trả về mảng: 1, 3, 2, 9, 10. Yêu cầu tìm khoảng cách nhỏ nhất giữa 2 phần tử, và tìm 2 phần tử lớn nhất thỏa mãn
        
        s = s.trim();
        String a[] = s.split(",");
        
        ArrayList<Integer> list = new ArrayList<>();
        for(String x : a){
            list.add(Integer.parseInt(x));
        }
         
        out.write(s.getBytes());
        out.flush();
        
        in.close();
        out.close();
        socket.close();
    }
    
}
