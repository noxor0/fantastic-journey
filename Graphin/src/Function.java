//Connor Cox, Last assignment

public class Function {
	double[] func;
	int foo;
	
	public Function (double [] func){
		this.func = func;
	}
	
	public double expo(Double x){
		double y = func[0]*Math.exp(func[1]*x);
		return y;
	}

	public double sine(Double x){
		double y = func[0]*Math.sin((func[1]*x+func[2]));
		return y;
	}
	
	public Double poly(Double x){ //dunno if this is right, instructions unclear
		double y=0;
		for (int i=1; i<=func[0]; i++ ) {
			y = y*x +func[i];
		}
		return y;
	}
	
}
