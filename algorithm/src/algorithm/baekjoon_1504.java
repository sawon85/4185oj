package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_1504 {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;
	static long[][] g;
	static int n, e;
	
	static void init() {
		for (int i = 1; i <= n; i++) 
			for (int j = 1; j <= n; j++) 
			{
				if(i==j) g[i][j] = 0;
				else g[i][j] = 800000000;
			}
	}
	
	static void ployd() {
		
		for (int k = 1; k <= n; k++)
			for (int i = 1; i <= n; i++)
				for (int j = 1; j <= n; j++) {
					if (g[i][j] <=  g[i][k] + g[k][j]) continue;
						g[i][j] = g[i][k] + g[k][j];
				}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		s = bf.readLine(); st = new StringTokenizer(s);
		n = Integer.parseInt(st.nextToken()); e = Integer.parseInt(st.nextToken());
		g = new long[n+1][n+1];
		init();
		
		int from, to, w;
		for(int i=0; i<e; i++) {
			s = bf.readLine(); st = new StringTokenizer(s);
			from = Integer.parseInt(st.nextToken()); to =Integer.parseInt(st.nextToken()); w = Integer.parseInt(st.nextToken());
			if(g[from][to]<=w) continue;
			g[from][to] = w; g[to][from] = w;
		}
		
		ployd();
		
		int n1, n2;
		s = bf.readLine(); st = new StringTokenizer(s);
		n1 = Integer.parseInt(st.nextToken()); n2 = Integer.parseInt(st.nextToken());
		
		long result = Math.min(g[1][n1]+g[n1][n2]+g[n2][n], g[1][n2]+g[n2][n1]+g[n1][n]);
		if(result>=800000000) result = -1;
		System.out.println(result);
	}
}
