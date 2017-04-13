
public class BinaryNode {
	Object element;     //friendly data accessible by any class in the same package
	BinaryNode left, right;  // no need to provide access and update methods
	
	BinaryNode() { this(null); }  //3 constructors 
	BinaryNode(Object e) { this(e, null, null);  }
	BinaryNode(Object e, BinaryNode ln, BinaryNode rn) {
		element = e; 
		left = ln; 
		right = rn; 
	}
	
	public static int nodeCount(BinaryNode n) {
		if(n == null) return 0; 
		else
			return 1+ nodeCount(n.left) + nodeCount(n.right); 
	}
	
	public static int height(BinaryNode n) {
		if(n == null) return -1; 
		else return 1 + Math.max(height(n.left) , height(n.right)); 
	}
}
