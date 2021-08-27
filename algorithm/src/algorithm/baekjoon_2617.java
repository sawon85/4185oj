package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon_2617 {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;
	
	static ArrayList<Integer>[] heavier;
	static ArrayList<Integer>[] lighter;
	static int max = 0;
	static boolean[] visited;
	
	
	static void dfs(int st, int cnt, ArrayList<Integer>[] arr) {
		
		if(arr[st].size() == 0) {
			max += cnt;
			return;
		}
		
		for(Integer ball : arr[st]) {
			if(visited[ball]) continue;
			visited[ball] = true;
			dfs(ball, cnt+1, arr);
		}
		
	}

	public static void main(String[] args) throws IOException {
		
		int n, m;
		
		s = bf.readLine(); st = new StringTokenizer(s);
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		
		heavier = new ArrayList[n]; lighter = new ArrayList[n];
		visited = new boolean[n];
		
		for(int i=0; i<n; i++) {
			heavier[i] = new ArrayList<>();
			lighter[i] = new ArrayList<>();
		}
		
		int light, heavy;
		for(int i=0; i<m; i++) {
			s = bf.readLine(); st = new StringTokenizer(s);
			heavy = Integer.parseInt(st.nextToken())-1; light = Integer.parseInt(st.nextToken())-1;
			lighter[heavy].add(light);
			heavier[light].add(heavy);
		}
		
		int ans = 0;
		
		for(int i=0; i<n; i++) {
			
			max = 0;
			for(int j=0; j<n; j++) visited[j] = false;
			dfs(i, 0, heavier);
			
			
			if(max >= (n+1)/2) {
				ans++;
				continue;
			}
			
			max = 0;
			for(int j=0; j<n; j++) visited[j] = false;
			dfs(i, 0, lighter);
			if(max >= (n+1)/2) ans++;
		}
		

		System.out.println(ans);
	}

}
