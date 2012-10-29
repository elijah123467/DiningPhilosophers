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

			down(mutex, inI);

			state[inI] = HUNGRY;

			System.out.println("Semaphore:" + nameArray[inI] + " "
					+ semaphore[inI] + " Hungry " + state[inI]);

			test(inI);

			up(mutex, inI);
		}

		if (blocked = true) {

			down(semaphore[inI], inI);
		}

	}

	public void put_forks(int inI) {

		i = inI;

		down(mutex, inI);
		state[inI] = THINKING;

		System.out.println(nameArray[inI] + " is putting forks down. If ("
				+ semaphore[inI] + ") is 0 can start to eat again: " + " If ("
				+ state[inI] + ") is 0 then thinking.");

		test(LEFT);
		test(RIGHT);
		up(mutex, inI);

	}

	private void test(int inI) {

		i = inI;

		if (state[inI] == HUNGRY && state[LEFT] != EATING
				&& state[RIGHT] != EATING) {
			state[inI] = EATING;
			up(semaphore[inI], inI);
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
			System.out.println("Philosopher " + nameArray[inI]
					+ " is done eating. ");
			for (int i = 0; i < nameArray.length; i++) {
				System.out.println(" But " + nameArray[i]
						+ " Has ate this many times: " + countArray[i]);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		semaphore[inI] = 0;

	}

	private void down(int inMutex, int inI) {

		// Handles the semaphores critical region.
		if (((inMutex == 10) && (semaphore[inI] == 0) && (blockedArray[inI] == false))
				|| ((blockedArray[inI] == true) && (mutex == 10))) {
			System.out.println(nameArray[inI] + " not blocked.");
			mutex = 20;

		}

		else if (inMutex == 20) {

			if (mutex == 20) {
				System.out.println(nameArray[inI] + " is waiting");
			}

			blocked = true;
			System.out.println(nameArray[inI] + " is blocked " + blocked);
		}

		else if (inMutex < 5) {
			for (int i = 0; i < blockedArray.length; i++) {
				blockedArray[inI] = false;
			}
			blockedArray[inI] = true;
			System.out.println(nameArray[inI] + " is blocked ");
			down(mutex, inI);
			System.out.println(nameArray[inI] + " is no longer blocked ");
		}
	}

	private void up(int inMutex, int inI) {

		// Handles the semaphores critical region.
		if (inMutex == 20) {

			mutex = 10;

		}

		if (inMutex < 5) {

			semaphore[inI] = 1;

		}
	}
}