

public class Bucket {
	
	int keys [] = {27,53,13,10,138,109,49,174,26,24};
	int [] compsTwo = new int[10];
	Node [] hashtable2 = new Node[10];
	
	public int bucket(int key, Node [] array) {
		int numberOfComps =0;
		int n = array.length;
		int index = key % n;
		
		Node newNode = new Node(key);
		
		if(array[index] == null) {
			array[index] = newNode;
		} else if(array[index] != null) {
			numberOfComps++;
			while(array[index].getNextNode() != null) {
				array[index] = array[index].getNextNode();
				numberOfComps++;
			}
			array[index].setNextNode(newNode);
		}
		
		return numberOfComps;
	}
	
	
	public void test() {
		
		for(int i = 0; i < compsTwo.length; i++) {
			compsTwo[i] = bucket(keys[i], hashtable2);
		}
		
		for(int i=0; i < hashtable2.length; i++) {
			try {
			System.out.print(hashtable2[i].getData());
			while (hashtable2[i].getNextNode() != null) {
				System.out.print(" " + hashtable2[i].getNextNode().getData());
				hashtable2[i] = hashtable2[i].getNextNode();
			}
		} catch(NullPointerException e) {
			System.out.print("No value");
		}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i=0; i < compsTwo.length; i++) {
			System.out.println(keys[i] + ", " + compsTwo[i]);
		}
}
	
	
	public class Node{
		
		private int data;
		private Node next;
		
		public Node(int key) {
			this(key,null);
		}
		
		public Node(int key, Node nextNode) {
			this.data = key;
			this.next = nextNode;
		}
		
		public void setNextNode(Node nextNode) {
			next = nextNode;
		}
		
		public Node getNextNode() {
			return next;
		}
		
		public int getData() {
			return data;
		}
	}

}
