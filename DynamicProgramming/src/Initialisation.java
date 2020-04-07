import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Initialisation {
	


	int[] weight = new int[Constants.getDataSize()];
	int[] values = new int[Constants.getDataSize()]; 

	public void initialise() throws FileNotFoundException{

		Scanner s = new Scanner(new File(Constants.getDataFile()));
		

		int counter = 0;

		//while (s.hasNext())
		while(counter != Constants.getDataSize())
		{
			s.nextInt();         					// read and skip 'id'
			values[counter] =  s.nextInt(); 		// read and store 'name'
			weight[counter] = s.nextInt();         // read and skip 'age'
			counter++;
		}

	}


}
