package samsung;

import java.io.*;
import java.util.StringTokenizer;

public class bj14503 {
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int[][] map;
	static boolean[][] visited;
	static int n, m;
	static C c;
	
	static void init() throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		map = new int[n][m]; visited = new boolean[n][m];
		
		st = new StringTokenizer(br.readLine());
		int y= Integer.parseInt(st.nextToken()),x=Integer.parseInt(st.nextToken()), d= Integer.parseInt(st.nextToken());
		c = new C(y, x, d);
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
	}
	
	static boolean sholdGo(int y, int x) {
		
		if(y<0||y>=n||x<0||x>=m) return false;
		if(map[y][x]==1) return false;
		if(visited[y][x]) return false;
		return true;
	}
	
	static boolean move() {
		
		
		int d = c.d;
		
		int ny, nx, nd;
		boolean flag = false;
		for(int i=0; i<4; i++) {
			
			nd = (d+4-i-1)%4;
			
			ny = c.y+dy[nd]; nx = c.x+dx[nd];
			
			if(!sholdGo(ny,nx)) continue;
			flag = true;
			c.y=ny;
			c.x=nx;
			c.d=nd;
			visited[ny][nx]=true;
			break;
			
		}
		
		return flag;
	}
	
	static boolean canBack() {
		
		int d = c.d;
		int newd = (d+2)%4;
		
		int ny = c.y+dy[newd], nx=c.x+dx[newd];
		
		if(ny<0||ny>=n||nx<0||nx>=m) return false;
		if(map[ny][nx]==1) return false;
		
		c.y=ny; c.x=nx;
		return true;
	}
	
	static int solution() throws IOException	{
		
		init();
		
		visited[c.y][c.x]=true;
		
		while(true) {	
			if(!move()) if(!canBack()) break;
		}
		
		int cnt=0;
		
		for(int i=0; i<n; i++) for(int j=0; j<m; j++) if(visited[i][j]) cnt++;
		
		return cnt;
		
	}
	public static void main(String[] args) throws IOException{
		System.out.println(solution());
	}
	
	static class C{
		
		int y, x, d;
		
		C(int y, int x, int d){
			this.y=y; this.x=x; this.d=d;
		}
		
	}

}
