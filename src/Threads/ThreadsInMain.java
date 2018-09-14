package Threads;

public class ThreadsInMain {
	public static void main(String[] args) {
		
		Thread myThread = new Thread(new Runnable() {
			public void run() 
			{
				for (int i = 0; i < 4; i++) {
					System.out.println(i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("Thread has been interrupted");
					}
				}
			}
		});
		myThread.start(); 

		System.out.println("Главный поток завершён");
	}
}
