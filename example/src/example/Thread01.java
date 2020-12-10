package example;

class ThreadWithClass extends Thread {
	ThreadWithClass(){
		
	}
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(getName());
			System.out.println(1);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ThreadWithRunnable implements Runnable {
	ThreadWithRunnable(){
		
	}
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName());
			System.out.println(2);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Thread01 {

	public static void main(String[] args) {
		ThreadWithClass thread1 = new ThreadWithClass();
		Thread thread2 = new Thread();

		thread1.start();
		thread2.start();
		
	}

}
