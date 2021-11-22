package samsung;
import java.util.*;
import java.io.*;

public class bj15684 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean[][] ladder;
	static int n, m, h;
	
	static void init() throws IOException {
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken()); m=Integer.parseInt(st.nextToken()); h=Integer.parseInt(st.nextToken());
		ladder = new boolean[h][n-1];
		
		int y, x;
		for(int i=0; i<m; i++) {
			st =new StringTokenizer(br.readLine());
			y=Integer.parseInt(st.nextToken())-1; x=Integer.parseInt(st.nextToken())-1;
			ladder[y][x]=true;
		}
		
	}
	
	static int getAns(int num) {
		
		for(int i=0; i<h; i++) {

			if(num>0&&ladder[i][num-1]) num--;
			else if(num<n-1&&ladder[i][num]) num++;

		}
		
		return num;
	}
	
	static boolean check(int y, int x) {
		
		if(ladder[y][x]) return false;
		if(x>0) if(ladder[y][x-1]) return false;
		if(x<n-2) if(ladder[y][x+1]) return false;
		
		return true;
		
	}
	
	static void print() {
		System.out.println();
		for(int i=0; i<ladder.length; i++) {
			
			for(int j=0; j<ladder[i].length; j++)
				System.out.print(ladder[i][j] + " ");
			
			System.out.println();
		}
		System.out.println();
	}
	
	static boolean dfs(int max_count, int count, int index) {
		
		if(max_count==count) {
			
			//print();
			
			for(int i=0; i<n; i++) if(i!=getAns(i)) return false;
			return true;
			
		}
		
		if(index==(n-1)*h) return false;
		
		int y = index/(n-1);
		int x = index%(n-1);
		
		if(check(y,x)) {
			ladder[y][x]=true;
			if(dfs(max_count,count+1, index+1)) return true;
			ladder[y][x]=false;
		}
		
		if(dfs(max_count,count,index+1)) return true;
		
		return false;
	}
	
	
	static int soloution() throws IOException {
		init();
		if(dfs(0,0,0)) return 0;
		if(dfs(1,0,0)) return 1;
		if(dfs(2,0,0)) return 2;
		if(dfs(3,0,0)) return 3;
		
		return -1;
	}
	public static void main(String[] args) throws IOException{
		System.out.println(soloution());
	}
}
