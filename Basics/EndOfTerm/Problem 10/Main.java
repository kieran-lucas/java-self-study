import java.util.concurrent.*;
public class Main {
    public static void main (String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Callable<Integer> task = () -> {
            int total = 0;
            for (int i = 1; i < 101; i++) {
                int number = i;
                total += number;
            }
            return total;
        };
        Future<Integer> result = executor.submit(task);
        System.out.println(result.get());
        executor.shutdown();
    }
}
