public class Main {
    public static void main(String[] args) {
        class MyThread extends Thread {
            public void run() {
                System.out.println("Hello from " + Thread.currentThread().getName());
            }

        }
        MyThread mythread = new MyThread();
        mythread.start();
    }
}
