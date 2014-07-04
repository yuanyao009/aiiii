import java.util.Stack;

public class DepthLimit extends Method {

    //Queue<Grid> queue;
    Stack<Grid> stack;
    //int depth = Integer.MAX_VALUE;
    int depth = 10000;
    Grid start;

    public DepthLimit(Grid start) {
        stack = new Stack<>();
        stack.add(start);
    }
    @Override
    public void perform() {
        System.out.println("Starting the DepthLimit");
        long start_time = System.currentTimeMillis();
        Grid temp=new Grid();
        temp.lastGrid = null;
        //possibleMoves(temp);
        int level = 0;
        while (stack.size() != 0) {
            try {
            	temp=stack.pop();
            	level=temp.currentLevel();
                System.out.println("Current Level " + level);
                if (level > this.depth) {
                	System.out.println("Current Level " + level);
                    System.out.println("You reach the limit");
                    System.out.println("Stack Size :" + stack.size());
                    continue;
                }
                possibleMoves(temp);
                if (success(temp.grid)) {
                        temp.ShowProcess();
                        temp.show();
                    System.out.println("gameover");
                    System.out.println("Stack Size :" + stack.size());
                //System.out.println("Nodes Explored :" + this.numGrid);
                    System.out.println("Current Level " + level);
                    long total_time = System.currentTimeMillis() - start_time;
                    System.out.println("Time Spent :" + total_time + " ms");
                    return;
                }
                //temp = stack.pop();
                //possibleMoves(temp);
            } catch (Exception e) {
                System.out.println("Game Over --Solution NOT found");
                System.out.println("Queue Size :" + stack.size());
                //System.out.println("Nodes Explored :" + this.numGrid);

                long total_time = System.currentTimeMillis() - start_time;
                System.out.println("Time Spent :" + total_time + " ms");
            } catch (OutOfMemoryError e) {
                System.out.println("Game Over --Solution NOT found");
                System.out.println("Queue Size :" + stack.size());
                //System.out.println("Nodes Explored :" + this.numGrid);
                long total_time = System.currentTimeMillis() - start_time;
                System.out.println("Time Spent :" + total_time + " ms");
                return;
            }
        }
        System.out.println("EMPTY QUEUE");
        long total_time = System.currentTimeMillis() - start_time;
        System.out.println("Time Spent :" + total_time + " ms");
        //System.out.println("Nodes Explored :" + this.numGrid);
        if (success(temp.grid)) {
                temp.ShowProcess();
            System.out.println("Game Over --Solution FOUND");
        } else {
            System.out.println("Game Over --Solution NOT found");
        }
    }
    @Override
    public void addtoQueue(Grid board) {
        //this.numGrid++;
        this.stack.add(board);
    }

}
