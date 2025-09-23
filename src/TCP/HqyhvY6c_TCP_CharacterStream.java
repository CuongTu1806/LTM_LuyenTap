package TCP;

import java.io.*;
import java.net.*;
import java.util.*;

public class HqyhvY6c_TCP_CharacterStream {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2208);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String ma = "B22DCCN096;hqyhvY6c";

        out.write(ma);
        out.newLine();
        out.flush();

        String s = in.readLine().trim();

//        String s = "hello world this is a test example";
        String[] ss = s.split(" ");
        int n = ss.length;
        String tmp = "";
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - 1; j++){
                if(ss[j].length() > ss[j + 1].length()){
                    tmp = ss[j];
                    ss[j] = ss[j + 1];
                    ss[j + 1] = tmp;
                }
            }
        }

        List<String> list = Arrays.asList(ss);
        tmp = String.join(", ", list);
        System.out.println(tmp);
        out.write(tmp);
        out.newLine();
        out.flush();

        in.close();
        out.close();
        socket.close();
    }
}
