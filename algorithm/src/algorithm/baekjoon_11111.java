package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_11111 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String s;
    
    
    static int[][] price_tag = {
    		{10, 8, 7, 5, 1},
    		{8, 6, 4, 3, 1},
    		{7, 4, 3, 2, 1},
    		{5, 3, 2, 2, 1},
    		{1, 1, 1, 1, 0}
    };
    
    static int[] xx = {-1, 1, 0, 0};
    static int[] yy = {0, 0, -1, 1};
    
    static int[][] map = new int[50][50];
    static boolean[][] visited = new boolean[50][50];
    static int n, m;
    
    static int ans = 0;
    
    static void dfs(int index, int price) {
    	
    	
    	if(index >= n*m) {
    		
    		ans = (price > ans)? price : ans;
    		
    		return;
    	}
    	
    	int x = index%m, y = index/m;
    	
    	if(visited[y][x]) {
    		
    		dfs(index+1, price);
    		return;
    	}
    	
    	int x2, y2;
    	visited[y][x] = true;
    	for(int i=0; i<4; i++) {
    		
    		x2 = x + xx[i]; y2 = y + yy[i];
    		
    		if(x2<0 || y2<0 || x2>=m || y2>=n) continue;
    		if(visited[y2][x2]) continue;
    		
    		visited[y2][x2] = true;
    		dfs(index+1, price+price_tag[map[y][x]][map[y2][x2]]);
    		visited[y2][x2] = false;
    		
    	}
    	
    	dfs(index+1, price);
    	visited[y][x] = false;
    }
    
	public static void main(String[] args) throws IOException {
		
		s = br.readLine();
		st = new StringTokenizer(s);
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=0;i <n; i++) {
			s= br.readLine();
			
			for(int j=0; j<s.length(); j++) {
				
				switch(s.charAt(j)) {
				
				case 'A' : map[i][j] = 0; break;
				case 'B' : map[i][j] = 1; break;
				case 'C' : map[i][j] = 2; break;
				case 'D' : map[i][j] = 3; break;
				case 'F' : map[i][j] = 4; break;
								
				}
				
			}
		}
		
		dfs(0,0);
		
		System.out.print(ans);

	}

}
