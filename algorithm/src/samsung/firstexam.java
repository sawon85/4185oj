package samsung;

import java.io.*;
import java.util.*;

public class firstexam {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int[][] map;
	static ArrayList<Integer>[] s;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, 1, -1, 0};
	static PriorityQueue<D> pq = new PriorityQueue<>();
	static Queue<Integer> q = new LinkedList<>();
	
	public static void init() throws NumberFormatException, IOException {
		
		n = Integer.parseInt(br.readLine());
		
		s = new ArrayList[n*n];
		map = new int[n][n];
		
		pq.clear();
		q.clear();
		
		int num;
		StringTokenizer st;
		for(int i=0; i<n*n; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			num = Integer.parseInt(st.nextToken());
			s[num-1] = new ArrayList<>();
			q.add(num);
			
			for(int j=0; j<4; j++) {
				s[num-1].add(Integer.parseInt(st.nextToken()));
			}
			
		}
		
	}
	
	public static int getLikeStu(int y, int x, int num) {
		
		
		int ny, nx;
		int count = 0;
		for(int i=0; i<4; i++) {
			
			ny = y + dy[i];
			nx = x + dx[i];
			
			if(ny<0||ny>=n||nx<0||nx>=n) continue;
			
			if(s[num-1].contains(Integer.valueOf(map[ny][nx]))) count++;
		}
		
		return count;
	}
	
	public static D getD(int y, int x, int num) {
		
		int ny, nx;
		int like = 0;
		int blank = 0;
		
		for(int i=0; i<4; i++) {
			
			ny = y + dy[i];
			nx = x + dx[i];
			
			if(ny<0||ny>=n||nx<0||nx>=n) continue;
			
			if(map[ny][nx]==0) blank++;
			else if(s[num-1].contains(Integer.valueOf(map[ny][nx]))) like++;
		}
		
		return new D(y, x, like, blank);
	}
	
	public static D set(int num) {
		
		pq.clear();
		
		for(int i=0; i<n; i++){
			
			for(int j=0; j<n; j++) {
	
				if(map[i][j]>0) continue;
				pq.add(getD(i, j, num));
			}
		}
		
		return pq.poll();
	}
	
	public static int solution() throws NumberFormatException, IOException {
		
		init();
		
		D tmp;
		int num;
		for(int i=1; i<=n*n; i++) {
			
			num = q.poll();
			tmp = set(num);
			map[tmp.y][tmp.x]=num;
			//print();
		}
		
		int ans = 0;
		int cnt;

		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++) {
				
				cnt=getLikeStu(i, j, map[i][j]);
				
				if(cnt==1) ans+=1;
				else if(cnt==2) ans+=10;
				else if(cnt==3) ans+=100;
				else if(cnt==4) ans+=1000;
				
			}
		
		return ans;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println(solution());
	}
	
	static class D implements Comparable<D>{
		
		int like, blank, y, x;
		
		D(int y, int x, int like, int blank){
			this.y=y;
			this.x=x;
			this.like=like;
			this.blank=blank;
		}

		@Override
		public int compareTo(D o) {
			
			if(this.like==o.like)
			{
				if(this.blank==o.blank) {
					if(this.y==o.y) {
						return this.x-o.x;
					}
					
					return this.y-o.y;
				}
					
				return o.blank-this.blank;
			}
			
			
			return o.like-this.like;
		}
	
	}

}
