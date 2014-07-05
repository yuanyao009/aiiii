import java.util.Comparator;
/**
 * Define the comparator of AStar's priority queue. 
*/

public class ComparatorAStar implements Comparator {	
	public int compare(Object object1, Object object2) {
		Grid grid1=(Grid)object1;
		Grid grid2=(Grid)object2;
		int f1 = ((Integer) grid1.heuristic + grid1.cost);//f(n)=h(n)+g(n)
        int f2 = ((Integer) grid2.heuristic + grid2.cost);
        return (f1 < f2 ? -1 : ((f1 == f2 && grid1.time<grid2.time) ? 0 : 1));
		
	}
}
