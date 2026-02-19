public class p3 {
    static class Person {
        int age;
        Person(int age) {
            this.age = age;
        }
    }
    public static void main(String[] args) {
        Person p = new Person(20);
        System.out.println(p.age);
    }
}
