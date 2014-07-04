/*
* Heuristic function is used in Greedy and AStar search
*/
public class Heuristic {
	public Grid gridClass;
	public char[][] grid;
	/*
	public Heuristic(Grid grid,){
		gridClass=grid;
		this.grid=grid.grid;
	}
	**/
//get mouse position
    public int[] getMousePosition(char[][] grid) {
        int[] mouseP = new int[2];
        for (int i = 0; i < grid.length; i++) {
        	for(int j=0;j<grid[0].length;j++){
        		if(grid[i][j]=='A')
        			mouseP[0]=i;
        			mouseP[1]=j;
        	}
        }
        return mouseP;
    }
    //get the distance between mouse and cheese
    public double distance(char[][] grid) {
    	int[] mouseP=getMousePosition(grid);
    	double distance=(mouseP[0]-gridClass.goal[0])*(mouseP[0]-gridClass.goal[0])+(mouseP[1]-gridClass.goal[1])*(mouseP[1]-gridClass.goal[1]);
    	return distance;
    }  
    /*
    public int score(char[][] grid) {
        int numBlocking = 0;
        int[] mp = getMousePosition(grid);
        for (int i = mouse + 1; i < 6; i++) {
            if (grid[2][i] != ' ') {
                numBlocking++;
            }
        }
        return numBlocking;
    }
    **/
    public int score(char[][] board) {
        throw new UnsupportedOperationException("not here.");
    }
}
