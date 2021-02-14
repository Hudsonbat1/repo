import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	
	Comparator<T> comparator;
	
	public SortedDoubleLinkedList(Comparator<T> comparator2) {
		this.comparator = comparator2;
	}
	
	public SortedDoubleLinkedList<T> add(T data){
		
		Node currentNode;
		Node nodeAfter = head;
		Node endNode;
		
		if(numberOfEntries <= 0) {
			head = new Node(data);
			tail = head;
			numberOfEntries++;
			return this;
		} else if(numberOfEntries == 1) {
			if(comparator.compare(data, head.getData()) <= 0) {
				currentNode = new Node(null, data, head);
				head.setPreviousNode(currentNode);
				head = currentNode;
				numberOfEntries++;
		} else {
			currentNode = new Node(head,data,null);
			head.setNextNode(currentNode);
			tail = currentNode;
			numberOfEntries++;
		}
			return this;
		} else {
		
		while(nodeAfter != null) {
			if(comparator.compare(data, nodeAfter.getData()) <= 0) {
				if(nodeAfter.getPreviousNode() != null) {
					currentNode = new Node(nodeAfter.getPreviousNode(),data, nodeAfter);
					nodeAfter.getPreviousNode().setNextNode(currentNode);
					nodeAfter.setPreviousNode(currentNode);
					numberOfEntries++;
				} else {
					currentNode = new Node(null, data, nodeAfter);
					head = currentNode;
					nodeAfter.setPreviousNode(currentNode);
					numberOfEntries++;
				}
				break;
			}
			
			if(nodeAfter.getNextNode() == null) {
				endNode = new Node(tail, data, null);
				tail.setNextNode(endNode);
				tail = endNode;
				numberOfEntries++;
				break;
			}
			
			nodeAfter = nodeAfter.getNextNode();
			}
		}

		return this;
	}
	
	@Override
	public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	@Override
	public BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	@Override
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	
	@Override
	public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator){
		super.remove(data, comparator);
		return this;
	}
	

}
