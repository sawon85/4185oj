package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class baekjoon_11723 {
	
	
	static Scanner sc = new Scanner(System.in);
	static int number = 0;
	
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // 출력을 위한 객체
    static StringBuilder sb = new StringBuilder();
	
	static void add(int x) {
		
		number |= (1 << x);
		
	}
	
	static void remove(int x) {
		
		number &= ~(1 << x);
		
	}
	
	static void check(int x) {
		
		if( (number&(1<<x)) == 0) sb.append("0\n");
		else sb.append("1\n");
	
		
	}
	
	static void toggle(int x) {
		if( (number&(1<<x)) == 0) add(x);
		else remove(x);
	}
	
	static void all() {
		number = ~(0);
		
	}
	
	static void empty() {
		number = 0;
	}

	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			switch(cmd) {
			
			case "add" :		
				add(Integer.parseInt(st.nextToken())-1);
				break;
			
			case "remove" :		
				remove(Integer.parseInt(st.nextToken())-1);
				break;
				
			case "check" :		
				check(Integer.parseInt(st.nextToken())-1);
				break;
				
			case "toggle" :		
				toggle(Integer.parseInt(st.nextToken())-1);
				break;
				
			case "all" :		
				all();
				break;
				
			case "empty" :		
				empty();
				break;
			
			}
			
		}
		
		bw.write(sb.toString());
        bw.close();
        br.close();
		
	}
	

}
