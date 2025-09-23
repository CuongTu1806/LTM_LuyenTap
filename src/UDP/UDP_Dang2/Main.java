package UDP.UDP_Dang2;

import java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("");
        int port = 2206;

        String code = "dddd";

        DatagramPacket dpSendCode = new DatagramPacket(code.getBytes(), code.length(), ip, port);
        socket.send(dpSendCode);

        //
        byte[] buffer = new byte[1024];
        DatagramPacket dpRecived = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpRecived);

        // Nhận thông điệp requestId gồm 8 byte đầu tiên
        String rq = new String(dpRecived.getData(), 0, 8);
        System.out.println(rq);

        // các byte còn lại là của ob student
        ByteArrayInputStream input = new ByteArrayInputStream(dpRecived.getData(), 8, dpRecived.getLength() - 8);
        ObjectInputStream obInput = new ObjectInputStream(input);
        Student sv = (Student) obInput.readObject();
        System.out.println(sv);

        // xử lý logic


        //Gửi data đi
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ObjectOutputStream obOutput = new ObjectOutputStream(output);
        obOutput.writeObject(sv);
        obOutput.flush();

        // Tạo mảng byte để guier data lên server
        byte sendResult[] = new byte[8 + output.size()];

        // hàm copy (dataSource, positionSourceStart_copy, dataDest, positionDestStart_write, length_copy)
        System.arraycopy(rq.getBytes(), 0, sendResult, 0, 8);
        System.arraycopy(output.toByteArray(), 0, sendResult, 8, output.size());
        DatagramPacket dpSendResult = new DatagramPacket(sendResult, sendResult.length, ip, port);
        socket.send(dpSendResult);
        socket.close();
    }

}
