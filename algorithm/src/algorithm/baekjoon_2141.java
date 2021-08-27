package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon_2141 {
	
	static List<Town> towns;
 	static long[] total;
	static int n;
	static int ans = 1000000001;
	static long diff = Long.MAX_VALUE;
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void binary(int l, int r) {
		
		int mid;
		
		long leftPeople, rightPeople;
		long temp;
		
		while(l<=r) {
			
			mid = (l+r)/2;
			
			leftPeople = total[mid]-(long)towns.get(mid).a;
			rightPeople = total[n-1]-total[mid];
			temp = Math.abs(rightPeople-leftPeople);
			
			if(leftPeople<rightPeople) l = mid+1;
			else if(rightPeople<leftPeople||leftPeople==rightPeople) r = mid-1;
			
			if(temp<=diff) {
				if(temp==diff&&ans<mid);
				else {
					diff = temp;
					ans = mid;
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		n = Integer.parseInt(bf.readLine());
		
		towns = new ArrayList<Town>();
		total = new long[n];
		
		String s; StringTokenizer st;
		
		int x = 0, a=0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			towns.add(new Town( Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(towns);
	
		
		total[0] = (long)towns.get(0).a;
		for(int i=1; i<n; i++) total[i] = total[i-1] + (long)towns.get(i).a;
		
		binary(0, n-1);
		
		System.out.println(towns.get(ans).x);
		
	}
	
	static class Town implements Comparable<Town> {
		
		public int x, a;
		
		Town(int x, int a){
			this.x = x; this.a=a;
		}

		@Override
		public int compareTo(Town o) {
			if (this.x>o.x) return 1;
			else return -1;
		}
		
	}
}
