package multithreading;

public class RaceCondition {

    public static void main(String[] args) {
//		JointAccount account = new JointAccount();
//		account.setBalance(100);
//		
//		Thread john = new Thread(account);
//		john.setName("John");
//		Thread anita = new Thread(account);
//		anita.setName("Anita");
//		john.start();
//		anita.start();

        Th t = new Th();
        Thread a = new Thread(t);
        a.setName("thread a");
        Thread b = new Thread(t);
        b.setName("thread b");
        a.start();
        b.start();
    }

}

class Th implements Runnable {
    int count = 0;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " : Before increment, count is " + count);
        count += 1;
//		while(true) {
//			System.out.println("t1..");
//		}
        System.out.println(Thread.currentThread().getName() + " : After increment, count is " + count);
    }

}

class JointAccount implements Runnable {

    private int balance;

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public void run() {
        doTransaction();
    }

    private void doTransaction() {
        makeWithdrawl(60);
        if (balance < 0) {
            System.out.println("balance is negative " + Thread.currentThread().getName());
        }
    }

    private synchronized void makeWithdrawl(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw " + amount + "$");
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrawn " + amount + "$");
            System.out.println("Remaining balance is " + balance);
        } else {
            System.out.println("Not enough fund for " + Thread.currentThread().getName());
        }
    }
}
