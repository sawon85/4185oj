package Kakao0821;
import java.util.*;

public class nhn2 {
	
	static I[] is = new I[21];
	static PriorityQueue<I> q = new PriorityQueue<>();
	
	static void init() {
		
		for(int i=0; i<21; i++) is[i] = new I(i, 0);
	}
	
	static void solve(int[][] f, int k) {
		
		for(int i=0; i<f.length; i++) {
			
			for(int j=0; j<f[i].length; j++) {
				is[f[i][j]].count++;
			}
		}
		
		for(int i=0; i<21; i++) q.add(is[i]);
		
	}
	
	static class I implements Comparable<I>{
		
		int num;
		int count;
		
		I(int num, int count){
			this.num=num;
			this.count=count;
		}

		@Override
		public int compareTo(I o) {
			return o.count-this.count;
		}
		
	}

}
