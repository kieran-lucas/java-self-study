public class p4 {
    static class Person {
        private int age;
        Person(int age) {
            if (age < 0) {
                this.age = 0;
            } else {
                this.age = age;
            }
        }
        int getAge() {
            return age;
        }
    }
    public static void main(String[] args) {
        Person p1 = new Person(-5);
        System.out.println(p1.getAge());
        Person p2 = new Person(25);
        System.out.println(p2.getAge());
    }
}
