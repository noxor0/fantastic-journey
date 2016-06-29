public class DHStester{
	static Quadratic quad;
	public static void main(String[] args) {

		quad = new Quadratic(2.0,-14.0,24.0);
		if (testIt() != 161.5) System.out.println("************ bad value***********");
		if (quad.discriminant()!= 4.0) System.out.println("Bad disc");


		quad = new Quadratic(1,-4.0,4.0);
		if (testIt() != 110.25) System.out.println("************ bad value***********");
		if (quad.discriminant()!=  0.0) System.out.println("Bad disc");


		quad = new Quadratic(1.0,1.0,1.0);
		if (testIt() != 169.75) System.out.println("************ bad value***********");
		if (quad.discriminant()!= -3.0) System.out.println("Bad disc");

	}

	public static double testIt() {

		
		String QuadraticEquasion = quad.toString();
		System.out.println("\n" + QuadraticEquasion);

		double x = quad.f(12.5);
		System.out.println("Quadratic function output= " + x);
		System.out.println("Disc: " + quad.discriminant());
		if (quad.discriminant() > 0){
			double r1 = quad.r1();		
			double r2 = quad.r2();
			System.out.println("There are two distinct roots: " + r1 +" and "+ r2);
		}
		else if (quad.discriminant() == 0){
			double paired = quad.paired();
			System.out.println("One doubled real root: " + paired);
		}
		else if (quad.discriminant() < 0){
			String complex = quad.complex();
			System.out.println(complex);

		}
		return x;

	}

}