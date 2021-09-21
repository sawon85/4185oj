package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class baekjoon_2533 {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;
	
	
	static Node[] tree;
	static int n;
	static int[][] dp;  // 0 : 얼리어 답터가 아냐 .. 1 
	static boolean[] visited;
	
	static void solution(Node parent) {
		
		int num = parent.num;
		
		if(visited[num]) return;
		
		ArrayList<Integer> children = parent.child;
		
		visited[num] = true;
		
		for(Integer child : children) solution(tree[child]);
			
		
		int nowEarlysum = 1;
		int notEarlysum = 0;
		
		for(Integer child : children) {
			
			nowEarlysum += Math.min(dp[child][0], dp[child][1]);
			notEarlysum += dp[child][1];
			
		}
		
		dp[num][0] = notEarlysum;
		dp[num][1] = nowEarlysum;
		
		
	}
	
	static void init(int p, int c) {
		
		Node parent = tree[p];
		
		if(parent.child.contains(c)) return;
		
		parent.child.add(c);
		
	}
	
	public static void main(String[] args) throws IOException {
		
		n = Integer.parseInt(bf.readLine());
		tree = new Node[n];
		dp = new int[n][2];
		visited = new boolean[n];
		
		for(int i=0; i<n; i++) tree[i] = new Node(i);
		
		int v1, v2;
		for(int i=0; i<n-1; i++) {
			s = bf.readLine();
			st = new StringTokenizer(s);
			
			v1 = Integer.parseInt(st.nextToken())-1; v2 = Integer.parseInt(st.nextToken())-1;
			init(v1, v2);
			init(v2, v1);
			
		}
		
		solution(tree[0]);
		
		System.out.println(Math.min(dp[0][0], dp[0][1]));
		
	}
	
	
	static class Node {
		
		ArrayList<Integer> child = new ArrayList<>();
		int num;
		
		Node(int num){
			this.num = num;
		}
		
	}

}
