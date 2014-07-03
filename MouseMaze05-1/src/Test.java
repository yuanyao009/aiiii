import java.util.Scanner;
/**
 * Test the efficiency of different methods to reach the final goal
 */
public class Test {
    public static void main(String[] args) {
    	//System.out.println("please input the name of method : ");
    	//Scanner input = new Scanner(System.in);
    	//String method= input.next();//DepthFirst,IterativeDepthFirst,BreathFirst,Greed,AStar
    	//Scanner input2= new Scanner(System.in);
    	//System.out.println("pleas input the game level: ");
    	//String level= input2.next();//easy,normal,hard
    	String level="normal";
    	String method="Breathfirst";
    	
    	Grid grid=new Grid(level);
    	
        System.out.println("<:left; >:right; ^:up; v:down; A:head; B:tail");

        System.out.println("move direction:\r"
        		+ "<:left; >:right; ^:up; v:down; A:head; B:tail!!!!!");
        System.out.println("rules:left and right move together, up and down move together, head and tail move together");
        System.out.println("once the head is move to position[2][5], it wins!");
    	if (method.equalsIgnoreCase("DepthFirst")) {
    	  	grid.show();
    		DepthFirst method2 = new DepthFirst(grid);
            method2.perform();
        }
    	else if (method.equalsIgnoreCase("IterativeDepthFirst")) {
    	  	grid.show();
    		IterativeDepthFirst method2 = new IterativeDepthFirst(grid);
            method2.perform();
        }
        else if (method.equalsIgnoreCase("BreathFirst")) {
          	grid.show();
        	BreathFirst method2 = new BreathFirst(grid);
            method2.perform();
        }
        else if (method.equalsIgnoreCase("Greedy")) {
          	grid.show();
            int heuristic = Character.getNumericValue(method.charAt(1));
            //System.out.println("heuristic is "+heuristic);
            Greedy method2 = new Greedy(grid, heuristic);
            method2.perform();
        }
        else if (method.equalsIgnoreCase("AStar")) {  	
        	grid.show();
            int heuristic = Character.getNumericValue(method.charAt(1));  
            AStar method2 = new AStar(grid);
            method2.perform();
        }
        else{System.out.println("The wrong input");}
}
}