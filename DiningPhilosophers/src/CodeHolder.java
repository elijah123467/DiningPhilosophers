
//public class CodeHolder {
//	/*
//	Program written by:	Elijah Wright
//	Program written on:	October 29, 2010
//	Purpose:		Program starts with 5000 cookies. Program creates
//	                        three threads that symbolize guests. Each thread
//	                        eats a cookie at different timed intervals. When
//	                        all the cookies are eaten the threads tell how many
//	                        cookies each of them have eaten by printing to the
//	                        screen.
//	*/
//
//	
//
//	  // Plate of cookies variable.
//	  static int cookies = 5000;
//
//	  public static void main ( String[] args ) {
//
//	    // Create tasks
//	    Runnable guest1 = new cookieMonster();
//	    Runnable guest2 = new miranda();
//	    Runnable guest3 = new eli();
//
//	    // Create threads
//	    Thread thread1 = new Thread(guest1);
//	    Thread thread2 = new Thread(guest2);
//	    Thread thread3 = new Thread(guest3);
//
//	    // Start threads
//	    thread1.start();
//	    thread2.start();
//	    thread3.start();
//	  }
//	}
//
//	// A task class for eating cookies.
//	class cookieMonster implements Runnable {
//
//	  // Variable to store the amount of cookies eaten.
//	  int cookie = 0;
//
//	  public void run() {
//	    try {
//	    // Decides to eat cookies until there is no more.
//	    while ( CodeHolder.cookies > 0 ) {
//	      // Check to see if another thread is eating cookies.
//	      if ( eat.eat() ) {
//	        // Counts eaten cookie to a variable.
//	        cookie += 1;
//	        Thread.sleep( 2000 );
//	        //System.out.println( cookie );
//	      }
//	    }
//	    // When done eating cookies display how many eaten.
//	    System.out.println( "\nI am the Cookie Monster. I ate " + cookie + " cookies" );
//	    }
//	    catch ( InterruptedException ex ) {
//	      ex.printStackTrace();
//	    }
//	  }
//	}
//
//	// A task class for eating cookies.
//	class miranda implements Runnable {
//
//	  // Variable to store the amount of cookies eaten.
//	  int cookie = 0;
//
//	  public void run() {
//	    try {
//	      // Decides to eat cookies until there is no more.
//	      while ( CodeHolder.cookies > 0 ) {
//	        // Check to see if another thread is eating cookies.
//	        if ( eat.eat() ) {
//	          // Counts eaten cookie to a variable.
//	          cookie += 1;
//	          Thread.sleep( 3000 );
//	          //System.out.println( cookie );
//	        }
//	      }
//	      // When done eating cookies display how many eaten.
//	      System.out.println( "\nI am Miranda. I ate " + cookie + " cookies" );
//	    }
//	    catch ( InterruptedException ex ) {
//	      ex.printStackTrace();
//	    }
//	  }
//	}
//
//	// A task class for eating cookies.
//	class eli implements Runnable{
//
//	  // Variable to store the amount of cookies eaten.
//	  int cookie = 0;
//
//	  public void run() {
//	    try {
//	      // Decides to eat cookies until there is no more.
//	      while ( CodeHolder.cookies > 0 ) {
//	        // Check to see if another thread is eating cookies.
//	        if ( eat.eat() ) {
//	          // Counts eaten cookie to a variable.
//	          cookie += 1;
//	          Thread.sleep( 4000 );
//	          //System.out.println( cookie );
//	        }
//	      }
//	      // When done eating cookies display how many eaten.
//	      System.out.println( "\nI am Eli. I ate " + cookie + " cookies" );
//	    }
//	    catch ( InterruptedException ex ) {
//	      ex.printStackTrace();
//	    }
//	  }
//	}
//
//	// Class to handle thread access of the cookie variable.
//	class eat {
//
//	  public synchronized static boolean eat() {
//
//	    // Eats a cookie.
//	    CodeHolder.cookies -= 1;
//	    return true;
//	  }
//	}
//
//	/*
//
//	I am Eli. I ate 1279 cookies
//
//	I am the Cookie Monster. I ate 2131 cookies
//
//	I am Miranda. I ate 1599 cookies
//	Press any key to continue . . .
//
//	*/
//
//
//
//
//
