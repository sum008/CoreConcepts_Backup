package multithreading;

import java.util.ArrayList;
import java.util.List;

public class MonitorObject {

    public static void main(String[] args) {
        // Monitor m1 = new Monitor();
        // Monitor m2 = new Monitor();
        // Monitor m3 = new Monitor();

        MonObj race = new MonObj();
        // race.check_lock();
        Thread t1 = new Thread(race, "Thread A");
        Thread t2 = new Thread(race, "Thread B");
        Thread t3 = new Thread(race, "Thread C");
        Thread t4 = new Thread(race, "Thread D");
        // t1.start();
        // t2.start();
        // t3.start();
        t4.start();
    }
}

class MonObj implements Runnable {

    // three different monitor objects for three synchronized blocks and these
    // monitor objects will be shared in all the threads acting upon this class
    // if I change monitor obj to "this", then only one synchronized block will be
    // accessed at a time by single thread because "this" is an instance of
    // this class and if one thread is acting upon any of the sync block, the "this"
    // monitor will be blocked until thread complete its task and only
    // after that any other thread can act, so this is a bad idea in regards of
    // performance
    // so better approach will be to create separate monitor objects
    final Object obj1 = new Object();
    final Object obj2 = new Object();

    // MonObj(Monitor monitor) {
    // m1=monitor;
    // }
    final Object obj3 = new Object();

    // public void check_v3() {
    // synchronized(m1) {
    // if (!list.contains(1)) {
    // System.out.println("checking for 1 "+list +
    // Thread.currentThread().getName());
    // list.add(1);
    // System.out.println(Thread.currentThread().getName()+" : checking for 1
    // "+list);
    // }
    // }
    // synchronized(m2) {
    // if (!list.contains(2)) {
    // System.out.println("checking for 2 "+list +
    // Thread.currentThread().getName());
    // list.add(2);
    // System.out.println(Thread.currentThread().getName()+" : checking for 2
    // "+list);
    // }
    // }
    // synchronized(m3) {
    // if (!list.contains(3)) {
    // System.out.println("checking for 3 "+list+ Thread.currentThread().getName());
    // list.add(3);
    // System.out.println(Thread.currentThread().getName()+" : checking for 3
    // "+list);
    // }
    // }
    // }
    volatile List<Integer> list = new ArrayList<>();
    // Monitor m1;
    // Monitor m1 = new Monitor();
    // Monitor m2 = new Monitor();
    // Monitor m3 = new Monitor();
    Monitor m = new Monitor();

    MonObj() {
    }

    void check_lock() {
        System.out.println("*************checking lock******************");
        System.out
                .println("obj1 lock is " + Thread.holdsLock(obj1) + " for thread " + Thread.currentThread().getName());
        System.out
                .println("obj2 lock is " + Thread.holdsLock(obj2) + " for thread " + Thread.currentThread().getName());
        System.out
                .println("obj3 lock is " + Thread.holdsLock(obj3) + " for thread " + Thread.currentThread().getName());
    }

    public void check_v4() {
        System.out
                .println("obj1 lock is " + Thread.holdsLock(obj1) + " for thread " + Thread.currentThread().getName());
        synchronized (obj1) {
            try {
                System.out.println(Thread.currentThread().getName() + " : checking 1 in list in v4 " + list);
            } catch (Exception e) {
                System.out.println(
                        "%%%%%%%%%%%%%%%%%Error in thread for v4 " + Thread.currentThread().getName() + " " + list);
            }

            if (!list.contains(1)) {
                System.out.println("checking for 1 v4 " + list + Thread.currentThread().getName());
                try {
                    list.add(1);
                } catch (Exception e) {
                    System.out.println(
                            "##################Error in thread " + Thread.currentThread().getName() + " " + list);
                }

                System.out.println(Thread.currentThread().getName() + " : added 1 " + list);
            }
        }
    }

    public void check_v5() {
        System.out
                .println("obj2 lock is " + Thread.holdsLock(obj2) + " for thread " + Thread.currentThread().getName());
        synchronized (obj2) {
            try {
                System.out.println(Thread.currentThread().getName() + " : checking 2 in list in v5 " + list);
            } catch (Exception e) {
                System.out.println(
                        "%%%%%%%%%%%%%%%%%Error in thread for v5 " + Thread.currentThread().getName() + " " + list);
            }
            if (!list.contains(2)) {
                System.out.println("checking for 2 v5 " + list + Thread.currentThread().getName());
                try {
                    list.add(2);
                } catch (Exception e) {
                    System.out.println(
                            "#################Error in thread " + Thread.currentThread().getName() + " " + list);
                }
                System.out.println(Thread.currentThread().getName() + " : added 2 " + list);
            }
        }
    }

    public void check_v6() {
        System.out
                .println("obj3 lock is " + Thread.holdsLock(obj3) + " for thread " + Thread.currentThread().getName());
        synchronized (obj3) {
            try {
                System.out.println(Thread.currentThread().getName() + " : checking 3 in list in v6 " + list);
            } catch (Exception e) {
                System.out.println(
                        "%%%%%%%%%%%%%%%%%Error in thread for v6 " + Thread.currentThread().getName() + " " + list);
            }
            if (!list.contains(3)) {
                System.out.println("checking for 3 v6 " + list + Thread.currentThread().getName());
                try {
                    list.add(3);
                } catch (Exception e) {
                    System.out.println(
                            "###################Error in thread " + Thread.currentThread().getName() + " " + list);
                }
                System.out.println(Thread.currentThread().getName() + " : added 3 " + list);
            }
        }
    }

    public void check_v4(Monitor m1) {
        synchronized (m1) {
            System.out.println(
                    Thread.currentThread().getName() + " : checking 1 in list in v4 " + list + " " + m1.getCount());
            if (!list.contains(1)) {
                System.out.println("checking for 1 " + list + Thread.currentThread().getName());
                list.add(1);
                System.out.println(Thread.currentThread().getName() + " : added 1 " + list);
            }
        }
    }

    public void check_v5(Monitor m2) {
        synchronized (m2) {
            System.out.println(
                    Thread.currentThread().getName() + " : checking 2 in list in v5 " + list + " " + m2.getCount());
            if (!list.contains(2)) {
                System.out.println("checking for 2 " + list + Thread.currentThread().getName());
                list.add(2);
                System.out.println(Thread.currentThread().getName() + " : added 2 " + list);
            }
        }
    }

    public void check_v6(Monitor m3) {
        synchronized (m3) {
            System.out.println(
                    Thread.currentThread().getName() + " : checking 3 in list in v6 " + list + " " + m3.getCount());
            if (!list.contains(3)) {
                System.out.println("checking for 3 " + list + Thread.currentThread().getName());
                list.add(3);
                System.out.println(Thread.currentThread().getName() + " : added 3 " + list);
            }
        }
    }

    @Override
    public void run() {
        // Monitor m=new Monitor();
        check_v4();
        check_v5();
        check_v6();

    }
}

class Monitor {

    int count = 0;

    Monitor() {
        System.out.println("Monitor object is getting created.. " + count);
        count += 1;
    }

    public int getCount() {
        return count;
    }
}
