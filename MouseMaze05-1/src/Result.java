/**
 *restore every result,including method name, number of nodes explored, time spend,number of steps and if success 
*/
public class Result {
	public String method;
	public int nodes;
	public long time;
	public int steps;
	public boolean success;
	
	public Result(){
		method = "";
		nodes = 0;
		time = 0;
		steps = 0;
		success = false;
	}
	
	public void print(){
		System.out.println("*******************************");
		System.out.println("method is "+ this.method);
		System.out.println("step is "+this.steps);
		System.out.println("time is "+this.time);
		System.out.println("nodes explored is "+ this.nodes);
		System.out.println("if found solution " +this.success);
		
	}
	
}
