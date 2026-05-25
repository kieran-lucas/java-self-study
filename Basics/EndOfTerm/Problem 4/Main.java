public class Main {
    public static void main(String[] args) {
        Thread myThread = new Thread(() -> {
            System.out.println("Learning Java Thread with Lambda from " + Thread.currentThread().getName());
        });
        myThread.start();
    }
}
