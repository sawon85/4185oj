package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_2866 {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;
	
	
	static int[] visited = new int[1000];
	static int n, m;

	static void init(StringBuilder s, Node parent, int index) {
		
		if(s.length()==index) return;
		
		Node child;
		int ch = s.charAt(index) - 'a';
		
		if(parent.childeren[ch]==null) parent.childeren[ch] = new Node();
		
		child = parent.childeren[ch];
		child.cnt++;
		visited[index] = Math.max(child.cnt, visited[index]);
		init(s, child, index+1);
		
	}
	
	static int getAns() {

		int cnt = 0;
		for(int i=n-1; i>0; i--) {
			if(visited[i-1]!=1) break;
			cnt++;
		}
		
		return cnt;
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		s = bf.readLine(); st = new StringTokenizer(s);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		StringBuilder[] ss = new StringBuilder[m+1];
		for(int i=0; i<m; i++) ss[i] = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			s = bf.readLine();
			for(int j=0; j<m; j++) ss[j].append(s.charAt(j));
			
		}
		
		Node root = new Node();
		for(int i=0; i<m; i++) init(ss[i].reverse(), root, 0);
		
		System.out.println(getAns());
		bw.flush(); bw.close();
	}
	
	static class Node{
		
		int cnt = 0;
		Node[] childeren = new Node['z'-'a'+1];
		
	}

}
