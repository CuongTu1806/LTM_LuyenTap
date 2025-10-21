package TCP;

import java.io.Serializable;

public class Product implements Serializable {

    //id int, name String, price double, int discount) và
    // private static final long serialVersionUID = 20231107;

    public int id, discount;
    public String name;
    public double price;
    private static final long serialVersionUID = 20231107;

    public Product(int id, int discount, String name, double price) {
        this.id = id;
        this.discount = discount;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", discount=" + discount +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
