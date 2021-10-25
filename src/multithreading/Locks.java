package multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class Locks {

    public static void main(String[] args) {
        ReentrantLock l1 = new ReentrantLock();
        ReentrantLock l2 = new ReentrantLock();
        Runnable ta = new T(l1, l2);
        Thread t1 = new Thread(ta, "T1");
        Thread t2 = new Thread(ta, "T2");
        Thread t3 = new Thread(ta, "T3");
        Thread t4 = new Thread(ta, "T4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class T implements Runnable {

    ReentrantLock l1;
    ReentrantLock l2;
    Object monObj = new Object();
    boolean locked = false;

    T(ReentrantLock l1, ReentrantLock l2) {
        this.l1 = l1;
        this.l2 = l2;
    }

    @Override
    public void run() {
//		lock();
//		syncLock();
//		deadlock_test();
        Synclock1();
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" completed the work");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SyncUnlock1();

    }

    void check_and_unlock(ReentrantLock lock, String tname, String l) {
        if (Thread.currentThread().getName().equals(tname) && lock.isLocked()) {
            System.out.println(Thread.currentThread().getName() + " unlocking " + l + " " + lock.isLocked());
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " unlocked " + l);
        }
    }

    void deadlock_test() {
        //t1->l1
        //t2->l2

        //t1 ->acc->l2
        //t2 ->acc->l1

        //unlock t1
        //unlock t2

        if (Thread.currentThread().getName().equals("T1")) {
            System.out.println(Thread.currentThread().getName() + " locking l1.. " + l1.isLocked());
            l1.lock();
            System.out.println(Thread.currentThread().getName() + " locked l1.. " + l1.isLocked());
        }

        if (Thread.currentThread().getName().equals("T2")) {
            System.out.println(Thread.currentThread().getName() + " locking l2.. " + l2.isLocked());
            l2.lock();
            System.out.println(Thread.currentThread().getName() + " locked l2.. " + l2.isLocked());
        }

        if (Thread.currentThread().getName().equals("T1")) {
            System.out.println(Thread.currentThread().getName() + " locking l2.. " + l2.isLocked());
            l2.lock();
            System.out.println(Thread.currentThread().getName() + " locked l2.. " + l2.isLocked());
            l2.unlock();
            System.out.println("unlocked...");
        }

        if (Thread.currentThread().getName().equals("T2")) {
            System.out.println(Thread.currentThread().getName() + " locking l1.. " + l1.isLocked());
            l1.lock();
            System.out.println(Thread.currentThread().getName() + " locked l1.. " + l1.isLocked());
            l1.unlock();
        }
        check_and_unlock(l1, "T1", "l1");
        check_and_unlock(l2, "T2", "l2");
        check_and_unlock(l2, "T1", "l2");
        check_and_unlock(l1, "T2", "l1");
    }

    void lock() {
        System.out.println(Thread.currentThread().getName() + " locking l1.. " + l1.isLocked());
        long time = System.currentTimeMillis();
        l1.lock();
        System.out.println(Thread.currentThread().getName() + " waited " + (System.currentTimeMillis() - time) + "ms to lock l1");
        System.out.println(Thread.currentThread().getName() + " locked l1.. " + l1.isLocked());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " locking l2.. " + l2.isLocked());
        time = System.currentTimeMillis();
        l2.lock();
        System.out.println(Thread.currentThread().getName() + " waited " + (System.currentTimeMillis() - time) + "ms to lock l2");
        System.out.println(Thread.currentThread().getName() + " locked l2.. " + l2.isLocked());

        System.out.println(Thread.currentThread().getName() + " unlocking l1..");
        l2.unlock();
        System.out.println(Thread.currentThread().getName() + " unlocked l1..");


        System.out.println(Thread.currentThread().getName() + " unlocking l2..");
        l1.unlock();
        System.out.println(Thread.currentThread().getName() + " unlocked l2..");
    }


    void syncLock() {

        System.out.println(Thread.currentThread().getName() + " locking l1.. " + l1.isLocked());
        long time = System.currentTimeMillis();
        synchronized (l1) {
            System.out.println(Thread.currentThread().getName() + " waited " + (System.currentTimeMillis() - time) + "ms to lock l1");
            System.out.println(Thread.currentThread().getName() + " locked l1..");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " locking l2.. " + l2.isLocked());
            time = System.currentTimeMillis();
            synchronized (l2) {
                System.out.println(Thread.currentThread().getName() + " waited " + (System.currentTimeMillis() - time) + "ms to lock l2");
                System.out.println(Thread.currentThread().getName() + " locked l2..");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " unlocked l2..");
        }
        System.out.println(Thread.currentThread().getName() + " unlocked l1..");
    }

    void Synclock() {
    	System.out.println();
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " in this sync.." + locked);
            while (locked) {
                synchronized (monObj) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " in monObj sync..");
                        monObj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            locked = true;
        }
    }
    
    void Synclock1() {
    	System.out.println();
    	System.out.println(Thread.currentThread().getName() + " in this sync.." + locked);
        while (locked) {
            synchronized (monObj) {
                try {
                    System.out.println(Thread.currentThread().getName() + " in monObj sync..");
                    monObj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        locked = true;
    }

    void SyncUnlock1() { //for deadlock
    	System.out.println();
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " in monObj sync unlock.." + locked);
            locked = false;
            synchronized (monObj) {
                monObj.notifyAll();
            }
        }
    }
    
    void SyncUnlock() {
    	System.out.println();
    	System.out.println(Thread.currentThread().getName() + " in monObj sync unlock.." + locked);
        locked = false;
        synchronized (monObj) {
            monObj.notify();
        }
    }
}