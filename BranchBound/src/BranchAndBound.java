
import java.util.*;
import java.io.*;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

/**
 * Best First Branch and Bound Algorithm for the 0/1 Knapsack problem.
 * This algorithm uses Lagrangian relaxation to prune the Branch and Bound tree.
 * @author  Shalin Shah
 * Email: shalin@alumni.usc.edu
 */
public class BranchAndBound
{    
	public static void main(String [] args) throws IOException
	{   

		/////////////////////////////////////////////////////////////////////////////////////////////////

		File file = new File("D:\\", "BranchTest25.txt");

		if (!file.isFile() && !file.createNewFile())
		{
			throw new IOException("Error creating new file: " + file.getAbsolutePath());
		}

		BufferedReader reader = new BufferedReader(new FileReader(file));
		int lines = 0;
		while (reader.readLine() != null) lines++;
		reader.close();

		int testCase = lines/30;
		testCase = 2;


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
		//case 71:	Constants.setDataSize(100000); Constants.setKSCapacity(100000); Constants.setName("D:\\test8.in");
		//break;
		case 68: System.exit(0);
			

		default:
			break;
		}

		//////////////////////////////////////////////////////////////////////////////////////////////////




		long start = System.currentTimeMillis();
		LagrangianRelaxation.calculateLambda();
		KNode incumbent = new KNode(Util.createEmptyKnapsack(), 0, 0, 0);
		incumbent = runBranchAndBound(incumbent);
		long end = System.currentTimeMillis();
		
		int profit = incumbent.value();
		int weightK = incumbent.weight();

		System.out.println("Profit: " + profit);
		System.out.println("Selected Items: " + incumbent.getKnapsackContents());
		System.out.println("Weight: " + weightK);

		System.out.println("Wall clock time: " + (end-start) + " milliseconds.");
		MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
		System.out.println("Memory: " + mbean.getHeapMemoryUsage());
		
		
		String[] line = new String[4];
		line[0] = String.valueOf(profit) + ", ";
		line[1] = String.valueOf(weightK) + ", ";
		line[2] = String.valueOf(end-start) + ", ";
		line[3] = String.valueOf(mbean.getHeapMemoryUsage());


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

	public static KNode runBranchAndBound(KNode in)
	{
		KNode incumbent = new KNode((BitSet)in.getKnapsackContents().clone(), 0, in.weight(), in.value());
		TreeSet heap = new TreeSet();
		KNode node1 = new KNode(new BitSet(Constants.getDataSize()), 0, 0, 0);
		KNode node2 = new KNode(new BitSet(Constants.getDataSize()), 0, 0, 0);
		node1.addOne();
		node2.addZero();

		if(node1.maxValue() > incumbent.value())
			heap.add(node1);

		if(node2.maxValue() > incumbent.value())
			heap.add(node2);

		boolean heapEmpty = false;

		while(!heap.isEmpty())
		{   
			KNode node = (KNode)heap.first();
			heap.remove(node);

			while(node.getIndex() == Constants.getDataSize())
			{
				node.fathom();
				if(node.value() > incumbent.value() && Util.isValidSolution(node))
				{
					incumbent = node;
				}

				if(!heap.isEmpty())
				{
					node = (KNode)heap.first();
					heap.remove(node);
				}
				else
				{
					heapEmpty = true;
					break;
				}
			}

			if(heapEmpty)
			{
				break;
			}

			/* Expand the node */
			KNode node3 = new KNode((BitSet)node.getKnapsackContents().clone(), node.getIndex(), node.weight(), node.value());
			KNode node4 = new KNode((BitSet)node.getKnapsackContents().clone(), node.getIndex(), node.weight(), node.value());
			node3.addOne();
			node4.addZero();

			if(node3.maxValue() > incumbent.value() && Util.isValidSolution(node3))
				heap.add(node3);

			if(node4.maxValue() > incumbent.value() && Util.isValidSolution(node4))
				heap.add(node4);
		}

		return incumbent;
	}
}