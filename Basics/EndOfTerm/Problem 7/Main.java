public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    System.out.println("Loading " + (i + 1) + " ...");
                    Thread.sleep(1000);
                }
                System.out.println("Done");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        });
        thread.start();
    }
}
