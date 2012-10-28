public class Plato implements Runnable {
	// Variable to store the amount of cookies eaten.
	int philosopher = 4;

	boolean dining = true;

	public void run() {
		try {

			// Run method to eat, think.

			DiningPhilosophers philoAction = new DiningPhilosophers();

			philoAction.DiningPhilosopherRun(philosopher, "Plato");

			Thread.sleep(1);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
