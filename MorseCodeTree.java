import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	
	private TreeNode root;
	
	public MorseCodeTree() {
		buildTree();
	}

	@Override
	public TreeNode getRoot() {
		return root;
	}

	@Override
	public void setRoot(TreeNode newNode) {
		root = newNode;
	}

	@Override
	public LinkedConverterTreeInterface insert(String code, String result) {
		
		addNode(root, code, result);
		return this;
	}

	@Override
	public void addNode(TreeNode root, String code, String letter) throws NoSuchElementException {
	
		int index = 0;
		TreeNode currentNode = root;
		TreeNode leftChild;
		TreeNode rightChild;
		
		if(code.length() == 1) {
			if(code.equals(".")) {
				currentNode.setLeftChild(new TreeNode<>(letter));
			} else if (code.equals("-")) {
				currentNode.setRightChild(new TreeNode<>(letter));
			}
		} else {
			if(code.charAt(index) == '.') {
				currentNode = currentNode.getLeftChild();
				addNode(currentNode, code.substring(1), letter);
			} else if(code.charAt(index) == '-') {
				currentNode = currentNode.getRightChild();
				addNode(currentNode,code.substring(1),letter);
			} else {
				throw new NoSuchElementException();
			}
		}
	}

	@Override
	public String fetch(String code) {
		if(code.equals("/")) {
			return " ";
		} else {
			return fetchNode(root, code);
		}
	}

	@Override
	public String fetchNode(TreeNode root, String code) throws NoSuchElementException {
		int index = 0;
		TreeNode<String> currentNode = root;
		String result = currentNode.getData();
		
		
		if(code.length() == 0) {
			return result;
		} else {
			if (code.charAt(index) == '.') {
				return fetchNode(root.getLeftChild(), code.substring(1));
			} else if(code.charAt(index) == '-') {
				return fetchNode(root.getRightChild(), code.substring(1));
			} else {
				throw new NoSuchElementException();
			}
		}
		
	}

	@Override
	public LinkedConverterTreeInterface delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("This operation is not supported in the MorseCodeTree");
	}

	@Override
	public LinkedConverterTreeInterface update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("This operation is not supported in the MorseCodeTree");
	}

	@Override
	public void buildTree() {
		
		setRoot(new TreeNode<>(""));
		
		insert(".","e");
		insert("-","t");
		insert("..","i");
		insert(".-","a");
		insert("-.","n");
		insert("--","m");
		insert("...","s");
		insert("..-","u");
		insert(".-.","r");
		insert(".--","w");
		insert("-..","d");
		insert("-.-","k");
		insert("--.","g");
		insert("---","o");
		insert("....","h");
		insert("...-","v");
		insert("..-.","f");
		insert(".-..","l");
		insert(".--.","p");
		insert(".---","j");
		insert("-...","b");
		insert("-..-","x");
		insert("-.-.","c");
		insert("-.--","y");
		insert("--..","z");
		insert("--.-","q");
		
	}

	@Override
	public ArrayList toArrayList() {
		
		ArrayList<String> list = new ArrayList<>();
		LNRoutputTraversal(root, list);
		
		return list;
	}

	@Override
	public void LNRoutputTraversal(TreeNode root, ArrayList list) {
		
		if (root != null) {
			LNRoutputTraversal(root.getLeftChild(), list);
			list.add(root.getData());
			LNRoutputTraversal(root.getRightChild(),list);
		}
		
	}
	

}
