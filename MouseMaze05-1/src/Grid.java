/**
 * Construct the grid class of game,including mouse,goal position;
 */

import java.util.*;

public class Grid {
    public char[][] grid;
    public Grid lastGrid;
    public int cost; 
    public int heuristic;
    public long time = System.currentTimeMillis();
    public int dimension=6;
    public int[] goal=new int[2];
    public static int goal_x=0;
    public static int goal_y=5;
    public static int start_x=1;
    public static int start_y=2;
    
    
    public Grid(){
    	grid=new char[dimension][dimension];
    }
    
    //generate the grid in random or hard-coded way 
    public Grid(String level) {
    	switch (level) {
    	case "random":
    		grid = new char[][]{
    	            {' ',' ',' ',' ',' ',' '},
    	            {' ',' ',' ',' ',' ',' '},
    	            {' ',' ',' ',' ',' ',' '}, 
    	            {' ',' ',' ',' ',' ',' '},
    	            {' ',' ',' ',' ',' ',' '},
    	            {' ',' ',' ',' ',' ',' '}};
    		 start_x=(int)(Math.random()*6);
    		 start_y=(int)(Math.random()*6);
    		int temp_goal_x=(int)(Math.random()*6);
    		int temp_goal_y=(int)(Math.random()*6);
    		while(start_x==temp_goal_x&&start_y==temp_goal_y)
    		{temp_goal_x=(int)(Math.random()*6);
    		temp_goal_y=(int)(Math.random()*6);}
    		goal_x=temp_goal_x;
    		goal_y=temp_goal_y;
    		grid[start_x][start_y]='A';
    	        int counter = 0;
    	        for (int i = 0; i < 100000 && counter < 6; i++) {
    	            try {
    	                int row = (int) (Math.random() * 6);
    	                int col = (int) (Math.random() * 6);
    	                double orientation = Math.random();
    	                if (orientation <= 0.5) {
    	                    if (grid[row][col] == ' ' && grid[row][col + 1] == ' ') {
    	                        grid[row][col] = '<';
    	                        grid[row][col + 1] = '>';
    	                        counter++;
    	                    }
    	                } else {
    	                    if (orientation < 0.75) {
    	                        if (grid[row][col] == ' ' && grid[row + 1][col] ==' ') {
    	                            grid[row][col] = '^';
    	                            grid[row + 1][col] ='v';
    	                            counter++;
    	                        }
    	                    } else {
    	                        if (grid[row][col] ==' ' && grid[row + 1][col] == ' '
    	                                && grid[row + 2][col] == ' ') {
    	                            grid[row][col] ='^';
    	                            grid[row + 1][col] ='|';
    	                            grid[row + 2][col] ='v';
    	                            counter++;
    	                        }
    	                    }
    	                }
    	            } catch (Exception e) {
    	                // TODO: handle exception
    	            }
    	        }
    	        
         break;
    	
        case "normal":  
            grid = new char[][]{
            		{' ', ' ', '<', '>', '<', '>'},
                    {' ', '<', '>', '<', '>', '^'},
                    {' ', 'A', ' ', ' ', '^', '|'},
                    {'<', '>', '<', '>', 'v', 'v'},
                    {'^', ' ', ' ', '^', '<', '>'},
                    {'v', ' ', ' ', 'v', '<', '>'}};
            goal[0]=2;
            goal[1]=5;
        break;
    	}
    
}
    public void setGoal(int x, int y){
    	goal[0]=x;
    	goal[1]=y;
    }
    public int[] getGoal(){
    	return goal;
    }
    
    public void show() {
        System.out.println();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }
    public void copy(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            System.arraycopy(grid[i], 0, this.grid[i], 0, grid[i].length);
        }
    }
    public int currentLevel() {
        Grid currentGrid = this;
        int steps = 0;
        while (currentGrid.lastGrid != null) {
        	currentGrid = currentGrid.lastGrid;
            steps++;
        }
        return steps;
    }
    public int ShowProcess() {
        Grid currentGrid = this;
        //System.out.println("********Final result*********");
        Stack<Grid> stack = new Stack<Grid>();
        while (currentGrid.lastGrid != null) {
            stack.add(currentGrid.lastGrid);
            currentGrid = currentGrid.lastGrid;
        }
        int steps = stack.size();
        //
        /*
        while (!stack.empty()) {
            stack.pop().show();
        }
        **/
        
        //System.out.println("------ Done in  " + steps + " steps");
        return steps;
    }
    /*
     * Define how to move a block and generate a new grid
     */
    char[][] move(char[][] grid, int i, int j, char move) {
        switch (move) {
        	case 'l':
        		//System.out.println("l"+i+j);
        		grid[i][j] ='A';
                grid[i][j+1] =' ';
                
                break;
        	case 'r':
        		//System.out.println("r"+i+j);
        		grid[i][j] ='A';
                grid[i][j-1] =' ';
                
                break; 
        	case 'u':
        		//System.out.println("u"+i+j);
        		grid[i][j] ='A';
                grid[i+1][j] =' ';
                
                break;
        	case 'd':
        		//System.out.println("d"+i+j);
        		grid[i][j] ='A';
                grid[i-1][j] =' ';                
                break;	
            case '<':
                grid[i][j - 1] = grid[i][j];
                grid[i][j] = grid[i][j + 1];
                if (grid[i][j] == '-') {
                    grid[i][j + 1] = grid[i][j + 2];
                    grid[i][j + 2] = ' ';
                } else {
                    grid[i][j + 1] = ' ';
                }
                break;
            case '>':
                grid[i][j + 1] = grid[i][j];
                grid[i][j] = grid[i][j - 1];
                if (grid[i][j - 1] == '-') {
                    grid[i][j - 1] = grid[i][j - 2];
                    grid[i][j - 2] = ' ';
                } else {
                    grid[i][j - 1] = ' ';
                }
                break;
            case '^':
                grid[i - 1][j] = grid[i][j];
                grid[i][j] = grid[i + 1][j];
                if (grid[i + 1][j] == '|') {
                    grid[i + 1][j] = grid[i + 2][j];
                    grid[i + 2][j] = ' ';
                } else {
                    grid[i + 1][j] = ' ';
                }
                break;
            case 'v':
                grid[i + 1][j] = grid[i][j];
                grid[i][j] = grid[i - 1][j];
                if (grid[i - 1][j] == '|') {
                    grid[i - 1][j] = grid[i - 2][j];
                    grid[i - 2][j] = ' ';
                } else {
                    grid[i - 1][j] = ' ';
                }
                break;
            default:
            	break;
        }
        return grid;
    }
    /*
     * Makes sure that the no explored gird can be repeated , returns true in
     * case that the grid configuration is unique, false otherwise
     */
    public boolean insert(char[][] grid, Queue<Grid> explored) {
        if (explored.isEmpty()) {
            return true;
        }
        for (Grid temp : explored) {
            boolean found = Arrays.deepEquals(grid, temp.grid);
            if (found) {
                return false;
            }
        }
        return true;
    }
}