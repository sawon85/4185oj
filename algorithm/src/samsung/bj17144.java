package samsung;

import java.io.*;
import java.util.StringTokenizer;

public class bj17144 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int r, c, t;
	static int[][] map;
	static int fx1=-1, fy1,fx2, fy2;
	static int[] dx= {1, 0, -1, 0};
	static int[] dy= {0, 1, 0, -1};
	
	static void print() {
		System.out.println();
		for(int i=0; i<r; i++) {
			System.out.println();
			for(int j=0; j<c; j++) {
				System.out.print(map[i][j] + " ");
			}
		}
		System.out.println();
	}
	
	static void init() throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		r=Integer.parseInt(st.nextToken()); c=Integer.parseInt(st.nextToken()); t=Integer.parseInt(st.nextToken());
		map = new int[r][c];
		
		int num;
		fx1=-1;
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++)
			{
				num = Integer.parseInt(st.nextToken());
				if(num==-1) {
					
					if(fx1==-1) {
						fx1=j;
						fy1=i;
					}
					
					else {
						fx2=j;
						fy2=i;
						
					}	
					continue;
				}
				map[i][j]=num;
			}
		}
		

	}
	
	static void dust() {
		
		int[][] tmp = new int[r][c];
		
		int p;
		int count=0;
		int ny, nx;
		
		for(int i=0; i<r; i++) {
			
			for(int j=0; j<c; j++) {
				
				if(map[i][j]==0) continue;
				
				p = (int) Math.floor((float)map[i][j]/5.0f);
				
				count=0;
				for(int k=0; k<4; k++) {
					
					ny=i+dy[k];
					nx=j+dx[k];
					
					if(ny<0||ny>=r||nx<0||nx>=c) continue;
					if(ny==fy1&&nx==fx1) continue;
					if(ny==fy2&&nx==fx2) continue;
					
					count++;
					tmp[ny][nx]+=p;
					
				}
				
				
				tmp[i][j] -= p*count;
			}
		}
		
		for(int i=0; i<r; i++) 
			for(int j=0; j<c; j++)
				map[i][j]+=tmp[i][j];
		
		//print();
		
	}
	
	static void f1() {
		
		int x=fx1, y=fy1-1;
		
		for(; y>0; y--) {
			map[y][x] = map[y-1][x];
		}
		
		for(; x<c-1; x++) {
			map[y][x] = map[y][x+1];
		}
		
		for(;y<fy1;y++) {
			map[y][x] = map[y+1][x];
		}
		
		for(;x>0;x--) {
			map[y][x] = map[y][x-1];
		}
		
	}
	
	static void f2() {
		
		int x=fx2, y=fy2+1;
		
		for(; y<r-1; y++) {
			map[y][x] = map[y+1][x];
		}
		
		for(; x<c-1; x++) {
			map[y][x] = map[y][x+1];
		}
		
		for(;y>fy2;y--) {
			map[y][x] = map[y-1][x];
		}
		
		for(;x>0;x--) {
			map[y][x] = map[y][x-1];
		}
		
	}
	
	static void o2() {
		
		f1();
		f2();	
	}
	
	
	static int solution() throws IOException {
		
		init();
		
		for(int i=0; i<t; i++) {
			dust();
			o2();
	
		}
		
		int ans = 0;
		for(int i=0; i<r; i++) for(int j=0; j<c; j++) ans+=map[i][j];
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(solution());

	}

}
