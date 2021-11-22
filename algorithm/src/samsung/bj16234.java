package samsung;

import java.io.*;
import java.util.*;

public class bj16234 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n,l,r;
	static int[][] map;
	static Queue<P> q = new LinkedList<>();
	static Queue<P> v = new LinkedList<>();
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	
	public static void init() throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken()); l=Integer.parseInt(st.nextToken()); r=Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		q.clear();
		v.clear();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		

	}
	
	public static boolean bfs(int y, int x, boolean[][] visited) {
		v.clear();
		P p = new P(y, x);
		visited[y][x] = true;
		q.add(p);
		v.add(p);
		
		int ny, nx;
		int diff;
		int sum=map[y][x];
		
		P tmp;
		while(!q.isEmpty()) {
			
			p = q.poll();
			
			for(int i=0; i<4; i++) {
				
				ny=p.y+dy[i]; nx=p.x+dx[i];
				
				if(ny<0||ny>=n||nx<0||nx>=n) continue;
				if(visited[ny][nx]) continue;
				diff = Math.abs(map[ny][nx]-map[p.y][p.x]);
				if(diff<l||diff>r) continue;
				visited[ny][nx]=true;
				sum+=map[ny][nx];
				tmp = new P(ny, nx);
				q.add(tmp);
				v.add(tmp);
			}
			
		}
		
		if(v.size()<=1) return false;
		
		int value = sum/v.size();
		
		while(!v.isEmpty()) {
			p = v.poll();
			map[p.y][p.x] = value;
		}
		
		return true;
	}
	
	public static void print() {
		
		System.out.println();
		for(int i=0; i<n; i++) {
			
			for(int j=0; j<n; j++)
				System.out.print(map[i][j]+" ");
			
			System.out.println();
		}
	}
	
	public static boolean dfs() {
		
		boolean[][] visited = new boolean[n][n];
		
		boolean flag = false;
		
		for(int i=0; i<n; i++) 
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) if(bfs(i, j, visited)) flag=true;
				
			}
		
		return flag;
		
	}
	
	public static int solution() throws IOException {
		
		init();
		
		int time=0;
		
		while(true) {
			if(!dfs()) return time;
			time++;
		}
		
	}

	public static void main(String[] args) throws IOException {
		System.out.println(solution());
	}
	
	public static class P{
		
		int y, x;
		
		P(int y, int x){
			this.y=y; this.x=x;
		}
		
	}

}
