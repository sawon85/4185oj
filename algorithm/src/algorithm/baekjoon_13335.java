package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_13335 {
	
	
	static class info{
		public int t, w;
		info(int t, int w){
			this.t= t;
			this.w = w;
		}
	}

	static Scanner sc = new Scanner(System.in);
	
	static int n, w, l;
	static ArrayList<Integer> truck = new ArrayList<>();
	static Queue<info> q = new LinkedList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		n = sc.nextInt();
		w = sc.nextInt();
		l = sc.nextInt();
		
		for(int i=0; i<n; i++)
		{
			int temp = sc.nextInt();
			truck.add(temp);
		}
		
		int tw = 0;
		int t = 0;
		int i = 0;
		
		
		boolean remove = false;
		
		while(true) {

			remove = false;
			
			if(!q.isEmpty())
			for(info in : q) {
				in.t++;		
				if(in.t >= w) remove = true;
			}
			
			if(remove) {
				info in = q.poll();
				tw -= in.w;
			}
			
			if(i<n)
			if(l >= tw + truck.get(i)) {
				q.add(new info(0, truck.get(i)));
				tw += truck.get(i);
				i++;
				
			}
			
			t++;
			
			if(i>=n && q.isEmpty()) break;
			
		}

		System.out.print(t);
	}

}
