
import java.util.Comparator;
public class ComparatorGreedy implements Comparator{	
	//@Override
	public int compare(Object o1, Object o2) {
		Grid grid1=(Grid)o1;
		Grid grid2=(Grid)o2;
		int j1 = ((Integer) grid1.heuristic );
        int j2 = ((Integer) grid2.heuristic );
        //  return (j1 < j2 ? -1 : (j1 == j2 ? 0 : 1));

        return (j1 < j2 ? -1 : ((j1 == j2 && grid1.time<grid2.time) ? 0 : 1));
		//return (grid1.heuristic< grid2.heuristic ? -1 : ((grid1.heuristic==grid2.heuristic && grid1.time < grid2.time) ? 0 : 1));
	}
}

