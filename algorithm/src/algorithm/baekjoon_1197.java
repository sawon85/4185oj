package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon_1197 {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;
	
	static int[] visited;
	static PriorityQueue<Info> pq = new PriorityQueue<Info>();
	static int n;
	static int cnt = 0;
	
	static int findP(int n) {
		if(visited[n]==n) return n;	
		return visited[n] = findP(visited[n]);
	}
	
	static boolean setP(int n1, int n2) {
		
		int p1=findP(n1), p2=findP(n2);
		
		if(p1==p2) return true;
		
		if(p1<p2) {
			visited[p2] = p1;
			visited[n2] = p1;
		}
		
		else {
			visited[p1] = p2;
			visited[n1] = p2;
		}
		
		return false;
	}
	
	static long kruskcal() {
		
		for(int i=1;i<visited.length; i++) visited[i] = i;
		Info temp;
		long ans = 0;
		cnt = 0;
		
		while(!pq.isEmpty()) {
			
			temp = pq.poll(); 
			if(setP(temp.from, temp.to)) continue;
			ans += (long)temp.w;
			
			if(cnt==n) return ans;
			
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException{
		
		s = bf.readLine(); st = new StringTokenizer(s);
		n = Integer.parseInt(st.nextToken()); 
		int m =  Integer.parseInt(st.nextToken()); 
		visited = new int[n+1];
		
		
		for(int i=0; i<m; i++) {
			s = bf.readLine(); st = new StringTokenizer(s);
			pq.add(new Info(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		System.out.println(kruskcal());
	}
	
	static class Info implements Comparable<Info>{
		
		public int from, to, w;
	
		Info(int from, int to, int w){
			this.from=from; this.to=to; this.w=w;
		}


		@Override
		public int compareTo(Info o) {
			return this.w-o.w;
		}
		
	}

}
