
public class BlockingTilesHeuristic extends Heuristic {
    /**
     * Guesses distance to goal based on the number of tiles between the mouse
     * and the exit
     */
    @Override
    public int score(char[][] board) {
        int numBlocking = 0;
        int [] mp = getMousePosition(board);
        for (int i = mp[1]; i < 6; i++) {
            if (board[mp[0]][i] != 0) {
                numBlocking++;
            }
        }
        return numBlocking;
    }
}
