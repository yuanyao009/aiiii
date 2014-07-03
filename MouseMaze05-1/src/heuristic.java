
public class Heuristic {
	public Grid gridClass;
	public char[][] grid;
	
	public Heuristic(Grid grid){
		gridClass=grid;
		this.grid=grid.grid;
		
	}

    public int[] getMousePosition() {
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
    
    public double distance() {
    	int[] mouseP=getMousePosition();
    	double distance=(mouseP[0]-gridClass.goal[0])*(mouseP[0]-gridClass.goal[0])+(mouseP[1]-gridClass.goal[1])*(mouseP[1]-gridClass.goal[1]);
    	return distance;
    }
    
    /*
    * returns the horizontal position of the whole mouse (2 blocks)
    */
    
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
    
}