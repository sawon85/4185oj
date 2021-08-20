package algorithm;

import java.util.Scanner;

public class baekjoon_1074 {

	static int[][] map = new int[15][15];
	static int ans = 0;
	static boolean flag = false;
	static int x, y;
	static Scanner sc = new Scanner(System.in);
	
	static void solution(int stx, int sty, int size) {
		
		if(x==stx && y==sty) flag = true;				

		
		 if (x >= stx + size || x < stx || y >= sty + size || y < sty) {
			 ans += size*size;
			 return;
		 }
		 

		solution(stx,sty, size/2);
		if(flag) return;
		solution(stx+size/2,sty, size/2);
		if(flag) return;
		solution(stx,sty+size/2, size/2);
		if(flag) return;
		solution(stx+size/2,sty+size/2, size/2);
		if(flag) return;
		
	}
	
	
	public static void main(String[] args) {
		
		int n = sc.nextInt();
		y = sc. nextInt(); x = sc. nextInt();
		
		solution(0, 0, (int)Math.pow(2, n));
		
		System.out.println(ans);
		
		
	}
}
