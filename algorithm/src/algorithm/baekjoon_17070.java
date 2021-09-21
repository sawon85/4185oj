package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class baekjoon_17070 {
	

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;
	static int n;
	static int[][][] visited;
	static int[][] map;
	
	
	public static int set() {
		
		visited[0][1][0] = 1;
		
		for(int i=0; i<n; i++) {
			if(map[0][i]==1) break;
			visited[0][i][0] = 1;
		}
		
		for(int i=1; i<n; i++) {
			
			for(int j=2; j<n; j++) {
				
				if(map[i][j]==1) continue;
				
				visited[i][j][0] = visited[i][j-1][0] + visited[i][j-1][2];
				
				visited[i][j][1] = visited[i-1][j][1] + visited[i-1][j][2];
				
				
				if(map[i][j-1]==0 && map[i-1][j]==0) {
					
					visited[i][j][2] = visited[i-1][j-1][0] + visited[i-1][j-1][1] + visited[i-1][j-1][2];
					
				}
 				
			
			}
			
		}
		
		return visited[n-1][n-1][0]+visited[n-1][n-1][1]+visited[n-1][n-1][2];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		n = Integer.parseInt(bf.readLine());
		visited = new int[n][n][3];
		map = new int[n][n];
		
		String s;
		int ans;
		for(int i=0; i<n; i++) {
			s = bf.readLine();
			
			for(int j=0; j<n; j++) map[i][j] = s.charAt(j*2)-'0';
				
		}
		
		System.out.println(set());
		

	}

	static class Point{
		
		int y1, x1;
		int y2, x2;
		int po; // 가로 1 세로 2 
		int cnt;
		
		Point(int y1, int x1, int y2, int x2, int cnt){
			
			this.cnt = cnt;
			
			if((y2==y1&&x1<x2)||y2>y1){

				this.y1=y2; this.x1=x2;
				this.y2=y1; this.x2=x1;
				return;
			}
			
			this.y1=y1; this.x1=x1;
			this.y2=y2; this.x2=x2;		
			
		}
		
	}
}
