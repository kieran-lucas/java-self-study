/*
Prototype: Chỉ định các loại đối tượng cần tạo bằng một thể hiện nguyên mẫu,
và tạo các đối tượng mới bằng cách sao chép nguyên mẫu đó.

 */

interface Prototype {
    Prototype copy();
}

class Student implements Prototype {
    String name;
    String className;
    String studentID;

    public Student(String name, String className, String studentID) {
        this.name = name;
        this.className = className;
        this.studentID = studentID;
    }

    public void showResult() {
        System.out.println("Name: " + name);
        System.out.println("Class: " + className);
        System.out.println("Student ID: " + studentID);

    }

    public Student copy() {
        return new Student(this.name, this.className, this.studentID);
    }
}

public class Main {
    public static void main(String[] args) {
        Student origin = new Student("Kieran", "CS2", "002");
        Student Clone = origin.copy();
        Clone.showResult();
    }
}
