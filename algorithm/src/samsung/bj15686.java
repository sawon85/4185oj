package samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj15686 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int n, m;
	static ArrayList<Point> h = new ArrayList<>();
	static ArrayList<Point> chicken = new ArrayList<>();
	static int[] visited; 
	static int ans=Integer.MAX_VALUE;
	
	static void init() throws NumberFormatException, IOException {
		
		ans=Integer.MAX_VALUE;
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h.clear(); chicken.clear();
		
		int num;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<n; j++) {
				num = Integer.parseInt(st.nextToken());
				if(num==1) h.add(new Point(i, j));
				else if(num==2) chicken.add(new Point(i, j));
			}
		}
		
		visited = new int[h.size()];
		for(int i=0; i<visited.length; i++) visited[i]=Integer.MAX_VALUE;
	}
	
	static int d(Point a, Point b) {
		return Math.abs(a.x-b.x)+Math.abs(b.y-a.y);
	}
	
	static void copy(int[] from, int[] to) {
		for(int i=0; i<from.length; i++) to[i]=from[i];
	}
	
	static void dfs(int index, int count){
		
		if(count>=m) {
			
			int r=0;
			for(int i=0; i<visited.length; i++) r+=visited[i];
			
			ans=Math.min(r,  ans);
			
			return;
		}
		
		if(chicken.size()==index) return;
		
		int[] tmp = new int[visited.length];
		copy(visited, tmp);
		
		for(int i=0; i<h.size(); i++) visited[i] = Math.min(visited[i], d(h.get(i),chicken.get(index)));
		
		dfs(index+1, count+1);
		
		copy(tmp, visited);
		
		dfs(index+1, count);
		
	}
	
	public static void main(String[] args) throws IOException{
		init();
		dfs(0, 0);
		System.out.println(ans);
	}

	static class Point{
		int y, x;
		
		Point(int y, int x){
			this.y=y;
			this.x=x;
		}
	}
}
