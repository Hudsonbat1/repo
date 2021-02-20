
public class Driver {

	public static void main(String[] args) {
		
		int keys [] = {27,53,13,10,138,109,49,174,26,24};
		
		Integer[] hashtable = new Integer[13];
		
		int [] comps = new int[10];
		
		
		for(int i = 0; i < keys.length; i++) {
			comps[i] = calc(keys[i],hashtable);
		}
		
		for(int i = 0; i < hashtable.length; i++) {
			System.out.println(hashtable[i]);
		}
		
		System.out.println();
		
		for(int i = 0; i < comps.length; i++) {
			System.out.println(keys[i] + ", " + comps[i]);
		}
		
		System.out.println();
		
		Bucket b = new Bucket();
		
		b.test();
		

	}
	
	public static int calc(int key, Integer [] array) {
		
		int numberOfComps = 1;
		int n = array.length;
		int index = key % n;
		int offset;
		
		int q = key/n;
		
		if(q%n != 0) {
			offset = q;
		} else {
			offset = 19;
		}
		
		while(array[index] != null) {
			index = (index + offset)%n;
			numberOfComps++;
		}
		
		array[index] = key;
		
		return numberOfComps;
	}

}
