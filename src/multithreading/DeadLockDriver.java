package multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLockDriver {

    public static void main(String[] args) {
        ReentrantLock l1 = new ReentrantLock();
        ReentrantLock l2 = new ReentrantLock();

        DeadLock1 dl1 = new DeadLock1(l1, l2);
        DeadLock2 dl2 = new DeadLock2(l1, l2);

        Thread t1 = new Thread(dl1, "T1");
        Thread t2 = new Thread(dl2, "T2");

        t1.start();
        t2.start();
    }

}
