package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baekjoon_9251 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] dp = new int[1001][1001];
	static char[] s1, s2;
	
	public static void print(int i, int j) throws IOException {
		
		if(dp[i][j]==0) return;
		if(s1[i-1]==s2[j-1]) {
			print(i-1, j-1);
			bw.write(s1[i-1]);
			return;
		}
		
		if(dp[i-1][j]>dp[i][j-1]) print(i-1, j);
		else print(i, j-1);
	}
	
	public static void solve(char[] s1, char[] s2) {
		
		for(int i=0;i<s1.length;i++) 
			for(int j=0;j<s2.length;j++) {
				
				if(s1[i]==s2[j]) dp[i+1][j+1] = dp[i][j]+1;	
				else dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
			
			}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		s1 = bf.readLine().toCharArray(); s2 = bf.readLine().toCharArray();
		solve(s1, s2);
		System.out.println(dp[s1.length][s2.length]);
		print(s1.length,s2.length);
		bw.flush(); bw.close();
	}

}
