package samsung;

import java.io.*;
import java.util.StringTokenizer;

public class bj19236 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Fish[][] map;
	static Fish[] fishes;
	static Fish shark;
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int ans = 0;
	
	static void print(Fish[][] map) {
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++)
				if(map[i][j]==null) System.out.print("** ");
				else System.out.printf("%2d ", map[i][j].num+1);
			System.out.println();
		}
		System.out.println();	
	}
	
	static void copyFishes(Fish[] from, Fish[] to) {
		
		for(int i=0; i<16; i++)
			to[i] = new Fish(from[i].num,from[i].d,from[i].y,from[i].x,from[i].isEaten);
		
	}
	
	static void init() {
		map = new Fish[4][4];
		fishes = new Fish[16];
		shark = new Fish(-1,-1,0,0,false);
		ans=0;
	}
	
	static int eat() {
		if(map[shark.y][shark.x]==null) return -1;
		shark.d=map[shark.y][shark.x].d;
		int num = map[shark.y][shark.x].num;
		map[shark.y][shark.x].isEaten=true;
		map[shark.y][shark.x]=null;
		return num;
	}
	
	static boolean canMove(Fish f) {
		
		int nx=f.x+dx[f.d];
		int ny=f.y+dy[f.d];
		
		if(shark.y==ny&&shark.x==nx) return false;
		if(ny<0||ny>=4||nx<0||nx>=4) return false;
		
		Fish tmp = map[ny][nx];
		map[ny][nx] = f;
		map[f.y][f.x]=tmp;
		
		if(tmp!=null) {
			tmp.x=f.x;
			tmp.y=f.y;
		}
		
		f.x=nx;
		f.y=ny;
		
		return true;
	}
	
	public static void copy(Fish[][]from, Fish[][] to) {
		for(int i=0;i<4;i++)for(int j=0; j<4; j++) to[i][j]=from[i][j];
	}
	
	public static void input() throws IOException {
		
		StringTokenizer st;
		Fish f;
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				f = new Fish(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1, i , j, false);
				fishes[f.num] = f;
				map[i][j]=f;
			}
		}
	}
	
	public static int dfs(int result) {
		
		int nowNum = eat();
		if(nowNum==-1) {
			ans = Math.max(result, ans);
			return nowNum;
		}
		
		result += (nowNum+1);
		
		Fish[][] tmp = new Fish[4][4];
		Fish[] fishes_ = new Fish[16];
		
	
		boolean flag;
	
		for(Fish f : fishes) {
			if(f.isEaten) continue;
			f.d--;
			flag = false;
			for(int i=0; i<8; i++) {
				f.d = (f.d+1)%8;
				System.out.print(f.d+" ");
				if(canMove(f)) {
					flag = true;
					break;
				}
			}
			
			if(!flag) f.d = (f.d+1)%8;
			System.out.println();
		}
		copy(map, tmp);
		copyFishes(fishes,fishes_);
		System.out.println("before:");
		print(map);
		System.out.println("after:");
		print(tmp);
		
		int count = 0;
		int sx, sy, sd;
		
		System.out.println("\n");
		sy=shark.y; sx=shark.x; sd=shark.d;
		for(int i=1; i<4; i++) {
			shark.y=sy+dy[sd]*i;
			shark.x=sx+dx[sd]*i;
			shark.d=sd;
			if(shark.y<0||shark.y>=4||shark.x<0||shark.x>=4) break;
			if(map[shark.y][shark.x]!=null) {
				dfs(result);
				count++;
				copy(tmp, map);
				copyFishes(fishes_,fishes);
				shark.y=sy; shark.x=sx; shark.d=sd;
			}
			
		}
	
		/*
		while(shark.y>=0&&shark.y<4&&shark.x>=0&&shark.x<4) {
			
			if(map[shark.y][shark.x]!=null) {
				sy=shark.y; sx=shark.x; sd=shark.d;
				dfs(result);
				count++;
				copy(tmp, map);
				copyFishes(fishes_,fishes);
				shark.y=sy;shark.x=sx;shark.d=sd;
			}
			
			shark.y+=dy[shark.d]; shark.x+=dx[shark.d];
			System.out.println(result+"/"+shark.y + " " +shark.x);
		}
		*/
		if(count==0) {
			ans = Math.max(result, ans);
		}
		
		return nowNum;
	}
	
	public static int solution() throws IOException {
		
		init();
		input();
		dfs(0);	
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		bw.write(Integer.toString(solution()));
		bw.flush();
		bw.close();

	}

	
	static class Fish{
		int num, d;
		int x, y;
		boolean isEaten;
		Fish(int num, int d, int y, int x, boolean isEaten){
			this.num=num;
			this.d=d;
			this.y=y;
			this.x=x;
			this.isEaten=isEaten;
		}
	}
}
