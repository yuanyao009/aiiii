/**
* Calculate the Manhattan distance from the mouse to the cheese
*/
public class Distance extends Heuristic {

    public int score(char[][] board) {
    	int [] mp = getMousePosition(board);
        /*int num = 0;
        
        for (int i = mp[1]; i < 6; i++) {
            if (board[mp[0]][i] != 0) {
                num++;
            }
        }*/
        
    	/*
        int nonspace = 0;
        int startY = Math.min(mp[1], Grid.goal_y);
        int endY = Math.max(mp[1], Grid.goal_y);
        int startX = Math.min(mp[0], Grid.goal_x);
        int endX = Math.max(mp[0], Grid.goal_x);
        */
        /*
        for (int i = startX; i <= endX; i++) {
        	for (int j = startY; j <= endY; j++)
        		if (board[i][j] != ' ') {
                nonspace++;
            }
        } */
        
        
        /*for (int i = startX; i <= endX; i++) {
        	if (board[mp[0]][i] != ' ') {
        		nonspace++;
            }
        }*/
        
        
        //int sqrdistance = (mp[1] - Grid.goal_y)^2 + (mp[0] - Grid.goal_x)^2;
        int mandistance = Math.abs(mp[1] - Grid.goal_y) + Math.abs(mp[0] - Grid.goal_x);
        
        //int num = sqrdistance*nonspace;
        return mandistance;
    }
}
