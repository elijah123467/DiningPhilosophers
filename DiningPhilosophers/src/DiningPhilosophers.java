import java.util.Random;

public class DiningPhilosophers {
	String name;
	int i;
	int N = 5;
	int LEFT = (i + N - 1) % N;
	int RIGHT = (i + 1) % N;
	int THINKING = 0;
	int HUNGRY = 1;
	int EATING = 2;
	// typedef int semaphore;
	int[] state = new int[N];
	/* semaphore */int mutex = 1;
	/* semaphore s[N]; */
	int[] semaphore = new int[N];

	public DiningPhilosophers() {

	}

	public void DiningPhilosopherRun(int inI, String Name) {

		for (int j = 0; j < semaphore.length; j++) {
			System.out.println("Semaphore:" + semaphore[j]);
		}

		i = inI;

		name = Name;

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
		System.out.println("Semaphore:" + semaphore[inI] + " State"
				+ state[inI]);
		test(inI);
		up(mutex);
		down(semaphore[inI]);

		System.out.println("Semaphore:" + semaphore[inI] + " State"
				+ state[inI]);

	}

	private void put_forks(int inI) {

		down(mutex);
		state[inI] = THINKING;
		test(LEFT);
		test(RIGHT);
		up(mutex);

		System.out.println("Semaphore:" + semaphore[inI] + " State"
				+ state[inI]);

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
			Thread.sleep(thinkRand.nextInt(4000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void eat(int inI) {
		Random eatRand = new Random();
		System.out.println("Philosopher " + i + " " + name + " is eating.");
		try {
			Thread.sleep(eatRand.nextInt(4000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void down(int mutex) {
		semaphore[i] = mutex;

		System.out.println("Semaphore:" + semaphore[i] + " State" + state[i]);

	}

	private void up(int mutex) {
		semaphore[i] = 0;

		System.out.println("Semaphore:" + semaphore[i] + " State" + state[i]);

	}
}