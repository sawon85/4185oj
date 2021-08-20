package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon_17298 {
	
	
	static int[] arr = new int[1000000];
	static int[] ans = new int[1000000];
	static Scanner sc = new Scanner(System.in);
	static Stack<Integer> st = new Stack<>();
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		int n = Integer.parseInt(bf.readLine()); 
		
		String s = bf.readLine();
		StringTokenizer sto = new StringTokenizer(s); 
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(sto.nextToken()); 
		for(int i=0; i<n; i++) ans[i] = -1;
		
		
		for(int i=0; i<n; i++) {
			
			if(st.empty() || arr[st.peek()] > arr[i]) {
				st.add(i);
				continue;
			}
			
			while(arr[st.peek()] < arr[i]) {
				ans[st.pop()] = arr[i];
				if(st.empty()) break;
				
			}
			
			st.add(i);
		}
		
		for(int i=0; i<n; i++) bw.write(ans[i] + " ");
		
		
		bw.flush();
		bw.close();
		
	}
}
