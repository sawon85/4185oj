package samsung;

import java.util.*;
import java.io.*;

public class bj20056 {

	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int n, m, k;
	
	
	public static void print(ArrayList<Fb>[][] map) {
		
		System.out.println();
		
		for(int i=0; i<n; i++) {
			
			for(int j=0; j<n; j++) {
				
				if(map[i][j]==null) System.out.print(" 0" );
				else System.out.print(" "+map[i][j].size());
				
			}
			
			System.out.println();
		}
		
		System.out.println();
	}
	
	public static ArrayList<Fb> move(ArrayList<Fb> fbs) {
		
		ArrayList<Fb>[][] map = new ArrayList[n][n];
		
		int nx, ny;
		
		for(Fb f : fbs) {
			nx = f.x;
			ny = f.y;
			
			for(int i=0; i<f.s%n; i++) {
				
				nx += dx[f.d];
				ny += dy[f.d];
				
				if(nx<0) nx=n-1;
				else if(nx>=n) nx=0;
				
				if(ny<0) ny=n-1;
				else if(ny>=n) ny=0;
					
			}
			
			f.x=nx; f.y=ny;
			
			if(map[ny][nx]==null) map[ny][nx] = new ArrayList<>();
			map[ny][nx].add(f);
		}
		
		ArrayList<Fb> newfbs = new ArrayList<>();

		int count=0, m=0, s=0, d;
		boolean same;
		
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++) {
				
				if(map[i][j]==null) continue;
				
				if(map[i][j].size()==1) {
					newfbs.add(map[i][j].get(0));
					continue;
				}
				
				//파이어볼 합치기
				count=m=s=0;
				d=-1;
				same=true;
				
				for(Fb f : map[i][j]) {
					
					if(d==-1) d=f.d%2;
					else if(d!=f.d%2) same=false;				
					count++;
					m+=f.m;
					s+=f.s;
				}
				
				m=m/5;	
				if(m==0) continue;
				
				s=s/count;
				if(same) d=0;
				else d=1;
				
				for(int k=0; k<4; k++) {
					newfbs.add(new Fb(i, j, m, s, d));
					d+=2;
				}
					
			}
		
		
		return newfbs;
		
	}
	
	public static ArrayList<Fb> init() throws IOException {
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken()); m=Integer.parseInt(st.nextToken()); k=Integer.parseInt(st.nextToken());
		
		ArrayList<Fb> fbs= new ArrayList<>();
		for(int i=0; i<m; i++) {
			st =new StringTokenizer(br.readLine());
			fbs.add(new Fb(Integer.parseInt(st.nextToken())-1,
					Integer.parseInt(st.nextToken())-1,
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
			
		}
		
		return fbs;
	}
	
	public static int solve() throws IOException {
		
		ArrayList<Fb> fbs = init();
		
		for(int i=0; i<k; i++) fbs = move(fbs);
		
		int ans=0;
		for(Fb f : fbs) ans+=f.m;
		
		return ans;
		
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(solve());

	}

	
	static class Fb{
		
		int y, x, m, d, s;
		
		Fb(int y, int x, int m, int s, int d){
			this.y=y; this.x=x; this.m=m; this.d=d; this.s=s;
			
		}
		
	}
	
}
