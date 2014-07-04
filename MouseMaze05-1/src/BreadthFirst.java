import java.util.LinkedList;
import java.util.Queue;
/**
 * Implement BreathFirst method. 
*/

public class BreadthFirst extends Method {
    Queue<Grid> queue;
    final int maxTime;
    Grid start;
    public BreadthFirst(Grid start,int maxTime) {
        queue = new LinkedList<Grid>();
        queue.add(start);
        this.start=start;
        this.maxTime=maxTime;
    }
    @Override
    public Result perform() {
    	Result res = new Result();
    	res.method = "BreadthFirst";
        long start_time = System.currentTimeMillis();
        System.out.println("Starting the BFS");
        Grid temp = queue.remove();
        temp.lastGrid= null;
        possibleMoves(temp);
        while (queue.size() != 0) {
        	long timePass=System.currentTimeMillis()-start_time;
        	if(timePass>=maxTime){
        		break;
        	}
            //System.out.println("size : " + queue.size());
            if (success(temp.grid)) {
                    res.steps=temp.ShowProcess();//show the process
                    //System.out.println("last state");
                    //temp.show();
                //System.out.println("gameover");
                //System.out.println("Nodes Explored :" + this.gridPassed.size());
                long total_time = System.currentTimeMillis() - start_time;
                //System.out.println("Time Spent :" + total_time + " ms"); 
                //System.out.println("Start position is  :" + start.start_x+", "+start.start_y); 
                //System.out.println("Goal's position is  :" + start.goal_x+", "+start.goal_y); 
                res.success = true;
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
                temp.ShowProcess();
            //System.out.println("--Solution FOUND");
        } else {
            //System.out.println("--Solution NOT FOUND");
        }
        return res;
    }
    @Override
    public void addtoQueue(Grid board) {
        //this.explored_nodes++;
        this.queue.add(board);
        //board.show();
    }
}