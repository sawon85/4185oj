package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import javax.swing.text.AbstractDocument.BranchElement;

public class baekjoon_2096 {
	
	static int[][] board;
	static int[][] max;
	static int[][] min;
	static int n;
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static void left(int i) {
		
		max[i][0] = Math.max(max[i-1][0]+board[i][0], max[i-1][1]+board[i][0]);
		min[i][0] = Math.min(min[i-1][0]+board[i][0], min[i-1][1]+board[i][0]);
		
	}
	
   static void center(int i) {
		
		max[i][1] = Math.max(max[i-1][0]+board[i][1], max[i-1][1]+board[i][1]);
		max[i][1] = Math.max(max[i][1], max[i-1][2]+board[i][1]);
		min[i][1] = Math.min(min[i-1][0]+board[i][1], min[i-1][1]+board[i][1]);
		min[i][1] = Math.min(min[i][1], min[i-1][2]+board[i][1]);
		
	}
	
   
	static void right(int i) {
		
		max[i][2] = Math.max(max[i-1][1]+board[i][2], max[i-1][2]+board[i][2]);
		min[i][2] = Math.min(min[i-1][1]+board[i][2], min[i-1][2]+board[i][2]);
		
	}
	
	static void init() {
		
		max[0][0] = min[0][0] = board[0][0]; 
		max[0][1] = min[0][1] = board[0][1];
		max[0][2] = min[0][2] = board[0][2];
		
	}

	static void solution() {
		
		init();
		
		for(int i=1; i<n; i++) {
			left(i); center(i); right(i);	
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		
		
		n = Integer.parseInt(bf.readLine());
		board = new int[n][3]; max = new int[n][3];  min = new int[n][3]; 
		
		String s;
		StringTokenizer st;
		
		for(int i=0; i<n; i++) {
			s = bf.readLine(); st = new StringTokenizer(s);
			
			board[i][0] = Integer.parseInt(st.nextToken());
			board[i][1] = Integer.parseInt(st.nextToken());
			board[i][2] = Integer.parseInt(st.nextToken());
			
		}
		
		solution();
		
		int ans_max = Math.max(max[n-1][0], Math.max( max[n-1][1], max[n-1][2]));
		int ans_min = Math.min(min[n-1][0], Math.min( min[n-1][1], min[n-1][2]));
		
		bw.write(ans_max+" "+ans_min);
		bw.flush();
		bw.close();
		
	}
	

}
