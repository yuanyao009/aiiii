import java.util.*;

/**
 *Implement A* method. 
*/
public class AStar extends Method {
    PriorityQueue<Grid> queue;
    double heuristic;
    final int maxTime;
    Grid start;
    
    public AStar(Grid start,int heuristic,int maxTime) { 	
        this.heuristic = heuristic;
        Comparator <Grid> comparator = new ComparatorAStar();
        queue = new PriorityQueue<Grid>(1, comparator);
        queue.add(start);
        this.start=start;
        this.maxTime=maxTime;
    }
    public Result perform() {
    	Result res=new Result();
    	res.method="AStar";
        System.out.println("Starting the AStar ");
        long start_time = System.currentTimeMillis();
        Grid temp = queue.remove();
        Grid start_map=temp;
        temp.lastGrid = null;
        possibleMoves(temp);
        while (queue.size() != 0) {
        	long timePass=System.currentTimeMillis()-start_time;
        	if(timePass>=maxTime){
        		break;
        	}
            //System.out.println("size : " + queue.size());
            if (success(temp.grid)) {
            	res.steps=temp.ShowProcess();
                    //temp.ShowProcess();
                    //start_map.show();
                    //temp.show();
                //System.out.println("Game Over --Solution FOUND");
                //System.out.println("Nodes Explored :" + this.gridPassed.size());
                //System.out.println("Nodes Explored- :" + this.explored_nodes);
                long total_time = System.currentTimeMillis() - start_time;
                //System.out.println("Time Spent :" + total_time + " ms");
                //System.out.println("The start point:"+Grid.start_x+" "+Grid.start_y);
                //System.out.println("The goal point:"+Grid.goal_x+" "+Grid.goal_y);
                res.success=true;
                res.nodes = this.gridPassed.size();
                res.time = total_time;
                return res;
            }
            temp = queue.remove();
            possibleMoves(temp);
        }
        //System.out.println("EMPTY QUEUE");
        long total_time = System.currentTimeMillis() - start_time;
        //System.out.println("Time Spent :" + total_time + " ms");
        //System.out.println("Nodes Explored :" + this.gridPassed.size());
        //System.out.println("Nodes Explored- :" + this.explored_nodes);
        if (success(temp.grid)) {
                //temp.ShowProcess();
            //System.out.println("Game Over --Solution FOUND");
        } else {
            //System.out.println("Game Over --Solution NOT found");
        }
        return res;
    }
    public void addtoQueue(Grid grid) {
         //BlockingTilesHeuristic BlockingTilesHeuristic = new BlockingTilesHeuristic();
    	Distance BlockingTilesHeuristic = new Distance();
    	grid.heuristic = BlockingTilesHeuristic.score(grid.grid);
    	grid.cost = grid.lastGrid.cost + grid.heuristic;
    	this.queue.add(grid);
    }
}