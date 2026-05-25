class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from " + Thread.currentThread().getName());

    }
}

public class Main {
    public static void main(String[] args) {
        MyThread mythread = new MyThread();
        mythread.start();
}
