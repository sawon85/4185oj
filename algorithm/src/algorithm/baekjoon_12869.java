package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_12869 {

	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static int[][][] visited = new int[61][61][61];
	static int[][] p = {{9,3,1},{9,1,3},{3,9,1},{3,1,9},{1,3,9},{1,9,3} };
	
	
	public static int solution(int[] hp) {
		
		Info tmp = new Info(hp, 1);
		visited[hp[0]][hp[1]][hp[2]] = 1;
		Queue<Info> q = new LinkedList<>();
		q.add(tmp);
		Info newInfo;
		
		while(!q.isEmpty()) {
			
			tmp = q.poll();
			
			for(int i=0; i<6; i++) {
				
				int[] newHp = new int[3];
				
				
				for(int j=0; j<3; j++) {
					newHp[j] = Math.max(tmp.hp[j] - p[i][j], 0);
					
				}
	
				
				newInfo = new Info(newHp, tmp.cnt+1);
				if(visited[newHp[0]][newHp[1]][newHp[2]] > 0 ) continue;
				if(newHp[0]==0 && newHp[1]==0 && newHp[2]==0) return tmp.cnt;
				visited[newHp[0]][newHp[1]][newHp[2]] = tmp.cnt+1;
				q.add(newInfo);
				
			}
			
			
		}
		
		return -1;
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int n  = Integer.parseInt(bf.readLine());
		int[] hp = new int[3];
		
		
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		for(int i=0; i<n; i++) {
			hp[i] = Integer.parseInt(st.nextToken());
			
		}

		
		System.out.println(solution(hp));
	}

	
	public static class Info {
		
		int[] hp;
		int cnt;
		
		Info(int[] hp, int cnt) {
			
			Arrays.sort(hp);
			this.hp = hp.clone();
			this.cnt = cnt;
			
		}
		
	}
}
