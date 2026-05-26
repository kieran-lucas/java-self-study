public class Main {
    public static void main(String[] args) {

        Thread threadOne = new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        });
        Thread threadTwo = new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        });
        threadOne.start();
        threadTwo.start();

    }

}
