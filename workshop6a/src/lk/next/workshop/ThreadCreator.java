package lk.next.workshop;

public class ThreadCreator {

	public static void main(String[] arg) {

		System.out.println("Creating Threads");

		Thread thread1 = new Thread(new PrintTask("task1"));
		Thread thread2 = new Thread(new PrintTask("task2"));
		Thread thread3 = new Thread(new PrintTask("task3"));

		System.out.println("Threads created, staring tasks.");

		thread1.start();
		thread2.start();
		thread3.start();

		System.out.println("Task started, main ends. \n");

	}

}
