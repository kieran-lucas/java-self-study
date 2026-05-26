import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<Integer> task1 = () -> {
            int total = 0;
            for (int i = 1; i <= 10; i++) {
                total += i;
            }
            return total;
        };

        Callable<Integer> task2 = () -> {
            int total = 0;
            for (int i = 11; i <= 20; i++) {
                total += i;
            }
            return total;
        };

        Callable<Integer> task3 = () -> {
            int total = 0;
            for (int i = 21; i <= 30; i++) {
                total += i;
            }
            return total;
        };

        Future<Integer> future1 = executor.submit(task1);
        Future<Integer> future2 = executor.submit(task2);
        Future<Integer> future3 = executor.submit(task3);

        int result1 = future1.get();
        int result2 = future2.get();
        int result3 = future3.get();

        System.out.println("Result 1 = " + result1);
        System.out.println("Result 2 = " + result2);
        System.out.println("Result 3 = " + result3);
        System.out.println("Total = " + (result1 + result2 + result3));

        executor.shutdown();
    }
}
