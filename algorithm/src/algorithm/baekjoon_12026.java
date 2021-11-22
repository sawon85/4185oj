package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class baekjoon_12026 {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] road = new int[1000+1];
	static StringBuilder sb;
	static ArrayList<Integer>[] arr = new ArrayList[3];
	
	
	public static void solution(int n) {
		
		
		Arrays.fill(road, -1);
		road[1] = 0;
		
		int now = 0;
		int boj;
		int index;
		int pre;
		int k;
		
		for(int i=2; i<=n; i++) {
			
			
			index = sb.charAt(i-1) - '0';
			pre = (index+2)%3;
			
			for(int j : arr[pre]) {
				
				if(j>i) break;
				
				if(road[j] == -1) continue;
				
				k = (i-j)*(i-j);
				
				if(road[i]==-1) road[i] = road[j]+k;
				else road[i] = Math.min(road[i], road[j]+k);
				
			}
			
		}
		
		
	}
	
	
	public static void main(String[] args) throws Exception{
		
		int n = Integer.parseInt(bf.readLine());
		
		String s = bf.readLine();
		
		for(int i=0; i<3; i++) arr[i] = new ArrayList<>();
		
		sb = new StringBuilder();
		
		for(int i=0;i<s.length(); i++) {
			
			switch(s.charAt(i)) {
			
			case 'B':
				sb.append('0'); 
				arr[0].add(i+1);
				break;
				
			case 'O':
				sb.append('1'); 
				arr[1].add(i+1);
				break;
				
			case 'J':
				sb.append('2');
				arr[2].add(i+1);
				break;
			
			
			}
		}
		
		solution(n);
		
		System.out.println(road[n]);
		
	}
	
}
