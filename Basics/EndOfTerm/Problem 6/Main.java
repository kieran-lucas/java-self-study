public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread downloadThread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Downloading... " + (i + 1));
            }
        });
        Thread processThread = new Thread(() -> {
            System.out.println("Processing data...");
        });
        Thread saveThread = new Thread(() -> {
            System.out.print("Saving result...");
        });
        downloadThread.start();
        downloadThread.join();
        processThread.start();
        processThread.join();
        saveThread.start();
    }
}
