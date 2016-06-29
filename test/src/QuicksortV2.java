
import javax.swing.JOptionPane;
public class QuicksortV2 {
	public static void main(String[] args) {
		int n = Integer.parseInt(JOptionPane.showInputDialog("n? "));
		double[] x = new double[n];
		for (int i=0; i<n; i++) x[i]=Math.random();
		
		quickSort(x,0,n-1);
		for (int i=0; i<n; i++) System.out.println("x["+i+"]= " + x[i]);
	}
	public static void quickSort(double[] x, int min, int max) {
		if (min >= max) return;  //basecase
		int pivot = 0;
		double pivVal = x[min];
		double[] y = new double [max-min+1];  //too big, should be something like j-i+1
		int minPos = min;
		int maxPos = max;
		for (int k=min; k<=max; k++) {  //splits high and low values up around
			if (x[k] < pivVal) {           //around whatever value was in x[0]
				y[(minPos++)-min] = x[k];       
			} else {
				y[(maxPos--)-min] = x[k];
			}
		}
		pivot = minPos;
		y[pivot-min] = pivVal;			
		for (int k=0; k<y.length;k++) x[k+min] = y[k];
		quickSort(x, min, pivot-1); //recursive
		quickSort(x, pivot+1, max);
	}

}
