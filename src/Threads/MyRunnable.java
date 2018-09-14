package Threads;

public class MyRunnable {

	public static void main(String[] args) {
		RunThread rth1 = new RunThread("Thread1");
		rth1.start();
		RunThread rth2 = new RunThread("Thread2");
		rth2.start();
	}
}

class RunThread implements Runnable {
	Thread first;
	private String name;

	RunThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("Thread running " + name);
		for (int i = 0; i < 4; i++) {
			System.out.println(i+" " + name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Thread has been interrupted");
			}
		}
	}

	public void start() {
		System.out.println("Thread started");
		if (first == null) {
			first = new Thread(this, name);
			first.start();
		}

	}

}
