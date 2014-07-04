/**
* Calculate the horizontal distance from the mouse to the cheese
*/
public class Distance extends Heuristic {

    public int score(char[][] board) {
        int num = 0;
        int [] mp = getMousePosition(board);
        for (int i = mp[1]; i < 6; i++) {
            if (board[mp[0]][i] != 0) {
                num++;
            }
        }
        return num;
    }
}
