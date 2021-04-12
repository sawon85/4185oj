package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class baekjoon_20183 {
static class edge {
		
		int nexV;
		long w;
		
		edge(int nexV, long w)
		{
			this.nexV = nexV;
			this.w = w;
		}
		
	}
	
	static ArrayList<edge>[] graph;
	static long[] visited;
	static int N, M, A, B;
	static long C;
	
	static long max = -1, min = Long.MAX_VALUE;
	
	static private boolean canGo(long cutline)
	{
		Queue<edge> q = new LinkedList<>();

		for(int i=1; i<=N; i++) visited[i] = Long.MAX_VALUE;

		q.add(new edge(A,0));
		visited[A] = 0;
		
		ArrayList<edge> nowVList;
		int nowV;	
		int nextV;
		long w;
		
		long newCost;
		
		while(!q.isEmpty())
		{
			nowV = q.poll().nexV;
			nowVList = graph[nowV];
			
			for(edge e : nowVList)
			{
				nextV = e.nexV;
				w =  e.w;
				
				newCost = visited[nowV] + w;
				
				if( w > cutline || visited[nextV] < visited[nowV] + w) continue;
				if(newCost > C) continue;
				
				visited[nextV] = newCost;
				
				if(nextV == B) return true;
				
				q.add(e);
				
			}
		}
		
		return visited[B] <= C;
	}

	
	static private long binary()
	{
		long left = min;
		long right = Math.min(C, max);
		long mid;
		long ans = -1;
		
		while(left<=right)
		{
			mid = (left + right) >> 1;
			
			if(canGo(mid)) {
				right = mid - 1;
				ans = mid;
				continue;
			}
			
			left = mid + 1;
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		visited = new long[N+1];
		graph = new ArrayList[N+1];
		
		for(int i=0; i<N+1; i++) graph[i] = new ArrayList<>();
		
		int from;
		int to;
		long w;
		
		for(int i=0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			w = Long.parseLong(st.nextToken());
			
			graph[from].add(new edge(to,w));
			graph[to].add(new edge(from,w));
			max =Math.max(max,w);
			min = Math.min(min, w);
		}
		
		System.out.println(binary());
		
	}
}
