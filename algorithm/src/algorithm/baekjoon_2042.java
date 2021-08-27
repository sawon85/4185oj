package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_2042 {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;
	static long[] fenwikTree; 
	static long[] diff; 
	static long[] arr; 
	static int n, m, k;
	
	static void setTree(int num) {
		
		if(num<0||num>n) return;
		
		int index = num;
		
		while(index<=n) {
			fenwikTree[index]+=diff[num];
			index += index&(-index);
		}
		
	}
	
	static long getSum(int num) {
		
		if(num<=0||num>n) return 0;
		
		int index = num - (num&(-num));

	
		return fenwikTree[num] + getSum(index);
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		s = bf.readLine(); st = new StringTokenizer(s);
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
		
		fenwikTree = new long[n+1]; diff = new long[n+1]; arr = new long[n+1];
		for(int i=1; i<=n; i++) {
			diff[i] = Long.parseLong(bf.readLine());	
			arr[i] = diff[i];
		}
		
		for(int i=1; i<=n; i++) setTree(i);

		
		int a, b;
		for(int i=0; i<m+k; i++) {
			s = bf.readLine(); st = new StringTokenizer(s);
			a =  Integer.parseInt(st.nextToken()); b = Integer.parseInt(st.nextToken()); 
			
			if(a==1) {
				long c;
				c = Long.parseLong(st.nextToken());
				diff[b] = (c - arr[b]);
				arr[b] = c;
				setTree(b);
			}
			
			else if(a==2) {
				int c;
				c = Integer.parseInt(st.nextToken());
				bw.write((getSum(c) - getSum(b-1)) + "\n");
			}
			
		}
		
		bw.flush(); bw.close();
		
	}
}
