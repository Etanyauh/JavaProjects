
public class BinaryTreeNode {
	public int data; 
	public BinaryTreeNode left, right; 
	
	public BinaryTreeNode() { this(0); }
	
	public BinaryTreeNode(int data) {
		this.data = data; 
		left = null; 
		right = null; 
	}
	
	public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
		this.data = data; 
		this.left = left; 
		this.right = right; 
	}
	
	public int getData() {
		return data; 
	}
	
	public void setData(int data) {
		this.data = data; 
	}
	
	public BinaryTreeNode getLeft() {
		return left; 
	}
	
	public void setLeft(BinaryTreeNode left) {
		this.left = left; 
	}
	
	public BinaryTreeNode getRight() {
		return right; 
	}
	
	public void setRight(BinaryTreeNode right) {
		this.right = right; 
	}
	
	//Returns the number of nodes in the Binary Tree
	public static int nodeCount(BinaryTreeNode n) {
		if(n== null) return 0; 
		else
			return 1 + nodeCount(n.left) + nodeCount(n.right); 
	}
	//Returns the height of the Binary Tree
	public static int height(BinaryTreeNode n) {
		if(n == null) return -1; 
		else
			return 1 + Math.max(height(n.left) , height(n.right)); 
	}
}
