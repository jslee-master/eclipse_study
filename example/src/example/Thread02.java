package example;

class ThreadWithRunnable2 implements Runnable {
	ThreadWithRunnable2(){
		
	}
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}

public class Thread02 {

	public static void main(String[] args) {
		Thread thread1 = new Thread();
		Thread thread2 = new Thread();

		thread2.setPriority(10);
		
		thread1.start();
		thread2.start();
		
		System.out.println(thread1.getPriority()+" 111");
		System.out.println(thread2.getPriority()+" 222");
		
	}

}
