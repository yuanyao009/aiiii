
/**
 * A* method. 
*/
import java.util.*;

public class AStar extends Method {
    PriorityQueue<Grid> queue;
    double heuristic;
    
    public AStar(Grid start,int heuristic) { 	
        this.heuristic = heuristic;
        Comparator <Grid> comparator = new ComparatorAStar();
        queue = new PriorityQueue<Grid>(1, comparator);
        queue.add(start);
    }
    public void perform() {
        System.out.println("Astar method");
        long start_time = System.currentTimeMillis();
        Grid temp = queue.remove();
        Grid start_map=temp;
        temp.lastGrid = null;
        possibleMoves(temp);
        while (queue.size() != 0) {
            System.out.println("size : " + queue.size());
            if (success(temp.grid)) {
                    temp.ShowProcess();
                    start_map.show();
                    temp.show();
                System.out.println("Game Over --Solution FOUND");
                System.out.println("Nodes Explored :" + this.gridPassed.size());
                //System.out.println("Nodes Explored- :" + this.explored_nodes);
                long total_time = System.currentTimeMillis() - start_time;
                System.out.println("Time Spent :" + total_time + " ms");
                System.out.println("The start point:"+Grid.start_x+" "+Grid.start_y);
                System.out.println("The goal point:"+Grid.goal_x+" "+Grid.goal_y);
                return;
            }
            temp = queue.remove();
            possibleMoves(temp);
        }
        //System.out.println("EMPTY QUEUE");
        long total_time = System.currentTimeMillis() - start_time;
        System.out.println("Time Spent :" + total_time + " ms");
        System.out.println("Nodes Explored :" + this.gridPassed.size());
        //System.out.println("Nodes Explored- :" + this.explored_nodes);
        if (success(temp.grid)) {
                temp.ShowProcess();
            System.out.println("Game Over --Solution FOUND");
        } else {
            System.out.println("Game Over --Solution NOT found");
        }
    }
    public void addtoQueue(Grid grid) {
         //BlockingTilesHeuristic BlockingTilesHeuristic = new BlockingTilesHeuristic();
    	BlockingTilesHeuristic BlockingTilesHeuristic = new BlockingTilesHeuristic();
    	grid.heuristic = BlockingTilesHeuristic.score(grid.grid);
    	grid.cost = grid.lastGrid.cost + grid.heuristic;
    	this.queue.add(grid);
    }
}