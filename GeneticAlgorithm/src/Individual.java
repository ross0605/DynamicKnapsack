import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Individual {

	int[] weight = new int[Parameters.getDataSize()];
	int[] values = new int[Parameters.getDataSize()];
	boolean[] included = new boolean[Parameters.getDataSize()];

	public Individual() {		

	}


	public void initialise() throws FileNotFoundException{

		Scanner s = new Scanner(new File(Parameters.getDataFile()));

		int counter = 0;
		int b;
		int c;

		//while (s.hasNext())
		while(counter != Parameters.getDataSize())
		{
			s.nextInt();            // read and skip 'id'
			b = s.nextInt(); 		// read and store 'name'
			c = s.nextInt();        // read and skip 'age'

			weight[counter] = c;
			values[counter] = b;
			included[counter] = false;

			if(values[counter] / weight[counter] > 3) {
				included[counter] = true;
			}

			counter++;
		}		
	}

	public double getFitness(){

		Random r = new Random();

		int totalFitness = 0;
		int totalWeight = 0;

		for(int i = 0; i< included.length; i++){
			//System.out.println(included[i]);
			if(included[i] == true){
				totalFitness += values[i];
				totalWeight += weight[i];
			}
		}

		if(totalWeight > Parameters.getKSCapacity()){
			while(totalWeight > Parameters.getKSCapacity()) {
				int result = r.nextInt(Parameters.getDataSize());
				if(included[result] == true) {
					included[result] = false;
					totalWeight -= weight[result];
				}
			}
		}

		return totalFitness;
	}



	public Individual copy(){
		Individual individual = new Individual();
		for(int i = 0; i < weight.length; i++){
			individual.weight[i] = weight[i];
		}		
		for(int i = 0; i < values.length; i++){
			individual.values[i] = values[i];
		}		
		for(int i = 0; i < included.length; i++){
			individual.included[i] = included[i];
		}	
		return individual;
	}


}

