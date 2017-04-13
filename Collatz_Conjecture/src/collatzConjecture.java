//UNFINISHED 
import java.util.Random; 

public class collatzConjecture {
	private static final int ITERATIONS = 15; 
	
	public static void main(String[] args) {
		Random rand = new Random(); 
		int i = rand.nextInt(10) + 1; 
		System.out.println("The value of i is: " + i); 
		collatzConjectureUncrackable(i);
		for( int j = 0; j < ITERATIONS; j++) {
			if(i%2 ==0) {
				i = i/2; 
			}
			else {
				i = 3*i +1; 
			}
		}
		System.out.println("Current value of i is: " + i); 
		//System.out.println("The final answer after " + ITERATIONS + " iterations is:" + i);
	}
	
	public static int collatzConjectureUncrackable(int num) {  
		if(num%2 ==0) {
			num = num/2;
			return num;
		} 
		else {
			num= 3*num +1; 
			return num; 
		}
			
	}
}
