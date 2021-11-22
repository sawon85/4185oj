package samsung;
import java.util.*;
import java.io.*;

public class bj14890 {

	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;
	static int[][] map;
	static int n, r;
	
	static int sol_r() {
		
		int ans=0;
		int pre, count;
		boolean flag;
		
		for(int y=0; y<n; y++) {
			
			pre = map[y][0];
			count=1;
			flag = true;
			
			for(int x=1; x<n; x++) {
				
				if(pre==map[y][x]) {
					count++;
					continue;
				}
				
				if(pre-1==map[y][x]) {
					
					for(int i=1; i<r; i++) {
						
						if(x+i>=n) {
							flag=false;
							break;
						}
						
						if(map[y][x+i]!=pre-1) {
							flag=false;
							break;
						}
	
					}
					
					if(!flag) break;
					
					x+=r-1;
					pre=map[y][x];
					count=0;
					
					continue;
				}
				
				if(pre+1==map[y][x]) {
					if(count<r) {
						flag = false;
						break;
					}
					count=1;
					pre++;
					continue;
				}
				
				flag = false;
				break;
				
			}
			
			if(flag) ans++;
			
		}
		
		return ans;
		
	}
	static int sol_c() {
		
		int ans=0;
		int pre, count;
		boolean flag;
		
		for(int x=0; x<n; x++) {
			
			pre = map[0][x];
			count=1;
			flag = true;
			
			for(int y=1; y<n; y++) {
				
				if(pre==map[y][x]) {
					count++;
					continue;
				}
				
				if(pre-1==map[y][x]) {
					
					for(int i=1; i<r; i++) {
						
						if(y+i>=n) {
							flag=false;
							break;
						}
						
						if(map[y+i][x]!=pre-1) {
							flag=false;
							break;
						}
	
					}
					
					if(!flag) break;
					
					y+=r-1;
					pre=map[y][x];
					count=0;
					
					continue;
				}
				
				if(pre+1==map[y][x]) {
					if(count<r) {
						flag = false;
						break;
					}
					count=1;
					pre++;
					continue;
				}
				
				flag = false;
				break;
				
			}
			
			if(flag) ans++;
			
		}
		
		return ans;
		
	}
	
	static int solution() {
		return sol_r()+sol_c();
	}
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); r= Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++)
				map[i][j]=Integer.parseInt(st.nextToken());
		}
		
		bw.append(Integer.toString(solution()));
		bw.flush();
		bw.close();
	}

}
