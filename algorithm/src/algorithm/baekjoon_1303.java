package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_1303 {
	
	static class  Point{
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	
	 static int n, m;
	 static char[][] map;
	 static boolean[][] visited;
	 
	 static Scanner sc = new Scanner(System.in);
	 
	 static int[] xx = {1, -1, 0, 0};	 
	 static int[] yy = {0, 0, 1, -1};	
	 
	 static int black = 0;
	 static int white = 0;
	 
	 public static int bfs(int y, int x, char team) {
		 
		 Queue<Point> q = new LinkedList<>();
		 q.add(new Point(x, y));
		 visited[y][x] = true;
		 int ans = 0;
		 ans++;
		 
		 while(!q.isEmpty()) {
			 
			 Point temp = q.poll();
			 
			 for(int i=0; i<4; i++)
			 {
				 Point newPoint = new Point(temp.x + xx[i], temp.y + yy[i]);
				 if(temp.y + yy[i] >= n || temp.y + yy[i] < 0) continue;
				 if(temp.x + xx[i] >= m || temp.x + xx[i] < 0) continue;
				 if(visited[newPoint.y][newPoint.x]) continue;
				 if(map[temp.y + yy[i]][temp.x + xx[i]] != team) continue;
				 	 
				 q.add(newPoint);				 
				 visited[newPoint.y][newPoint.x] = true;
				 ans++;
				 
				 
			 }
			 
		 }
		 
		 return ans;
		 
	 }
	 
	 public static void solution() {
		 
		 for(int i=0; i<n; i++)
		 {
			 for(int j=0; j<m; j++)
			 {
				 if(visited[i][j]) continue;
				 int cnt = bfs(i,j,map[i][j]);
				 
		
				 
				 if(map[i][j] == 'B') black += Math.pow(cnt, 2);
				 else white += Math.pow(cnt, 2);
				 
			 }
		 }
		 
	 }
	
	 public static void main(String[] args)
	 {
		 
	   	m = sc.nextInt();
		 n = sc.nextInt();
		 map = new char[n][m];
		 visited = new boolean[n][m];
		 
		 for(int i=0; i<n; i++)
		 {
			 String temp = sc.next();
			 for(int j=0; j<m; j++)
			 {
				 map[i][j] = temp.charAt(j);
			 }
		 }
		 
		 
		 solution();
		 
		 System.out.print(white + " " + black);
		 
	 }

}
