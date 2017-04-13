/**************************************************************************************************
 * Name: Joseph Huaynate
 * Class: project3
 * Purpose: The project takes a map, represented by an undirected graph, and assigns one of four 
 *          possible colors to each region. 
 ************************************************************************************************/
import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.IOException;
import java.util.*; 


public class project3 {
	
	public static void main(String[] args) throws IOException {
		if(args.length == 0)
			System.out.println("No file specified.");
		 
		else {
			
			FileReader theFile; 
			BufferedReader inFile; 
			Scanner input; 
			
			try {
				theFile = new FileReader(args[0]); 
				inFile = new BufferedReader(theFile);
				input = new Scanner(inFile); 
				
				while(( input.hasNextLine()) == true) {
					System.out.print("\n"); 
					Graph.numNodes = input.nextInt(); 	// number of nodes in graph
					int index_Num[] = new int[Graph.numNodes]; 
					System.out.println("The number of Nodes are: " + Graph.numNodes);
					System.out.println("Initial colors for Nodes: "); 
					System.out.println(Arrays.toString(index_Num) + "\n");  //prints out the values of the index array
					System.out.print("Adjacency Table:\n");
					//For loop that reads the input and stores it into a 2D array
					for(int i = 0; i < Graph.numNodes; i++) {
						for(int j = 0; j < Graph.numNodes; j++) {
							Graph.matrix[i][j] = input.nextInt(); 
							System.out.print(Graph.matrix[i][j] +" "); 
						}//FOR-j
						System.out.println(); 
					}//FOR- i
					Graph.fourColor(index_Num, Graph.matrix, Graph.numNodes);
					
				} //WHILE
			}catch  (Exception e) {
				e.printStackTrace(System.out);
				System.out.println(e);
			}
			
		}//ELSE
	}//MAIN	
}