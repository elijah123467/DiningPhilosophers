public class Marx implements Runnable {
	// Variable to store Philosopher.
	int philosopher = 2;
	String name = "";

	boolean dining = true;

	public void run() {
		try {

			// Run method to eat, think.

			DiningPhilosophers philoAction = new DiningPhilosophers();

			philoAction.DiningPhilosopherRun(philosopher, "Marx");

			Thread.sleep(1);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
