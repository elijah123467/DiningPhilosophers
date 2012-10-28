public class Aristotle implements Runnable {
	// Variable to store method for multiple runs.
	DiningPhilosophers methodPhilosopher = null;

	public Aristotle() {

	}

	public Aristotle(DiningPhilosophers philoAction) {
		methodPhilosopher = philoAction;
	}

	int philosopher = 1;

	boolean dining = true;

	public void run() {

		// Run method to eat, think.
		methodPhilosopher.DiningPhilosopherRun(philosopher, "Aristotle");
		while (true) {
			methodPhilosopher.think();
			methodPhilosopher.take_forks(philosopher);
			methodPhilosopher.eat(philosopher);
			methodPhilosopher.put_forks(philosopher);
		}

	}
}
