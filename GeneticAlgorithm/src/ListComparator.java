import java.util.Comparator;

public class ListComparator implements Comparator<Pair<Double, Integer>> {

	public int compare(Pair<Double, Integer> o1, Pair<Double, Integer> o2) {
		// TODO Auto-generated method stub
		return (int) (o2.first - o1.first);
	}
 
}