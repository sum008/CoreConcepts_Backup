package multithreading;

public class CheckingMemoryModel {

    public static void main(String[] args) {
//		Clazz m1 = new Clazz();
//		System.out.println(m1.toString());
//		Clazz m2 = new Clazz();
//		System.out.println(m2.toString());

        System.out.println(Clazz.clazzInstance.toString());


        Thread t1 = new Thread(new Model1(), "Thread A");
        Thread t2 = new Thread(new Model1(), "Thread B");
        //t1.start(); t2.start();
    }

}

class Model1 implements Runnable {

    @Override
    public void run() {
        method1();
    }

    private void method1() {
        System.out.println(Thread.currentThread().getName() + " : inside method1");
        Clazz instance = Clazz.clazzInstance;
        System.out.println(instance.toString());
    }

}

class Clazz {

    public static Clazz clazzInstance = new Clazz();

    static {
        System.out.println("static block start..");
        System.out.println(clazzInstance.toString());
        System.out.println("static block end..");
    }

    {
        System.out.println("creating Clazz object..");
    }

}
