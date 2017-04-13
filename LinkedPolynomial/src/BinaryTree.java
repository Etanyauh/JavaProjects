
public class BinaryTree {
	private BinaryNode root; 
	
	public BinaryTree(Object x) {
		root = new BinaryNode(x); 
	}
	
	public boolean isEmpty() { return root == null; }
	public void makeEmpty() { root = null; }
	public int nodeCount() { return BinaryNode.nodeCount(root); }
	public Object getRootObj() throws BinaryTreeException {
		if(root == null) throw new BinaryTreeException("Empty Tree");
		else
			return root.element; 
	}
	
	public void setRootObj(Object x) throws BinaryTreeException {
		if(root == null) throw new BinaryTreeException("Empty Tree"); 
		else
			root.element = x; 
	}
	
	public BinaryTree getLeft() throws BinaryTreeException {
		if(root == null) throw new BinaryTreeException("Empty tree"); 
		else {
			BinaryTree t = new BinaryTree();
			t.root = root.left; 
			return t; 
		}
	}
	
	public void setLeft(BinaryTree t) throws BinaryTreeException {
		if(root == null) throw new BinaryTreeException("Empty Tree");
		else 
			root.left = t.root; 
	}
	
	public BinaryTree getRight() throws BinaryTreeException {
		if(root == null) throw new BinaryTreeException("Empty Tree"); 
		else
			BinaryTree t = new BinaryTree(); 
			t.root = root.right; 
			return t; 
			
	}
	
	public void setRight(BinaryTree t) throws BinaryTreeException {
		if(root == null) throw new BinaryTreeException("Empty Tree"); 
		else root.right = t.root; 
	}
	
}
