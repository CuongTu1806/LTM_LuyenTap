package UDP;

import java.net.*;
import java.util.*;
import java.io.*;

public class UDP_Dang1 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;

        String code = ";B22DCCN096;ma";

        // gửi đi dạng byte
        DatagramPacket dpSendCode = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpSendCode);

        // Tạo mảng byte để nhận data
        byte[] buffer = new byte[1024];
        DatagramPacket dpRecived = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpRecived);


        // gán dữ liệu vừa nhận
        String s = new String(dpRecived.getData());

        // xử lý String s

        // Gửi lên server
        DatagramPacket dpSendResult = new DatagramPacket(s.getBytes(), s.length(), sA, sP);
        socket.send(dpSendResult);
    }
}
