/*
 * Joseph Huaynate
 * Project1
 * CS313 Summer 2016
 */
public class Node {
		public int coefficient; 
		public Node next; 
		
		public Node() {
			this(0, null);  
		}
		
		public Node(int coefficient) {
			this.coefficient = coefficient; 
		}
		
		public Node(int coefficient, Node next ) {
			this.coefficient = coefficient; 
			this.next = next; 
		}
		
		public int getCoeff() {
			return coefficient; 
		}
		
		public void setCoeff(int coefficient) {
			this.coefficient = coefficient; 
		}
		
		public Node getNext() {
			return this.next; 
		}
		
		public void setNext(Node next) {
			this.next = next; 
		}
		
		public int coeffReturn() {
			return getCoeff(); 
		}
		
	

}
