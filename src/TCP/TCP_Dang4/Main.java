/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP.TCP_Dang4;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) throws Exception{
        
        Socket socket = new Socket("1.1.1.1", 2206);
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        
        //Gửi mã lên server
        String ma = "";
        out.writeObject(ma);
        out.flush();
        
        // nhận dữ liệu từ server
        Customer cus = (Customer) in.readObject();
        System.out.println("cus");
        
        // xử lý
        
        // trả kết quả lên server
        out.writeObject(cus);
        out.flush();
        
        // đóng
        in.close();
        out.close();
        socket.close();
        
    }
}
