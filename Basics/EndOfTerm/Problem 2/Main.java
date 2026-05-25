class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from " + Thread.currentThread().getName());
    }

}
public class Main {
    public static void main(String[] args) {
        Thread myThread = new Thread(new MyTask());
        myThread.start();
    }
}
