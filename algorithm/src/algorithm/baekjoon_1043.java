package algorithm;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class baekjoon_1043 {

	public static Scanner sc = new Scanner(System.in);
	

	public static int[] w;
	public static int[] liers = new int[51];
	
	public static int n, m;
	
	public static int[][] map = new int[51][51];
	
	public static int findP(int n) {
		
		if(w[n]==n) return n;
		
		return w[n] = findP(w[n]);
		
	}
	
	public static void setP(int n1, int n2) {
		
		int p1 = findP(n1);
		int p2 = findP(n2);
		
		if(p1 > p2) {
			w[n1] = p2;
			w[p1] = p2;
		}
		
		if(p1 < p2) {
			w[n2] = p1;
			w[p2] = p1;
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		n = sc.nextInt(); m = sc.nextInt();
		
		w = new int[n+1];
		
		for(int i=1; i<=n; i++) w[i] = i;
		
		
		int liernum = sc.nextInt();
		
		for(int i=0; i<liernum; i++) {
			liers[i] = sc.nextInt();
			
			if(i>0) setP(liers[i-1], liers[i]);
		}
		
		
		for(int i=0; i<m; i++) {
			
			int num = sc.nextInt();
			 
			for(int j=0; j<num; j++) {
				map[i][j] = sc.nextInt();
				
				if(j>0) setP(map[i][j-1], map[i][j]);
				
			}
		}
		
		int ans = 0;
	
		for (int i=0; i<=n; i++) findP(i);
		
		int lierP = findP(liers[0]);
		
		for(int i=0; i<m; i++)
		{
			boolean canLie = true;
			for(int j=0; j<51; j++)
			{
				if(map[i][j] == 0 ) break;
				if(findP(map[i][j])==lierP) {
					canLie = false;
					break;
				}
			}
			
			if(canLie) ans++;
		}
		
		
		System.out.println(ans);
	
	}

}
