
public class QuickSort{

	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void qs(T[] ar, int min, int max) {
		
//		if(min < max){
//			T y = ar[(max + min) / 2];
//			int minPos = min;
//			int maxPos = max;
//			do{
//				while(ar[minPos].compareTo(y) < 0) minPos ++;
//				while(y.compareTo(ar[maxPos]) < 0) maxPos--;
//				if ( minPos <= maxPos){
//					T tmp = ar[minPos];
//					ar[minPos] = ar[maxPos];
//					ar[maxPos] = tmp;
//					minPos++;
//					maxPos--;
//				}
//			}while(minPos <= maxPos);
//			qs(ar, min, maxPos);
//			qs(ar, minPos, max);
//		}
			
		//how's this?		
		if (min >= max) return;
		
		int minPos = min;
		int maxPos = max;
		int pivot = min;
		T pivVal = ar[pivot];
		Object[] y = new Object[max-min+1];  
		
		for (int k= min+1; k<=max; k++) { 
			if (ar[k].compareTo(pivVal) < 0) {           
				y[(minPos++)-min] = ar[k];
			} else {
				y[(maxPos--)-min] = ar[k];
			}
		}
		pivot = minPos;
		y[minPos-min] = pivVal;
		for(int k=0; k<y.length;k++) ar[k+min] = (T)y[k];			
		qs(ar, min, pivot-1); //recursive
		qs(ar, pivot+1, max);
	}
}
