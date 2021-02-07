
public class ArraySum {
	
	public ArraySum() {}
	
	public int sumOfArray(Integer[] a, int index) {
		
		int sum;
		
		if(index == 0) {
			sum = a[0];
		} else {
			sum = a[index] + sumOfArray(a,--index);
		}
		
		return sum;
	}


}
