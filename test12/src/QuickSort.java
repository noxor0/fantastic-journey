import javax.swing.JOptionPane;

public class QuicksortV2 {
	public static void main(String[] args) {
		int n = Integer.parseInt(JOptionPane.showInputDialog("n? "));
		double[] x = new double[n];
		for (int i=0; i<n; i++) x[i]=Math.random(); {
			
		}
		
		quickSort(x,0,n-1);
		for (int i=0; i<n; i++) System.out.println("x["+i+"]= " + x[i]);
	}
	public static void quickSort(double[] x, int min, int max) {
		if (min >= max) return;  //basecase
		int pivot = doPivot(x,min,max);
		
		quickSort(x, min, pivot-1); //recursive
		quickSort(x, pivot+1, max);
		
		// at this stage, x[pivot] divides the array into
		// two parts.  Below are all values less than x[pivot],
		// above it are all values > x[pivot]
		
	}
		public static int doPivot(double[] x, int min, int max) {
			int pivot = 0;
			double pivVal = x[min];
			double[] y = new double [max-min+1];  //too big, should be something like j-i+1
			
			int minPos = min;
			int maxPos = max;
			
			for (int k= min+1; k<=max; k++) {  //splits high and low values up around
				if (x[k] < pivVal) {           //around whatever value was in x[0]
					y[(minPos++)-min] = x[k];       
				} else {
					y[(maxPos--)-min] = x[k];
				}
			}
//			if(minPos > y.length-1) return; // something i added to stop out of bounds
//			if(maxPos < 0) return;
			pivot = minPos;
			y[pivot-min] = pivVal;
			//hardest part, trying to copy the array back in
			//y[0 to length] into x[min to max]					
			
			for(int k= 0; k<y.length;k++) x[k+min] = y[k];
						
			return pivot;	
					
				
		}
	
}
