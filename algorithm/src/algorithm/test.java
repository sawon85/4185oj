package algorithm;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class test {
	
	static char[] arr = {'d', 'd', 'd', 'd', 'c', 'c', 'r', 'r'};
	static boolean[] visited;
	static Set<String> set = new HashSet<>();
	
	static boolean check(String s) {
		if(!s.contains("dd")) return false;
		if(s.contains("cc")) return false;
		return true;
	}
	
	static void dfs(int cnt, String s) {
		
		if(cnt==arr.length) {
			if(check(s)) return;
			if(set.contains(s)) return;
			set.add(s);
			System.out.println(s);
			return;
		}
		
		for(int i=0; i<visited.length; i++) {
			if(visited[i]) continue;
			visited[i]=true;
			dfs(cnt+1, s+arr[i]);
			visited[i]=false;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		visited = new boolean[arr.length];
		dfs(0, "");
		System.out.println(set.size());
		
	}

}
