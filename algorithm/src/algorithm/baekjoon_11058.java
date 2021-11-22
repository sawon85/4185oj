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
	static long[] dp = new long[100+1];
	
	static void solution(int n) {

		for(int i=1; i<n+1; i++) {
			dp[i] = dp[i-1]+1;
			if(i>6) {
				for(int j=2; j<5; j++) {
					dp[i] = Math.max(dp[i], dp[i-(j+1)]*j);
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
	     
	     System.out.println(dp[n]);
	}

}
