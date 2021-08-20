package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon_18428 {

	
	static class Point{
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static Scanner sc = new Scanner(System.in);
	
	static char[][] map;
	static int n;
	static int[] xx = {-1, 1, 0, 0};
	static int[] yy = {0, 0, -1, 1};
	
	static ArrayList<Point> teachers = new ArrayList<>();
	
	
	static Point index2point(int i) {
		return new Point(i%n, i/n);
	}
	
	static boolean canBeTrap(Point point) {
		return map[point.y][point.x] == 'X';
	}
	
	
	static boolean solution() {
		
		
		for(Point teacher : teachers) {
			
			for(int i=0; i<4; i++) {
				int x = teacher.x, y=teacher.y;
				while(true) {
				
					x += xx[i];
					y += yy[i];
					
					if(x < 0 || x>=n) break;
					if(y < 0 || y>=n) break;
					if(map[y][x] == 'S') return false;
					if(map[y][x] == 'G') break;
				
				}
				
			}
			
		}
		
		return true;
	}
	
	static boolean dfs() {
		
		Point x, y, z;
		for(int i=0; i<n*n-2; i++) {
			x = index2point(i);
			if(!canBeTrap(x)) continue;
			
			for(int j=i+1; j<n*n-1; j++) {
				y = index2point(j);
				if(!canBeTrap(y)) continue;
				
				for(int k=j+1; k<n*n; k++) {
					z = index2point(k);
					if(!canBeTrap(z)) continue;
					
					map[x.y][x.x] = 'G';  map[y.y][y.x] = 'G'; map[z.y][z.x] = 'G';
					if(solution()) return true;
					map[x.y][x.x] = 'X';  map[y.y][y.x] = 'X'; map[z.y][z.x] = 'X';
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		n = sc.nextInt();
		map = new char[n][n];

		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++) {
				
				String temp = sc.next();
				map[i][j] = temp.charAt(0);
				
				if(map[i][j] == 'T') {
					teachers.add(new Point(j, i));
				}
				
			}
			
		}
		
		if(dfs()) System.out.print("YES");
		else System.out.print("NO");
		
	}
}
