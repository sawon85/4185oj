package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon_16637 {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;
	static StringBuilder cmd = new StringBuilder();
	static ArrayList<Integer> nums = new ArrayList<>();
	static int max = Integer.MIN_VALUE;
	static boolean[] visited;
	
	public static int cacul(char oper, int n1, int n2) {
		
		switch(oper) {
		
		case '+' : return n1+n2;
		case '-' : return n1-n2;
		case '*' : return n1*n2;
		
		}
		
		return 0;
	}
	
	public static int getResult() {
		
		int ans = cacul(cmd.charAt(0),nums.get(0), nums.get(1));
				
		for(int i=1; i<cmd.length(); i++) {
			ans = cacul(cmd.charAt(i),ans,nums.get(i+1));
		}
		
		return ans;
	}
	
	public static void solve() {
		
		StringBuilder originalCmd = new StringBuilder(cmd);
		ArrayList<Integer> originalNums = (ArrayList<Integer>) nums.clone();
		
		int val;
		
		for(int i=0; i<visited.length; i++) {
			if(!visited[i]) continue;
			val = cacul(cmd.charAt(i),nums.get(i),nums.get(i+1));
			cmd.setCharAt(i, '+');
			nums.set(i, val);
			nums.set(i+1, 0);

		}
		
		max = Math.max(max, getResult());
		
		cmd = originalCmd;
		nums = originalNums;
	}
	
	public static void dfs(int index, boolean pre) {
		
		if(index==visited.length) {
			solve();
			return;
		}
		
		if(!pre) {
			visited[index] = true;
			dfs(index+1, true);
			visited[index] = false;
		}
		
		dfs(index+1, false);
	}
	
	public static void main(String[] args) throws IOException{
		
		int n; n=Integer.parseInt(bf.readLine());
		s = bf.readLine();
		
		for(int i=0; i<n; i++) {
			if(i%2==0) nums.add(s.charAt(i)-'0');
			else cmd.append(s.charAt(i));		
		}
		
		visited = new boolean[cmd.length()];
		
		if(n==1) max = nums.get(0);
		else dfs(0, false);
		
		System.out.println(max);
	}
}
