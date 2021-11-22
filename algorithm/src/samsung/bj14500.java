package samsung;

import java.io.*;
import java.util.StringTokenizer;

public class bj14500 {

	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
	
	public static int n, m;
	public static int[][] map;
	public static boolean[][] visited;
	public static int ans=0;
	public static int[] dx= {-1, 0, 1, 0};
	public static int[] dy= {0, -1, 0, 1};
	
	public static boolean[][][] board = {
			
			{
				{false, true, false},
				{true, true, true}
			},
			{
				{true, true, true},
				{false, true, false}
			},
			{
				{true, false},
				{true, true},
				{true, false}
			},
			{
				{false, true},
				{true, true},
				{false, true}
			}};
	
	public static void init() throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); 	m = Integer.parseInt(st.nextToken());
		map = new int[n][m]; visited = new boolean[n][m];
		ans=0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) map[i][j] = Integer.parseInt(st.nextToken());
			
		}
	}
	
	public static int checkBoard(int y, int x, boolean[][] board) {
		
		int ny, nx;
		
		int count=0;
		for(int i=0; i<board.length; i++) {
			
			for(int j=0; j<board[i].length; j++) {
				
				ny = y+i; nx=x+j;
				
				if(ny<0||ny>=n||nx<0||nx>=m) return -1;
				if(board[i][j]) count+=map[ny][nx];
			}
		}	
		
		return count;
	}
	
	public static void check(int y, int x) {
		
		for(int i=0; i<board.length; i++) {
			ans = Math.max(ans, checkBoard(y, x, board[i]));
		}
	}
	
	public static void dfs(int y, int x, int cnt, int score) {
		
		if(cnt==4) {
			ans = Math.max(ans, score);
			return;
		}
		
		int ny, nx;
		
		for(int i=0; i<4; i++) {
			ny=y+dy[i]; nx=x+dx[i];
			if(ny<0||ny>=n||nx<0||nx>=m) continue;
			if(visited[ny][nx]) continue;
			visited[ny][nx]=true;
			dfs(ny, nx, cnt+1, score+map[ny][nx]);
			visited[ny][nx]=false;
		}
		
	}
	
	
	public static int solution() throws IOException {
		
		init();
		
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++) {
				check(i, j);
				visited[i][j]=true;
				dfs(i, j, 1, map[i][j]);
				visited[i][j]=false;
			}
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		bw.write(Integer.toString(solution())+"\n");
		bw.flush(); bw.close();
	}

}
