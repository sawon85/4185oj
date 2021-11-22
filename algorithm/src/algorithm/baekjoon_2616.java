package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_2616 {
	
	static int[][] dp = new int[50002][4];
	static int[] train;
	static int n;
	static int gap;
	static int[] sum;
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static void solution() {
		
		sum[1] = train[0];
		for(int i=2; i<=n; i++)
			sum[i] = sum[i-1] + train[i-1];
		
		for (int i=1; i<4; i++) 
			for(int j=i*gap; j<=n; j++) 		
				dp[j][i] = Math.max(dp[j-1][i], dp[j-gap][i-1]+(sum[j] - sum[j-gap]));
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		n = Integer.parseInt(bf.readLine());
		train = new int[n];
		sum = new int[n+1];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for(int i=0; i<n; i++) train[i] = Integer.parseInt(st.nextToken());
		
		gap = Integer.parseInt(bf.readLine());
		
		solution();
		
		System.out.println(dp[n][3]);

	}

}
