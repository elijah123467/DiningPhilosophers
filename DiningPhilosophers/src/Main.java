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
		System.out.println("fuck off man1");
		//thread2.start();
		System.out.println("fuck off man2");
		//thread3.start();
		System.out.println("fuck off man3");
		//thread4.start();
		System.out.println("fuck off man4");
		//thread5.start();
		System.out.println("fuck off man5");
	}

}
