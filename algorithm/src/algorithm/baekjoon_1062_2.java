package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_1062_2 {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;
	static int n, k;
	static int[] sentences;
	static int visited  = 0;
	static int length = 'z' - 'a' + 1;
	static int ans = -1;
	
	public static void dfs(int index,int cnt) {
		
		
		if(cnt == k) {			
			int result = 0;	
			for(int i=0; i<sentences.length; i++) if((sentences[i]&visited)==sentences[i]) result++;		
			ans = Math.max(ans, result);
			return;
		}

		if(index>=length) return;
		
		int temp;
		
		for(int i=index; i<length; i++) {
			temp = 1<<i;

			if((visited & temp) != 0 ) continue;
			
			visited |= temp;
			dfs(i+1,cnt+1);
			visited &= ~temp;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		visited |= (1<<('a'-'a')); 
		visited |= (1<<('c'-'a')); 
		visited |= (1<<('i'-'a'));  
		visited |= (1<<('n'-'a'));  
		visited |= (1<<('t'-'a')); 
		
		s = bf.readLine(); st = new StringTokenizer(s);
		n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
		sentences = new int[n];
		
		for(int i=0; i<n; i++) {
			s = bf.readLine();
			for(int j=0; j<s.length(); j++) {	
				sentences[i] |=  (1<<(s.charAt(j)-'a')); 
			}

		}
		
		if(k<5) System.out.println(0);
		else if(k==length) System.out.println(n);
		else {
			k -= 5;
			dfs(0,0);
			System.out.println(ans);
		}
		
	}

}
