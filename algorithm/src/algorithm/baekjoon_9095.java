package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baekjoon_9095 {

	
	static int[] n = new int[12];
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	
	static void solution() {
		
		n[1] = 1; n[2] = 2; n[3] = 4;
		
		for(int i=4; i<12; i++) n[i] = n[i-3] + n[i-2] + n[i-1];

		
	}
	
	public static void main(String[] args) throws Exception{
		
		solution();
		
		int t = Integer.parseInt(bf.readLine());
		int num;
		
		for(int i=0; i<t; i++) bw.write(n[Integer.parseInt(bf.readLine())]+"\n");
			
		
		bw.flush();
		bw.close();
		
		
		
	}
	
}
