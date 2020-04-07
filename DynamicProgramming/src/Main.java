
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;


public class Main {
	
	static int profit= 0;
	static int weightK= 0; 
 
	public void knapsackDP(int[] Weight, int[] Values, int Capacity, int dataSize) {
	 
		int table[][] = new int[dataSize+1][Capacity + 1];
		
		for (int i=0; i<=dataSize; i++)
			for (int j=0; j<=Capacity; j++) {
				table[i][j] = 0;
			}
		
		for (int i = 1; i <= dataSize; i++) {
			for (int j = 0; j <= Capacity; j++) { 
				table[i][j] = table[i - 1][j];
				
				if ((j >= Weight[i-1]) && (table[i][j] < table[i - 1][j - Weight[i - 1]] + Values[i - 1])) {
					table[i][j] = table[i - 1][j - Weight[i - 1]] + Values[i - 1]; 
				}				
			}
		}
	    
	    System.out.println("Profit: " + table[dataSize][Capacity]);
	    profit = table[dataSize][Capacity];
		
		System.out.print("Selected Items: ");
		
		int n = dataSize;
		int M = Capacity;
	    int k = 0;
		
		while (n != 0) {
			if (table[n][M] != table[n - 1][M]) {
				System.out.print(n + ", ");
				k += Weight[n-1];

				
				M = M - Weight[n-1];
			}
			
			n--;
		}
		
		weightK = k;

		System.out.println("\nWeight: " + k);
	}

	/**
	 * @param args the command line arguments
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/////////////////////////////////////////////////////////////////////////////////////////////////

		File file = new File("D:\\", "DynamicProgrammingResults.txt");

		if (!file.isFile() && !file.createNewFile())
		{
			throw new IOException("Error creating new file: " + file.getAbsolutePath());
		}

		BufferedReader reader = new BufferedReader(new FileReader(file));
		int lines = 0;
		while (reader.readLine() != null) lines++;
		reader.close();

		int testCase = 71;
		
//		System.out.println(testCase);
//		System.exit(0);

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
		//break;
		case 72:	Constants.setDataSize(50000); Constants.setKSCapacity(50000); Constants.setName("D:\\test7.in");
		break;
		case 73:	Constants.setDataSize(100000); Constants.setKSCapacity(50000); Constants.setName("D:\\test7.in");
		break;

		case 61:	Constants.setDataSize(50); Constants.setKSCapacity(100000); Constants.setName("D:\\test8.in");
		break; 
		case 62:	Constants.setDataSize(100); Constants.setKSCapacity(100000); Constants.setName("D:\\test8.in");
		break;
		case 63:	Constants.setDataSize(500); Constants.setKSCapacity(100000); Constants.setName("D:\\test8.in");
		break;
		case 64:	Constants.setDataSize(750); Constants.setKSCapacity(100000); Constants.setName("D:\\test8.in");
		break;
		case 65:	Constants.setDataSize(1000); Constants.setKSCapacity(100000); Constants.setName("D:\\test8.in");
		break;
		case 66:	Constants.setDataSize(5000); Constants.setKSCapacity(100000); Constants.setName("D:\\test8.in");
		break;
		case 67:	Constants.setDataSize(10000); Constants.setKSCapacity(100000); Constants.setName("D:\\test8.in");
		break;
		//case 70:	Constants.setDataSize(50000); Constants.setKSCapacity(100000); Constants.setName("D:\\test8.in");
		//break;
		case 71:	Constants.setDataSize(100000); Constants.setKSCapacity(100000); Constants.setName("D:\\test8.in");
		break;
		case 68: System.exit(0);
			

		default:
			break;
		}


		/////////////////////////////////////////////////////////////////////////////////////////////////

		profit = 0;
		weightK = 0;

		int[] weight = new int[Constants.getDataSize()];
		int[] values = new int[Constants.getDataSize()];

		Initialisation init = new Initialisation();
		init.initialise();
		values = init.values;
		weight = init.weight;

		Main test = new Main();  

		long start = System.currentTimeMillis();
		test.knapsackDP(weight, values, Constants.getKSCapacity(), Constants.getDataSize());
		long end = System.currentTimeMillis();
		
		System.out.println("Wall Clock Time: " + (end-start) + " milliseconds.");

		MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();

		long memoryUsed = mbean.getHeapMemoryUsage().getUsed() / 1024;
		
		System.out.println("Memory: " + memoryUsed);


		String[] line = new String[4];
		line[0] = String.valueOf(profit) + ",";
		line[1] = String.valueOf(weightK) + ",";
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
}
