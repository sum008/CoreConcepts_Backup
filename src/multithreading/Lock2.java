package multithreading;


public class Lock2 {

    public static void main(String[] args) {
        Test t = new Test();
        Thread t1 = new Thread(t, "T1");
        Thread t2 = new Thread(t, "T2");
//		Thread t3 = new Thread(ta,"T3");
//		Thread t4 = new Thread(ta,"T4");
        t1.start();
        t2.start();
    }

}

class Test implements Runnable {

    private boolean isLocked = false;

    @Override
    public void run() {
        lock();
        unlock();

    }

    public void lock() {
        System.out.println("ent.. " + Thread.currentThread().getName());
        synchronized (this) {
            System.out.println("entered.. " + Thread.currentThread().getName() + " " + isLocked);
            while (isLocked) {
                try {
                    System.out.println("in wh.. " + Thread.currentThread().getName());
                    this.wait(); //wait will release the lock
                } catch (InterruptedException e) {
                    //do nothing, keep waiting
                }

            }
            System.out.println("hgfh.. " + Thread.currentThread().getName());
            synchronized (this) {
                System.out.println("syncBlk.. " + Thread.currentThread().getName());
                isLocked = true;
            }
        }
//      System.out.println("hgfh.. "+Thread.currentThread().getName());
//      synchronized(this){
//    	  System.out.println("syncBlk.. "+Thread.currentThread().getName());
//        isLocked = true;
//      }
    }

    public synchronized void unlock() {
        System.out.println("unlocked " + Thread.currentThread().getName());
        isLocked = false;
        this.notify();
    }

}
