package javaBasic;

import java.util.Calendar;
import java.util.Random;

public class Topic_15_random {

	public static int generateFakeNumber() {
		Random random = new Random();
		return random.nextInt(9999);
	}

	// random 3 number
	public static int generate3Number() {
		int ulimit = 9999;
		int ilimit = 100;
		Random random = new Random();
		return ilimit + random.nextInt(ulimit - ilimit);
	}

	// get random number by date time
	public static long getRandomNumberByDateTime() {
		return Calendar.getInstance().getTimeInMillis() % 100000;
	}

}
