package algorithm;

import java.util.Scanner;

public class baekjoon_14569 {
	
	static Scanner sc = new Scanner(System.in);

	
	public static void main(String[] args) {

		Long[] timetable;
		
		int n;
		
		n = sc.nextInt();
		timetable = new Long[n];
		
		int k;
		
		
		for(int i=0; i<n; i++) {
			
			k = sc.nextInt();
			timetable[i] = 0L;
			
			for(int j=0; j<k; j++) {
				
				int time = sc.nextInt();
				time--;
				
				timetable[i] ^= 1L<<time;
				
			}
		
		}
		
		int m;
		m = sc.nextInt();
		
		for(int i=0; i<m; i++) {
			
			int p;
			p = sc.nextInt();
			
			Long t = 0L;
			
			for(int q=0; q<p; q++) {
				
				int time = sc.nextInt();
				time--;
				
				 t ^= 1L<<time;
				
			}
			
			Long diff;
			int cnt = 0;
			
			for(int j=0; j<n; j++)
			{
				diff = (t&timetable[j]);
				
				
				if(diff.equals(timetable[j])) cnt++;
				
			}
			
			System.out.println(cnt);
			
		}
		
	}

}
