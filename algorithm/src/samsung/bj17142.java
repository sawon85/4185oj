package samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class bj17142 {
	
	static int n, m;
	static ArrayList<P> virus;
	static int[][] map;
	static int[] dx = {-1 ,0, 1, 0};
	static int[] dy = {0, -1 ,0, 1};
	static int ans = Integer.MAX_VALUE;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static void print(int[][] map) {
		
		System.out.println();
		for(int i=0; i<n; i++) {
			
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j]+" ");
				
			}
			System.out.println();
		}
		
	}
	
	public static void init() throws IOException {
		virus = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		ans = Integer.MAX_VALUE;
		
		for(int i=0; i<n; i++)
		{
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				
				if(map[i][j]==2) {
					virus.add(new P(i, j));
				}
				
			}
			
		}
	}
	
	public static int bfs(boolean[] visited) {
		
		int[][] cnt = new int[n][n];
		Queue<P> q = new LinkedList<>();
		
		for(int i=0; i<visited.length; i++) 
			if(visited[i]) {
				q.add(virus.get(i));
				cnt[virus.get(i).y][virus.get(i).x]=1;
			}
		
		int nx, ny;
		int ans = 1;
		
		P tmp;
		while(!q.isEmpty()) {
			
			tmp = q.poll();
			
			for(int i=0; i<4; i++) {
				
				nx = tmp.x+dx[i]; 	ny = tmp.y+dy[i];
				
				if(nx<0||nx>=n||ny<0||ny>=n) continue;
				if(map[ny][nx]==1) continue; //
				if(cnt[ny][nx]!=0&&cnt[ny][nx]<=cnt[tmp.y][tmp.x]+1) continue; //방문했는데, 가려는 곳보다같거나 작아.
				cnt[ny][nx]=cnt[tmp.y][tmp.x]+1;
				if(map[ny][nx]==0) ans=Math.max(ans, cnt[ny][nx]);
				q.add(new P(ny, nx));
			}
			
		}
		
		for(int i=0; i<n; i++) for(int j=0; j<n; j++) if(map[i][j]!=1&&cnt[i][j]==0) return -1;
		
		return ans-1;
	}

	
	public static void dfs(boolean[] visited, int index, int cnt) {
		
		if(cnt==m) {
			int result = bfs(visited);
			if(result==-1) return;
			ans = Math.min(ans, result);
			return;
		}
		
		if(index==visited.length) return;
		
		visited[index]=true;
		dfs(visited, index+1, cnt+1);
		visited[index]=false;
		dfs(visited, index+1, cnt);
	}
	
	public static int solution() throws IOException {
		init();
		dfs(new boolean[virus.size()], 0, 0);
		if(ans==Integer.MAX_VALUE) return -1;
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(solution());
	}

	static class P{
		int y ,x;
		
		P(int y, int x){
			this.y=y; this.x=x;
		}
	}
}
