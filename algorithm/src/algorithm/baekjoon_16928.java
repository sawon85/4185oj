package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_16928 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    static StringBuilder sb = new StringBuilder();
	
	static int xx[] = {-1, 1, 0, 0};
	static int yy[] = {0, 0, 1, -1};
	
	static int[][] map = new int[201][201];
	static int r, c, n;
	
	
	static void boom(int y, int x) {
		
		int x1, y1;
		for(int i=0; i<4; i++) {

			x1 = x+xx[i];
			y1 = y+yy[i];
			
			if(x1<0 || x1>=c || y1<0 || y1>=r) continue;
			if(map[y1][x1]<2) continue;
			
			map[y1][x1] = 0;
			
		}
		
		map[y][x] = 0;
	}
	
	static void allBoom() {
		
		for(int i=0; i<r; i++) 
			for(int j=0; j<c; j++) {
				
				if(map[i][j] == 1) boom(i, j);
				
			}
		
		time();
	
	}
	
	static void time() {
		
		for(int i=0; i<r; i++) 
			for(int j=0; j<c; j++)
				if(map[i][j]>0) map[i][j]--;

	}
	
	static void makeBomb() {
		
		for(int i=0; i<r; i++) 
			for(int j=0; j<c; j++)
			{
				if(map[i][j]==0) map[i][j] = 3;
				else map[i][j]--;
			}
		
		//time();
	}
	
	static void print() throws IOException {
		
		for(int i=0; i<r; i++) 
		{
			for(int j=0; j<c; j++) {
				if(map[i][j]==0) bw.write('.');
				else bw.write('O');
			}
			bw.write('\n');
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		r = Integer.parseInt(st.nextToken()); c = Integer.parseInt(st.nextToken()); n = Integer.parseInt(st.nextToken());
        
		for(int i=0; i<r; i++) {
			s = br.readLine();
			
			for(int j=0; j<s.length(); j++) {
				
				if(s.charAt(j)=='.') map[i][j] = 0;
				else map[i][j] = 3;
				
			}
		}
		
		time();
		n--;
		
		while(n>0) {
			makeBomb(); if(--n==0) break;
			allBoom(); if(--n==0) break;
		}
		
		print();
		
		bw.flush();
		bw.close();
		
	}

}
