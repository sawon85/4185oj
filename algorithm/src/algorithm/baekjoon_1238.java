package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon_1238 {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;
	
	static final int MAX = 1000000;
	
	static ArrayList<E>[] g;
	static int n, m, party;
	
	static int[] getDistArr() {
		
		int[] visited = new int[n+1];
		
		for(int i=1; i<=n; i++) visited[i] = MAX;
		
		return visited;
	}
	
	static void insertPriorityQueue(PriorityQueue<E> pq, int from) {
		for(int i=0; i<g[from].size(); i++) pq.add(g[from].get(i));
	}
	
	static int[] dijkstra(int start) {
		
		int[] dist = getDistArr();
		dist[start] = 0;
		PriorityQueue<E> pq = new PriorityQueue<>();
		pq.add(new E(start, 0));
		
		E temp;
		while(!pq.isEmpty()) {
			temp = pq.poll();
			
			for(E e : g[temp.to]) {
				if(dist[e.to]<=dist[temp.to]+e.w) continue;
				dist[e.to]=dist[temp.to]+e.w;
				pq.add(e);
			}
			
		}
		
		return dist;
	}
	
	public static void main(String[] args) throws IOException {
		
		s = bf.readLine(); st = new StringTokenizer(s);
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken()); party = Integer.parseInt(st.nextToken());
		g = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) g[i] = new ArrayList<>();
		
		int from, to, w;
		for(int i=0; i<m; i++) {
			s = bf.readLine(); st = new StringTokenizer(s);
			from = Integer.parseInt(st.nextToken()); to =Integer.parseInt(st.nextToken()); w = Integer.parseInt(st.nextToken());
			if(g[from].add(new E(to, w))) continue;
		}
		
		int[] fromParty = dijkstra(party);
		
		int max = -1;
		for(int i=1; i<=n; i++) {
			if(i==party) continue;
			max = Math.max(dijkstra(i)[party] + fromParty[i], max);
			
		}
		
		System.out.println(max);
	}
	
	static class E implements Comparable<E>{
		int to, w;
		
		E(int to, int w){
			this.to = to; this.w = w;
		}

		@Override
		public int compareTo(E o) {
			return this.w - o.w;
		}
	}

}
