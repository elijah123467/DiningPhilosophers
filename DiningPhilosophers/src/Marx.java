public class Marx implements Runnable {
	// Variable to store method for multiple runs.
	DiningPhilosophers methodPhilosopher = null;

	public Marx() {

	}

	public Marx(DiningPhilosophers philoAction) {
		methodPhilosopher = philoAction;
	}

	// Variable to store Philosopher.
	int philosopher = 2;

	boolean dining = true;

	public void run() {

		// Run method to eat, think.
		methodPhilosopher.DiningPhilosopherRun(philosopher, "Marx");
		while (true) {
			methodPhilosopher.think();
			methodPhilosopher.take_forks(philosopher);
			methodPhilosopher.eat(philosopher);
			methodPhilosopher.put_forks(philosopher);
		}
	}
}
