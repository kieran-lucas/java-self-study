import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorS
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        Thread threadOne = new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        });
        Thread threadTwo = new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        });
        threadOne.start();
        threadTwo.start();

    }

}
