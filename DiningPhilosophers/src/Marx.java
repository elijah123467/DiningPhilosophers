public class Marx implements Runnable {
	// Variable to store the amount of cookies eaten.
	int philosopher = 0;
	String name = "";

	boolean dining = true;

	public void run() {
		try {
			// Decides to eat cookies until there is no more.
			while (dining) {

				// Check to see if another thread is eating cookies.

				DiningPhilosophers philoAction = new DiningPhilosophers();
				philoAction.DiningPhilosopherRun(3,"Marx");

				Thread.sleep(4000);

				// System.out.println( cookie );

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// When done eating cookies display how many eaten.
		System.out.println("");
	}
}
