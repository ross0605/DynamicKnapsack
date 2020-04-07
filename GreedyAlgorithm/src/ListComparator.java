import java.util.Comparator;

public class ListComparator implements Comparator<Pair<Double, Integer>> {

	public int compare(Pair<Double, Integer> o1, Pair<Double, Integer> o2) {
		// TODO Auto-generated method stub
		if(o1.first < o2.first) {
			return -1;
		}
		if(o1.first > o2.first) {
			return 1;
		}
		return 0;
	}
 
}