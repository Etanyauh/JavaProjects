
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> 
	{
		private static class Node<AnyType> {
			private AnyType element; 
			private Node<AnyType> parent; 
			private Node<AnyType> left; 
			private Node<AnyType> right; 
			private int height; 
			
			public Node(AnyType e, Node<AnyType> p, 
						Node<AnyType> l, Node<AnyType> r) {
				element = e; 
				parent = p; 
				left = l; 
				right = r; 
				height = 0; 
			}
			
			public AnyType getElement() { return element; }
			public Node<AnyType> getParent() { return parent; }
			public Node<AnyType> getLeft() { return left; }
			public Node<AnyType> getRight() { return right; }
			public int getHeight() { return height; }
			
			public void setElement(AnyType e) { element = e; }
			public void setParent(Node<AnyType> p) { parent = p; }
			public void setLeft(Node<AnyType> l) { left = l; }
			public void setRight(Node<AnyType> r) { right = r; }
			
		}
		
		private Node<AnyType> root; 
		
		public BinarySearchTree() { makeEmpty(); }
		public void makeEmpty() { root = null; }
		public boolean isEmpty() { return root == null; }
		public boolean contains(AnyType x) { return contains(x, root); }
		
		public AnyType findMin() throws IllegalStateException {
			if(isEmpty()) 
				throw new IllegalStateException("Search Tree is Empty."); 
			
			Node<AnyType> minNode = findMin(root); 
			return minNode.getElement(); 
		}
		
		public AnyType findMax() throws IllegalStateException {
			if(isEmpty()) 
				throw new IllegalStateException ("Search Tree is Empty."); 
			
			Node<AnyType> maxNode = findMax(root); 
			return maxNode.getElement(); 
		}
		
		public void insert(AnyType x) { root = insert(x, null, root);  }
		public void remove(AnyType x) { root = remove(x, root);  }
		public void printTree() {
			if(isEmpty()) 
				System.out.println("Empty Tree.");
			else 
				printTree(root); 
		}
		
		private boolean contains(AnyType x, Node<AnyType> t) {
			if(t == null) return false; 
			
			int compareResult = x.compareTo(t.getElement());
			 if(compareResult < 0)
				 return contains(x, t.getLeft()); 
			 else 
				 if(compareResult > 0)
					 return contains(x, t.getRight());
				 else
					 return true; 
		}
		
		private Node<AnyType> findMin(Node<AnyType> t) {
			if(t == null)return null; 
			else
				if(t.getLeft() == null)
					return t; 
			
			return findMin(t.getLeft()); 
		}
		
		private Node<AnyType> findMax(Node<AnyType> t){
			if(t == null) 
				while(t.getRight() != null)
					t= t.getRight(); 
			
			return t; 
		}
		
		private Node<AnyType> insert(AnyType x, Node<AnyType> p, 
									Node<AnyType> t) {
			if(t == null) return new Node<>(x, p, null, null); 
			
			int compareResult= x.compareTo(t.getElement()); 
			
			if(compareResult < 0)
				t.setLeft(insert(x, t, t.getLeft())); 
			else
				if(compareResult > 0)
					t.setRight(insert(x, t, t.getRight())); 
				else
					; // Duplicate value, do nothing
			
			return t; 
		}
		
		private Node<AnyType> remove(AnyType x, Node<AnyType> t) {
			if(t == null) return t; 
			
			int compareResult = x.compareTo(t.getElement()); 
			
			if(compareResult < 0)
				t.setLeft(remove(x, t.getLeft()));
			else
				if(compareResult > 0)
					t.setRight(remove(x, t.getRight()));
				else 
					if(t.getLeft() != null && t.getRight() != null)
					{
						Node<AnyType> minNodeRightSubtree = findMin(t.getRight()); 
						t.setElement(minNodeRightSubtree.getElement());
						t.setRight(remove(t.getElement(), t.getRight()));
					}
			return t; 
		}
		
		private void printTree(Node<AnyType> t) {
			if(t != null) 
			{
				printTree(t.getLeft()); 
				System.out.println(t.getElement());
				printTree(t.getRight()); 
			}
		}
}
