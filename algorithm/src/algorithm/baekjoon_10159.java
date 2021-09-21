package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_10159 {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;
	
	static int n;
	static int[][] distance1;
	static int[][] distance2;
	
	public static void init(int[][] distance) {
		for(int i=1; i<distance.length; i++)
			for(int j=1; j<distance[0].length; j++)
				if(i!=j)distance[i][j] = 20000;
	}
	
	public static void floydWarshall(int[][] distance) {

		for(int k = 1; k <= n; k++) 
			for(int i=1; i <= n; i++) 
				for(int j=1; j <= n; j++) 
                  distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]);

	} 
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		n = Integer.parseInt(bf.readLine());
		distance1 = new int[n+1][n+1];
		distance2 = new int[n+1][n+1];
		int m = Integer.parseInt(bf.readLine());
		init(distance1); init(distance2);
		
		int from, to;
		
		for(int i=0; i<m; i++) {
			s = bf.readLine(); st = new StringTokenizer(s);
			from = Integer.parseInt(st.nextToken()); to = Integer.parseInt(st.nextToken());
			distance1[from][to] = 1;
			distance2[to][from] = 1;
		}

		floydWarshall(distance1); floydWarshall(distance2);
		
		int cnt;
		for(int i=1; i<=n; i++) {
			cnt = 0;
			for(int j=1; j<=n; j++) if(distance1[i][j]>=20000 && distance2[i][j]>=20000) cnt++;
			bw.append(cnt+"\n");
		}
		
		bw.flush(); bw.close();
	}

}
