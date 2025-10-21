/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.*;
public class Laptop implements Serializable{
    public int id, quantity;
    public String code, name;
    private static final long serialVersionUID = 20150711L; 
    
    public Laptop(int id, int quantity, String code, String name) {
        this.id = id;
        this.quantity = quantity;
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Laptop{" + "id=" + id + ", quantity=" + quantity + ", code=" + code + ", name=" + name + '}';
    }
    
}
