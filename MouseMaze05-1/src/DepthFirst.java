
import java.util.Stack;
/**
 *Implement depthFirst search method. 
*/

public class DepthFirst extends Method {

    Stack<Grid> stack;
    final int maxTime;
    Grid start;
    
    public DepthFirst(Grid start,int maxTime) {
        stack = new Stack<>();
        stack.add(start);
        this.start=start;
        this.maxTime=maxTime;
    }
    @Override
    public Result perform() {
    	Result res = new Result();
    	res.method = "DepthFirst";
        System.out.println("Starting the DFS");
        long start_time = System.currentTimeMillis();

        Grid temp = stack.pop();
        Grid startMap=temp;
        temp.lastGrid = null;
        possibleMoves(temp);//add to stack
        while (stack.size() != 0) {
        	long timePass=System.currentTimeMillis()-start_time;
        	if(timePass>=maxTime){
        		break;
        	}
            //System.out.println("size : " + stack.size());
            if (success(temp.grid)) {
            	res.steps=temp.ShowProcess();
                    //temp.show();;
                //System.out.println("gameover");
                //System.out.println("Nodes Explored :" + this.gridPassed.size());
                //System.out.println("Nodes Explored- :" + this.explored_nodes);

                long total_time = System.currentTimeMillis() - start_time;
                //System.out.println("Time Spent :" + total_time + " ms");
                //System.out.println("The start point:"+Grid.start_x+" "+Grid.start_y);
                //System.out.println("The goal point:"+Grid.goal_x+" "+Grid.goal_y);
                res.success = true;
                res.nodes = this.gridPassed.size();
                res.time = total_time;
                return res;
            }
            temp = stack.pop();
            possibleMoves(temp);
        }
        //stack is empty
        //System.out.println("EMPTY stack");
        long total_time = System.currentTimeMillis() - start_time;
        //System.out.println("Time Spent :" + total_time + " ms");
//        temp.visualize();
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
    @Override
    public void addtoQueue(Grid board) {
        this.stack.add(board);
    }
}