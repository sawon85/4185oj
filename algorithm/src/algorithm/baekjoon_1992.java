package algorithm;

import java.util.Scanner;

public class baekjoon_1992 {
	
	static Scanner sc = new Scanner(System.in);
	
	static int[][] map = new int[64][64];
	static int n;
	static StringBuilder sb= new StringBuilder();
	
	public static boolean allSame(int stx, int sty, int size) {
		
		int n = 0;
		
		if(map[sty][stx]==1) n = 1;
		
		for(int i=sty; i<sty+size; i++)
			for(int j=stx; j<stx+size; j++)
				if(map[i][j]!=n) return false;
		
		return true;
		
	}
	
	public static void solution(int stx, int sty, int size) {
		
		
		if(allSame(stx, sty, size)){
			sb.append(Integer.toString(map[sty][stx]).charAt(0));
			return;
		}
		
		
		
		sb.append('(');
		solution(stx,sty, size/2);
		solution(stx+size/2,sty, size/2);
		solution(stx,sty+size/2, size/2);
		solution(stx+size/2,sty+size/2, size/2);	
		sb.append(')');
		
	
		
	}
	
	public static void main(String[] args) {
		
		n=sc.nextInt();
		
		sc.nextLine();
		for(int i=0; i<n; i++) {
			String st;
			st = sc.nextLine();
			for(int j=0; j<n; j++) map[i][j] = st.charAt(j) - '0';
		}
		
		
		solution(0, 0, n);
		
		System.out.println(sb);
		
		
	}

}
