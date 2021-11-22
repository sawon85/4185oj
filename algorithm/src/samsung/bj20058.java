package samsung;

import java.io.*;
import java.util.*;

public class bj20058 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n,q;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static StringTokenizer st;
	static int sum=0;
	static int big=0;
	static Queue<P> qq = new LinkedList<>();
	
	static void print(int[][] map) {
		System.out.println();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) System.out.print(map[i][j]+" ");
			System.out.println();
		}
	}
	
	static void storm(int y, int x, int size) {
		
		int[][] tmp=new int[size][size];
		
		for(int i=0; i<size; i++)
			for(int j=0; j<size; j++)
				tmp[i][j] = map[y+size-1-j][x+i];
		
		for(int i=y; i<y+size; i++)
			for(int j=x; j<x+size; j++)
				map[i][j] = tmp[i-y][j-x];
	}
	
	
	static void doL(int l) {
		
		int size=(int)Math.pow(2, l);
		
		int x=0, y=0;
		
		for(;y<n;y+=size) {
			x=0;
			for(;x<n;x+=size) {
				storm(y, x, size);
			}
		}
		
		
		int[][] tmp = new int[n][n];
		int nx, ny;
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++) {
				if(map[i][j]==0) continue;
				
				for(int k=0; k<4; k++) {
					
					ny=i+dy[k];
					nx=j+dx[k];
					
					if(ny<0||ny>=n||nx<0||nx>=n) continue;
					tmp[ny][nx]++;
				}
								
			}
		
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				if(tmp[i][j]<3&&map[i][j]>0) map[i][j]--;
		
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken()); q=Integer.parseInt(st.nextToken());
		n=(int)Math.pow(2, n);
		map=new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}	
		}
	}
	
	public static int bfs(int y, int x, boolean[][] visited) {
		
		int cnt=1;
		qq.add(new P(y,x));
		visited[y][x] = true;
		int ny,nx;
		P tmp;
		while(!qq.isEmpty()) {
			tmp = qq.poll();
			
			for(int i=0; i<4; i++) {
				
				ny = tmp.y+dy[i];
				nx = tmp.x+dx[i];
				
				if(ny<0||ny>=n||nx<0||nx>=n) continue;
				if(visited[ny][nx]) continue;
				if(map[ny][nx]==0) continue;
				
				qq.add(new P(ny, nx));
				visited[ny][nx]=true;
				cnt++;
				
			}

		}
		
		return cnt;
	}
	
	public static void check() {
		
		boolean[][] visited = new boolean[n][n];
		
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++) {
				sum+=map[i][j];
				if(visited[i][j]) continue;
				if(map[i][j]<=0) continue;
				big=Math.max(bfs(i, j, visited), big);
			}
		
	}
	
	public static void solution() throws IOException {
		init();
		
		int l;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<q; i++) {
			l=Integer.parseInt(st.nextToken());
			doL(l);
		}
		
		check();
	}

	public static void main(String[] args) throws IOException {
		solution();
		System.out.println(sum);
		System.out.println(big);
	}

	static class P{
		int y, x;
		
		P(int y, int x){
			this.y=y;
			this.x=x;
		}
	}
}
