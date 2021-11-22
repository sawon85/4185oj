package samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class bj17822 {
	
	static int n, m, t;
	static Circle[] cs;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static void move(Circle c, int t, int d) {
		c.moveSt(t, d);
	}
	
	
	public static boolean bfs(Point p, int num) {
		
		Queue<Point> q = new LinkedList<>();
		
		int ny, nx;
		for(int i=0; i<4; i++)
		{
			ny = p.y+dy[i]; nx = p.x+dx[i];
			if(ny<0||ny>=n) continue;
			if(nx<0) nx=m-1;
			else if(nx>=m) nx=0;
			if(cs[ny].get(nx)!=num) continue;
			q.add(new Point(ny, nx));
			cs[ny].set(nx, 0);
		}
		
		if(q.size()==0) return false;
		cs[p.y].set(p.x, 0);
		
		while(!q.isEmpty()) {
			p = q.poll();
			
			for(int i=0; i<4; i++)
			{
				ny = p.y+dy[i]; nx = p.x+dx[i];
				if(ny<0||ny>=n) continue;
				if(nx<0) nx=m-1;
				else if(nx>=m) nx=0;
				if(cs[ny].get(nx)!=num) continue;
				q.add(new Point(ny, nx));
				cs[ny].set(nx, 0);
			}
			
		}
		
		return true;
		
	}
	
	public static void dfs() {
		
		boolean diff = true;
		int num;
		int cnt=0, sum=0;
		for(int i=0; i<n; i++) 
			for(int j=0; j<m; j++) {
				num = cs[i].get(j);
				if(num==0) continue;
				cnt++;
				sum+=num;
				if(bfs(new Point(i, j), num)) diff=false;
			}
		
		
		if(cnt==0) return;
		
		if(diff) {
			
			float avg=sum/(float)cnt;
			
			for(int i=0; i<n; i++)
				for(int j=0; j<m; j++) {
					if(cs[i].arr[j]==0) continue;
					if(cs[i].arr[j]<avg) cs[i].arr[j]++;
					else if(cs[i].arr[j]>avg) cs[i].arr[j]--;
				}
			
		}
		
	}
	
	public static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken()); m=Integer.parseInt(st.nextToken()); t=Integer.parseInt(st.nextToken());
		cs = new Circle[n];
		for(int i=0; i<n; i++) cs[i] = new Circle();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) cs[i].arr[j] = Integer.parseInt(st.nextToken());
			
		}
		
	}
	
	public static void print() {
		
		System.out.println();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(cs[i].get(j)+" ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
	public static int solve() throws IOException {
		
		init();
		StringTokenizer st;
		int x, d, k;

		
		for(int i=0; i<t; i++) {
		
			st = new StringTokenizer(br.readLine());
			x=Integer.parseInt(st.nextToken()); d=Integer.parseInt(st.nextToken()); k=Integer.parseInt(st.nextToken());
			
			for(int j=x;j<=n;j+=x) move(cs[j-1],k, d);
		
			dfs();
			
		}

		
		int ans=0;
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++) ans+=cs[i].arr[j];
		
		return ans;
	}

	public static void main(String[] args) throws IOException {
		
		System.out.println(solve());

	}
	
	static class Point{
		int y, x;
		
		Point(int y, int x){
			this.y=y; this.x=x;
		}
	}
	
	static class Circle{
		
		int[] arr;
		int st;
		
		Circle(){
			arr = new int[m];
			st=0;
		}
		
		int getIdx(int idx) {
			int nextIdx=st+idx;
			if(nextIdx>=m) return nextIdx-m;
			return nextIdx;
		}
		
		int get(int idx) {
			return arr[getIdx(idx)];
		}
		
		void moveSt(int t, int d) {
			t=t%m;
			int diff=1;
			if(d==0) diff=-1;
			
			st=st+diff*t;
			
			if(st>=m) st=st-m;
			else if(st<0) st=m+st;
		}
		
		void set(int idx, int num) {
			arr[getIdx(idx)]=num;
		}
	}

}
