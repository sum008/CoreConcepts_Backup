package javaIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.locks.ReentrantLock;

class Producer extends Thread {
	
	private OutputStream pos;
	private ReentrantLock lock;
	Producer(OutputStream pos, ReentrantLock lock) {
		this.pos=pos;
		this.lock=lock;
	}

	@Override
	public void run() {
		int count=1;
		while (true) {
			this.lock.lock();
			try {
				pos.write(count);
				pos.flush();
				System.out.println("count from pos "+count);
				System.out.flush();
				count+=1;
				
			} catch (IOException e) {e.printStackTrace();}
			this.lock.unlock();
		}
	}
}

class Consumer extends Thread {
	
	private InputStream pis;
	private ReentrantLock lock;
	Consumer(InputStream pis, ReentrantLock lock) {
		this.pis=pis;
		this.lock=lock;
	}

	@Override
	public void run() {
		while (true) {
			this.lock.lock();
			try {
				int readVal=pis.read();
				System.out.println("piped input "+readVal);
			} catch (IOException e) {e.printStackTrace();}
			this.lock.unlock();
		}
	}
}

public class Pipes {

	public static void main(String[] args) {
		
		try {
			PipedOutputStream pos = new PipedOutputStream();
			PipedInputStream pis = new PipedInputStream();
			pos.connect(pis);
			ReentrantLock lock = new ReentrantLock();
			
			Producer pro = new Producer(pos, lock);
			Consumer con = new Consumer(pis, lock);
			
			pro.start();
			con.start();
		} catch (IOException e) {e.printStackTrace();}
		
	}

}
