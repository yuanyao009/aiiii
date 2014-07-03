

import java.util.Comparator;
import java.util.PriorityQueue;

public class Greedy extends Method {

    PriorityQueue<Grid> queue;
    int heuristic;

    public Greedy(Grid start, int heuristic) {
        this.heuristic = heuristic;
        Comparator<Grid> comparator = new Comparator1();
        queue = new PriorityQueue<>(1, comparator);
        queue.add(start);
    }
    public void perform() {
        System.out.println("Starting the Greedy");
        long start_time = System.currentTimeMillis();

        if (queue.size() == 0) {
            System.out.println("Cant start with no Board");
            return;
        }
        Grid temp = queue.remove();
        temp.lastGrid = null;
        possibleMoves(temp);
        while (queue.size() != 0) {
            System.out.println("size : " + queue.size());
            if (success(temp.grid)) {
                    temp.ShowProcess();
                    temp.show();
                System.out.println("Game Over --Solution FOUND");

                System.out.println("Nodes Explored :" + this.gridPassed.size());
                //System.out.println("Nodes Explored- :" + this.numGrid);


                long total_time = System.currentTimeMillis() - start_time;
                System.out.println("Time Spent :" + total_time + " ms");
                return;
            }
            temp = queue.remove();
            possibleMoves(temp);
        }
        System.out.println("EMPTY QUEUE");
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
   	 	Heuristic heu=new Heuristic(grid);
        grid.heuristic = heu.distance();
        //board.cost = board.lastGrid.cost + board.heuristic;
        System.out.println("heu is" + grid.heuristic);
       // this.explored_nodes++;
        this.queue.add(grid);
    }
}