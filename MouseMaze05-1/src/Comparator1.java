import java.util.Comparator;


public class Comparator1 implements Comparator {	
	@Override
	public int compare(Object o1, Object o2) {
		Grid grid1=(Grid)o1;
		Grid grid2=(Grid)o2;
		return (grid1.heuristic< grid2.heuristic ? -1 : ((grid1.heuristic==grid2.heuristic && grid1.time < grid2.time) ? 0 : 1));
	}
}
