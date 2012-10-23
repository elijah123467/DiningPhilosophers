public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create tasks
		
		Runnable aristotle = new Aristotle();
		Runnable socrates = new Socrates();
		Runnable kant = new Kant();
		Runnable marx = new Marx();
		Runnable plato = new Plato();

		// Create threads
		Thread thread1 = new Thread(aristotle);
		Thread thread2 = new Thread(socrates);
		Thread thread3 = new Thread(kant);
		Thread thread4 = new Thread(marx);
		Thread thread5 = new Thread(plato);

		// Start threads
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
	}

}
