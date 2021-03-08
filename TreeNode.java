
public class TreeNode<T> {
	
	private T data;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;

	public TreeNode(T dataNode) {
		this(dataNode,null,null);
	}
	
	public TreeNode(TreeNode<T> node) {
		this(node.getData(), node.getLeftChild(), node.getRightChild());
	}
	
	public TreeNode(T dataNode, TreeNode<T> leftChild, TreeNode<T> rightChild) {
		this.data = dataNode;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public TreeNode<T> getLeftChild() {
		return leftChild;
	}
	
	public TreeNode<T> getRightChild(){
		return rightChild;
	}
	
	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}
	
	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}
	
	public boolean hasRightChild() {
		return rightChild != null;
	}
	
	public boolean hasLeftChild() {
		return leftChild != null;
	}
	
	public boolean isLeaf() {
		return (leftChild == null) && (rightChild == null);
	}
	
}
