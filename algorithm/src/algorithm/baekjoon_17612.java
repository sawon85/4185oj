package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon_17612 {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;
	static int n, k;
	static Queue<Cart> carts = new LinkedList<>();
	
	public static long solve() {
		
		PriorityQueue<Counter> pq = new PriorityQueue<>();
		Stack<Counter> sameTime = new Stack<>();

		Counter temp;
		Cart next;
		
		for(int i=1; i<=k; i++) {
			if(carts.isEmpty()) break;
			pq.add(new Counter(i, carts.poll()));
		}

		long ans = 0;
		int cnt = 0;
		
		while(!pq.isEmpty()) {
			
			do {
				temp = pq.poll();
				sameTime.push(temp);
				ans+=(++cnt)*(long)temp.now.id;
			}while(!pq.isEmpty()&&pq.peek().time==temp.time);
			
			while(!sameTime.isEmpty()) {
				temp = sameTime.pop();
				if(!carts.isEmpty()) {
					next = carts.poll();
					temp.time += next.w;
					temp.now = next;
					pq.add(temp);
				}
			}
		}
		
		return ans;
	}

	public static void main(String[] args) throws IOException {
		s = bf.readLine(); st = new StringTokenizer(s);
		n = Integer.parseInt(st.nextToken()); k=Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			s = bf.readLine(); st = new StringTokenizer(s);
			carts.add(new Cart(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		System.out.println(solve());
	}
	
	public static class Cart{

		int id, w;
		
		Cart(int id, int w){
			this.id=id; this.w=w;
		}
		
	}
	
	public static class Counter implements Comparable<Counter>{

		int time, k;
		Cart now;
		
		Counter(int k, Cart now){
			this.k=k;  this.now = now;
			time = now.w;
		}
		
		@Override
		public int compareTo(Counter o) {
			if(this.time==o.time) return o.k-this.k;
			return this.time-o.time;
		}
		
		
	}

}
