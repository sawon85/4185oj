package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class baekjoon_11559 {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;

	static int[][] map = new int[12][6];
	static boolean[][] visited = new boolean[12][6];
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	static boolean bfs(int y, int x) {
		
		Queue<Point> q = new LinkedList<>();
		Queue<Point> visit = new LinkedList<>();
		q.add(new Point(y, x));
		int now = map[y][x];
		visited[y][x] = true;
		
		Point temp;
		
		int nx, ny;
		
		while(!q.isEmpty()) {
			
			temp = q.poll();
			visit.add(temp);
					
			for(int i=0; i<4; i++) {
				
				nx = temp.x + dx[i]; ny = temp.y + dy[i];
				
				if(nx<0 || nx>=6 || ny<0 || ny>=12) continue;
				
				if(visited[ny][nx]) continue;
				if(map[ny][nx]!=now) continue;
				
				visited[ny][nx] = true;
				q.add(new Point(ny, nx));
				
			}
			
		}
		
		if(visit.size()>=4) {
			
			while(!visit.isEmpty()) {
					
				temp = visit.poll();
				
				map[temp.y][temp.x] = 0;
				
			}	
			
			return true;
		}
		
		return false;
	}
	
	static void mapSet() {
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0; i<6; i++) {
			
			for(int j=11; j>=0; j--) 
				if(map[j][i]!=0) {
				q.add(map[j][i]);
				map[j][i] = 0;
			}
			
		
			int j = 12;
			while(!q.isEmpty()) map[--j][i] = q.poll();
			
		}
		
		
		System.out.println();
		for(int i=0; i<12; i++) {
			for(int j=0; j<6; j++) {
				
			System.out.print(map[i][j] + " ");
				}
			
			System.out.println();
			}
	}
	
	
	static int solution() {
		
		boolean flag = false;
		int cnt = 0;
		
		while(true) {
			
			for(int i=0; i<12; i++) Arrays.fill(visited[i], false);
			
			for(int i=0; i<12; i++) {
				for(int j=0; j<6; j++) {
					
					if(map[i][j] == 0) continue;
					
					if(bfs(i, j)) {
						flag = true;
						mapSet();
						cnt++;
						break;
					}
				}
				
				if(flag) break;
			}
			
			if(flag) {
				flag = false;
				continue;			
			}
			
			return cnt;
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		String s;
		for(int i=0; i<12; i++) {
			s = bf.readLine();
			
			for(int j=0; j<6; j++) {
				
				switch(s.charAt(j)) {
				
				case'.' :
					map[i][j]=0;
					break;
				
				case'R' :
					map[i][j]=1;
					break;
					
				case'G' :
					map[i][j]=2;
					break;
					
				case'B' :
					map[i][j]=3;
					break;
					
				case'P' :
					map[i][j]=4;
					break;
					
				case'Y' :
					map[i][j]=5;
					break;
				
				}
				
			}
			
		}
		
		System.out.println(solution());
		
	}
	
	static class Point{
		
		int x, y;
		
		Point(int y, int x){
			this.x = x; 
			this.y = y;
		}
	}

}
