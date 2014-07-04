import java.util.Scanner;
/**
 *The main test of the program, where including the main class. 
*/
public class Test {
	public static Result[] res;
	public  static int maxiter;
	public static void main(String[] args) {
		
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the number of random puzzles to generate: ");

    	maxiter = Integer.parseInt(input.next());//change iteration
    	System.out.println("Please enter the time limit for the search in seconds (search will fail if solution is not find within the time limit): ");
    	
    	int maxTime=Integer.parseInt(input.next())*1000;//change the limited time,if it can not find solution in this time, it will stop!
		res = new Result[maxiter*4];
    	for (int i=0; i<maxiter; i++){
    		System.out.println("");
    		System.out.println("Starting puzzle " +i+":");
    		Grid grid = new Grid("random");
    		for(int j=0;j<4;j++){
    			switch (j){
    			case 0:
    				DepthFirst method0 = new DepthFirst(grid,maxTime);
    				res[j+4*i] = method0.perform();
    				break;
    			case 1:
    				BreadthFirst method1 = new BreadthFirst(grid,maxTime);
    				res[j+4*i] = method1.perform();
    				break;
    			case 2:
    				AStar method2=new AStar(grid,7,maxTime);
    				res[j+4*i] = method2.perform();
    				break;
    			case 3:
    				int heuristic = Character.getNumericValue("Greedy".charAt(1));
    				Greedy method3 = new Greedy(grid, heuristic,maxTime);
    				res[j+4*i] = method3.perform();
    				break;
    			default:
    				break;
    			}
    			}
    		}
    	printTable();
    	System.out.println("**********************************************************");
    	printAverageTable();
    	}

	//print the table including every iterate
	public static void printTable(){
		System.out.println("**********************************************************");
		System.out.println("detail	"+"DepthFirst	"+"BreadthFirst	"+"AStar	"+"Greedy	");
		System.out.println("---------------------------------------------------------");
		for(int i=0;i<res.length/4;i++){
			System.out.println("steps	"+res[0+4*i].steps+"		"+res[1+4*i].steps+"		"+res[2+4*i].steps+"	"+res[3+4*i].steps+"		");
			System.out.println("nodes	"+res[0+4*i].nodes+"		"+res[1+4*i].nodes+"		"+res[2+4*i].nodes+"	"+res[3+4*i].nodes+"		");
			System.out.println("time(ms)"+res[0+4*i].time+"		"+res[1+4*i].time+"		"+res[2+4*i].time+"	"+res[3+4*i].time+"		");
			System.out.println("success	"+res[0+4*i].success+"		"+res[1+4*i].success+"		"+res[2+4*i].success+"	"+res[3+4*i].success+"		");
			System.out.println("---------------------------------------------------------");
		}
	}
	//print the final average table
	public static void printAverageTable(){
		
		double [] step=new double[4];
		double[] node=new double[4];
		double[] time=new double[4];
		double[] numTrue=new double[4];
		for(int i=0;i<res.length/4;i++){
			for(int j=0;j<4;j++){
				if(res[j+4*i].success==true){
					step[j]+=res[j+4*i].steps;
					node[j]+=res[j+4*i].nodes;
					time[j]+=res[j+4*i].time;
					numTrue[j]++;
				}
				else{
					continue;
				}
			}
		}
		for(int k=0;k<4;k++){
			if(numTrue[k]==0){
				step[k]=0;
				node[k]=0;
				time[k]=0;
			}
		step[k]=step[k]/numTrue[k];
		node[k]=node[k]/numTrue[k];
		time[k]=time[k]/numTrue[k];
		}
		System.out.println("average	"+"DepthFirst	"+"BreadthFirst	"+"AStar	"+"Greedy	");
		System.out.println("---------------------------------------------------------");
		System.out.println("steps	"+String.format("%.1f", step[0])+"		"+String.format("%.1f", step[1])+"		"+String.format("%.1f", step[2])+"	"+String.format("%.1f", step[3])+"		");
		System.out.println("nodes	"+String.format("%.1f", node[0])+"		"+String.format("%.1f", node[1])+"		"+String.format("%.1f", node[2])+"	"+String.format("%.1f", node[3])+"		");
		System.out.println("time(ms)"+String.format("%.1f", time[0])+"		"+String.format("%.1f", time[1])+"		"+String.format("%.1f", time[2])+"	"+String.format("%.1f", time[3])+"		");
		System.out.println("sucess	"+String.format("%2.0f", numTrue[0]*100/maxiter)+"%		"+String.format("%2.0f", numTrue[1]*100/maxiter)+"%		"+String.format("%2.0f", numTrue[2]*100/maxiter)+"%	"+String.format("%2.0f", numTrue[2]*100/maxiter)+"%");//System.out.println("sucess	"+res[0+4*i].success+"		"+res[1+4*i].success+"		"+res[2+4*i].success+"	"+res[3+4*i].success+"		");
	}
}
