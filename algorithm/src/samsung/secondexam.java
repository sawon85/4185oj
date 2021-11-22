package samsung;

import java.io.*;
import java.util.*;

public class secondexam {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] cx = {-1, 1, -1, 1};
	static int[] cy = {1, 1, -1, -1};
	static int n, m;
	static boolean[][] visited;
	static int[][] map;
	static ArrayList<C> cs;
	
	public static void init() throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		map = new int[n][n]; visited = new boolean[n][n];
		cs = new ArrayList<>();
		
		cs.add(new C(n-1,1-1)); cs.add(new C(n-1,2-1)); cs.add(new C(n-2,1-1)); cs.add(new C(n-2,2-1));
		visited[n-1][1-1]=true; visited[n-1][2-1]=true; visited[n-2][1-1]=true; visited[n-2][2-1]=true;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) map[i][j]=Integer.parseInt(st.nextToken());
		}
		
	}
	
	public static void move(int d, int s) {
		
		for(C c : cs) {
			visited[c.y][c.x]=false;
			c.move(d, s);
		}
		
		for(C c : cs) {
			visited[c.y][c.x]=true;
		}
	}
	
	public static void addWater() {
		for(C c : cs) {
			map[c.y][c.x]++;
		}
	}
	
	public static void copy() {
		
		int ny, nx, count;
		
		for(C c : cs) {
			
			count = 0;
			
			for(int i=0; i<4; i++) {
				
				ny = c.y+cy[i]; nx = c.x+cx[i];
				
				if(ny<0||ny>=n||nx<0||nx>=n) continue;
				if(map[ny][nx]==0) continue;
				count++;
				
			}
			
			map[c.y][c.x]+=count;
		}
	}
	
	public static void reset() {
		
		cs.clear();
		
		for(int i=0; i<n; i++) {
			
			for(int j=0; j<n; j++) {
				
				if(visited[i][j]) {
					visited[i][j] = false;
					continue;
				}
				
				if(map[i][j]<2) continue;
				
				map[i][j]-=2;
				cs.add(new C(i, j));
				visited[i][j]=true;
				
			}
		}
		
	}
	
	public static void print() {
		
		System.out.println();
		for(int i=0; i<n; i++) {
			
			for(int j=0; j<n; j++)
				System.out.print(map[i][j]+" ");
			
			System.out.println();
		}
		
	}
	
	public static int solution() throws IOException {
		
		init();
		
		StringTokenizer st;
		int d, s;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken())-1; s = Integer.parseInt(st.nextToken());
			move(d, s);
			addWater();
			copy();
		
			reset();
	
		}
		
		int ans=0;
		for(int i=0; i<n; i++) for(int j=0; j<n; j++) ans+=map[i][j];
		
		return ans;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(solution());
	}

	
	public static class C{
		
		int y, x;
		
		C(int y, int x){
			this.y=y; this.x=x;
		}
		
		void move(int d, int s) {
			
			int ny, nx;
			
			s=s%n;
			
			ny = y+dy[d]*s;
			nx = x+dx[d]*s;
			
			if(ny<0) ny=n+ny;
			if(nx<0) nx=n+nx;
			if(ny>=n) ny=ny-n;
			if(nx>=n) nx=nx-n;
			
			x=nx;
			y=ny;
		}
	}
}
