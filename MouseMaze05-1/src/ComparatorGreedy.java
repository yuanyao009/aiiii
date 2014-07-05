
import java.util.Comparator;
/**
 * Define the comparator of Greedy's priority queue. 
*/
public class ComparatorGreedy implements Comparator{	
	public int compare(Object object1, Object object2) {
		Grid grid1=(Grid)object1;
		Grid grid2=(Grid)object2;
		int h1 = ((Integer) grid1.heuristic );//heuristic function
        int h2 = ((Integer) grid2.heuristic );
        return (h1 < h2 ? -1 : ((h1 == h2 && grid1.time<grid2.time) ? 0 : 1));

	}
}

