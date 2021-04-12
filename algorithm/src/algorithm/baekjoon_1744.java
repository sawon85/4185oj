package algorithm;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class baekjoon_1744 {
	
	static Scanner sc = new Scanner(System.in);
	
	static PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
	static PriorityQueue<Integer> minus = new PriorityQueue<>();
	static int n;
	
	static int cacul(int x, int y)
	{
		return Math.max(x+y, x*y);
		
	}
	
	static int run(PriorityQueue<Integer> queue, Integer num1, int result)
	{
		if(queue.isEmpty())  return (num1 == null ) ? result : num1 + result;
		
		int priNum = queue.poll();
		
		if(num1 == null) return run(queue, priNum, result);
		
		return run(queue, null, result + cacul(num1, priNum));
		
		
	}

	public static void main(String[] args) {
		
		n = sc.nextInt();
		
		int num;
		for(int i=0; i<n; i++)
		{
			num = sc.nextInt();
			
			if(num > 0) plus.add(num);
			else minus.add(num);
		}
		
		System.out.print(run(plus,null,0) + run(minus,null,0));
		
	}

}
