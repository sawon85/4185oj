package Kakao0821;

public class nhn3 {

	static int ans=0;
	static boolean[] visited = new boolean[8];
	static int[][] c;
	
	
	static boolean check(int[] ch, String s) {
		
		String a = Integer.toString(ch[0])+Integer.toString(ch[1]);
		if(s.contains(a)) return false;
		
		a = Integer.toString(ch[1])+Integer.toString(ch[0]);
		if(s.contains(a)) return false;
		
		return true;
	}
	
	
	static boolean available(String s) {
		
		for(int i=0; i<c.length; i++) if(!check(c[i], s)) return false;
		return true;
		
	}
	
	static void dfs(int count, String s) {
		
		if(count==9) {
			if(available(s)) ans++;
			return;
		}
		
		for(int i=1; i<=8; i++) {
			if(visited[i-1]) continue;
			dfs(count+1, s+i);
		}
		
	}
	
}
