package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_6087 {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;

	static int[] xx = {-1, 1, 0, 0};
	static int[] yy = {0, 0, 1, -1};
	static int w, h;
	static int[][] map; // 0, -1, 2
	static int[][] cnt;
	static Queue<Laser> q = new LinkedList<>();
	static Laser[] c = new Laser[2];
	
	static int bfs() {
	
		Laser temp = c[0];
		cnt[temp.y][temp.x]=1;
		q.add(temp);
		temp = new Laser(c[0].x, c[0].y, 2);
		q.add(temp);
		
		int x2, y2;
		while(!q.isEmpty()) {
			
			temp = q.poll();
			
			for(int i=temp.getNextDist();i<temp.getNextDist()+2; i++) {
				x2 = temp.x; y2 = temp.y;
				
				while(true) {
					x2 += xx[i]; y2 += yy[i];
					
					if(x2<0||x2>=w||y2<0||y2>=h) break;
					if(map[y2][x2]==-1) break;
					if(cnt[y2][x2]!=0&&cnt[y2][x2]<=cnt[temp.y][temp.x]) break;
					if(c[1].x==x2&&c[1].y==y2) return cnt[temp.y][temp.x]-1;
					
					cnt[y2][x2] = cnt[temp.y][temp.x] + 1;
					q.add(new Laser(x2, y2, i));
				}				
			}		
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		s=bf.readLine(); st = new StringTokenizer(s);
		w = Integer.parseInt(st.nextToken()); h=Integer.parseInt(st.nextToken());
		map = new int[h][w]; cnt = new int[h][w];
		
		int cidx = 0;
		
		for(int i=0;i<h;i++) {
			s=bf.readLine();
			
			for(int j=0;j<w;j++) {
				
				switch(s.charAt(j)) {
				
				case '.' : map[i][j] = 0; break;
				case '*' : map[i][j] = -1; break;
				case 'C' : c[cidx++]=new Laser(j,i,0);break;
				
				}
			}
		}
		
		System.out.println(bfs());

	}
	
	static class Laser{
		
		int x, y, dist;

		Laser(int x, int y, int dist){
			this.x=x; this.y=y; this.dist=dist;
		}
		
		public int getNextDist() {
			if(dist<2) return 2;
			return 0;
		}
	}

}
