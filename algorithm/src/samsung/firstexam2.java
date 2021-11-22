package samsung;

import java.io.*;
import java.util.*;

public class firstexam2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int m;
	
	public static void init() throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j=0; j<n; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
	}
	
	public static I getI(int[][] visited, int y, int x, int num, int what) {
		
		I ans = new I(num, y, x);
		Queue<P> q = new LinkedList<>();
		q.add(new P(y, x));
		visited[y][x] = num;
		ans.count=1;
		
		int nx, ny;
		
		P tmp;
		while(!q.isEmpty()) {
			
			tmp = q.poll();
			
			for(int i=0; i<4; i++) {
				
				ny = tmp.y+dy[i];
				nx = tmp.x+dx[i];
				
				if(ny<0||ny>=n||nx<0||nx>=n) continue;
				if(map[ny][nx]!=0&&map[ny][nx]!=what) continue;
				if(visited[ny][nx]==num) continue;
				visited[ny][nx] = num;

				ans.count++;
				
				if(map[ny][nx]==0) ans.rainbow++;
				
				else {
					
					if(ny==ans.y) {
						
						if(nx<ans.x) {
							ans.x=nx;
							ans.y=ny;
						}
						
					}
					
					else if(ny<ans.y) {
						ans.x=nx;
						ans.y=ny;
					}
					
				}

				q.add(new P(ny, nx));
				
			}
		}
		
		return ans;
	}
	
	
	public static void bfs(int y, int x, int what) {
		
		Queue<P> q = new LinkedList<>();
		q.add(new P(y, x));
		map[y][x]=-2;
		
		int nx, ny;
		
		P tmp;
		
		while(!q.isEmpty()) {
			
			tmp = q.poll();
			
			for(int i=0; i<4; i++) {
				
				ny = tmp.y+dy[i];
				nx = tmp.x+dx[i];
				
				if(ny<0||ny>=n||nx<0||nx>=n) continue;
				if(map[ny][nx]!=0&&map[ny][nx]!=what) continue;
				map[ny][nx]=-2;
				q.add(new P(ny, nx));
			}
		}
		
	}
	
	public static int turn() {
		
		PriorityQueue<I> pq = new PriorityQueue<I>();
		
		int num=1;
		int[][] visited = new int[n][n];
		I tmp;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]<=0) continue;
				if(visited[i][j]>0) continue;
				tmp = getI(visited, i, j, num++, map[i][j]);
				if(tmp.count<2) continue;
				pq.add(tmp);
			}
		}
		
		if(pq.isEmpty()) return -1;
		tmp = pq.poll();
		bfs(tmp.y, tmp.x, map[tmp.y][tmp.x]);
			
		return tmp.count*tmp.count;
	}
	
	public static void rotate() {
		
		int[][] tmp = new int[n][n];
		
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
					tmp[i][j] = map[j][n-1-i];
		
		map=tmp;
		
	}
	
	public static void gravity() {
		
		int y,x;
		Queue<Integer> q = new LinkedList<>();
		
		int st;
		for(int i=0; i<n; i++) {
			y=n-1;
			x=i;
			st=y;
			
			while(y>=0) {
				
				if(map[y][x]==-1) {
					
					while(!q.isEmpty()) {
						map[st--][x] = q.poll();
					}
					
					for(; st>y; st--) map[st][x] = -2;
					
					st=y-1;
					
				}
				else if(map[y][x]>=0) q.add(map[y][x]);
				
				y--;
			}
			
			while(!q.isEmpty()) {
				map[st--][x] = q.poll();
			}
			
			for(; st>=0; st--) map[st][x] = -2;
		}
	}
	
	public static int solution() throws IOException {
		init();
		int ans = 0;
		int s;
		while(true) {
			s=turn();
			if(s==-1) return ans;
			ans+=s;
			gravity();
			rotate();
			gravity();

		}
		
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(solution());

	}
	
	static class I implements Comparable<I>{
		
		int num, count, rainbow, y, x;
		
		I(int num, int y, int x){
			this.num=num;
			this.rainbow=0;
			this.y=y;
			this.x=x;
			this.count = 0;
		}
		
		I(int num, int rainbow, int count, int y, int x){
			this.num=num;
			this.rainbow=rainbow;
			this.y=y;
			this.x=x;
			this.count = count;
		}

		@Override
		public int compareTo(I o) {
			
			if(this.count==o.count) {
				
				if(this.rainbow==o.rainbow) {
					
					if(this.y==o.y) return o.x-this.x;
					return o.y-this.y;
				}
				
				return o.rainbow-this.rainbow;
			}
			
			return o.count-this.count;
		}
	}
	
	static class P{
		
		int y, x;
		
		P(int y, int x){
			this.y=y;
			this.x=x;
		}
	}

}
