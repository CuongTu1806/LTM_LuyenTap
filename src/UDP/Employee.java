/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class Employee implements Serializable{
    public String name, id, hireDate;
    public double salary;
    private static final long serialVersionUID = 20261107L;

    public Employee(String name, String id, String hireDate, double salary) {
        this.name = name;
        this.id = id;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", id=" + id + ", hireDate=" + hireDate + ", salary=" + salary + '}';
    }
    
}
