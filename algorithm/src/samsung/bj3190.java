package samsung;

import java.util.*;
import java.io.*;

public class bj3190 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static ArrayList<P> snake;
	static Queue<C> cmds;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int d = 0;
	static int n, k, l;
	static int[][] map;
	
	static void print() {
		System.out.println();
		
		for(int i=0; i<n; i++) {
			
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j] + " ");
			}
			
			System.out.println();
			
		}
		
	}
	
	static void init() throws NumberFormatException, IOException {
		snake = new ArrayList<>();
		cmds = new LinkedList<>();
		snake.add(new P(0,0));
		d=0;
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		map=new int[n][n];
		map[0][0]=2;
		
		StringTokenizer st;
		int y, x;
		for(int i=0 ;i<k ;i++) {
			st = new StringTokenizer(br.readLine());
			y=Integer.parseInt(st.nextToken())-1; x=Integer.parseInt(st.nextToken())-1;
			map[y][x]=1;
		}
		
		l=Integer.parseInt(br.readLine());
		
		int t;
		String s;
		for(int i=0; i<l; i++) {
			st = new StringTokenizer(br.readLine());
			
			t=Integer.parseInt(st.nextToken()); s=st.nextToken();
			
			switch(s) {
			
			case "L":
				cmds.add(new C(t, 1));
				break;
				
			case "D":
				cmds.add(new C(t, -1));
				break;
			}
		}
		
	}
	
	static boolean canGo(int y, int x) {
		
		if(y<0||y>=n||x<0||x>=n) return false;
		if(map[y][x]==2) return false;
		return true;
		
	}
	
	static boolean isApple(int y, int x) {
		if(map[y][x]!=1) return false;
		map[y][x]=2;
		return true;
	}
	
	public static boolean move(){
		
		P head = snake.get(0);
		
		int ny=head.y+dy[d],  nx=head.x+dx[d];
		
		if(!canGo(ny, nx)) return false;
		
		snake.add(0, new P(ny, nx));
		
		P last;
		if(!isApple(ny,nx)) {
			last = snake.get(snake.size()-1);
			map[last.y][last.x]=0;
			snake.remove(snake.size()-1);
		}
		
		map[ny][nx]=2;
		
		return true;
		
	}
	
	public static int solution() throws NumberFormatException, IOException {
		init();
		
		int time=0;
		
		while(true) {
			
			time++;
			if(!move()) return time;
			
			if(!cmds.isEmpty()) {
				
				if(cmds.peek().time==time) {
	
					d = ((d+4)+cmds.peek().d)%4;
					cmds.poll();
				}
				
			}
		}

	}
			
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println(solution());

	}

	static class C{
		int time, d;
		
		C(int time, int d){
			this.time=time; this.d=d;
		}
	}
	
	static class P{
		int y, x;
		
		P(int y, int x){
			this.y=y; this.x=x;
		}
	}
}
