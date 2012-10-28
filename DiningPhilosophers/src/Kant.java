public class Kant implements Runnable {
	// Variable to store method for multiple runs.
	DiningPhilosophers methodPhilosopher = null;

	public Kant() {

	}

	public Kant(DiningPhilosophers philoAction) {
		methodPhilosopher = philoAction;
	}
	
	// Variable to store philosopher.
	int philosopher = 3;

	boolean dining = true;

	public void run() {
		
			// Run method to eat, think.
			methodPhilosopher.DiningPhilosopherRun(philosopher, "Kant");
			while (true) {
				methodPhilosopher.think();
				methodPhilosopher.take_forks(philosopher);
				methodPhilosopher.eat(philosopher);
				methodPhilosopher.put_forks(philosopher);
			}
	}
}
