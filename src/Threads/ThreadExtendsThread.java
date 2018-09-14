package Threads;

public class ThreadExtendsThread {

	public static void main(String[] args) {
		(new TET()).start();
		(new TET()).start();
	}
	
	public static synchronized void testThreads(String name) {
		System.out.println("Who synchronized? " + name);
		for (int i=0;i<4;i++) {
			System.out.println(name + " " + i);
		}
	}

}

class TET extends Thread {
	public void run() {
		System.out.println("Running" + getName());
		ThreadExtendsThread.testThreads(getName());
	}
}