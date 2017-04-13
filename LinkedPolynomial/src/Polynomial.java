/*
 * Joseph Huaynate
 * Project 1
 * CS313 Summer 2016
 */
public class Polynomial {
	private Node head, tail; 
	private int size;  
	
	public Polynomial() {
		head = null; 
		tail = head; 
	}
	
	public Node getHead() {
		return head;  
	}
	
	
	public void setHead(Node n) {
		head = n; 
	}
	
	public boolean isEmpty() {
		return (head == null); 
	}
	
	public void addCoeffNode(int x) {
		Node n = new Node(x, null); 
		if(size == 0) 
			head = n; 
		else
			tail.setNext(n);
		
		tail = n; 
		size++; 
	}
	
	public int size() {
		int currentSize = 0; 
		Node current = head;
		while(current != null) {
			currentSize = currentSize + 1; 
			current = current.getNext(); 
		}
		
		return currentSize; 
	}
	
	public String toString() {
		return " Polynomial  has " + size() + " elements."; 
	}
	
	public void printPolynomialList() {
		Node current = head; 
		while(current != null) {
			System.out.print(current.coeffReturn()); 
			current = current.getNext(); 
		}
		System.out.println("");
	}
	
	/* Puts the values of each node into an array
	 * 
	 */
	public int[] makeArray() { 
		int [] array = new int [this.size()]; 
		Node current = this.getHead();
		for(int i = 0; i < this.size(); i++) {
			array[i] = current.getCoeff();
			current=current.getNext();
		}
		return array; 
		
	}
	
	public void makeEmpty() {
		head=null;
		tail=null;
		size=0;

	}
	public static Polynomial add( Polynomial polyA, Polynomial polyB) {
		Polynomial sumPoly = new Polynomial(); 
		if(polyA.size()<polyB.size()){
			for(int i=0;i<polyB.size()-polyA.size();i++){
				polyA.addCoeffNode(0);
			}
		}
		else if(polyB.size()<polyA.size()){
			for(int i=0;i<polyA.size()-polyB.size();i++){
				polyA.addCoeffNode(0);
			}
			
		}else{
		int[] first=new int[polyA.size()]; 
		int [] second = new int[polyB.size()];
		first = polyA.makeArray(); 
		second = polyB.makeArray(); 
		
		for(int i=0;i<polyA.size();i++){
			sumPoly.addCoeffNode(first[i] + second[i]); 
		}
		}

		return sumPoly; 
	}
	
	
	
	
}

