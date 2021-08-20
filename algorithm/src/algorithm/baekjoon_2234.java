package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class baekjoon_2234 {
	
	static int[] xx = {-1 ,1, 0, 0};
	static int[] yy = {0, 0, -1, 1};
	
	static int[][] map;
	static int[][] room;
	static int n, m;
	
	static int maxPeopleCnt = 0;
	static ArrayList<Integer> peoplePerRoom = new ArrayList<Integer>();
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static Set<Integer> getDirection(int wall) {
		
		Set<Integer> arr = new HashSet<>();
		arr.add(0); arr.add(1); arr.add(2); arr.add(3);
		
		if((wall&1) == 1) arr.remove(0);
		if((wall&2)==2) arr.remove(2);
		if((wall&4)==4) arr.remove(1);
		if((wall&8)==8) arr.remove(3);
		
		return arr;
	}
	
	static int getMaxPeopleAfterDestory() {
		
		int x2;
		int y2;
		int maxCnt = 0;

		for(int y=0; y<m; y++)
			for(int x=0; x<n; x++) {
	
				for(int i=0; i<4; i++) {
					
					x2 = x + xx[i]; y2 = y + yy[i];
					
					if(x2<0||x2>=n||y2<0||y2>=m) continue;
					if(room[y][x]==room[y2][x2]) continue;
					
					maxCnt = Math.max(maxCnt, peoplePerRoom.get(room[y][x]-1) + peoplePerRoom.get(room[y2][x2]-1));
					
				}
				
			}
		
		return maxCnt;
		
	}
	
	static int bfs(int roomNumber, int y, int x) {
		
		Queue<Point> q = new LinkedList<>();
		room[y][x] = roomNumber;
		q.add(new Point(y,x));
		
		int y2, x2;
		Point tmp;
		Set<Integer> indexs;
		
		int roomCnt = 1;
		
		while(!q.isEmpty()) {
			tmp = q.poll();
			indexs = getDirection(map[tmp.y][tmp.x]);
			
			for(Integer i : indexs) {
				x2 = tmp.x+xx[i];
				y2 = tmp.y+yy[i];
				
				if(y2<0||y2>=m||x2<0||x2>=n) continue;
				if(room[y2][x2] > 0) continue;
					
				room[y2][x2] = roomNumber;
				
				q.add(new Point(y2, x2));
				roomCnt++;
				
			}
			
		}
		
		return roomCnt;
		
	}

	static int dfs() {
		
		int roomNum = 0;
		int cnt;
		
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
			{
				if(room[i][j] > 0) continue;
				cnt = bfs(++roomNum, i ,j);
				peoplePerRoom.add(cnt);
				maxPeopleCnt = Math.max(maxPeopleCnt, cnt);
				
			}
		
		return roomNum;
	}
	

	public static void print() {
		
		for(int i=0; i<m; i++) {
			
			for(int j=0; j<n; j++) System.out.print(room[i][j] +" ");
			
			System.out.print("\n");
		}
	}
	
	
	 public static void main(String[] args) throws Exception {

		 String s;
		 
		 s = bf.readLine();
		 StringTokenizer st = new StringTokenizer(s);
		 
		 n = Integer.parseInt(st.nextToken());  m = Integer.parseInt(st.nextToken()); 
		 
		 map = new int[m][n];
		 room = new int[m][n];
		 
		 for(int i=0; i<m; i++)
		 {
			 s = bf.readLine();
			 st = new StringTokenizer(s);
			 for(int j=0; j<n; j++) map[i][j] = Integer.parseInt(st.nextToken());
		 }
		 
		 
		 int roomCnt = dfs();
		 int maxPeopleAfterDestory = getMaxPeopleAfterDestory();
		 
		 System.out.println(roomCnt);
		 System.out.println(maxPeopleCnt);
		 System.out.println(maxPeopleAfterDestory);
		 
	   }

	 
	 public static class Point {
		 
		 int x, y;
		 
		 public Point(int y, int x) {
			 this.y = y; this.x = x;
		 }
		 
	 }
}
