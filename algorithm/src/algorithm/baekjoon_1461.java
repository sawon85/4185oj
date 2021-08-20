package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_1461 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    static StringTokenizer st;
    static String s;
    static PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> minus = new PriorityQueue<>();
    
    
    static Integer[] book_plus;
    static Integer[] book_minus;
    static int n, m;
    static int ans = 0;
    static int bigAbs = 0;
    
    static void solution(PriorityQueue<Integer> number) {
    	
    	if(number.isEmpty()) return;
    	
    	int length = number.peek();
    	
    	for(int i=0; i<m; i++) { if(number.isEmpty()) break; number.poll();}
    	
    	if(length == bigAbs) ans += Math.abs(length);
    	
    	else ans += 2* Math.abs(length);
    	
    	solution(number);
    }
    
    public static void main(String[] args) throws IOException {
    	
    	s = br.readLine();
    	st = new StringTokenizer(s);
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	book_plus = new Integer[n];
    	book_minus = new Integer[n];
    	
 
    	s = br.readLine();
    	st = new StringTokenizer(s);
 
    	
    	for(int i=0; i<n; i++) {
    		
    		int spot = Integer.parseInt(st.nextToken());
    		
    		if(spot > 0) plus.add(spot);
    		else minus.add(spot);
    		
    	}
    	
    	if(plus.isEmpty()) bigAbs = minus.peek();
    	else if(minus.isEmpty()) bigAbs = plus.peek();
    	else bigAbs = (plus.peek() > Math.abs(minus.peek())) ? plus.peek() : minus.peek();
    	
    	solution(plus); solution(minus);
    	
    	System.out.print(ans);
    	
    }
	
}
