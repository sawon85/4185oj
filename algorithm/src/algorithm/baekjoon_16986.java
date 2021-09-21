package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_16986 {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;

	static int[][] board;
	static int[] jiwoo;
	static int[] kyung = new int[20];
	static int[] min = new int[20];
	static int[] score = new int[3]; //지우 0 경희1 민호2 
	static int n, k;
	static boolean[] visited;
	
	static boolean vs(int n1, int n2) { //앞 사람이 이기면 true	
		if(board[n1][n2]==2) return true;
		return false;
	}
	
	
	static boolean solution() {
		
		int jiwoo_idx=0, kyung_idx=0, min_idx=0;
		for(int i=0; i<3; i++) score[i] = 0;
		
		
		while(true) {
			
			
		}
		
		while(true) {
		
			if(vs(jiwoo[jiwoo_idx++], kyung[kyung_idx++])) score[0]++;
			else score[1]++;
			
			if(score[0]==k) return true; if(score[1]==k) return false;
			if(jiwoo_idx==n) return false;
			
			if(vs(kyung[kyung_idx++], min[min_idx++])) score[1]++;
			else score[2]++;
			
			if(score[1]==k) return false; if(score[2]==k) return false;
			
			if(vs(jiwoo[jiwoo_idx++], min[min_idx++])) score[0]++;
			else score[2]++;
			
			if(score[0]==k) return true; if(score[2]==k) return false;			
			if(jiwoo_idx==n) return false;
			
			
			if(jiwoo_idx==20 || jiwoo_idx==n) return false;
			
		}
	}
	
	static boolean dfs(int index) {
		
		if(index==20||index==n) {
			if(solution()) {
				for(int i=0; i<n; i++) System.out.print(jiwoo[i]+" ");
				System.out.println();
				return true;
			}
			return false;
		}
		
		for(int i=0; i<n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			jiwoo[index] = i;
			if(dfs(index+1)) return true;
			visited[i] = false;
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException{
		s = bf.readLine(); st = new StringTokenizer(s);
		n = Integer.parseInt(st.nextToken());  k = Integer.parseInt(st.nextToken()); 
		
		board = new int[n][n]; visited = new boolean[n]; jiwoo = new int[n];
		for(int i=0; i<n; i++) {
			s = bf.readLine(); st = new StringTokenizer(s);
			for(int j=0; j<n; j++) board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		s = bf.readLine(); st = new StringTokenizer(s);
		for(int i=0; i<20; i++) kyung[i] = Integer.parseInt(st.nextToken())-1;
		
		s = bf.readLine(); st = new StringTokenizer(s);
		for(int i=0; i<20; i++) min[i] = Integer.parseInt(st.nextToken())-1;
		
		if(dfs(0)) System.out.println(1);
		else System.out.println(0);
	}
}
