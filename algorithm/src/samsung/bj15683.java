package samsung;

import java.util.*;
import java.io.*;

public class bj15683 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, m;
	static int[][] map;
	static ArrayList<CCTV> cctvs = new ArrayList<CCTV>();
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int ans = Integer.MAX_VALUE;
	static boolean[][] visited;
	
	static boolean[][] cctv1 = {
			{true, false, false, false},
			{false, true, false, false},
			{false, false, true, false},
			{false, false, false, true}
	};
	
	static boolean[][] cctv2 = {
			{true, false, true, false},
			{false, true, false, true},
	};
	
	static boolean[][] cctv3 = {
			{true, true, false, false},
			{false, true, true, false},
			{false, false, true, true},
			{true, false, false, true}
	};
	
	static boolean[][] cctv4 = {
			{true, true, true, false},
			{false, true, true, true},
			{true, false, true, true},
			{true, true, false, true}
	};
	
	static boolean[][] cctv5 = {
			{true, true, true, true},
	};
	
	static boolean[][] getBoard(int num){
		
		switch(num) {
		
		case 1: return cctv1;
		case 2: return cctv2;
		case 3: return cctv3;
		case 4: return cctv4;
		case 5: return cctv5;
		
		}
		
		return null;
	}
	
	static int init() throws IOException {
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken()); m=Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		int cnt=0;
		
		for(int i=0; i<n; i++) {
			
			st=new StringTokenizer(br.readLine());
				
			for(int j=0; j<m; j++) {
				
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==0) continue;
				visited[i][j]=true;
				cnt++;
				if(map[i][j]==6) continue;
				cctvs.add(new CCTV(i, j, map[i][j]));
				
			}
			
		}
		
		
		return cnt;
	}
	
	static void print(boolean[][] visited) {
		
		System.out.println();
		for(int i=0;i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visited[i][j])System.out.print("X ");
				else System.out.print("O ");
			}
			System.out.println();
		}
		
		System.out.println();
	}
	
	static void copy(boolean[][] from, boolean[][] to) {
		
		for(int i=0;i<n; i++) for(int j=0; j<m; j++) to[i][j]=from[i][j];

	}
	
	static void dfs(boolean[][]visited, int cnt, int index) {
		
		if(index==cctvs.size()) {
			ans = Math.min(ans, n*m-cnt);
			return;
		}
		
		boolean[][] tmp = new boolean[n][m];
		copy(visited, tmp);
		
		CCTV c;
		int num;
		c=cctvs.get(index);
		num = c.num;
		int nx, ny;
		boolean[][] board = getBoard(num);
		int count=0;
		
		for(int i=0;i<board.length; i++) {
			
			count=0;	
			for(int j=0; j<4; j++) {
				
				if(!board[i][j]) continue;
				
					ny=c.p.y;
					nx=c.p.x;
					
					while(true) {
						
						ny+=dy[j];
						nx+=dx[j];
							
						if(ny<0||nx<0||ny>=n||nx>=m) break;
						if(map[ny][nx]==6) break;
						if(visited[ny][nx]) continue;
						visited[ny][nx]=true;
						count++;
					
					}
				
			}
			
			dfs(visited,cnt+count,index+1);
			copy(tmp, visited);

		}
		
	}
	

	public static void main(String[] args) throws IOException {
		int cnt = init();
		dfs(visited, cnt,0);
		System.out.println(ans);

	}

	static class CCTV{
		int num;
		Point p;
		
		CCTV(int y, int x, int num){
			p=new Point(y,x);
			this.num=num;
		}
	}
	
	static class Point{
		int y,x;
		
		Point(int y, int x){
			this.y=y;
			this.x=x;
		}
	}
}
