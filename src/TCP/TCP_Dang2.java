/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.util.*;
import java.io.*;
import java.net.*;

// Đọc ghi bằng bufferWriter và BufferReader

public class TCP_Dang2 {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109 ", 2206);
        
        //in và out bằng buffer
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        // Đẩy mã lên server: gửi lên string và server gửi về string luôn
        String ma = "";
        out.write(ma);
        out.newLine(); // thêm cái này
        out.flush();
        
        // nhận dữ liệu từ server
        String s = in.readLine().trim();
        System.out.println(s);
        
        
        // xử lý
        System.out.println("ket qua");
        
        // gửi kết quả lên server
        out.write(s);
        out.newLine();
        out.flush();
        
        // đóng 
        in.close();
        out.close();
        socket.close();
    }
}
