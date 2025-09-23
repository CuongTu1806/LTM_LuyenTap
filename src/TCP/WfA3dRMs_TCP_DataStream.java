package TCP;

import java.net.*;
import java.io.*;

public class WfA3dRMs_TCP_DataStream {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("203.162.10.109", 2207);

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String ma = "B22DCCN096;WfA3dRMs";

        out.writeUTF(ma);
        out.flush();

        int a = in.readInt();
        int b = in.readInt();

        int tong = a + b;
        int tich = a * b;

        out.writeInt(tong);
        out.writeInt(tich);
        out.flush();

        in.close();
        out.close();
        socket.close();
    }
}
