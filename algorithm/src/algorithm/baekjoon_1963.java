package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_1963 {
	
	static Scanner sc = new Scanner(System.in);
	
	static boolean[] prime = new boolean[10000];
	
	static void init(int[] visited) {
		
		for(int i=1000; i<10000; i++) visited[i] = Integer.MAX_VALUE;
		
	}
	
	static void setPrime() {
		
		 for(int i=2; i*i<10000; i++){
		        for(int j=i*i; j<10000; j+=i){
		            prime[j] = true;
		        }
		    }     
	}
	
	static boolean canAdd(int[] visited, int number, int cnt) {
		
		if(number<1000) return false;
		
		if(prime[number]) return false;
		
		if(visited[number]<=cnt+1) return false;
		
		return true;
		
	}
	
	static boolean add(Queue<Integer> q, int[] visited, int number, int cnt, int to) {
		
		q.add(number);
		visited[number] = cnt+1;
		
		if(number==to) return true;
		
		return false;
	}

	static int bfs(int from, int to) {
		
		if(from == to) return 0;
		
		int[] visited = new int[10000];
		init(visited);

		Queue<Integer> q = new LinkedList<>();
		q.add(from);
		visited[from]= 0;
			
		int now;
		int n1, n2, n3, n4;
		int a,b,c,d;
		while(!q.isEmpty()) {
			
			now = q.poll();
			
			n1 = (now%1000);
			n2 = (now/1000)*1000 + n1%100;
			n3 = (now/100)*100 + now%10;
			n4 = (now/10)*10;
			
			
			for(int i=0; i<10; i++) {
				
				a = n1+1000*i; b = n2+100*i; c = n3+10*i; d = n4+1*i;
	
				 
				if(i!=0) if(canAdd(visited, a, visited[now])) if(add(q, visited, a, visited[now], to)) return visited[now]+1;
				if(canAdd(visited, b, visited[now])) if(add(q, visited, b, visited[now], to)) return visited[now]+1;
				if(canAdd(visited, c, visited[now])) if(add(q, visited, c, visited[now], to)) return visited[now]+1;
				if(canAdd(visited, d, visited[now])) if(add(q, visited, d, visited[now], to)) return visited[now]+1;
			}
			
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		
		int t = sc.nextInt();
		setPrime();
		
		for(int i=0; i<t; i++)
		{
			int result = bfs(sc.nextInt(), sc.nextInt());
			if(result==-1) System.out.println("Impossible");
			else System.out.println(result);
		}
	}
	
	

}
