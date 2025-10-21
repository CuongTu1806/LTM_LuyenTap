package TCP;

import java.util.*;
import java.io.*;
import java.net.*;

public class LrhaMMN8_TCP_DataStream {



    public static String convert(int dec, int coso){
        Map<Integer, String> map = new HashMap<>();
        map.put(10,"A");
        map.put(11,"B");
        map.put(12,"B");
        map.put(13,"D");
        map.put(14,"E");
        map.put(15,"F");
        List<String> list = new ArrayList<>();
        int du;
        while(dec > 0){
            du = dec % coso;
            if(du < 10) list.add(String.valueOf(du));
            else list.add(String.valueOf(map.get(du)));
            dec /= coso;
        }
        Collections.reverse(list);
        return String.join("", list);
    }
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2207);

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());

        String ma = "B22DCCN096;LrhaMMN8";

        out.writeUTF(ma);
        out.flush();

        int dec = in.readInt();
        System.out.println(dec);


        String oct = convert(dec, 8);
        String hex = convert(dec, 16);

        System.out.println(oct);
        System.out.println(hex);
        String result = oct + ";" + hex;
//        out.writeUTF(oct.trim());
//        out.writeUTF(hex.trim());
        out.writeUTF(result);
        out.flush();

        in.close();
        out.close();
        socket.close();

    }
}
