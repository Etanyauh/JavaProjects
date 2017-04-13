/***********************************************************************************
 * Name: Joseph Huaynate 
 * Class: Graph 
 * Purpose: Allows the coloring of four colors to a n by n map
 * COLOR KEY: 1 = RED  2 = GREEN  3 = BLUE   4 = YELLOW   5 = INVALID COLOR 
 **********************************************************************************/
import java.util.*;

public class Graph {
	public static int numNodes = 0; 							  //Number of Nodes in the graph
	public static final int maxNodes = 16; 			              //Maximum number of nodes
	public static int matrix [] [] = new int[maxNodes][maxNodes]; // 2D adjacency matrix representation of graph
	public static int index_Num[]; 		
	public static int limit = 0; // the values of the index/Nodes

	/*************************************************************************************************
	 * Method: fourColor
	 * Parameters: int array1d[], int array2d[], int length	
	 * Purpose: The way the method works is in the thought of nodes as the position/index of the
	 *  1 Dimensional Array. The Array will contain numbers which will be represented as colors
	 *  (COLOR KEY: 1 = RED  2 = GREEN  3 = BLUE   4 = YELLOW   5 = INVALID COLOR). Then as long as
	 *  there isn't an adjacency relationship between two elements it continues. If not then the element
	 *  in the 1 Dimensional Array will increase by a factor of one, which in part changes the color. 
	 * It does this by traversing the 2 Dimensional Array. If a solution can not be found, backtrack is 
	 * needed. 
	 **********************************************************************************************/
	public static void fourColor(int array1d[], int array2d[][], int length) { 
		int c = 1; 

		while(limit < length){
			array1d[limit] = c; 

			for( int row = 0; row < length; row++) {
				if((array2d[limit][row] == 1) && (array1d[limit] == array1d[row])) {
					array1d[limit]++;
					row = 0;
				}//IF_1

				//BACKTRACK
				if(array1d[limit] > 4){
					System.out.println(limit);
					System.out.println("Backtrack in Progress:");
					backtrack(array1d); 
					currentColors(array1d);
					System.out.println(limit);
				}//IF_2
			}//FOR

			//c=1;
			limit++;
		}//WHILE
		limit=0;
		//		System.out.println("limit is "+limit+"out of while loop");
		System.out.println( Arrays.toString(array1d)+ "\n");
		System.out.println("Final Solution:");   
		currentColors(array1d); 
	}//LETSCHECK

	/**********************************************************************************
	 * Method: Backtrack
	 * Parameters: int array[], int index
	 * Purpose: 
	 **************************************************************************/
	public static void backtrack(int array[]){   //THIS MIGHT CAUSE A PROBLEM
		System.out.println("Backtrack in Session..."); 
		System.out.println(limit);
		array[limit] = 0;    // limit equal zero
		limit = limit -1;   // go back one position in the array
		array[limit]++;     // increament the value by 1
		
		if(array[limit]>4) { // if greater than 4, call backtrack again
			backtrack(array); 
		}

	}//BACKTRACK END

	// Prints out the color array
	public static void currentColors(int array[]) {
		System.out.println("Current Colors of nodes: ");
		for(int i = 0; i < array.length; i++) {
			if(array[i] == 1) {
				System.out.println("Node " + i + "'s color is: " + "RED"); 
			}
			else if(array[i] == 2) {
				System.out.println("Node " + i + "'s color is: " + "GREEN");
			}
			else if(array[i] == 3) {
				System.out.println("Node " + i + "'s color is: " + "BLUE"); 
			}
			else if(array[i] == 4) {
				System.out.println("Node " + i + "'s color is: " + "YELLOW"); 
			}
			else if(array[i] == 5) {
				System.out.println("Node " + i + "'s color is: " + "INVALID NUMBER");
			}
		}
	}

}
