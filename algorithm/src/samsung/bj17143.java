package samsung;

import java.io.*;
import java.util.*;

public class bj17143 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {-1, 1, 0, 0};// d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽
	static Shark[][] map;
	static int r, c;
	static ArrayList<Shark> sharks = new ArrayList<>();
	
	static void move(Shark s) {
		
		for(int i=0; i<s.speed; i++) {
			s.x+=dx[s.d]; s.y+=dy[s.d];
			
			if(s.x<0) {
				s.x=1;
				s.d=2;
			}
			else if(s.x>=c) {
				s.x=c-2;
				s.d=3;
			}
			
			else if(s.y<0) {
				s.y=1;
				s.d=1;
			}
			else if(s.y>=r) {
				s.y=r-2;
				s.d=0;
			}
		}
		
		s.cnt++;
	}
	
	public static int catchShark(int now) {
		
		Shark tmp;
		for(int i=0; i<r; i++) {
			if(map[i][now]==null) continue;
			tmp = map[i][now];
			map[i][now]=null;
			tmp.isEaten = true;
			return tmp.size;
		}
		
		return 0;
	}
	
	public static void twosharks(Shark a, Shark b) {
		
		Shark big = (a.size > b.size) ? a : b;
		Shark small = (a.size > b.size) ? b : a;
		small.isEaten = true;
		map[big.y][big.x] = big;
		
	}
	
	public static int solution() {	
		int ans=0;
		for(int now=0; now<c; now++) {
			ans+=catchShark(now);
			for(Shark shark : sharks) {
				if(shark.isEaten) continue;
				if(map[shark.y][shark.x]==shark) map[shark.y][shark.x]=null;
				move(shark);
				if(map[shark.y][shark.x]!=null&&map[shark.y][shark.x].cnt==shark.cnt) twosharks(map[shark.y][shark.x], shark);
				else map[shark.y][shark.x]=shark;
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int m; String s = br.readLine(); StringTokenizer st = new StringTokenizer(s);
		r = Integer.parseInt(st.nextToken()); c = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		map = new Shark[r][c];
		
		Shark tmp;
		for(int i=0; i<m; i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			tmp = new Shark(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			sharks.add(tmp);
			map[tmp.y][tmp.x] = tmp;
		}
		
		bw.append(Integer.toString(solution()));
		bw.flush();
		bw.close();
		
	}
	
	static class Shark{
		int size, d, speed;
		int x,y;
		boolean isEaten = false;
		int cnt=-1;
		
		Shark(int y, int x, int speed,int d,int size){
			this.y=y-1; this.x=x-1;
			this.size=size;
			this.d=d-1;
			if(d<=2) this.speed=speed%(r+r-2);
			else this.speed=speed%(c+c-2);
		}
		
	}

}
