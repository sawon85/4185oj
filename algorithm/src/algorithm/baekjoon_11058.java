package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_11058 {
	
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;
	static long[][] dp = new long[100+1][2];
	
	static void solution(int n) {
		
		dp[1][0] = 1; dp[1][1] = 0;
		
		
		for(int i=2; i<=n; i++) {
			
			dp[i][0] = Math.max(dp[i-1][0]+1,dp[i-1][0]+dp[i-1][1]);
			dp[i][1] = dp[i-1][1];
			
			if(i>4) {
				if(dp[i][0] <= dp[i-3][0]*2) {
					dp[i][0] = dp[i-3][0]*2;
					dp[i][1] = dp[i-3][0];
				}
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     String s;
	
	     int n = Integer.parseInt(br.readLine());
	     solution(n);
	     
	     System.out.println(dp[n][0]);
	}

}
