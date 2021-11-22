package samsung;

import java.io.*;
import java.util.StringTokenizer;

public class bj20057 {
	
	
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

	static int n;
	static int[][] map;
	static int[][] left = {
			{0, 0, 2, 0, 0},
			{0, 10, 7, 1, 0},
			{5, -1, 0, 0, 0},
			{0, 10, 7, 1, 0},
			{0, 0, 2, 0, 0}
	};
	
	static int[][] up;
	static int[][] down;
	static int[][] right;
	static int ans=0;
	
	public static int[][] turn(int[][] from) {
		
		int[][] tmp = new int[5][5];
		
		for(int i=0; i<5; i++)
			for(int j=0; j<5; j++) {
				tmp[i][j] = from[j][5-1-i];
			}
		
		return tmp;
	}
	
	public static void print(int[][] b) {
		System.out.println();
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++)
				System.out.print(b[i][j]+" ");
			System.out.println();
		}
	}
	
	
	public static void setting() {	
		down=turn(left);
		right=turn(down);
		up=turn(right);

	}
	
	public static void set(int y, int x, int[][] b) {
		
		int sand = map[y][x];
		int plus=0;
		
		int ny, nx;
		int tmp;
		int py=0, px=0;
		
		for(int i=-2; i<=2; i++) {
			for(int j=-2; j<=2; j++) {
				ny = y+i;
				nx = x+j;
				
				if(b[i+2][j+2]==-1) {
					py=ny;
					px=nx;
					continue;
				}
				
				tmp = (int)Math.floor((float)b[i+2][j+2]/100.0f*sand);
				plus+=tmp;
				
				if(ny<0||ny>=n||nx<0||nx>=n) ans+=tmp;
				else map[ny][nx]+=tmp;
			}
		}
		
		int left=sand-plus;
		map[y][x]=0;
		if(py<0||py>=n||px<0||px>=n) ans+=left;
		else map[py][px]+=left;
		
	}
	
	public static void init() throws NumberFormatException, IOException {
		
		setting();
		
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		ans=0;
	}
	
	public static void solution(){
		
		int y=n/2;
		int x=n/2;
		
		int size=1;
		
		while(size<n) {
			
			for(int i=0; i<size; i++) set(y,--x,left);
			for(int i=0; i<size; i++) set(++y,x,down);
			size++;
			for(int i=0; i<size; i++) set(y,++x,right);
			for(int i=0; i<size; i++) set(--y,x,up);
			if(size==n-1) for(int i=0; i<size; i++) set(y,--x,left);
			size++;
		}
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
		solution();
		System.out.println(ans);

	}

}
