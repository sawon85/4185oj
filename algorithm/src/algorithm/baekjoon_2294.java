package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class baekjoon_2294 {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;
	
	static int[] coins;
	static int[] visited;
	static int n, k;
	static Queue<Integer> q = new LinkedList<>();
	
	
	static boolean add(int coin, int cnt) {
		
		if(coin==k) return true;
		
		if(coin>k) return false;
		
		if(visited[coin]!=0 && visited[coin]<=cnt) return false;
		
		q.add(coin);
		visited[coin] = cnt;
	
		return false;

	}
	
	static int bfs() {
		
		for(int i=0; i<coins.length; i++) if(add(coins[i], 1)) return 1;
		
		int now;
		int cnt;
		while(!q.isEmpty()) {
			now = q.poll();
			cnt = visited[now];
			for(int i=0; i<coins.length; i++) if(add(now+coins[i], cnt+1)) return cnt+1;
			
		}
		
		return -1;
	}

	public static void main(String[] args) throws IOException{
		
		s=bf.readLine(); st = new StringTokenizer(s);
		n = Integer.parseInt(st.nextToken()); k=Integer.parseInt(st.nextToken());
		coins = new int[n]; visited = new int[k+1];
		
		for(int i=0; i<n; i++) coins[i] = Integer.parseInt(bf.readLine());
		System.out.println(bfs());
 		
	}
	
	
}
