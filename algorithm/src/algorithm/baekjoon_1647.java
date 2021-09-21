package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class baekjoon_1647 {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;
	
	static int[] group;
	static PriorityQueue<E> q = new PriorityQueue<>();
	static PriorityQueue<E> road = new PriorityQueue<>();
	static int nowGroup = 1;
	static Set<Integer> set  = new HashSet<>();
	static int visited = 0;
	static int n;
	
	
	static void init() {
		
		for(int i=0; i<group.length; i++) group[i] = Integer.MAX_VALUE;

	}
	
	static void reset(int preGroup, int nowGroup) {
		
		for(int i=0; i<group.length; i++) if(group[i]==preGroup) group[i]=nowGroup;
	}
	
	static void print() {
		
		System.out.println();
		for(int i=0; i<group.length; i++) System.out.print(group[i] +" ");

	}
	
	static int mst() {
		init();
		
		E temp;
		int ans = 0;
		
		while(!q.isEmpty()) {
			
			temp  = q.poll();
			
			if(group[temp.from]==Integer.MAX_VALUE && group[temp.to]==Integer.MAX_VALUE)
			{
				group[temp.from] = nowGroup;
				group[temp.to] =  nowGroup;
				set.add(nowGroup++);
				ans += temp.w;
				visited += 2;
			} else if(group[temp.from]==group[temp.to]){
				continue;
			} else if(group[temp.from]==Integer.MAX_VALUE) {
				group[temp.from] = group[temp.to];
				visited++;
				ans += temp.w;
			} else if(group[temp.to]==Integer.MAX_VALUE) {
				group[temp.to] = group[temp.from];
				visited++;
				ans += temp.w;
			} else {	
				set.remove(group[temp.to]);
				reset(group[temp.to], group[temp.from]);
				ans += temp.w;
			
			} 
			
			if(visited==n-1 && set.size()==1) return ans;
			if(visited==n && set.size()==2) return ans;

			
		}
		
		return -1;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int m;
		s = bf.readLine(); st = new StringTokenizer(s);
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		group = new int[n];
		for(int i=0; i<m; i++) {
			s = bf.readLine(); st = new StringTokenizer(s);
			q.add(new E(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));
			
		}
		
		System.out.println(mst());
		
	}

	static class E implements Comparable<E>{
		
		public int from, to, w;
		
		E(int from, int to, int w){
			this.from = from; this.to= to; this.w=w;
		}

		@Override
		public int compareTo(E o) {
			return this.w - o.w;
		}
		
		
	}

}
