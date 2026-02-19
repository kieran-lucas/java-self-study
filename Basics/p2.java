public class p2 {
    static class Person {
        int age;

    }
    public static void changeValue(int x) {
        x = 100;
    }
    public static void changeAge(Person p) {
        p.age = 100;
    }
    public static void changePerson(Person p) {
        p = new Person();
        p.age = 200;

    }
    public static void main(String[] args) {
        int a = 10;
        changeValue(a);
        System.out.println(a);
        Person p1  = new Person();
        p1.age = 10;
        changeAge(p1);
        System.out.println(p1.age);
        Person p2 = new Person();
        p2.age = 20;
        changePerson(p2);
        System.out.println(p2.age);





    }
}
