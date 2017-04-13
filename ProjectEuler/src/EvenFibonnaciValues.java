import java.util.Scanner; 

public class EvenFibonnaciValues {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		
		System.out.println("Enter number upto which Fibonacci series to print: ");
		int number = new Scanner(System.in).nextInt(); 
		int answer = 0; 
		
		System.out.println("\nUsing Method-1: Using Recursion. Provided Number: " + number);
		//Printing Fibonacci series upto number
		for(int i = 1; i <= number; i++) {
			System.out.println(fibonacciRecursion(i) + " ");
			if(fibonacciRecursion(i) % 2 == 0) {
				answer = fibonacciRecursion(i) + answer; 
				
			}
		}
		System.out.println("The summ of all even numbers is: " + answer);
		
		System.out.println("\nMethod-2: Fibonacci number at location " + number + " is ==> " + (fibonacciLoop(number) + ""));
	}//MAIN
	
	//Method-1: Jav program for Fibonacci number using recursion
	public static int fibonacciRecursion(int number) {
		if(number == 1 || number == 2) {
			return 1; 
		}
		return fibonacciRecursion(number - 1) + fibonacciRecursion(number - 2); //tail recursion 
	}
	
	public static int fibonacciLoop(int number) {
		if(number == 1 || number == 2) {
			return 1; 
		}
		int fibo1 =1 ,fibo2 = 1, fibonacci = 1; 
		for(int i = 3; i <= number; i++) {
			fibonacci = fibo1 + fibo2; //Fibonacci number is sum of previous two Fibonacci nums
			fibo1 = fibo2; 
			fibo2 = fibonacci; 
		}
		return fibonacci; 
	}
}
