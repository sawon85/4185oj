package samsung;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj27140 {
	
	static int[][] a;
	static int rs=3, cs=3;
	static int r, c, k;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
	
	public static void init() throws IOException {
		
		a = new int[100][100];
		rs=3; cs=3;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		r=Integer.parseInt(st.nextToken())-1; c=Integer.parseInt(st.nextToken())-1; k=Integer.parseInt(st.nextToken());
		 
		
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) a[i][j] = Integer.parseInt(st.nextToken());
		}
		
	}
	
	
	
	public static int C(int c) {
		
		Num[] nums = new Num[101];
		for(int i=0; i<101; i++) nums[i] = new Num(i);
		
		for(int i=0; i<rs; i++) {
			if(a[i][c]==0) continue;
			nums[a[i][c]].count++;
		}
		
		Arrays.sort(nums);
		
		int i=0;
		
		for(Num n : nums) {
			if(n.count==0) continue;
			a[i++][c] = n.num;
			if(i>=100) break;
			a[i++][c] = n.count;
			if(i>=100) break;
		}
		
		for(int j=i;j<rs; j++) a[j][c] = 0;
		
		return i;
	}

	public static int R(int r) {
		
		Num[] nums = new Num[101];
		for(int i=0; i<101; i++) nums[i] = new Num(i);
		
		for(int i=0; i<cs; i++) {
			if(a[r][i]==0) continue;
			nums[a[r][i]].count++;
		}
		
		Arrays.sort(nums);
		
		int i=0;

		for(Num n : nums) {
			if(n.count==0) continue;
			a[r][i++] = n.num;
			if(i>=100) break;
			a[r][i++] = n.count;
			if(i>=100) break;
		}
		
		for(int j=i;j<cs; j++) a[r][j] = 0;
		
		return i;
	}
	
	public static int solution() throws IOException {
		
		init();
		
		int time=0;
		
		while(true) {
		
			if(a[r][c]==k) return time;
			if(time>100) break;
			
			
			int tmp=0;
			if(rs>=cs) {
				
				for(int i=0; i<rs; i++) tmp=Math.max(R(i), tmp);
				cs=tmp;
				
			}
			
			else {
				
				for(int i=0; i<cs; i++) tmp=Math.max(C(i), tmp);
				rs=tmp;
				
			}
			
			time++;
			
			

		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(solution());

	}

	
	static class Num implements Comparable<Num>{

		int num;
		int count;
		
		Num(int num){
			this.num=num;
			this.count=0;
		}
		
		@Override
		public int compareTo(Num o) {
			if(this.count==o.count) return this.num-o.num;
			return this.count-o.count;
		}
		
	}
}
