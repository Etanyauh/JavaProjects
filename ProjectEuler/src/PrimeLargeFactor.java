import java.util.Scanner; 
public class PrimeLargeFactor {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		long num = new Scanner(System.in).nextLong();
		printPrimeNumbers(num); 
	}
	
	public static void printPrimeNumbers(long prime) {
		long n; 
		for(long i = 2; i <= prime; i++) {
			n = 0; 
			while(prime % i == 0) {
				prime /= i; 
				n++; 
			}//WHILE
			
			if( n != 0) {
				for(long j = n; j > 0; j--) {
					System.out.print(i + "*");
				}//FOR
			}//IF
		}//FOR
	}
}
	
