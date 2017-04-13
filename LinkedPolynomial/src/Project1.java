/*
 * Joseph Huaynate
 * Project1
 * CS313 Summer 1
 */
import java.io.*; 
 
public class Project1 {
	public static void main(String[] args) {
		if(args.length == 0) { 
			System.out.println("No specified file");
		} else {
			FileReader theFile;
			BufferedReader inFile; 
			String oneLine; 
		
			try{
				int counter= 0;  
			
				theFile = new FileReader(args[0]); 
				inFile = new BufferedReader(theFile);
				Polynomial poly1 = new Polynomial();
				Polynomial poly2 = new Polynomial();
				oneLine=inFile.readLine();
				while(oneLine != null) {
					System.out.println("readLine: " + oneLine);  
					String numbers[] = oneLine.split(",");  
					if(counter % 2 == 0) {
						for(int i = 0; i < numbers.length; i++) {
						System.out.print(numbers[i] + " ");
						poly1.addCoeffNode(Integer.parseInt(numbers[i]));
						}	
						//poly1.printPolynomialList(); 
						System.out.println("\n");
					}else {
							for(int i = 0; i < numbers.length; i++) {
								System.out.print(numbers[i] + " "); 
								poly2.addCoeffNode(Integer.parseInt(numbers[i]));
							}
							System.out.println("\n"); 
							
							Polynomial polyResult = new Polynomial(); 
							polyResult.add(poly1, poly2); 
							//polyResult.printPolynomialList(); 
					}
						counter++;
						oneLine=inFile.readLine();
						if(oneLine.isEmpty())oneLine=inFile.readLine();	 
				}//WHILE 
			} catch(Exception e) { System.out.println(e); }
		}
	}
}
