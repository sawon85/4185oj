package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_1717 {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
	static int[] w= new int[1000001];
	
	static int findP(int n) {
		
		
		if(n==w[n]) return n;
		
		return w[n] = findP(w[n]);
	}

	
	static void setP(int n1, int n2) {
		
		int p1 = findP(n1);
		int p2 = findP(n2);
		
		if(p1 < p2) {
			
			w[p2] = p1;
			w[n2] = p1;
			
		}
		
		
		if(p1 > p2) {
			
			w[p1] = p2;
			w[n1] = p2;
			
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s); //StringTokenizer인자값에 입력 문자열 넣음\
		
		int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=n ; i++) w[i] = i;
		
		int comm, n1, n2;
		for(int i=0; i<m; i++) {
			
			s = bf.readLine();
			st = new StringTokenizer(s);
			comm = Integer.parseInt(st.nextToken());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			
			if(comm == 0) {
				setP(n1, n2);
				continue;
			}
			
			if(comm == 1) {
				
				if(findP(n1) == findP(n2)) bw.write("YES\n");
				else bw.write("NO\n");
				
			}
			
		}
		
		bw.flush();   //남아있는 데이터를 모두 출력시킴
		bw.close();
		
	   }
}
