import java.io.BufferedReader; 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.util.*;


public class Greedy
{    
	public static void main(String [] args) throws Exception
	{

		/////////////////////////////////////////////////////////////////////////////////////////////////

		File file = new File("D:\\GreedyAlgorithmTestData\\", "greedyVALUE.txt");

		if (!file.isFile() && !file.createNewFile())
		{
			throw new IOException("Error creating new file: " + file.getAbsolutePath());
		}

		BufferedReader reader = new BufferedReader(new FileReader(file));
		int lines = 0;
		while (reader.readLine() != null) lines++;
		reader.close();

		int testCase = lines/30;
		testCase = 50;


		switch(testCase) {
		case 0:	Constants.setDataSize(50); Constants.setKSCapacity(50); Constants.setName("D:\\test1.in"); 
		break;
		case 1:	Constants.setDataSize(100); Constants.setKSCapacity(50); Constants.setName("D:\\test1.in"); 
		break;
		case 2:	Constants.setDataSize(500); Constants.setKSCapacity(50); Constants.setName("D:\\test1.in"); 
		break;
		case 3:	Constants.setDataSize(750); Constants.setKSCapacity(50); Constants.setName("D:\\test1.in");  
		break;
		case 4:	Constants.setDataSize(1000); Constants.setKSCapacity(50); Constants.setName("D:\\test1.in");  
		break;
		case 5:	Constants.setDataSize(5000); Constants.setKSCapacity(50); Constants.setName("D:\\test1.in");  
		break;
		case 6:	Constants.setDataSize(10000); Constants.setKSCapacity(50); Constants.setName("D:\\test1.in"); 
		break;
		case 7:	Constants.setDataSize(50000); Constants.setKSCapacity(50); Constants.setName("D:\\test1.in"); 
		break;
		case 8:	Constants.setDataSize(100000); Constants.setKSCapacity(50); Constants.setName("D:\\test1.in"); 
		break;

		case 9:	Constants.setDataSize(50); Constants.setKSCapacity(100); Constants.setName("D:\\test2.in"); 
		break; 
		case 10:	Constants.setDataSize(100); Constants.setKSCapacity(100); Constants.setName("D:\\test2.in");  
		break;
		case 11:	Constants.setDataSize(500); Constants.setKSCapacity(100); Constants.setName("D:\\test2.in"); 
		break;
		case 12:	Constants.setDataSize(750); Constants.setKSCapacity(100); Constants.setName("D:\\test2.in"); 
		break;
		case 13:	Constants.setDataSize(1000); Constants.setKSCapacity(100); Constants.setName("D:\\test2.in");  
		break;
		case 14:	Constants.setDataSize(5000); Constants.setKSCapacity(100); Constants.setName("D:\\test2.in");  
		break;
		case 15:	Constants.setDataSize(10000); Constants.setKSCapacity(100); Constants.setName("D:\\test2.in"); 
		break;
		case 16:	Constants.setDataSize(50000); Constants.setKSCapacity(100); Constants.setName("D:\\test2.in");  
		break;
		case 17:	Constants.setDataSize(100000); Constants.setKSCapacity(100); Constants.setName("D:\\test2.in");  
		break;

		case 18:	Constants.setDataSize(50); Constants.setKSCapacity(500); Constants.setName("D:\\test3.in"); 
		break; 
		case 19:	Constants.setDataSize(100); Constants.setKSCapacity(500); Constants.setName("D:\\test3.in");  
		break;
		case 20:	Constants.setDataSize(500); Constants.setKSCapacity(500); Constants.setName("D:\\test3.in"); 
		break;
		case 21:	Constants.setDataSize(750); Constants.setKSCapacity(500); Constants.setName("D:\\test3.in");  
		break; 
		case 22:	Constants.setDataSize(1000); Constants.setKSCapacity(500); Constants.setName("D:\\test3.in"); 
		break;
		case 23:	Constants.setDataSize(5000); Constants.setKSCapacity(500); Constants.setName("D:\\test3.in");  
		break; 
		case 24:	Constants.setDataSize(10000); Constants.setKSCapacity(500); Constants.setName("D:\\test3.in"); 
		break; 
		case 25:	Constants.setDataSize(50000); Constants.setKSCapacity(500); Constants.setName("D:\\test3.in"); 
		break;
		case 26:	Constants.setDataSize(100000); Constants.setKSCapacity(500); Constants.setName("D:\\test3.in"); 
		break;

		case 27:	Constants.setDataSize(50); Constants.setKSCapacity(1000); Constants.setName("D:\\test4.in"); 
		break; 
		case 28:	Constants.setDataSize(100); Constants.setKSCapacity(1000); Constants.setName("D:\\test4.in");  
		break;
		case 29:	Constants.setDataSize(500); Constants.setKSCapacity(1000); Constants.setName("D:\\test4.in"); 
		break;
		case 30:	Constants.setDataSize(750); Constants.setKSCapacity(1000); Constants.setName("D:\\test4.in"); 
		break;
		case 31:	Constants.setDataSize(1000); Constants.setKSCapacity(1000); Constants.setName("D:\\test4.in"); 
		break;
		case 32:	Constants.setDataSize(5000); Constants.setKSCapacity(1000); Constants.setName("D:\\test4.in");  
		break;
		case 33:	Constants.setDataSize(10000); Constants.setKSCapacity(1000); Constants.setName("D:\\test4.in"); 
		break;
		case 34:	Constants.setDataSize(50000); Constants.setKSCapacity(1000); Constants.setName("D:\\test4.in");  
		break;
		case 35:	Constants.setDataSize(100000); Constants.setKSCapacity(1000); Constants.setName("D:\\test4.in"); 
		break;

		case 36:	Constants.setDataSize(50); Constants.setKSCapacity(5000); Constants.setName("D:\\test5.in"); 
		break; 
		case 37:	Constants.setDataSize(100); Constants.setKSCapacity(5000); Constants.setName("D:\\test5.in"); 
		break; 
		case 38:	Constants.setDataSize(500); Constants.setKSCapacity(5000); Constants.setName("D:\\test5.in"); 
		break;
		case 39:	Constants.setDataSize(750); Constants.setKSCapacity(5000); Constants.setName("D:\\test5.in");  
		break;
		case 40:	Constants.setDataSize(1000); Constants.setKSCapacity(5000); Constants.setName("D:\\test5.in");  
		break;
		case 41:	Constants.setDataSize(5000); Constants.setKSCapacity(5000); Constants.setName("D:\\test5.in");  
		break;
		case 42:	Constants.setDataSize(10000); Constants.setKSCapacity(5000); Constants.setName("D:\\test5.in");  
		break;
		case 43:	Constants.setDataSize(50000); Constants.setKSCapacity(5000); Constants.setName("D:\\test5.in");  
		break;
		case 44:	Constants.setDataSize(100000); Constants.setKSCapacity(5000); Constants.setName("D:\\test5.in");  
		break;

		case 45:	Constants.setDataSize(50); Constants.setKSCapacity(10000); Constants.setName("D:\\test6.in"); 
		break; 
		case 46:	Constants.setDataSize(100); Constants.setKSCapacity(10000); Constants.setName("D:\\test6.in");  
		break;
		case 47:	Constants.setDataSize(500); Constants.setKSCapacity(10000); Constants.setName("D:\\test6.in");  
		break;
		case 48:	Constants.setDataSize(750); Constants.setKSCapacity(10000); Constants.setName("D:\\test6.in");  
		break;
		case 49:	Constants.setDataSize(1000); Constants.setKSCapacity(10000); Constants.setName("D:\\test6.in");  
		break;
		case 50:	Constants.setDataSize(5000); Constants.setKSCapacity(10000); Constants.setName("D:\\test6.in"); 
		break;
		case 51:	Constants.setDataSize(10000); Constants.setKSCapacity(10000); Constants.setName("D:\\test6.in"); 
		break;
		case 52:	Constants.setDataSize(50000); Constants.setKSCapacity(10000); Constants.setName("D:\\test6.in"); 
		break;
		case 53:	Constants.setDataSize(100000); Constants.setKSCapacity(10000); Constants.setName("D:\\test6.in"); 
		break;

		case 54:	Constants.setDataSize(50); Constants.setKSCapacity(50000); Constants.setName("D:\\test7.in");  
		break; 
		case 55:	Constants.setDataSize(100); Constants.setKSCapacity(50000); Constants.setName("D:\\test7.in");  
		break;
		case 56:	Constants.setDataSize(500); Constants.setKSCapacity(50000); Constants.setName("D:\\test7.in");  
		break;
		case 57:	Constants.setDataSize(750); Constants.setKSCapacity(50000); Constants.setName("D:\\test7.in"); 
		break;
		case 58:	Constants.setDataSize(1000); Constants.setKSCapacity(50000); Constants.setName("D:\\test7.in");  
		break;
		case 59:	Constants.setDataSize(5000); Constants.setKSCapacity(50000); Constants.setName("D:\\test7.in");  
		break;  
		case 60:	Constants.setDataSize(10000); Constants.setKSCapacity(50000); Constants.setName("D:\\test7.in"); 
		break;
		case 61:	Constants.setDataSize(50000); Constants.setKSCapacity(50000); Constants.setName("D:\\test7.in");  
		break;
		case 62:	Constants.setDataSize(100000); Constants.setKSCapacity(50000); Constants.setName("D:\\test7.in");  
		break;

		case 63:	Constants.setDataSize(50); Constants.setKSCapacity(100000); Constants.setName("D:\\test8.in");  
		break;  
		case 64:	Constants.setDataSize(100); Constants.setKSCapacity(100000); Constants.setName("D:\\test8.in"); 
		break;
		case 65:	Constants.setDataSize(500); Constants.setKSCapacity(100000); Constants.setName("D:\\test8.in"); 
		break;
		case 66:	Constants.setDataSize(750); Constants.setKSCapacity(100000); Constants.setName("D:\\test8.in");  
		break;
		case 67:	Constants.setDataSize(1000); Constants.setKSCapacity(100000); Constants.setName("D:\\test8.in");  
		break;
		case 68:	Constants.setDataSize(5000); Constants.setKSCapacity(100000); Constants.setName("D:\\test8.in"); 
		break; 
		case 69:	Constants.setDataSize(10000); Constants.setKSCapacity(100000); Constants.setName("D:\\test8.in"); 
		break;
		case 70:	Constants.setDataSize(50000); Constants.setKSCapacity(100000); Constants.setName("D:\\test8.in");  
		break;
		case 71:	Constants.setDataSize(100000); Constants.setKSCapacity(100000); Constants.setName("D:\\test8.in"); 
		break;


		default:
			break;
		}

		long start = System.currentTimeMillis();
		DataProcessor.processData();
		int results[] = runGreedyAlgorithm();
		System.out.println("Profit: " + results[0]);
		System.out.println("Weight: "  + results[1]);
		long end = System.currentTimeMillis();
		System.out.println("Wall clock time: " + (end-start) + " milliseconds.");

		MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
		System.out.println("Memory: " + mbean.getHeapMemoryUsage());
		long memoryUsed = mbean.getHeapMemoryUsage().getUsed()/1024;
		
		
		String[] line = new String[4];
		line[0] = String.valueOf(results[0]) + ",";
		line[1] = String.valueOf(results[1]) + ",";
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


	/** Run the greedy algorithm for the 0/1 knapsack problem 
	 * @return 
	 * @return */
	public static int[] runGreedyAlgorithm()
	{
		List<Pair<Double, Integer>> pairs = new ArrayList<>(); // Pairs for sorting indexes

//		// FOR VALUE TO WEIGHT
//		for(int i=0; i < Constants.getDataSize(); i++)
//		{	
//			int idx = i;
//			double ratio = Constants.RATIO[i];
//			Pair<Double, Integer> p1 = Pair.of(ratio, idx);
//			pairs.add(p1);
//		}
		
		// FOR WEIGHT ASCENDING // MUST SWAP 1 and -1 IN LIST COMPAROTOR TO MAKE ASCENDING
		for(int i=0; i < Constants.getDataSize(); i++)
		{	
			int idx = i;
			//double ratio = Constants.RATIO[i];
			double weight = Constants.WEIGHTS[i];
			Pair<Double, Integer> p1 = Pair.of(weight, idx);
			pairs.add(p1);
		}
//		
//		// FOR VALUE DESCENDING
//				for(int i=0; i < Constants.getDataSize(); i++)
//				{	
//					int idx = i;
//					//double ratio = Constants.RATIO[i];
//					double value = Constants.VALUES[i];
//					Pair<Double, Integer> p1 = Pair.of(value, idx);
//					pairs.add(p1);
//				}

		Collections.sort(pairs, new ListComparator());
		
		ArrayList<Integer> knapsack = new ArrayList();

		int i = 0;

		int sum = 0;

		while(i < pairs.size())
		{
			// sum of weights
			sum = 0;

			// for each index in knapsack, add the weight to sum
			for(int j = 0; j < knapsack.size(); j++)
			{
				sum += Constants.WEIGHTS[knapsack.get(j)];
			}

			// if sum + weight of next item <= capacity, add item
			if(sum + Constants.WEIGHTS[pairs.get(i).second] <= Constants.getKSCapacity()) {
				knapsack.add(pairs.get(i).second);
			}

			// if weight is equal to knapsack capacity, then stop.
			if(sum == Constants.getKSCapacity()) {
				break;
			}

			i++;
			
		}

		int[] values = {0, 0};
		
		int sumV = 0;
		for(int j = 0; j < knapsack.size(); j++)
		{
			sumV += Constants.VALUES[knapsack.get(j)];
		}
		
		int sumW = 0;
		for(int j = 0; j < knapsack.size(); j++)
		{
			sumW += Constants.WEIGHTS[knapsack.get(j)];
		}

		values[0] = sumV;
		values[1] = sumW;

		return values;

	}
}