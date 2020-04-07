import java.io.*;
import java.util.*;

public class DataProcessor 
{    
    /** Process the data */
	public static void processData() throws FileNotFoundException
    {  
		
		Constants.VALUES = new int [Constants.getDataSize()];
		Constants.WEIGHTS = new int [Constants.getDataSize()];
		
		Scanner s = new Scanner(new File(Constants.getDataFile()));
		
		int counter = 0;
		
		while (counter < Constants.getDataSize())
		{
		    s.nextInt();         							  // read and skip 'id'
		    Constants.VALUES[counter] =  s.nextInt(); 		  // read and store 'name'
		    Constants.WEIGHTS[counter] = s.nextInt();         // read and skip 'age'
		    
		    counter++;
		}
		
		//System.out.println(Arrays.toString(Constants.VALUES));
		//System.out.println(Arrays.toString(Constants.WEIGHTS));
		
		
		
    }
	
}
