import java.util.ArrayList;
import java.util.List;

public class MultiExecutor {

	// Add any necessary member variables here
	private  List<Runnable> tasks;

	public MultiExecutor(List<Runnable> tasks) {
		this.tasks = tasks;
	}

	/**
	 * Starts and executes all the tasks concurrently
	 */
	public void executeAll() {
		List<Thread> myThreads = new ArrayList<Thread>();

		for (Runnable runnable : tasks) {
			Thread myThread = new Thread(runnable);
			myThreads.add(myThread);
		}

		for (Thread thread : myThreads) {
			thread.start();
		}

	}

	public static void main(String[] args) {
		List<Runnable> tasks = new ArrayList<Runnable>();
		
		tasks.add(new Task1());
		tasks.add(new Task2());
		tasks.add(new Task3());
		
		MultiExecutor multiExecutor = new MultiExecutor(tasks);
		
		multiExecutor.executeAll();
		
		
	}

	private static class Task1 extends Thread {
		@Override
		public void run() {
			System.out.println("Hello from new Task1 ");
		}
	}
	private static class Task2 extends Thread {
		@Override
		public void run() {
			System.out.println("Hello from new Task2 ");
		}
	}
	private static class Task3 extends Thread {
		@Override
		public void run() {
			System.out.println("Hello from new Task3 ");
		}
	}



}
