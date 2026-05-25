public class Main {
    public static void main(String[] args) {
        Thread myThread = new Thread(() -> {
            System.out.println("Hello from " + Thread.currentThread().getName());
        });
        myThread.start();
    }
}
