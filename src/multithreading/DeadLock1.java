package multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock1 implements Runnable {

    ReentrantLock lock1;
    ReentrantLock lock2;

    DeadLock1(ReentrantLock lock1, ReentrantLock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    private void sleep(long timeMillis) {
        try {
            Thread.sleep(timeMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        while (true) {
            int failedCount = 0;
            while (!tryLock()) {
                failedCount++;
                System.err.println(threadName + " failed to lock both Locks. " +
                        "Waiting a bit before retrying [" + failedCount + " tries]");
                sleep((long) (100L * Math.random()));
            }
            if (failedCount > 0) {
                System.out.println(threadName +
                        " succeeded in locking both locks - after " + failedCount + " failures.");
            }

            //do the work - now that both locks have been acquired (locked by this thread)

            //unlock
            lock1.unlock();
            lock2.unlock();
        }

    }

    boolean tryLock() {
        String threadName = Thread.currentThread().getName();
        System.out.println("lock1 is held by thread " + threadName + " : " + lock1.isHeldByCurrentThread());
        System.out.println("lock2 is held by thread " + threadName + " : " + lock2.isHeldByCurrentThread());
        try {
            boolean locked = lock1.tryLock(3000, TimeUnit.MILLISECONDS);
            if (!locked) {
                return false;
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " interrupted trying to lock Lock 1");
            return false;
        }

        try {
            boolean locked = lock2.tryLock(3000, TimeUnit.MILLISECONDS);
            if (!locked) {
                return false;
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " interrupted trying to lock Lock 2");
            return false;
        }
        return true;
    }
}
