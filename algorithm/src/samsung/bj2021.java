package samsung;
import java.io.*;
import java.util.*;

public class bj2021 {

	static int n;
	static int[][] board;
	static int ans = 0;
	static Queue<Integer> q = new LinkedList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static void copy(int[][] from, int[][] to) {
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
					to[i][j] = from[i][j];
	}
	
	static void print() {
		System.out.println();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++)
					System.out.print(board[i][j] + " ");
			System.out.println();
		}
	}
	
	static int left() {	
		q.clear();
		int max = -1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(board[i][j]==0) continue;
				q.add(board[i][j]);
				board[i][j] = 0;
			}
			
			for(int j=0; j<n; j++) {
				if(q.isEmpty()) break;
				board[i][j] = q.poll();
				max = Math.max(max, board[i][j]);
				if(q.isEmpty()) break;
				if(board[i][j]==q.peek()) board[i][j] += q.poll();
				max = Math.max(max, board[i][j]);
			}
		}
		
		return max;
	}
	
	static int right() {
		q.clear();
		int max = -1;
		for(int i=0; i<n; i++) {
			for(int j=n-1; j>=0; j--) {
				if(board[i][j]==0) continue;
				q.add(board[i][j]);
				board[i][j] = 0;
			}
			
			for(int j=n-1; j>=0; j--) {
				if(q.isEmpty()) break;
				board[i][j] = q.poll();
				max = Math.max(max, board[i][j]);
				if(q.isEmpty()) break;
				if(board[i][j]==q.peek()) board[i][j] += q.poll();
				max = Math.max(max, board[i][j]);
			}
		}
		
		return max;
		
	}
	
	static int down() {
		q.clear();
		int max = -1;
		for(int j=0; j<n; j++) {
			for(int i=n-1; i>=0; i--) {
				if(board[i][j]==0) continue;
				q.add(board[i][j]);
				board[i][j] = 0;
			}
			
			for(int i=n-1; i>=0; i--) {
				if(q.isEmpty()) break;
				board[i][j] = q.poll();
				max = Math.max(max, board[i][j]);
				if(q.isEmpty()) break;
				if(board[i][j]==q.peek()) board[i][j] += q.poll();
				max = Math.max(max, board[i][j]);
			}
		}
		
		return max;
	}
	
	static int up() {
		q.clear();
		int max = -1;
		for(int j=0; j<n; j++) {
			for(int i=0; i<n; i++) {
				if(board[i][j]==0) continue;
				q.add(board[i][j]);
				board[i][j] = 0;
			}
			
			for(int i=0; i<n; i++) {
				if(q.isEmpty()) break;
				board[i][j] = q.poll();
				max = Math.max(max, board[i][j]);
				if(q.isEmpty()) break;
				if(board[i][j]==q.peek()) board[i][j] += q.poll();
				max = Math.max(max, board[i][j]);
			}
		}
		
		return max;
	}

	static void dfs(int cnt, int dir) {
		
		int[][] tmp = new int[n][n];
	
		if(cnt==5) return;
		
			copy(board, tmp);
			ans = Math.max(ans, left());
			dfs(cnt+1,0);
			copy(tmp, board);
		
			copy(board, tmp);
			ans = Math.max(ans, right());
			dfs(cnt+1,1);
			copy(tmp, board);

			copy(board, tmp);
			ans = Math.max(ans, up());
			dfs(cnt+1,2);
			copy(tmp, board);
		
			copy(board, tmp);
			ans = Math.max(ans, down());
			dfs(cnt+1,3);
			copy(tmp, board);
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		String s; StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());		
			for(int j=0; j<n; j++) board[i][j] = Integer.parseInt(st.nextToken());
			
		}
		
		dfs(0,-1);
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}

}
