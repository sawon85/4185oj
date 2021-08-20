package algorithm;

import java.util.Scanner;

public class baekjoon_11062 {
		
	static int[] card = new int[1000];
	static int n;
	static Scanner sc = new Scanner(System.in);
	static int[][] k = new int[1000][2];   // 0 left 1 right
	static int[][] m = new int[1000][2];
	
	
	public static void main(String[] args) {
		
		n = sc.nextInt();
		
		for(int i=0; i<n; i++)  card[i] = sc.nextInt();
		
		k[0][0] = card[0]; k[0][1] = card[0];
		m[0][0] = 0; m[0][1] = 0;
		
		for(int i=1; i<n; i++) {
			
			k[i][0] = Math.max(  );
			k[i][1] = Math.max(  );
		
			
		}
		
	}

}
