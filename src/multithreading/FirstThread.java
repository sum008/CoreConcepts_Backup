package multithreading;

import java.util.concurrent.TimeUnit;

public class FirstThread {

    public static void main(String... args) throws InterruptedException {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();

        TimeUnit.SECONDS.sleep(3);
        System.out.println("inside main..");
        thread.start();
    }
}

class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("inside run..");
        task1();
    }

    private void task1() {
        System.out.println("Inside task1..");
        task2();
    }

    private void task2() {
        System.out.println("inside task2..");
    }

}
