package algorithm;

import java.util.Scanner;

public class baekjoon_15649 {
	
	static Scanner sc = new Scanner(System.in);
	static int n, m;
	static boolean[] visited;
	
	
	static void dfs(int index, int cnt, String str) {
		
		if(cnt==m) 
		{
				System.out.println(str);
				return;
		}
		
		for(int i=1; i<=n; i++) {
			
			if(visited[i]) continue;
			
			visited[i] = true;
			dfs(index+1, cnt+1, str+Integer.toString(i)+" ");
			visited[i] = false;
			
		}
		
	}
	
	public static void main(String[] args) {
		
		n = sc.nextInt();
		m = sc.nextInt();
		visited = new boolean[n+1];
		
		dfs(1, 0, "");
		
	}

}
