import java.util.concurrent.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Integer>> listTask = new ArrayList<>();
        int total = 0;
        for (int i = 1; i < 6; i++) {
            int number = i;
            Callable<Integer> task = () -> {
                return number * number;
            };
            listTask.add(executor.submit(task));
        }
        for (Future<Integer> result : listTask) {
            int number = result.get();
            System.out.println(number);
            total += number;

        }
        System.out.println(total);
        executor.shutdown();
    }
}
