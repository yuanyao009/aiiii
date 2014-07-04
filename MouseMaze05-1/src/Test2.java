
public class Test2 {
	public static Result[] res;
	
	public static void main(String[] args) {
    	int maxiter = 100;//change iteration
    	final int maxTime=1*60*1000;//change the limited time,if it can not find solution in this time, it will stop!
		res = new Result[maxiter*4];
    	for (int i=0; i<maxiter; i++){
    		Grid grid = new Grid("random");
    		for(int j=0;j<4;j++){
    			switch (j){
    			case 0:
    				DepthFirst method0 = new DepthFirst(grid,maxTime);
    				res[j+4*i] = method0.perform();
    				break;
    			case 1:
    				BreathFirst method1 = new BreathFirst(grid,maxTime);
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
		//for (int i=0; i<maxiter*4; i++){
    		//res[i].print();
    	}

	
	public static void printTable(){
		System.out.println("**********************************************************");
		System.out.println("detail	"+"DepthFirst	"+"BreathFirst	"+"AStar	"+"Greedy	");
		System.out.println("---------------------------------------------------------");
		for(int i=0;i<res.length/4;i++){
			System.out.println("step	"+res[0+4*i].steps+"		"+res[1+4*i].steps+"		"+res[2+4*i].steps+"	"+res[3+4*i].steps+"		");
			System.out.println("node	"+res[0+4*i].nodes+"		"+res[1+4*i].nodes+"		"+res[2+4*i].nodes+"	"+res[3+4*i].nodes+"		");
			System.out.println("time	"+res[0+4*i].time+"		"+res[1+4*i].time+"		"+res[2+4*i].time+"	"+res[3+4*i].time+"		");
			System.out.println("sucess	"+res[0+4*i].success+"		"+res[1+4*i].success+"		"+res[2+4*i].success+"	"+res[3+4*i].success+"		");
			System.out.println("---------------------------------------------------------");
		}
	}
	
	public static void printAverageTable(){
		
		long[] step=new long[4];
		long[] node=new long[4];
		long[] time=new long[4];
		int[] numTrue=new int[4];
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
		step[k]=step[k]/numTrue[k];
		node[k]=node[k]/numTrue[k];
		time[k]=time[k]/numTrue[k];
		}
		System.out.println("average	"+"DepthFirst	"+"BreathFirst	"+"AStar	"+"Greedy	");
		System.out.println("---------------------------------------------------------");
		System.out.println("step	"+step[0]+"		"+step[1]+"		"+step[2]+"	"+step[3]+"		");
		System.out.println("node	"+node[0]+"		"+node[1]+"		"+node[2]+"	"+node[3]+"		");
		System.out.println("time	"+time[0]+"		"+time[1]+"		"+time[2]+"	"+time[3]+"		");
		//System.out.println("sucess	"+res[0+4*i].success+"		"+res[1+4*i].success+"		"+res[2+4*i].success+"	"+res[3+4*i].success+"		");
	}


}
