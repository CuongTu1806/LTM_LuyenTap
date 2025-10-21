package TCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import TCP.Product;

public class ProductMain {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2209);

        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        String ma = "B22DCCN096;d4ahQo5E";

        out.writeObject(ma);
        out.flush();

        Product product = (Product) in.readObject();
        System.out.println(product);

        int int_price = (int) product.price;
        String str_int_price = String.valueOf(int_price);

        for(char c: str_int_price.toCharArray()) product.discount += Integer.parseInt(String.valueOf(c));

        out.writeObject(product);
        out.flush();

        in.close();
        out.close();
        socket.close();
    }
}
