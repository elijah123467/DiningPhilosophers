public class Socrates implements Runnable {
	// Variable to store method for multiple runs.
	DiningPhilosophers methodPhilosopher = null;

	public Socrates() {

	}

	public Socrates(DiningPhilosophers philoAction) {
		methodPhilosopher = philoAction;
	}

	// Variable to store philosopher.
	int philosopher = 0;

	boolean dining = true;

	public void run() {

		// Run method to eat, think.
		methodPhilosopher.DiningPhilosopherRun(philosopher, "Socrates");
		while (true) {
			methodPhilosopher.think();
			methodPhilosopher.take_forks(philosopher);
			methodPhilosopher.eat(philosopher);
			methodPhilosopher.put_forks(philosopher);
		}

	}
}
