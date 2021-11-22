package samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class bj16236 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int n, m;
	static int[][] map;
	static int[] dy = {0, 1, 0, -1};
	static Shark s;
	static int[][] visited;
	static int[] dx = {1, 0, -1, 0};
	
	static void init() throws NumberFormatException, IOException {
		s=new Shark();
		
		n=Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new int[n][n];
		
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j]==9) {
					s.p=new Point(i, j);
					map[i][j]=0;
				}
			}
			
		}
		
	}

	
	static int bfs() {
		
		for(int i=0; i<n; i++) for(int j=0; j<n; j++) visited[i][j]=0;
		
		Queue<Point> q = new LinkedList<>();
		q.add(s.p);
		visited[s.p.y][s.p.x] = 1;
		
		int nx, ny;
		Point p;
		int cnt = Integer.MAX_VALUE;
		Point tmp;
		int ansy=n, ansx=n;
		while(!q.isEmpty()) {
			
			p=q.poll();
			
			for(int i=0; i<4; i++) {
				
				ny=p.y+dy[i]; nx=p.x+dx[i];
			
				if(ny<0||ny>=n||nx<0||nx>=n) continue;
				if(map[ny][nx]>s.w) continue;
				if(visited[ny][nx]>0) continue;
				if(visited[p.y][p.x]+1>cnt) continue;
				visited[ny][nx]=visited[p.y][p.x]+1;
				
				tmp = new Point(ny, nx);
				q.add(tmp);
				
				//잡아먹기 가능 
				if(0<map[ny][nx]&&map[ny][nx]<s.w) {
					
					if(cnt>visited[p.y][p.x]+1) {
						cnt=visited[p.y][p.x]+1;
					}
					
					if(cnt==visited[ny][nx]) {
						if(ansy>ny||(ansy==ny&&ansx>nx)) {
							ansy=ny;
							ansx=nx;
						}
					}
					
				}
			}
		}
		
		//잡아먹기
		
		if(ansy==n) return -1;
		
		s.count++;
		if(s.count==s.w) {
			s.w++;
			s.count=0;
		}
		
		map[ansy][ansx]=0;
		s.p.y=ansy; 
		s.p.x=ansx;
		
		
		return visited[ansy][ansx]-1;
	}
	
	static int solution() throws NumberFormatException, IOException {
		
		init();
		int time=0;
		
		int num;
		while(true) {
			num = bfs();
			if(num==-1) break;
			time+=num;
		}
		
		return time;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println(solution());
	}
	
	static class Point{
		int y, x, cnt;
		
		Point(int y, int x){
			this.y=y; this.x=x;
		}
	}

	
	static class Shark{
		int count=0;
		int w=2;
		Point p;
	}
}
