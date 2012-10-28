public class Kant implements Runnable {
	// Variable to store the amount of cookies eaten.
	int philosopher = 3;
	String name = "";

	boolean dining = true;

	public void run() {
		try {
			// Run method to eat, think.

			DiningPhilosophers philoAction = new DiningPhilosophers();

			philoAction.DiningPhilosopherRun(philosopher, "Kant");

			Thread.sleep(1);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
