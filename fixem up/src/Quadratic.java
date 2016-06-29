import java.util.Scanner;

// Author: Lindsee Purnell, Assignment: Quadratic Objects
public class Quadratic {
	double a, b, c;
	double[] x = {a, b, c};
	
	public Quadratic(double a, double b, double c){
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public static double r1(double[] pro){
		double r2;
		r2 = (-pro[1] - Math.sqrt(pro[1]*pro[1] - 4*pro[0]*pro[2]))/(2.0*pro[0]);
		System.out.println("Root 2 is " + r2);
		return r2;
	}

	public static double r2(double[] pro){
		double r2;
		r2 = (-pro[1] - Math.sqrt(pro[1]*pro[1] - 4*pro[0]*pro[2]))/(2.0*pro[0]);
		System.out.println("Root 2 is " + r2);
		return r2;
	}

	public static String complex(double[] pro){
		String 12.5complex;
		complex = (-pro[1]/(2*pro[0])) + " +/- " + Math.sqrt(-(pro[1]*pro[1] - 4*pro[0]*pro[2]))/(2*pro[0]) + "i"; 
		System.out.println("Both Roots are Imaginary " + complex);
		return complex;
	}
	
	public static double paired(double[] pro){
		double paired; 
		paired = (-pro[1] + Math.sqrt(pro[1]*pro[1] - 4*pro[0]*pro[2]))/(2.0*pro[0]);
		System.out.println("Only One Root: " + paired);	
		return paired;
	}
	
	public static String toString(double[] pro){
		String toString;
		toString = pro[0] + " x^2 " + pro[1] + " x " + pro[2];
		return toString;
	}
	
	public double discriminant() {
		double[] array = {a,b,c};
		double discriminant;
		discriminant = (Math.pow(array[1], 2)-4*array[0]*array[2]);
		if (discriminant > 0){
			Quadratic.r1(array);
			Quadratic.r2(array);
		}
		else if (discriminant < 0){
			Quadratic.complex(array);
		}
		else if (discriminant == 0){
			Quadratic.paired(array);
		}
		return discriminant;
	}

	public static Quadratic getDoubles() {
		Scanner s = new Scanner(System.in);
		System.out.println("Input A variable");
		double a = s.nextDouble();
		System.out.println("Input B variable");
		double b = s.nextDouble(); 
		System.out.println("Input C variable");
		double c = s.nextDouble();
		Quadratic quad = new Quadratic(a,b,c);
		return quad;
	}
}




