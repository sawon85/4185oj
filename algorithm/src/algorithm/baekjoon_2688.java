package algorithm;

import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class baekjoon_2688 {
	
	static int ans = 0;
	
	static Scanner sc = new Scanner(System.in);
	static long dp[][] = new long[65][10];
	
	static void solution() {
		for (int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i <= 64; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = j; k <= 9; k++) {
									dp[i][j] += dp[i - 1][k];
							}
					}
			}
	}
	
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		solution();
		
		int n;
		long ans;
		for(int i=0; i<t; i++) {
		
			ans = 0L;
			n = Integer.parseInt(br.readLine());
			
			for (int j = 0; j <= 9; j++) {
				ans += dp[n][j];
			}
			
			sb.append(""+ans+"\n");
			
		}
		System.out.println(sb.toString());

		
	}

}
