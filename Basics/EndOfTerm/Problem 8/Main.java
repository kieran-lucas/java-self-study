import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(()-> {
            System.out.println("Task A is running in " + Thread.currentThread().getName());
        });
        executor.submit(()-> {
            System.out.println("Task B is running in " + Thread.currentThread().getName());
        });
        executor.submit(()-> {
            System.out.println("Task C is running in " + Thread.currentThread().getName());
        });
        executor.shutdown();

    }
}
