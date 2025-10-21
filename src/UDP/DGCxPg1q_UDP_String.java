package UDP;

import java.util.*;
import java.net.*;
import java.util.stream.Collectors;

public class DGCxPg1q_UDP_String {

    public static int cmp(String a, String b){
        a = a.toLowerCase();
        b = b.toLowerCase();
        return a.compareTo(b);
    }

    public static void main(String[] args) throws Exception {

        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("203.162.10.109");
        int port = 2208;

        String ma = ";B22DCCN096;DGCxPg1q";

        DatagramPacket dpCode = new DatagramPacket(ma.getBytes(), ma.length(), ip, port);
        socket.send(dpCode);

        byte[] buffer = new byte[1024];
        DatagramPacket dpReciveData = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpReciveData);

        String fulldata = new String(dpReciveData.getData(), 0, dpReciveData.getLength());

        String[] ss =fulldata.split(";");
        String rq = ss[0];
        String data = ss[1];

        List<String> list = new ArrayList<>(Arrays.asList(ss[1].split(" ")));

        list.sort((x, y) -> -cmp(x, y));
        String result = rq + ";" +String.join(",", list);

        System.out.println(result);

        DatagramPacket dbResult = new DatagramPacket(result.getBytes(), result.length(), ip, port);
        socket.send(dbResult);

        socket.close();
    }
}
