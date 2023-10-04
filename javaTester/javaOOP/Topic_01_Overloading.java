package javaOOP;

// dung trong 1 class => overloading
// dung ngoai class (abstract, ke thua class, interface) => overriding
public class Topic_01_Overloading {

	static int plusMethod(int x, int y) {
		return x + y;
	}

	static double plusMethod(double x, double y) {
		return x + y;
	}

	public static void main(String[] args) {
		plusMethod(2, 1.5);
	}
}
