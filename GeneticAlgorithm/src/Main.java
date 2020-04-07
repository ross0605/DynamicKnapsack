import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;



public class Main implements Runnable{

	private ArrayList<Individual> population = new ArrayList<Individual>();
	List<Pair<Double, Integer>> pairs = new ArrayList<>(); // Pairs for sorting indexes

	int gr1 = Parameters.popSize/4;
	int gr2 = Parameters.popSize/2;
	int gr3 = (Parameters.popSize/4) *3;
	int gr4 = Parameters.popSize;

	private int iteration = 0;

	int i = 0;

	int a = 0;
	
	static int finalValue = 0; 
	static int finalWeight = 0;


	public static void main(String[] args) throws IOException {

		/////////////////////////////////////////////////////////////////////////////////////////////////

		File file = new File("D:\\", "GAGreedy.txt");

		if (!file.isFile() && !file.createNewFile())
		{
			throw new IOException("Error creating new file: " + file.getAbsolutePath());
		}

		BufferedReader reader = new BufferedReader(new FileReader(file));
		int lines = 0;
		while (reader.readLine() != null) lines++;
		reader.close();

		int testCase = lines/30;
		if(testCase == 0) {
			testCase = 15;
		}
		else if(testCase == 1) {
			testCase = 34;
		}
		else if(testCase == 2) {
			testCase = 50;
		}
		else {
			System.exit(0);
		}
		

//		System.out.println(testCase);
//		System.exit(0);

		switch(testCase) {
		case 0:	Parameters.setDataSize(50); Parameters.setKSCapacity(50); Parameters.setName("D:\\test1.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 1:	Parameters.setDataSize(100); Parameters.setKSCapacity(50); Parameters.setName("D:\\test1.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 2:	Parameters.setDataSize(500); Parameters.setKSCapacity(50); Parameters.setName("D:\\test1.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 3:	Parameters.setDataSize(750); Parameters.setKSCapacity(50); Parameters.setName("D:\\test1.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 4:	Parameters.setDataSize(1000); Parameters.setKSCapacity(50); Parameters.setName("D:\\test1.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 5:	Parameters.setDataSize(5000); Parameters.setKSCapacity(50); Parameters.setName("D:\\test1.in"); Parameters.setMutationProb(0.0001); Parameters.setMaxIterations(Parameters.getDataSize()*3);
		break;
		case 6:	Parameters.setDataSize(10000); Parameters.setKSCapacity(50); Parameters.setName("D:\\test1.in"); Parameters.setMutationProb(0.0001); Parameters.setMaxIterations(Parameters.getDataSize()*4);
		break;
		case 7:	Parameters.setDataSize(50000); Parameters.setKSCapacity(50); Parameters.setName("D:\\test1.in"); Parameters.setMutationProb(0.00001); Parameters.setMaxIterations(Parameters.getDataSize());
		break;
		case 8:	Parameters.setDataSize(100000); Parameters.setKSCapacity(50); Parameters.setName("D:\\test1.in"); Parameters.setMutationProb(0.00001); Parameters.setMaxIterations(Parameters.getDataSize()/2);
		break;

		case 9:	Parameters.setDataSize(50); Parameters.setKSCapacity(100); Parameters.setName("D:\\test2.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break; 
		case 10:	Parameters.setDataSize(100); Parameters.setKSCapacity(100); Parameters.setName("D:\\test2.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 11:	Parameters.setDataSize(500); Parameters.setKSCapacity(100); Parameters.setName("D:\\test2.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 12:	Parameters.setDataSize(750); Parameters.setKSCapacity(100); Parameters.setName("D:\\test2.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 13:	Parameters.setDataSize(1000); Parameters.setKSCapacity(100); Parameters.setName("D:\\test2.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 14:	Parameters.setDataSize(5000); Parameters.setKSCapacity(100); Parameters.setName("D:\\test2.in"); Parameters.setMutationProb(0.0001); Parameters.setMaxIterations(Parameters.getDataSize()*3);
		break;
		case 15:	Parameters.setDataSize(10000); Parameters.setKSCapacity(100); Parameters.setName("D:\\test2.in"); Parameters.setMutationProb(0.0001); Parameters.setMaxIterations(Parameters.getDataSize()*4);
		break;
		case 16:	Parameters.setDataSize(50000); Parameters.setKSCapacity(100); Parameters.setName("D:\\test2.in"); Parameters.setMutationProb(0.00001); Parameters.setMaxIterations(Parameters.getDataSize());
		break;
		case 17:	Parameters.setDataSize(100000); Parameters.setKSCapacity(100); Parameters.setName("D:\\test2.in"); Parameters.setMutationProb(0.00001); Parameters.setMaxIterations(Parameters.getDataSize()/2);
		break;

		case 18:	Parameters.setDataSize(50); Parameters.setKSCapacity(500); Parameters.setName("D:\\test3.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break; 
		case 19:	Parameters.setDataSize(100); Parameters.setKSCapacity(500); Parameters.setName("D:\\test3.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 20:	Parameters.setDataSize(500); Parameters.setKSCapacity(500); Parameters.setName("D:\\test3.in"); Parameters.setMutationProb(0.001);	Parameters.setMaxIterations(10000);
		break;
		case 21:	Parameters.setDataSize(750); Parameters.setKSCapacity(500); Parameters.setName("D:\\test3.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break; 
		case 22:	Parameters.setDataSize(1000); Parameters.setKSCapacity(500); Parameters.setName("D:\\test3.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 23:	Parameters.setDataSize(5000); Parameters.setKSCapacity(500); Parameters.setName("D:\\test3.in"); Parameters.setMutationProb(0.0001); Parameters.setMaxIterations(Parameters.getDataSize()*3);
		break; 
		case 24:	Parameters.setDataSize(10000); Parameters.setKSCapacity(500); Parameters.setName("D:\\test3.in"); Parameters.setMutationProb(0.0001); Parameters.setMaxIterations(Parameters.getDataSize()*4);
		break; 
		case 25:	Parameters.setDataSize(50000); Parameters.setKSCapacity(500); Parameters.setName("D:\\test3.in"); Parameters.setMutationProb(0.00001); Parameters.setMaxIterations(Parameters.getDataSize());
		break;
		case 26:	Parameters.setDataSize(100000); Parameters.setKSCapacity(500); Parameters.setName("D:\\test3.in"); Parameters.setMutationProb(0.00001); Parameters.setMaxIterations(Parameters.getDataSize()/2);
		break;

		case 27:	Parameters.setDataSize(50); Parameters.setKSCapacity(1000); Parameters.setName("D:\\test4.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break; 
		case 28:	Parameters.setDataSize(100); Parameters.setKSCapacity(1000); Parameters.setName("D:\\test4.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 29:	Parameters.setDataSize(500); Parameters.setKSCapacity(1000); Parameters.setName("D:\\test4.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 30:	Parameters.setDataSize(750); Parameters.setKSCapacity(1000); Parameters.setName("D:\\test4.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 31:	Parameters.setDataSize(1000); Parameters.setKSCapacity(1000); Parameters.setName("D:\\test4.in"); Parameters.setMutationProb(0.0001); Parameters.setMaxIterations(10000);
		break;
		case 32:	Parameters.setDataSize(5000); Parameters.setKSCapacity(1000); Parameters.setName("D:\\test4.in"); Parameters.setMutationProb(0.0001); Parameters.setMaxIterations(Parameters.getDataSize()*3);
		break;
		case 33:	Parameters.setDataSize(10000); Parameters.setKSCapacity(1000); Parameters.setName("D:\\test4.in"); Parameters.setMutationProb(0.00001); Parameters.setMaxIterations(Parameters.getDataSize()*4);
		break;
		case 34:	Parameters.setDataSize(50000); Parameters.setKSCapacity(1000); Parameters.setName("D:\\test4.in"); Parameters.setMutationProb(0.00001); Parameters.setMaxIterations(Parameters.getDataSize());
		break;
		case 35:	Parameters.setDataSize(100000); Parameters.setKSCapacity(1000); Parameters.setName("D:\\test4.in"); Parameters.setMutationProb(0.00001); Parameters.setMaxIterations(Parameters.getDataSize()/2);
		break;

		case 36:	Parameters.setDataSize(50); Parameters.setKSCapacity(5000); Parameters.setName("D:\\test5.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break; 
		case 37:	Parameters.setDataSize(100); Parameters.setKSCapacity(5000); Parameters.setName("D:\\test5.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break; 
		case 38:	Parameters.setDataSize(500); Parameters.setKSCapacity(5000); Parameters.setName("D:\\test5.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 39:	Parameters.setDataSize(750); Parameters.setKSCapacity(5000); Parameters.setName("D:\\test5.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 40:	Parameters.setDataSize(1000); Parameters.setKSCapacity(5000); Parameters.setName("D:\\test5.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 41:	Parameters.setDataSize(5000); Parameters.setKSCapacity(5000); Parameters.setName("D:\\test5.in"); Parameters.setMutationProb(0.0001); Parameters.setMaxIterations(Parameters.getDataSize()*3);
		break;
		case 42:	Parameters.setDataSize(10000); Parameters.setKSCapacity(5000); Parameters.setName("D:\\test5.in"); Parameters.setMutationProb(0.0001); Parameters.setMaxIterations(Parameters.getDataSize()*4);
		break;
		case 43:	Parameters.setDataSize(50000); Parameters.setKSCapacity(5000); Parameters.setName("D:\\test5.in"); Parameters.setMutationProb(0.00001); Parameters.setMaxIterations(Parameters.getDataSize());
		break;
		case 44:	Parameters.setDataSize(100000); Parameters.setKSCapacity(5000); Parameters.setName("D:\\test5.in"); Parameters.setMutationProb(0.00001); Parameters.setMaxIterations(Parameters.getDataSize()/2);
		break;

		case 45:	Parameters.setDataSize(50); Parameters.setKSCapacity(10000); Parameters.setName("D:\\test6.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break; 
		case 46:	Parameters.setDataSize(100); Parameters.setKSCapacity(10000); Parameters.setName("D:\\test6.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 47:	Parameters.setDataSize(500); Parameters.setKSCapacity(10000); Parameters.setName("D:\\test6.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 48:	Parameters.setDataSize(750); Parameters.setKSCapacity(10000); Parameters.setName("D:\\test6.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 49:	Parameters.setDataSize(1000); Parameters.setKSCapacity(10000); Parameters.setName("D:\\test6.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 50:	Parameters.setDataSize(5000); Parameters.setKSCapacity(10000); Parameters.setName("D:\\test6.in"); Parameters.setMutationProb(0.0001); Parameters.setMaxIterations(Parameters.getDataSize()*3);
		break;
		case 51:	Parameters.setDataSize(10000); Parameters.setKSCapacity(10000); Parameters.setName("D:\\test6.in"); Parameters.setMutationProb(0.0001); Parameters.setMaxIterations(Parameters.getDataSize()*4);
		break;
		case 52:	Parameters.setDataSize(50000); Parameters.setKSCapacity(10000); Parameters.setName("D:\\test6.in"); Parameters.setMutationProb(0.00001); Parameters.setMaxIterations(Parameters.getDataSize());
		break;
		case 53:	Parameters.setDataSize(100000); Parameters.setKSCapacity(10000); Parameters.setName("D:\\test6.in"); Parameters.setMutationProb(0.00001); Parameters.setMaxIterations(Parameters.getDataSize()/2);
		break;

		case 54:	Parameters.setDataSize(50); Parameters.setKSCapacity(50000); Parameters.setName("D:\\test7.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break; 
		case 55:	Parameters.setDataSize(100); Parameters.setKSCapacity(50000); Parameters.setName("D:\\test7.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 56:	Parameters.setDataSize(500); Parameters.setKSCapacity(50000); Parameters.setName("D:\\test7.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 57:	Parameters.setDataSize(750); Parameters.setKSCapacity(50000); Parameters.setName("D:\\test7.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 58:	Parameters.setDataSize(1000); Parameters.setKSCapacity(50000); Parameters.setName("D:\\test7.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 59:	Parameters.setDataSize(5000); Parameters.setKSCapacity(50000); Parameters.setName("D:\\test7.in"); Parameters.setMutationProb(0.0001); Parameters.setMaxIterations(Parameters.getDataSize()*3);
		break;  
		case 60:	Parameters.setDataSize(10000); Parameters.setKSCapacity(50000); Parameters.setName("D:\\test7.in"); Parameters.setMutationProb(0.0001); Parameters.setMaxIterations(Parameters.getDataSize()*4);
		break;
		case 61:	Parameters.setDataSize(50000); Parameters.setKSCapacity(50000); Parameters.setName("D:\\test7.in"); Parameters.setMutationProb(0.00001); Parameters.setMaxIterations(Parameters.getDataSize());
		break;
		case 62:	Parameters.setDataSize(100000); Parameters.setKSCapacity(50000); Parameters.setName("D:\\test7.in"); Parameters.setMutationProb(0.00001); Parameters.setMaxIterations(Parameters.getDataSize()/2);
		break;

		case 63:	Parameters.setDataSize(50); Parameters.setKSCapacity(100000); Parameters.setName("D:\\test8.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;  
		case 64:	Parameters.setDataSize(100); Parameters.setKSCapacity(100000); Parameters.setName("D:\\test8.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 65:	Parameters.setDataSize(500); Parameters.setKSCapacity(100000); Parameters.setName("D:\\test8.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 66:	Parameters.setDataSize(750); Parameters.setKSCapacity(100000); Parameters.setName("D:\\test8.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 67:	Parameters.setDataSize(1000); Parameters.setKSCapacity(100000); Parameters.setName("D:\\test8.in"); Parameters.setMutationProb(0.001); Parameters.setMaxIterations(10000);
		break;
		case 68:	Parameters.setDataSize(5000); Parameters.setKSCapacity(100000); Parameters.setName("D:\\test8.in"); Parameters.setMutationProb(0.0001); Parameters.setMaxIterations(Parameters.getDataSize()*3);
		break; 
		case 69:	Parameters.setDataSize(10000); Parameters.setKSCapacity(100000); Parameters.setName("D:\\test8.in"); Parameters.setMutationProb(0.0001); Parameters.setMaxIterations(Parameters.getDataSize()*4);
		break;
		case 70:	Parameters.setDataSize(50000); Parameters.setKSCapacity(100000); Parameters.setName("D:\\test8.in"); Parameters.setMutationProb(0.00001); Parameters.setMaxIterations(Parameters.getDataSize());
		break;
		case 71:	Parameters.setDataSize(100000); Parameters.setKSCapacity(100000); Parameters.setName("D:\\test8.in"); Parameters.setMutationProb(0.00001); Parameters.setMaxIterations(Parameters.getDataSize()/2);
		break;
			

		default:
			break;
		}
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


		Main ga = new Main();
		long start = System.currentTimeMillis();
		ga.run();
		long end = System.currentTimeMillis();

		System.out.println("Wall Clock Time: " + (end-start) + " milliseconds.");

		MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
		System.out.println("Memory: " + mbean.getHeapMemoryUsage());
		
		long memoryUsed = mbean.getHeapMemoryUsage().getUsed() / 1024;
		
		
		
		
		String[] line = new String[4];
		line[0] = String.valueOf(finalValue) + ",";
		line[1] = String.valueOf(finalWeight) + ",";
		line[2] = String.valueOf(end-start) + ",";
		line[3] = String.valueOf(memoryUsed) + ",";


		try (FileWriter f = new FileWriter(file, true);
				BufferedWriter b = new BufferedWriter(f);
				PrintWriter p = new PrintWriter(b);) {

			p.print(String.valueOf(line[0]));
			p.print(String.valueOf(line[1]));
			p.print(String.valueOf(line[2]));
			p.print(String.valueOf(line[3]));
			p.println();

		}
	}

	public void run() {

		try {
			initialisePopulation();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Data Initialised Successfully.");
		
		long start_time = System.currentTimeMillis();
		long wait_time = 600000;
		long end_time = start_time + wait_time;
		boolean timeUp = false;
		
		iteration = 0;
		boolean STOP = false;
		double bestFitnessCounter = 0;

		while(STOP == false && timeUp == false) {
			iteration++;
			
			if(System.currentTimeMillis() > end_time){
				timeUp = true;
			}

			if(iteration%2000 == 0) {
				if(getBest(population).getFitness() == bestFitnessCounter) {
					STOP = true;
				}
				else {
					bestFitnessCounter = getBest(population).getFitness();
				}
			}



			// record two best individuals
			Individual elite1 = getBest(population);
			//Individual elite2 = getSecondBest(population);
			 
			Individual parent11 = groupSelection();
			Individual parent22 = groupSelection();
			
			int id1 = population.indexOf(parent11);
			int id2 = population.indexOf(parent22);
			
			Individual parent1 = parent11.copy();
			Individual parent2 = parent22.copy();
//			
//			i = 0;
//			while(i < Parameters.crossoverNumber){				
//				Individual child = crossover1X(parent1, parent2);
//				child = newMutate(child);
//				replace(child);
//				i++;
//			}
			
			Individual child1 = crossover1X(parent1, parent2);
			Individual child2 = crossover1X(parent2, parent1);
			
			child1 = newMutate(child1);
			child2 = newMutate(child2);
			
			
//			int index1 = population.indexOf(parent1);
//			int index2 = population.indexOf(parent2);
//			
//			System.out.println("index of parent 1: " + index1);
//			System.out.println("index of parent 2: " + index2);
//
//			population.set(index1, child1);
//			population.set(index2, child2);
			
			//replace(child1);
			//replace(child2);
					
			replaceParent(child1, child2, parent1, parent2, id1, id2);
			
			// add in two best individuals again
			replace(elite1);
			//replace(elite2);


			printStats();
		}

		Individual best = getBest(population);
		int totalWeight = 0;
		int totalVal = 0;

		for(int i = 0; i < best.included.length; i++) {
			if(best.included[i] == true) {
				System.out.println(i+1 + " included.");
			}
		}

		for(int i = 0; i < best.included.length; i++) {
			if(best.included[i] == true) {
				totalWeight += best.weight[i];
			}
		}

		for(int i = 0; i < best.included.length; i++) {
			if(best.included[i] == true) {
				totalVal += best.values[i];
			}
		}

		System.out.println("Profit: " + totalVal);
		finalValue = totalVal;
		System.out.println("Weight: " + totalWeight);
		finalWeight = totalWeight;
		System.out.println("");

	}

	// SELECTION PROCESS ///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private Individual tournamentSelection() {
		ArrayList<Individual> candidates = new ArrayList<Individual>();
		for(int i = 0; i < Parameters.tournamentSize; i++) {
			candidates.add(population.get(Parameters.rnd.nextInt(population.size())));
		}
		return getBest(candidates);
	}


	private Individual groupSelection() {

		Individual parent = null;

		pairs.clear();
		sortInd();

		int low = 0;
		int high = 0;

		double rand = Math.random();

		Random r = new Random();

		if(rand*100 <= 50) {
			low = 0;
			high = gr1;
		}
		else if(rand*100 < 80) {
			low = gr1;
			high = gr2;		
		}
		else if(rand*100 < 95) {
			low = gr2;
			high = gr3;			
		}
		else if(rand*100 <= 100){
			low = gr3;
			high = gr4;	
		}

		int result = r.nextInt(high-low) + low;

		Pair<Double, Integer> parent1 = pairs.get(result);
		int J = parent1.getValue();

		parent = population.get(J);

		return parent;

	}
	
	private Individual randomSelect() {		
		Individual parent = population.get(Parameters.rnd.nextInt(Parameters.popSize));
		return parent.copy();
	}



	// CROSSOVER ///////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	private Individual crossover1X(Individual parent1, Individual parent2) {
		if(Parameters.rnd.nextDouble() > Parameters.crossoverProbability){
			return parent1;
		}
		Individual child = new Individual();

		int crossoverPoint = Parameters.rnd.nextInt(parent1.included.length);
		//System.out.println("Crossover point: " + crossoverPoint);

		for(int i = 0; i < parent1.included.length; i++){
			child.weight[i] = parent1.weight[i];
			child.values[i] = parent1.values[i];
		}

		for(int i = 0; i < crossoverPoint; i++){
			child.included[i] = parent1.included[i];
		}
		for(int i = crossoverPoint; i < parent2.included.length; i++){
			child.included[i] = parent2.included[i];
		}
		return child;
	}

	
	private Individual crossover2X(Individual parent1, Individual parent2) {
		if(Parameters.rnd.nextDouble() > Parameters.crossoverProbability){
			return parent1;
		}
		
		Individual child = new Individual();

		int crossoverPoint = Parameters.rnd.nextInt(parent1.included.length);
		int crossoverPoint2 = Parameters.rnd.nextInt(parent1.included.length);

//		for(int i = 0; i < parent1.included.length; i++){
//			child.weight[i] = parent1.weight[i];
//			child.values[i] = parent1.values[i];
//		}

		for(int i = 0; i < crossoverPoint; i++){
			child.included[i] = parent1.included[i];
		}
		for(int i = crossoverPoint; i < crossoverPoint2; i++){
			child.included[i] = parent2.included[i];
		}
		for(int i = crossoverPoint2; i < parent2.included.length; i++){
			child.included[i] = parent1.included[i];
		}
		
		return child;
	}

	

	private Individual uniformCrossover(Individual parent1, Individual parent2) {
		if(Parameters.rnd.nextDouble() > Parameters.crossoverProbability){
			return parent1;
		}
		Individual child = new Individual();

		for(int i = 0; i < parent1.included.length; i++){
			child.weight[i] = parent1.weight[i];
			child.values[i] = parent1.values[i];
		}

		for(int i = 0; i < parent1.included.length; i++){
			if(Math.random() < 0.5) { 
				child.included[i] = parent1.included[i];
			}
			else {
				child.included[i] = parent2.included[i];
			}
		}
		return child;
	}


	// MUTATION ////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////


	private Individual newMutate2(Individual child) {

		Random r = new Random();

		int i = Parameters.mutationRateMax;
		int j = 0;
		int k = 0;

		while(j != i) {

			k = r.nextInt(child.included.length - 0) + 0;

			child.included[k] = !child.included[k];
			j++;
		}

		child.getFitness();

		return child;
	}




	private Individual newMutate(Individual child) {

		int i = 0;
		while(i != Parameters.getDataSize()) {
			if(Math.random() <= Parameters.getMutationProb()) {
				child.included[i] = !child.included[i];
			}
			i++;
		}

		child.getFitness();

		return child;
	}


	// MISC ////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	private Individual getBest(ArrayList<Individual> aPopulation) {
		double bestFitness = Double.MAX_VALUE;
		Individual best = null;
		for(Individual individual : aPopulation){
			if(individual.getFitness() > bestFitness || best == null){
				best = individual;
				bestFitness = best.getFitness();
			}
		}
		return best;
	}

	private Individual getSecondBest(ArrayList<Individual> aPopulation) {
		double bestFitness = Double.MAX_VALUE;
		double bestIndividualFitness = getBest(population).getFitness();
		Individual best = null;
		for(Individual individual : aPopulation){
			if((individual.getFitness() > bestFitness || best == null) && individual.getFitness() < bestIndividualFitness){
				best = individual;
				bestFitness = best.getFitness();
			}
		}
		return best;
	}


	private void replace(Individual child) {

		Individual worst = getWorst(population);

		if(child.getFitness() > worst.getFitness()){
			int idx = population.indexOf(worst);
			population.set(idx, child);
		}
	}
	
	
	private void replaceParent(Individual child1, Individual child2, Individual parent1, Individual parent2, int id1, int id2) {
		
		//System.out.println("index of parent 1: " + index1);
		//System.out.println("index of parent 2: " + index2);

		if(child1.getFitness() > parent1.getFitness()) {
			population.set(id1, child1);
		}
		if(child2.getFitness() > parent2.getFitness()) {
			population.set(id2, child2);
		}
		
	}

	private Individual getWorst(ArrayList<Individual> aPopulation) {
		double worstFitness = 100000;
		Individual worst = null;
		for(Individual individual : population){
			if(individual.getFitness() < worstFitness || worst == null){
				worst = individual;
				worstFitness = worst.getFitness();
			}
		}
		//System.out.println(worst.getFitness());
		return worst;
	}

	private Individual getWorstLast(ArrayList<Individual> aPopulation) {
		double worstFitness = 100000;
		Individual worst = null;
		//System.out.println("--------------------------------------------------------------------------------------");
		printPopulation();
		for(Individual individual : population){
			System.out.println("is " + individual.getFitness() + " fitness < worst " + worstFitness);
			if(worst == null){
				worst = individual;
				worstFitness = worst.getFitness();
				System.out.println("and now worstFitness - " + worstFitness + " is equal to " + worst.getFitness());
			}
			else if(individual.getFitness() < worstFitness) {
				System.out.println("then set worst - " + worst.getFitness() + " - to " + individual.getFitness());
				worst = individual;
				worstFitness = worst.getFitness();
				System.out.println("and now worstFitness - " + worstFitness + " is equal to " + worst.getFitness());
			}
		}

		System.out.println("now returning the worst - " + worst.getFitness());
		//System.out.println(worst.getFitness());
		return worst;
	}


	private void printPopulation() {
		for(Individual a : population){
			System.out.println(a.getFitness());
		}
	}


	private void printStats() {		
		System.out.println("" + iteration + "\t" + getBest(population).getFitness() + "\t" + getWorst(population).getFitness());		
	}


	private void sortInd() {

		int i = 0;

		for(Individual a : population) {
			Pair<Double, Integer> p1 = Pair.of(a.getFitness(), i);
			pairs.add(p1);
			i++;
		}



		Collections.sort(pairs, new ListComparator());
	}

	public boolean testEqual(ArrayList<Individual> aPopulation) {

		double lastFit = aPopulation.get(0).getFitness();

		for(Individual individual : aPopulation){	    	
			if(individual.getFitness() != lastFit){
				return false;
			}
		}

		return true;
	}


	// INITIALISE POPULATION ///////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////

	private void initialisePopulation() throws FileNotFoundException {

		if(!population.isEmpty()) {
			population.clear();
		}

		while(population.size() < Parameters.popSize){
			Individual individual = new Individual();
			individual.initialise();
			individual.getFitness();
			population.add(individual);

		}		
	}	
}
