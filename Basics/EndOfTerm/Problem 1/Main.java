public class Main {
    public static void main(String[] args) {
        class MyThread extends Thread {
            public void run() {
                System.out.println("Hello from MyThread");
            }

        }
        MyThread mythread = new MyThread();
        mythread.start();
    }
}
