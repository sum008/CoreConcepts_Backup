package multithreading;

public class HappensBefore {

    public static void main(String[] args) {
        HB hb = new HB();
        Thread t1 = new Thread(hb, "T1");
        Thread t2 = new Thread(hb, "T2");
        Thread t3 = new Thread(hb, "T3");
        Thread t4 = new Thread(hb, "T4");
        t1.start();
        t2.start();
//		t3.start();
//		t4.start();
    }
}

class HB implements Runnable {

    int y = 1;
    int x = 2;

//	void set() {
//		 y=1;
//		 y++;
//		 x=2;
//		 x++;
//	}
//	
//	void print() {
//	//	set();
//		System.out.println(Thread.currentThread().getName()+" : x is : "+x);
//		System.out.println(Thread.currentThread().getName()+" : y is : "+y);
//	}

    @Override
    public void run() {
        y++;
        System.out.println(Thread.currentThread().getName() + " : y is : " + y);
        x++;
//		 System.out.println(Thread.currentThread().getName()+" : y is : "+y);
        System.out.println(Thread.currentThread().getName() + " : x is : " + x);
    }


}
