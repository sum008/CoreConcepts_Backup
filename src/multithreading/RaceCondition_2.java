package multithreading;

import java.util.ArrayList;
import java.util.List;

public class RaceCondition_2 {

    public static void main(String[] args) {

        // A race condition occurs when two or more threads can access shared data and
        // they try to change it at the same time.

        Race_1 race = new Race_1();
        Thread t1 = new Thread(race, "Thread A");
        Thread t2 = new Thread(race, "Thread B");
        t1.start();
        t2.start();
    }

}

class Race_1 implements Runnable {

    List<Integer> list = new ArrayList<>();

    public void check_v1() {
        if (!list.contains(1)) {
            System.out.println("checking for 1 " + list + Thread.currentThread().getName());
            list.add(1);
            System.out.println(Thread.currentThread().getName() + " : added 1 " + list);
        }

        if (!list.contains(2)) {
            System.out.println("checking for 2 " + list + Thread.currentThread().getName());
            list.add(2);
            System.out.println(Thread.currentThread().getName() + " : added 2 " + list);
        }

        if (!list.contains(3)) {
            System.out.println("checking for 3 " + list + Thread.currentThread().getName());
            list.add(3);
            System.out.println(Thread.currentThread().getName() + " : added 3 " + list);
        }
    }

    public synchronized void check_v2() {
        if (!list.contains(1)) {
            System.out.println("checking for 1 " + list + Thread.currentThread().getName());
            list.add(1);
            System.out.println(Thread.currentThread().getName() + " : checking for 1 " + list);
        }

        if (!list.contains(2)) {
            System.out.println("checking for 2 " + list + Thread.currentThread().getName());
            list.add(2);
            System.out.println(Thread.currentThread().getName() + " : checking for 2 " + list);
        }

        if (!list.contains(3)) {
            System.out.println("checking for 3 " + list + Thread.currentThread().getName());
            list.add(3);
            System.out.println(Thread.currentThread().getName() + " : checking for 3 " + list);
        }
    }

    public void check_v3() {
        synchronized (this) {
            if (!list.contains(1)) {
                System.out.println("checking for 1 " + list + Thread.currentThread().getName());
                list.add(1);
                System.out.println(Thread.currentThread().getName() + " : checking for 1 " + list);
            }
        }
        synchronized (this) {
            if (!list.contains(2)) {
                System.out.println("checking for 2 " + list + Thread.currentThread().getName());
                list.add(2);
                System.out.println(Thread.currentThread().getName() + " : checking for 2 " + list);
            }
        }
        synchronized (this) {
            if (!list.contains(3)) {
                System.out.println("checking for 3 " + list + Thread.currentThread().getName());
                list.add(3);
                System.out.println(Thread.currentThread().getName() + " : checking for 3 " + list);
            }
        }
    }

    @Override
    public void run() {
        check_v1();
    }

}
