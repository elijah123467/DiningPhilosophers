import java.util.Random;

public class DiningPhilosophers {
	String name;
	int i;
	int count;
	int N = 5;
	int LEFT = (i + N - 1) % N;
	int RIGHT = (i + 1) % N;
	int THINKING = 0;
	int HUNGRY = 1;
	int EATING = 2;

	int mutex = 0;
	int[] semaphore = new int[N];
	int[] state = new int[N];

	public DiningPhilosophers() {

	}

	public void DiningPhilosopherRun(int inI, String Name) {

		i = inI;
		name = Name;

		System.out.println("Philosopher:" + name);

		while (true) {
			think();
			take_forks(inI);
			eat(i);
			put_forks(inI);
		}
	}

	private void take_forks(int inI) {

		down(mutex);
		state[inI] = HUNGRY;

		System.out.println("Semaphore:" + name + " " + semaphore[inI] + " Hungry "
				+ state[inI]);

		test(inI);

		up(mutex);
		down(semaphore[inI]);

	}

	private void put_forks(int inI) {

		down(mutex);
		state[inI] = THINKING;

		System.out.println("Semaphore: " + name + " " + semaphore[inI]
				+ " Thinking " + state[inI]);

		test(LEFT);
		test(RIGHT);
		up(mutex);

	}

	private void test(int inI) {
		if (state[inI] == HUNGRY && state[LEFT] != EATING
				&& state[RIGHT] != EATING) {
			state[inI] = EATING;
			up(semaphore[inI]);
		}
	}

	private void think() {
		Random thinkRand = new Random();
		System.out.println("Philosopher " + i + " " + name + " is thinking.");
		try {
			Thread.sleep(thinkRand.nextInt(40));
			System.out.println("Philosopher " + i + " " + name + " is Hungry.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void eat(int inI) {
		
		Random eatRand = new Random();
		System.out.println("Philosopher " + i + " " + name + " is eating.");
		try {
			Thread.sleep(eatRand.nextInt(40));
			System.out.println("Philosopher " + i + " " + name
					+ " is done eating." + " Has ate this many times: " + count);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count ++;
	}

	private void down(int mutex) {
		// Handles the semaphores critical region.
		semaphore[i] = 0;

	}

	private void up(int mutex) {
		// Handles the semaphores critical region.
		semaphore[i] = mutex;

	}
}