package samsung;

import java.io.*;
import java.util.StringTokenizer;

public class bj14499 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int n,m,k;
	static int[][] map;
	static int[] dice;
	static int y, x;
	//동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4로
	static int[] dx= {1, -1, 0, 0};
	static int[] dy= {0, 0, -1, 1};
	
	static final int top = 0;
	static final int bottom = 5;
	
	static  void init() throws IOException {
		dice = new int[6];
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken()); y = Integer.parseInt(st.nextToken()); x = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i=0; i<n ;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}

	}
	
	static int[] e() {
		
		int[] tmp = new int[6];
		
		tmp[1] = dice[1];
		tmp[5] = dice[3];
		tmp[3] = dice[0];
		tmp[0] = dice[2];
		tmp[4] = dice[4];
		tmp[2] = dice[5];
		
		return tmp;
	}
	
	static int[] w() {
		
		int[] tmp = new int[6];
		
		tmp[1] = dice[1];
		tmp[0] = dice[3];
		tmp[2] = dice[0];
		tmp[5] = dice[2];
		tmp[4] = dice[4];
		tmp[3] = dice[5];
		
		return tmp;
	}
	
	static int[] n() {
		
		int[] tmp = new int[6];
		
		tmp[0] = dice[1];
		tmp[3] = dice[3];
		tmp[4] = dice[0];
		tmp[2] = dice[2];
		tmp[5] = dice[4];
		tmp[1] = dice[5];
		
		return tmp;
	}
	
	
	static int[] s() {
		
		int[] tmp = new int[6];
		
		tmp[5] = dice[1];
		tmp[3] = dice[3];
		tmp[1] = dice[0];
		tmp[2] = dice[2];
		tmp[0] = dice[4];
		tmp[4] = dice[5];
		
		return tmp;
	}
	
	static boolean wheel(int num) {
		
		int[] tmp=null; //동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4로
		
		int nx=x+dx[num-1], ny=y+dy[num-1];
		
		if(nx<0||nx>=m||ny<0||ny>=n) return false;
		
		switch(num) {
		
		
		case 1: tmp=e(); break;
		case 2: tmp=w(); break;
		case 3: tmp=n(); break;
		case 4: tmp=s(); break;
		
		}
	
		dice = tmp;
		
		x=nx; y=ny;
		
		return true;
	}
	
	static void set() {
		
		if(map[y][x]==0) {
			map[y][x]=dice[bottom];
		}
		else {
			dice[bottom]=map[y][x];
			map[y][x]=0;
		}
	}
	
	static void solution() throws IOException {

		init();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int d;
		for(int i=0; i<k; i++) {
			d = Integer.parseInt(st.nextToken());
			if(wheel(d)) {
				set();
				bw.write(Integer.toString(dice[top])+"\n");
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		solution();
		bw.flush();
		bw.close();
	}

}
