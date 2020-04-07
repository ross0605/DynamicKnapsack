import java.util.Random;


public class Parameters {

	
	private static int capacity = 50;
	
	public static int getKSCapacity() {
		return capacity;
	}

	// Setter
	public static void setKSCapacity(int NKSCapacity) {
		capacity = NKSCapacity;
	}
	
	private static int dataSize = 50;
	
	public static int getDataSize() {
		return dataSize;
	}

	// Setter
	public static void setDataSize(int data) {
		dataSize = data;
	}
	
	
	private static String dataFile = "D:\\test1.in";

	public static String getDataFile() {
		return dataFile;
	}

	// Setter
	public static void setName(String newDataFile) {
		dataFile = newDataFile;
	}
	
	public static Random rnd = new Random(System.currentTimeMillis());
	
	public static int popSize = 350;
	public static int tournamentSize = popSize/12;
	
	public static int mutationRateMax = 25;
	
	
	private static double mutationProbability = 0.001; // This is 0.1% of 1, which really means the probability of mutation is 0.1%.
	
	public static double getMutationProb() {
		return mutationProbability;
	}

	public static void setMutationProb(double mut) {
		mutationProbability = mut;
	}
	
	
	public static double crossoverProbability = 0.85;
	
	public static int crossoverNumber = (int) (popSize*crossoverProbability);
	
	public static int maxIterations = 1000;
	
	public static int getMaxIterations() {
		return maxIterations;
	}

	public static void setMaxIterations(int maxIt) {
		maxIterations = maxIt;
	}

}
