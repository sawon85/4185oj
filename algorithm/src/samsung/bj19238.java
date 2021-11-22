package samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class bj19238 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int[][] map;
	static P taxi;
	static int n, m;
	static P[] pass;
	
	public static void init() throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		taxi = new P(0, 0);
		n=Integer.parseInt(st.nextToken()); m=Integer.parseInt(st.nextToken()); taxi.f=Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		taxi.y=Integer.parseInt(st.nextToken())-1; taxi.x=Integer.parseInt(st.nextToken())-1;
		
		pass = new P[m];
		
		
		int fx, fy, dy, dx;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			fy=Integer.parseInt(st.nextToken())-1; fx=Integer.parseInt(st.nextToken())-1; dy=Integer.parseInt(st.nextToken())-1; dx=Integer.parseInt(st.nextToken())-1;
			map[fy][fx]=i+2;
			pass[i] = new P(dy, dx);
		}
		
	}
	
	public static void print(int[][] visited, int y, int x) {
		/*
		System.out.println();
		System.out.println("dst:" + y+ " " + x);
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}
		*/
		
	}
	public static int bfs2(int y, int x, P d) {
		
		if(taxi.y==d.y&&taxi.x==d.x) return 0;
		
		
		Queue<P> q = new LinkedList<>();
		int[][] visited = new int[n][n];
		visited[y][x]=1;
		q.add(new P(y, x));
		
		int nx, ny;
		P tmp;
		
		while(!q.isEmpty()) {
			
			tmp=q.poll();
			print(visited, d.y, d.x);
			
			for(int i=0; i<4; i++) {
				
				ny = tmp.y+dy[i]; nx = tmp.x+dx[i];
				
				if(ny<0||ny>=n||nx<0||nx>=n) continue;
				if(visited[ny][nx]>0) continue;
				if(map[ny][nx]==1) continue;
				if(ny==d.y&&nx==d.x) {
					if(taxi.f<visited[tmp.y][tmp.x]) return -1;	
					taxi.f+=visited[tmp.y][tmp.x];
					taxi.y=ny;
					taxi.x=nx;
					print(visited, d.y, d.x);
					return visited[tmp.y][tmp.x];
				}
				
				visited[ny][nx] = visited[tmp.y][tmp.x]+1;
				q.add(new P(ny, nx));
				
			}
		}
		
		return -1;
	}
	
	public static int bfs(int y, int x) {
			
		if(map[taxi.y][taxi.x]>1) {
			int index = map[taxi.y][taxi.x]-2;
			map[taxi.y][taxi.x]=0;
			return index;
		}
	
		
		Queue<P> q = new LinkedList<>();
		int[][] visited = new int[n][n];		
		q.add(new P(y, x));
		visited[y][x]=1;
		
		int nx, ny;
		P tmp;
		int count = Integer.MAX_VALUE;
		
		int mx=n, my=n;
		
		while(!q.isEmpty()) {
			
			tmp=q.poll();
			print(visited, 0, 0);
			
			for(int i=0; i<4; i++) {
				
				ny = tmp.y+dy[i]; nx = tmp.x+dx[i];
				
				if(ny<0||ny>=n||nx<0||nx>=n) continue;
				if(visited[ny][nx]>0) continue;
				if(map[ny][nx]==1) continue;
				if(count<visited[tmp.y][tmp.x]+1) continue;
				visited[ny][nx] = visited[tmp.y][tmp.x]+1;
				q.add(new P(ny, nx));
				
				if(map[ny][nx]>1) {
					
					if(count>visited[ny][nx]) {
						count=visited[ny][nx];
						mx=n; my=n;
					}
					
					if(count==visited[ny][nx]) {
						if(my>ny||(my==ny&&nx<mx)) {
							mx=nx; my=ny;
						}
					}
				}
			}
		}
		
		
		if(my==n) return -1;
		
		if(taxi.f<(visited[my][mx]-1)) return -1;
		
		taxi.f=taxi.f-visited[my][mx]+1;
		
		int index = map[my][mx]-2;
		map[my][mx]=0;
		
		taxi.x=mx; taxi.y=my;
		
		return index;
	}
	
	public static int solution() throws IOException {
		
		init();
		
		int index;
		for(int i=0; i<m; i++) {
			index = bfs(taxi.y,taxi.x);
			if(index==-1) return -1;
			index = bfs2(taxi.y, taxi.x, pass[index]);
			if(index==-1) return -1;
		}
		
		return taxi.f;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(solution());

	}
	
	static class P{
		
		int y, x, f;
		
		P(int y, int x){
			this.y=y; this.x=x;
		}
	}

}
