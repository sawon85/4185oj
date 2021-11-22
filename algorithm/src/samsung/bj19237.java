package samsung;
import java.io.*;
import java.util.*;

public class bj19237 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, m, k;
	static Shark[] sharks;
	static M[][] map;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy= {-1, 1, 0, 0};
	
	public static void init() throws IOException {
		//입력
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken()); m=Integer.parseInt(st.nextToken());  k=Integer.parseInt(st.nextToken());
		
		map=new M[n][n];
		sharks=new Shark[m];
		int num;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<n; j++) {
				map[i][j] = new M(-1);
				num = Integer.parseInt(st.nextToken());
				if(num>0) sharks[num-1] = new Shark(num,i,j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			sharks[i].d=Integer.parseInt(st.nextToken())-1;
		}
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<4; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<4; k++) {
					sharks[i].b[j][k]=Integer.parseInt(st.nextToken())-1;
				}			
			}			
		}
		 
		
	}
	
	public static void perfume() {
		for(Shark s : sharks) {	
			if(s.isEaten) continue;
			map[s.y][s.x].count=k+1;
			map[s.y][s.x].num=s.num;
		}
	}
	
	public static void move(Shark shark) {
		
		int nowd = shark.d;
		int[][]b = shark.b;
		int nexd, nx, ny, d;
		int my=-1;
		
		for(int i=0; i<b[nowd].length; i++) {
			
			nexd=b[nowd][i];
			ny=shark.y+dy[nexd];
			nx=shark.x+dx[nexd];
			
			if(ny<0||ny>=n||nx<0||nx>=n) continue;
			if(map[ny][nx].num!=-1&&map[ny][nx].num!=shark.num) continue;
			if(map[ny][nx].num==shark.num) {
				if(my==-1) my=nexd;
				continue;
			}
			my=nexd;
			break;
		}
		
		nexd=my;
		shark.y=shark.y+dy[nexd];
		shark.x=shark.x+dx[nexd];
		shark.d=my;
	}
	
	public static int moveSharks() {
		
		for(int i=0; i<m; i++) if(!sharks[i].isEaten) move(sharks[i]);
		
		Shark s;
		int eaten=0;
		for(int i=0; i<m; i++) {
			if(sharks[i].isEaten) continue;
			
			s=sharks[i];
			
			if(map[s.y][s.x].count==k+1) {
				eaten++;
				s.isEaten=true;
			}
			
			else {
				map[s.y][s.x].count=k+1;
				map[s.y][s.x].num=s.num;
			}
			
		}
		return eaten;
	}
	
	public static void second() {
		
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				if(--map[i][j].count<=0) {
					map[i][j].count=0;
					map[i][j].num=-1;
				}
		
	}

	public static void print() {
					System.out.println();
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++)
					if(map[i][j].count==0) System.out.print("* ");
					else System.out.print(map[i][j].count + " ");
				System.out.println();
			}
	}
	public static int solution() throws IOException {
		
		init();
		perfume();
		int count=0;
		int time=0;
		while(true) {
			second();
			count+=moveSharks();
			time++;
			if(count>=m-1) return time;
			if(time>=1000) break;
		}
		
		return -1;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(solution());

	}
	
	static class M{
		int num;
		int count=0;
		
		M(int num){
			this.num = num; //빈칸 -1;
		}
	}
	
	static class Shark{
		int num;
		int x,y;
		int[][] b;
		boolean isEaten;
		int d;
		
		Shark(int num, int y, int x){
			this.num=num-1;
			this.y=y;
			this.x=x;
			isEaten=false;
			b=new int[4][4];
			d=-1;
		}
	}
}
