package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class baekjoon_18427 {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;
	static ArrayList<Integer>[] block;
	static int[][] board;
	static int n, m, h;
	
	static void solution(int num) {
		
		if(num==0)
		{
			for(Integer b : block[num]) if(b<=h) board[num][b]++;
			return;
		}
		
		for(int i=0; i<board[num-1].length; i++) {
			if(board[num-1][i]==0) continue;
			
			for(Integer b : block[num]) {
				if(i+b>=board[num].length) continue;
				board[num][i+b]+=board[num-1][i];
				board[num][i+b] %= 10007;
			}

		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		s = bf.readLine(); st = new StringTokenizer(s);
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken()); h = Integer.parseInt(st.nextToken());
		board = new int[n][h+1]; block = new ArrayList[n];
		
		String[] temp;
		for(int i=0; i<n; i++) {
			block[i] = new ArrayList<>();
			
			s = bf.readLine();
	
			block[i].add(0);
			
			temp = s.split(" ");
			
			for(int j=0; j<temp.length; j++) block[i].add(Integer.parseInt(temp[j]));
			
	
		}
		
		for(int i=0; i<n; i++) solution(i);
		
		System.out.println(board[n-1][h]);
		
	}

}
