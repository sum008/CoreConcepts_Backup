package multithreading;

public class WaitNotify {

    public static void main(String[] args) {
        Counter c = new Counter();
        Monitor1 m = new Monitor1();
        Thread t1 = new Thread(new Notifier(m, c), "T1");
        Thread t2 = new Thread(new Waiter(m, c), "T2");
        Thread t3 = new Thread(new Notifier(m, c), "T3");
        Thread t4 = new Thread(new Waiter(m, c), "T4");
        t2.start();
        t1.start();
//		t4.start();
//		t3.start();
    }
}

class Counter {
    int count = 0;
    int limit = 1000;

    void inc() {
        count += 1;
    }
}

class Monitor1 {

}

class Notifier implements Runnable {
    Monitor1 m;
    Counter c;

    Notifier(Monitor1 m, Counter c) {
        this.m = m;
        this.c = c;
    }

    @Override
    public void run() {
        synchronized (m) {
            while (c.count <= c.limit) {
                System.out.println("count : " + c.count);
                c.inc();
            }
            System.out.println("notifying..");
            m.notifyAll();
        }
    }
}

class Waiter implements Runnable {
    Monitor1 m;
    Counter c;

    Waiter(Monitor1 m, Counter c) {
        this.m = m;
        this.c = c;
    }

    @Override
    public void run() {
        synchronized (m) {
            while (c.count < c.limit) {
                System.out.println("waiting " + c.count);
                try {
                    m.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("finished waiting " + c.count);
        }
    }


}
