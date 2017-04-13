
public class SumSquareDifference {
	public static long sumOfSquares(long num) {
		int answer_1 = 0; 
		for(int i = 1; i <= num; i++) {
			answer_1 += i*i; 
		}
		return answer_1; 
	}
	
	public static long squareOfSum(long limit) {
		long sum = (limit * (limit + 1)) /2;
		return sum*sum; 
		
	}
	
	public static void main(String[] args) {
		long n = 100; 
		System.out.println("The Square of Sums: " + squareOfSum(n));
		System.out.println("The Sum Of Squares: " + sumOfSquares(n));
		System.out.println("The difference between the sum of the squares of the first one hundred" 
				+ "natural numbers and the square of the sum: " + (squareOfSum(n) - sumOfSquares(n)));
	}
}
