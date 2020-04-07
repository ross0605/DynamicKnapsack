import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {	

	public static void main(String[] args) throws IOException {

		int C = 0;
		int lineSkipper = 0;

		while(C != 72) {

			if(C == 0) {
				lineSkipper = 0;
			}
			else {
				lineSkipper += 30;
			}

			DecimalFormat df2 = new DecimalFormat("#.##");

			String[] weight = new String[30];
			String[] weights = new String[30];
			int[] WEIGHTS = new int[30];
			int[] values = new int[30]; 
			int[] time = new int[30]; 
			int[] memory = new int[30]; 

			Scanner s = new Scanner(new File("D:\\geneticTest.txt"));
			s.useDelimiter(",");

			skipLines(s, lineSkipper);


			int counter = 0;

			while(counter != 30)
			{

				weight[counter] =  s.next();
				values[counter] = s.nextInt();
				time[counter] = s.nextInt();
				memory[counter] = s.nextInt();
				counter++;
			}

			int j = 0;
			for(String w: weight) {
				weights[j] = w.replace("\n", "").replace("\r", "");
				j++;
			}

			int k = 0;
			for(String p: weights) {
				WEIGHTS[k] = Integer.parseInt(p);
				k++;
			}

			//		System.out.println("WEIGHTS: " + Arrays.toString(WEIGHTS));
			//		System.out.println("VALUES: " + Arrays.toString(values));
			//		System.out.println("TIME: " + Arrays.toString(time));
			//		System.out.println("MEMORY: " + Arrays.toString(memory));

			System.out.println("Average W: " + average(WEIGHTS, WEIGHTS.length));
			System.out.println("Average V: " + average(values, WEIGHTS.length));
			System.out.println("Average T: " + df2.format(average(time, WEIGHTS.length)));
			System.out.println("Average M: " + df2.format(average(memory, WEIGHTS.length)));

			String[] line = new String[4];
			line[0] = String.valueOf(average(WEIGHTS, WEIGHTS.length)) + ",";
			line[1] = String.valueOf(average(values, WEIGHTS.length)) + ",";
			line[2] = String.valueOf(df2.format(average(time, WEIGHTS.length))) + ",";
			line[3] = String.valueOf(df2.format(average(memory, WEIGHTS.length)));


			try (FileWriter f = new FileWriter("D:\\RESULTSGENETIC.txt", true);
					BufferedWriter b = new BufferedWriter(f);
					PrintWriter p = new PrintWriter(b);) {

				p.print(String.valueOf(line[0]));
				p.print(String.valueOf(line[1]));
				p.print(String.valueOf(line[2]));
				p.print(String.valueOf(line[3]));
				p.println();

			}

			C++;
		}
	}

static double average(int a[], int n) 
{ 

	// Find sum of array element 
	int sum = 0; 

	for (int i = 0; i < n; i++) 
		sum += a[i]; 

	return (double)sum/(double)n;
}

public static void skipLines(Scanner s,int lineNum){
	for(int i = 0; i < lineNum;i++){
		if(s.hasNextLine())s.nextLine();
	}
}



}
