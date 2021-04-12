package algorithm;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static class info{
		public int s, e, q;
		
		info(int s, int e, int q)
		{this.s = s; this.e = e; this.q = q;}
	}
	
	static int N, C, M;
	static info[] list;
	static int[] left;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static public StringTokenizer read() throws IOException
	{
		return new StringTokenizer(br.readLine());
		
	}
	public int compare(info i1, info i2) {
		
		if(i1.e < i2.e) return -1;
		
		if(i1.e > i2.e) return 1;
		
		return (i1.s <= i2.s) ? -1 : 1;
		
	}
	
	public static void main(String[] args) throws IOException
	{
		StringTokenizer st = read();
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st =read();
		M = Integer.parseInt(st.nextToken());
		
		list = new info[M];
		left = new int[N+1];
		
		for(int i=0; i<M; i++)
		{
			st = read();
			list[i] = new info(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(list, new Comparator<info>(){
			@Override
			public int compare(info i1, info i2) {
				
				if(i1.e < i2.e) return -1;
				
				if(i1.e > i2.e) return 1;
				
				return (i1.s <= i2.s) ? -1 : 1;
				
			}
		});
		
		int ans = 0;
		info now;
		int add;
		
		for(int i=0; i<M; i++)
		{
			now = list[i];
			
			int min = 20000;
			for(int j=now.s; j<now.e; j++) min = Math.min(min, C-left[j]);
			
			if(min <= 0 || min == 20000) continue;
			add = Math.min(min, now.q);
			ans += add;
			
			for(int j=now.s; j<now.e; j++)  left[j] += add;
			
		}
		
		System.out.print(ans);
		
	}

}
