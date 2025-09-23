package UDP.UDP_Dang2;

import java.io.Serializable;

public class Student implements Serializable {
    public String id, code, name, email;
    private static final long serialVersionUID = 1L;

    public Student(String code) {
        this.code = code;
    }

    public Student(String id, String code, String name, String email) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + ", code='" + code + ", name='" + name + ", email='" + email + '}';
    }
}
