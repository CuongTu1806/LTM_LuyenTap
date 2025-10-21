package TCP;

import java.util.*;
import java.net.*;
import java.io.*;
import java.util.logging.XMLFormatter;

public class B02mlFptFTCPDataStream {

    public static void reverse(String[] ss, int start, int end){
        int mid = (int)(Math.ceil(((double)end-start)/2)) - 1 + start;
        String tmp = "";
        for(int i=start; i <= mid; i++){
            tmp = ss[i];
            ss[i] = ss[(end - i + start)];
            ss[(end - i + start)] = tmp;
        }
    }

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2207);

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());

        String ma = "B22DCCN096;02mlFptF";

        out.writeUTF(ma);
        out.flush();

        int k = in.readInt();
        String[] ss = in.readUTF().trim().split(",");
//        int k = 3;
//        String[] ss = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        int len = ss.length;

        int st = (int)(Math.ceil((double)len/(double)k));

        for (int i = 0; i < st - 1; i++) {
            reverse(ss, i * k, k *(i + 1) - 1);
        }

        // Đặc biệt cho các số trong cụm cuối cùng, chỉnh end để không vượt quá len
        int sizeLast = len - (st - 1) * k;
        reverse(ss, k * (st - 1), k * (st - 1) + sizeLast - 1);
        String result = String.join(",", ss);

        System.out.println(result);

        out.writeUTF(result);
        out.flush();

        in.close();
        out.close();
        socket.close();
    }
}
