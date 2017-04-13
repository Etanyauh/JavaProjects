/*Name: Jospeh Huaynate
 * Project: Extra Credit
 * Date: 12/30/2016
 */
public class BirthdayCollisions {
	public static void main(String[] args) {
		double percent = 1; 
		double fifty = 0; 
		double ninety_five = 0; 
		
		for(double i = 365; i > 0; i--) {
			percent *= i/365; 
			
			if(percent > (1-.50)) {
				fifty = i -1; 
			}
			if(percent > (1-.95)) {
				ninety_five = i -1; 
			}
		}
		
		System.out.println("Number of people that will cause a 50% chance of collision: " + (365 - fifty));
		System.out.println("Number of people that will cause a 95% chance of collision: " + (365 - ninety_five));
	}
	
	/*Output:
	 * Number of people that will cause a 50% chance of collision: 22.0
	 * Number of people that will cause a 95% chance of collision: 46.0
	 * 
	 * Describe how you would handle collisions for the data, and also explain how you would write the "hash function"
	 * to assign a customer to the hash table by birthday:
	 * 
	 * In order to handle collisions, I would probably implement an open chaining hash function which would allow for more
	 * allowed values in the respective index. I would have an array of 365 which would represent the days of a year. Each 
	 * customer would have a unique ID but the last 3 digits would be their respective birthday. 
	 * E.G.: 124332(003)    I put parentheses to highlight the last 3 digits, but in this case
	 *                      003 would represent January 3. And this person would be assigned to position [3] of the array. 
	 *                      The array would probably start at index 1 in order to avoid confusion since 000 cannot be 
	 *                      used to represent a birthday.       
	 */
	
}
