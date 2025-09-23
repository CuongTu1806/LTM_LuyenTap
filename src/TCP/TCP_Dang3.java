/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.*;
import java.net.*;
import java.util.*;

// Đọc ghi bằng DataInputStream và DataOutputStream
public class TCP_Dang3 {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("1.1.1.1", 2206);
        
        // khởi tạo input, output
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        // gửi mã lên server
        String ma  = "";
        out.writeUTF(ma); // WriteUTF
        out.flush();
        
        
        // nhận data từ server về
        String s = in.readUTF(); // 
        
        // in kết quả
        
        // gửi kết quả lên server
        out.writeUTF(s);
        out.flush();
        
        // close
        in.close();
        out.close();
        socket.close();
        
        
        
      
    }
}
