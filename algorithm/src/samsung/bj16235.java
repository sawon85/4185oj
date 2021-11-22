package samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class bj16235 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static C[][] ground;
	static int[][] A;
	static int n,m,k;
	
	static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
	
	public static void stos(C now) {
		
		PriorityQueue<Integer> t=now.pq;
		PriorityQueue<Integer> nt=new PriorityQueue<>();
		
		int tmp;
		int plus=0;
		while(!t.isEmpty()) {
			
			tmp = t.poll();
			
			if(tmp>now.e) plus+=tmp/2;
			
			else {
				
				now.e-=tmp;
				nt.add(tmp+1);
				
			}
		}
		
		now.pq=nt;
		now.e+=plus;
		
	}
	
	public static void ss() {
		
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				stos(ground[i][j]);
	}
	
	static void child(int y, int x, int[][] tmp) {
		
		C c = ground[y][x];
		
		PriorityQueue<Integer> t=c.pq;
		PriorityQueue<Integer> nt=new PriorityQueue<>();
		
		int tree;
		int nx, ny;
		while(!t.isEmpty()) {
			tree=t.poll();
			
			if(tree%5==0) {
				
				for(int i=0; i<8; i++) {
					nx=x+dx[i]; ny=y+dy[i];
					
					if(nx<0||nx>=n||ny<0||ny>=n) continue;
					tmp[ny][nx]++;
				}
				
			}
			
			nt.add(tree);
		}
		
		c.pq=nt;
	}
	
	static void f() {
		
		int[][] tmp = new int[n][n];
		
		
		C c;
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				child(i, j, tmp);
		
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				for(int k=0; k<tmp[i][j]; k++)
					ground[i][j].pq.add(1);
		
	}
	
	static void w() {
		
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				ground[i][j].e+=A[i][j];
		
	}
	
	public static void init() throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
		 
		ground = new C[n][n];
		A = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				A[i][j]=Integer.parseInt(st.nextToken());
				ground[i][j] = new C(5);
			}
		}
		
		
		int y, x, a;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken())-1; x = Integer.parseInt(st.nextToken())-1; a=Integer.parseInt(st.nextToken());
			ground[y][x].pq.add(a);
			
		}
		
	}
	
	public static int solution() throws IOException {
		
		init();
		
		for(int i=0; i<k; i++) {
			
			ss(); f(); w();
		}
		
		int ans=0;
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				ans+=ground[i][j].pq.size();
		
		return ans;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(solution());
	}

	
	static class C{
		
		int e;
		PriorityQueue<Integer> pq;
		
		C(int e){
			this.e=e;
			pq=new PriorityQueue<>();
		}
	}
}
