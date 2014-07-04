import java.util.*;
import java.util.Map.Entry;
/**
 * Explain the moving strategy in detail.<>,<-> can only move horizontally;^v,^|v can only move vertically
 */
public class Method{

    Queue<Grid> gridPassed;
    //int numGrid = 0;
    public Method() {
        gridPassed = new LinkedList<Grid>();
    }
    public void cleargridPassed() {
        this.gridPassed = new LinkedList<Grid>();
    }
    public Result perform() {
        
    	return new Result();
    }
    public void addtoQueue(Grid board) {
        
    }
    public void possibleMoves(Grid b) {
        for (int i = 0; i < b.grid.length; i++) {
            for (int j = 0; j < b.grid[i].length; j++) {
                Grid tempBoard = new Grid();
                Grid tempBoardl = new Grid();
                Grid tempBoardr = new Grid();
                Grid tempBoardu = new Grid();
                Grid tempBoardd = new Grid();
                tempBoard.copy(b.grid);
                tempBoardl.copy(b.grid);
                tempBoardr.copy(b.grid);
                tempBoardu.copy(b.grid);
                tempBoardd.copy(b.grid);
                switch (b.grid[i][j]) {
                    case '<':
                        try {
                            if (b.grid[i][j - 1] == ' ') {
                                tempBoard.grid = tempBoard.move(tempBoard.grid, i, j, '<');
                                if (tempBoard.insert(tempBoard.grid, this.gridPassed)) {
                                    tempBoard.lastGrid = b;
                                    addtoQueue(tempBoard);
                                    gridPassed.add(tempBoard);
                                }
                            }
                        } catch (Exception e) {
                        }
                        break;
                        
                    case 'A':
                    	HashMap<String,int[]> map=new HashMap<String,int[]>();
                    	if(i-1>=0 && b.grid[i-1][j]==' '){
                    		int[] arr=new int[2];
                    		arr[0]=i-1;
                    		arr[1]=j;
                    		map.put("u",arr);
                    	}
                    	if(j-1>=0 && b.grid[i][j-1]==' '){
                    		int[] arr=new int[2];
                    		arr[0]=i;
                    		arr[1]=j-1;
                    		map.put("l",arr);
                    	}
                    	if(i+1<b.grid.length && b.grid[i+1][j]==' '){
                    		int[] arr=new int[2];
                    		arr[0]=i+1;
                    		arr[1]=j;
                    		map.put("d",arr);
                    		//System.out.println("d"+arr[0]);
                    	}
                    	if(j+1<b.grid.length && b.grid[i][j+1]==' '){
                    		int[] arr=new int[2];
                    		arr[0]=i;
                    		arr[1]=j+1;
                    		map.put("r",arr);
                    	}
                    	if(map.size()==0)
                    		break;
                    	else{
                    		for (Entry<String, int[]> entry : map.entrySet()) {
                    			if(entry.getKey()=="l"){
                    				tempBoardl.grid=tempBoardl.move(tempBoardl.grid, entry.getValue()[0], entry.getValue()[1], 'l');
    								if (tempBoardl.insert(tempBoardl.grid, this.gridPassed)) {
    		                            tempBoardl.lastGrid = b;
    		                            addtoQueue(tempBoardl);
    		                            gridPassed.add(tempBoardl);
    		                         }
                    			}
                    			else if((entry.getKey()=="r")){
                    				tempBoardr.grid=tempBoardr.move(tempBoardr.grid, entry.getValue()[0], entry.getValue()[1], 'r');
    								if (tempBoardr.insert(tempBoardr.grid, this.gridPassed)) {
    		                            tempBoardr.lastGrid = b;
    		                            addtoQueue(tempBoardr);
    		                            gridPassed.add(tempBoardr);
    		                         }
                    			}
	                    			
                    			else if((entry.getKey()=="u")){
                    				tempBoardu.grid=tempBoardu.move(tempBoardu.grid, entry.getValue()[0], entry.getValue()[1], 'u');
    								if (tempBoardu.insert(tempBoardu.grid, this.gridPassed)) {
    		                            tempBoardu.lastGrid = b;
    		                            addtoQueue(tempBoardu);
    		                            gridPassed.add(tempBoardu);
    		                         }
                    			}
                    			else if((entry.getKey()=="d")){
									tempBoardd.grid=tempBoardd.move(tempBoard.grid, entry.getValue()[0], entry.getValue()[1], 'd');
    								if (tempBoardd.insert(tempBoardd.grid, this.gridPassed)) {
    		                            tempBoardd.lastGrid = b;
    		                            addtoQueue(tempBoardd);
    		                            gridPassed.add(tempBoardd);
    		                         }
                    			}
                    			

							}
                    	}
                    	break;
                    case '>':
                        try {
                            if (b.grid[i][j + 1] == ' ') {
                                tempBoard.grid = tempBoard.move(tempBoard.grid, i, j, '>');
                                if (tempBoard.insert(tempBoard.grid, this.gridPassed)) {
                                    tempBoard.lastGrid = b;
                                    addtoQueue(tempBoard);
                                    gridPassed.add(tempBoard);
                                }
                            }
                        } catch (Exception e) {
                        }

                        break;
                    case '^':
                        try {
                            if (b.grid[i - 1][j] == ' ') {
                                tempBoard.grid = tempBoard.move(tempBoard.grid, i, j, '^');
                                if (tempBoard.insert(tempBoard.grid, this.gridPassed)) {
                                    tempBoard.lastGrid = b;
                                    addtoQueue(tempBoard);
                                    gridPassed.add(tempBoard);
                                }
                            }
                        } catch (Exception e) {
                        }

                        break;
                        
                    case 'v':
                        try {
                            if (b.grid[i + 1][j] == ' ') {
                                tempBoard.grid = tempBoard.move(tempBoard.grid, i, j, 'v');
                                if (tempBoard.insert(tempBoard.grid, this.gridPassed)) {
                                    tempBoard.lastGrid = b;
                                    addtoQueue(tempBoard);
                                    gridPassed.add(tempBoard);
                                }
                            }
                        } catch (Exception e) {
                        }
                        break;
                        
                     default:
                    	 break;
                }
            }
        }
    }
    public boolean success(char[][] grid) {
        if (grid[Grid.goal_x][Grid.goal_y] == 'A') {
            return true;
        }
        return false;
    }
}