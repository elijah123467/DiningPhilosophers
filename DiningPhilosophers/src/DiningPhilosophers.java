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
	int mutex = 10;
	
	int[] semaphore = new int[N];
	int[] state = new int[N];
	String[] nameArray = new String[N];
	int[] countArray = new int[N];

	boolean[] blockedArray = new boolean[N];
	boolean blocked = false;

	public DiningPhilosophers() {

	}

	public void DiningPhilosopherRun(int inI, String Name) {

		i = inI;
		nameArray[i] = Name;

		System.out.println("Philosopher:" + nameArray[i]);

	}

	public void take_forks(int inI) {

		i = inI;

		if (blocked == false) {
			
			down(mutex);
			
			state[inI] = HUNGRY;

			System.out.println("Semaphore:" + nameArray[inI] + " "
					+ semaphore[inI] + " Hungry " + state[inI]);

			test(inI);

			up(mutex);
		}

		if (blocked = true) {
			
			down(semaphore[inI]);
		}

	}

	public void put_forks(int inI) {

		i = inI;

		down(mutex);
		state[inI] = THINKING;

		System.out.println("Semaphore: " + nameArray[inI] + " "
				+ semaphore[inI] + " Thinking " + state[inI]);

		test(LEFT);
		test(RIGHT);
		up(mutex);

	}

	private void test(int inI) {

		i = inI;

		if (state[inI] == HUNGRY && state[LEFT] != EATING
				&& state[RIGHT] != EATING) {
			state[inI] = EATING;
			up(semaphore[inI]);
		}
	}

	public void think() {

		Random thinkRand = new Random();
		System.out.println("Philosopher " + i + " " + nameArray[i]
				+ " is thinking.");

		try {
			Thread.sleep(thinkRand.nextInt(400));
			System.out.println("Philosopher " + i + " " + nameArray[i]
					+ " is Hungry.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void eat(int inI) {

		Random eatRand = new Random();

		System.out.println("Philosopher " + inI + " " + nameArray[inI]
				+ " is eating.");

		countArray[inI] += 1;

		try {
			Thread.sleep(eatRand.nextInt(40));
			for (int i = 0; i < nameArray.length; i++) {
				System.out.println("Philosopher " + inI + " is done eating. " + " But " + nameArray[i]
						+ " Has ate this many times: "
						+ countArray[i]);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		semaphore[inI] = 0;

	}

	private void down(int inMutex) {

		// Handles the semaphores critical region.
		if ((inMutex == 10 && semaphore[i] == 0 && blockedArray[i] == false)
				|| (blockedArray[i] == true)) {

			mutex = 20;

		} else if (inMutex == 20) {

			if (mutex == 20) {
				System.out.println(nameArray[i] + " is waiting");
			}

			blocked = true;
			System.out.println(nameArray[i] + " is blocked " + blocked);
		}

		if (inMutex < 5) {
			for (int i = 0; i < blockedArray.length; i++) {
				blockedArray[i] = false;
			}
			blockedArray[i] = true;
			down(mutex);
			System.out.println(nameArray[i] + " is no longer blocked ");
		}
	}

	private void up(int inMutex) {

		// Handles the semaphores critical region.
		if (inMutex == 20) {

			mutex = 10;

		}

		if (inMutex < 5) {

			semaphore[i] = 1;

		}
	}
}