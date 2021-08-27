package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon_1600 {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] xx  = {-1, 1, 0, 0}, yy = {0, 0, 1, -1};
	static int[] xx2 = {-2, -1, 1, 2, -2, -1, 1, 2}; static int[] yy2 = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int w, h;
	static int[][] map;
	static int[][][] visited;
	static int k;
	
	static void push(Queue<Point> q, int y, int x, int k, int cnt) {
		
		if(y<0||y>=h||x<0||x>=w) return;
		if(map[y][x]>0) return;
		if(visited[y][x][0]!=0 &&visited[y][x][1]!=0&& visited[y][x][0]<cnt+1) return;
		if(visited[y][x][0]==cnt+1 && visited[y][x][1]>=k) return;
		q.add(new Point(y, x, k));
		visited[y][x][0] = cnt+1;
		visited[y][x][1] = k;
		
	}
	
	static void Print() {
		
		System.out.println();
		
		for(int i=0; i<h; i++)
		{
			for(int j=0; j<w; j++)
				System.out.print(visited[i][j][0]+" ");
			
			System.out.println();
		}
		
	}
	
	static void bfs() {
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0,0));
		visited[0][0][0] = 1;
		Point tmp;
		
		int newx; int newy;
		while(!q.isEmpty()) {
			tmp = q.poll();
			Print();
			if(tmp.y==h-1 && tmp.x==w-1) break;
			//System.out.println(tmp.y + " " + tmp.x + " " + visited[tmp.y][tmp.x][0] + " " + visited[tmp.y][tmp.x][1]);
			
			for(int i=0; i<4; i++) {	
				newx = tmp.x+xx[i]; newy = tmp.y+yy[i];
				push(q, newy, newx, tmp.k, visited[tmp.y][tmp.x][0]);	
			}
			
			
			if(tmp.k<k)
			for(int i=0; i<8; i++) {	
				newx = tmp.x+xx2[i]; newy = tmp.y+yy2[i];
				push(q, newy, newx, tmp.k+1, visited[tmp.y][tmp.x][0]);	
			}
			
			Stack<Integer> st = new Stack();
			st.poll
		
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		
		k = Integer.parseInt(bf.readLine());
		String s; StringTokenizer st;
		
		s = bf.readLine(); st = new StringTokenizer(s);
		w = Integer.parseInt(st.nextToken());  h = Integer.parseInt(st.nextToken()); 
		map = new int[h][w]; visited = new int[h][w][2];
		
		for(int i=0; i<h; i++)
		{
			s = bf.readLine(); st = new StringTokenizer(s);
			for(int j=0; j<w; j++) map[i][j] = Integer.parseInt(st.nextToken()); 
		}
		
		bfs();
		
		System.out.println(visited[h-1][w-1][0]-1);
		
	}

	static class Point {
		
		public int x, y, k;
		
		Point(int y, int x, int k){
			this.y = y;
			this.x = x;
			this.k = 0;
		}
		
	}

}
