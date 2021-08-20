package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class baekjoon_12101 {
	
	static int[] n = new int[12];
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Set<String> set = new TreeSet<String>();
	static ArrayList<String>[] arr = new ArrayList[12];
	
	
	static void init() {
		
		n[1] = 1; arr[1].add("1");
		
		n[2] = 2; arr[2].add("1+1"); arr[2].add("2");
		
		n[3] = 4; arr[3].add("1+1+1"); arr[3].add("2+1"); arr[3].add("1+2"); arr[3].add("3");
	}
	
	static void solution(int fin) {
		
		for(int i=0; i<12; i++) arr[i] = new ArrayList<>();
		
		init();
		
		for(int i=4; i<fin+1; i++)
		{
				n[i] = n[i-3] + n[i-2] + n[i-1];
				
				for(int j=3; j>0; j--) for(String s:arr[i-j]) arr[i].add(s+"+"+j);

				
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		solution(n);
		
		Collections.sort(arr[n]);
			
		if(arr[n].size()<k) bw.write("-1");
		else bw.write(arr[n].get(k-1));
		
		bw.flush();
		bw.close();
		
	}

}
