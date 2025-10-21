/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.channels.DatagramChannel;


public class EmployeeMain {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("203.162.10.109");
        int port = 2209;
        
        String code = "abcd";
        
        DatagramPacket dpSendCode = new DatagramPacket(code.getBytes(), code.length(), ip, port);
        socket.send(dpSendCode);
        
        byte[] buffer = new byte[1024];
        
        DatagramPacket dpReceive = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpReceive);
        
        //đọc rq
        String rq = new String(dpReceive.getData(), 0, 8);
        
        // đọc Object
        ByteArrayInputStream input = new ByteArrayInputStream(dpReceive.getData(), 8, dpReceive.getLength() - 8);
        ObjectInputStream obInput = new ObjectInputStream(input);
        Employee emp = (Employee) obInput.readObject();
        
        // đóng gói đối tượng thành byte
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ObjectOutputStream obOutput = new ObjectOutputStream(output);
        obOutput.writeObject(emp);
        obOutput.flush();
        
        // đóng gói toàn bộ cả rq và ob
        byte[] result = new byte[8 + output.size()];
        System.arraycopy(rq, 0, result, 0, 8);
        System.arraycopy(output, 0, result, 8, output.size());
        
        // gửi đi
        DatagramPacket dpSendResult = new DatagramPacket(result, result.length, ip, port);
        socket.send(dpSendResult);
        
    }
}
