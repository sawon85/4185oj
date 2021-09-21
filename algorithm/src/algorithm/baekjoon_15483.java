package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_15483 {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;
	
	static int[][] dp = new int[1001][1001];
	
	static String lcs(char[] s1, char[] s2) {
		
		boolean flag; StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<s1.length; i++) {
			flag = false;
			for(int j=0; j<s2.length; j++) {
				
				dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
				if(s1[i]==s2[j]&&!flag) {
					dp[i+1][j+1]++;
					sb.append(s1[i]);
					flag = true;
				}
			}
			
			if(!flag) sb.append('0');
		}
	
		return new String(sb);
	}
	
	public static void main(String[] args) throws IOException{
		
		char[] s1 = bf.readLine().toCharArray(), s2 = bf.readLine().toCharArray();
		
		String result = lcs(s1, s2);
		
		int diff1 = s1.length-dp[s1.length][s2.length];
		int diff2 = s2.length-dp[s1.length][s2.length];
		
		System.out.println(diff1+diff2);
	}

}
