
public class Combo extends heuristic {

    /**
     * is a combination between the blocking tiles Heuristic and the manhattan
     * distance which is the distance between the mouse and the goal.     
     */
    @Override
    public int score(char[][] board) {
        int mouse = getMousePosition_X(board);
        int distance = (5 - mouse);
        BlockingTilesHeuristic BlockingTilesHeuristic = new BlockingTilesHeuristic();
        return distance + BlockingTilesHeuristic.score(board);
    }
}