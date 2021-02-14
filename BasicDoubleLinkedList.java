import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T> {
	
	protected Node head;
	protected Node tail;
	protected int numberOfEntries;
	
	public BasicDoubleLinkedList() {
		head = null;
		tail = null;
		numberOfEntries = 0;
	}
	
	public BasicDoubleLinkedList<T> addToEnd(T data) {
		Node newNode = new Node(tail,data, null);
		
		if(isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setNextNode(newNode);
			tail = newNode;
		}
		numberOfEntries++;
		return this;
	}
	
	public BasicDoubleLinkedList<T> addToFront(T data) {
		Node newNode = new Node(null,data,head);
		
		if(isEmpty()) {
			head = newNode;
		} else {
			head.setPreviousNode(newNode);
			head = newNode;
		}
		numberOfEntries++;
		return this;
	}
	
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator){
		
		Node currentNode = head;
		Node nodeToRemove = null;
		Node nodeBefore;
		Node nodeAfter;
		
		while(currentNode != null) {
		
		if(comparator.compare(currentNode.getData(),targetData) == 0) {
			nodeToRemove = currentNode;
		
		if(nodeToRemove == head) {
			head = head.getNextNode();
		} else if(nodeToRemove == tail) {
			tail = tail.getPreviousNode();
		} else {
			nodeAfter = nodeToRemove.getNextNode();
			nodeBefore= nodeToRemove.getPreviousNode();
			nodeBefore.setNextNode(nodeAfter);	
			}
		}
		
		currentNode = currentNode.getNextNode();
		}
		numberOfEntries--;
		return this;
	}
	
	public T retrieveFirstElement() {
		T first = head.getData();
		
		head = head.getNextNode();
		
		numberOfEntries--;
		
		return first;
		
	}
	
	public T retrieveLastElement() {
		T last = tail.getData();
		
		tail = tail.getPreviousNode();
		
		numberOfEntries--;
		
		return last;
	}
	
	public ArrayList<T> toArrayList(){
		
		ArrayList<T> list = new ArrayList<T>(getSize());
		
		Node currentNode = head;
		int index = 0;
		while(currentNode!= null && index < getSize()) {
			list.add(currentNode.getData());
			index++;
			currentNode = currentNode.getNextNode();
		}
		return list;
	}
	
	public T getFirst() {
		return head.getData();
	}
	
	public T getLast() {
		
		return tail.getData();
	}
	
	public int getSize() {
		return numberOfEntries;
	}
	
	
	public boolean isEmpty() {
		return head == null;
	}
	
	@Override
	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {

		return new IteratorForLinkedList();
	}
	
	
	
	public class IteratorForLinkedList<T> implements ListIterator<T>{
		
		private Node nextNode;
		private Node previousNode;
		
		private IteratorForLinkedList() {
			nextNode = head;
		}

		@Override
		public void add(T arg) {
			throw new UnsupportedOperationException("add(T arg) is not supported "
					+ "by this operator");
		}

		@Override
		public boolean hasNext() {
			return nextNode != null;
		}

		@Override
		public boolean hasPrevious() {
			return previousNode != null;
		}

		@Override
		public T next() {
			T result;
			
			if(hasNext()) {
				previousNode = nextNode;
				result = (T)nextNode.getData();
				nextNode = nextNode.getNextNode();
				
			} else {
				throw new NoSuchElementException("Illegal call to next():" 
						+ "iterator is after end of list");
			}
			return result;
		}
		

		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException("nextIndex() is not supported "
					+ "by this operator");
		}

		@Override
		public T previous() {
			
			T result;
			
			if(hasPrevious()) {
				result = (T)previousNode.getData();
				previousNode = previousNode.getPreviousNode();
				
			} else {
				throw new NoSuchElementException("Illegal call to previous():"
						+ "iterator is at the beggining of lise");
			}
			
			return result;
		}

		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException("previousIndex() is not supported "
					+ "by this operator");
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("remove() is not supported "
					+ "by this operator");
		}

		@Override
		public void set(T arg) {
			throw new UnsupportedOperationException("set(T arg) is not supported "
					+ "by this operator");
		}
	}
	
	
	
	public class Node{
		
		protected T data;
		protected Node next;
		protected Node previous;
		
		public Node(T data) {
			this.data = data;
			previous = null;
			next = null;
		}
		
		public Node(Node previous,T data, Node next) {
			this.previous = previous;
			this.data = data;
			this.next = next;
		}
		
		public void setNextNode(Node nextNode) {
			next = nextNode;
		}
		
		public Node getNextNode() {
			return next;
		}
		
		public void setPreviousNode(Node previousNode) {
			previous = previousNode;
		}
		
		public Node getPreviousNode() {
			return previous;
		}
		
		public void setData(T anEntry) {
			data = anEntry;
		}
		
		public T getData() {
			return data;
		}
		
		
	
	}


}
