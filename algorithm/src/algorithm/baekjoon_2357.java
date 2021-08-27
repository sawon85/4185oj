package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_2357 {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;
	
	static int[] maxTree, arr, minTree;
	static int n,m;
	
	static int maxTreeInit(int start, int end, int node) {
		if(start == end) return maxTree[node] = arr[start];

		int mid = (start+end)/2;
		return maxTree[node] =  Math.max(maxTreeInit(start, mid, node*2+1),maxTreeInit(mid+1, end, node*2+2));
	}
	
	static int minTreeInit(int start, int end, int node) {
		if(start == end) return minTree[node] = arr[start];
		
		int mid = (start+end)/2;
		return minTree[node] =  Math.min(minTreeInit(start, mid, node*2+1),minTreeInit(mid+1, end, node*2+2));
	}
	
	static int getSectionMaxResult(int node, int start, int end, int left, int right) { //찾고있는 index left, right현재 찾는 ㅇ
		
		if(end<left||right<start) return 0;
		
		if(left<=start&&end<=right) return maxTree[node];
		
		int mid = (start+end)/2;
		
		return Math.max(getSectionMaxResult(node*2+1,start, mid, left, right),getSectionMaxResult(node*2+2,mid+1, end, left, right));
	}
	
	static int getSectionMinResult(int node, int start, int end, int left, int right) {
		
		if(end<left||right<start) return Integer.MAX_VALUE;
		
		if(left<=start&&end<=right) return minTree[node];
		
		int mid = (start+end)/2;
		
		return Math.min(getSectionMinResult(node*2+1,start, mid, left, right),getSectionMinResult(node*2+2,mid+1, end, left, right));
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		s = bf.readLine(); st = new StringTokenizer(s);
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken()); 
		arr = new int[n]; maxTree = new int[n*4]; minTree = new int[n*4];
		
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(bf.readLine());
		
		maxTreeInit(0,n-1,0); minTreeInit(0,n-1,0);
		
		int a, b;
		for(int i=0; i<m; i++) {
			s = bf.readLine(); st = new StringTokenizer(s);
			a = Integer.parseInt(st.nextToken()); b = Integer.parseInt(st.nextToken());
			bw.write(getSectionMinResult(0, 0, n-1, a-1, b-1) + " " + getSectionMaxResult(0, 0, n-1, a-1, b-1)+"\n");
			
		}
		
		bw.flush(); bw.close();
		
	}
}
