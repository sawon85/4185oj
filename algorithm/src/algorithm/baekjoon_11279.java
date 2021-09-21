package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import javax.swing.text.AbstractDocument.BranchElement;

public class baekjoon_11279 {

	static PriorityQueue<Integer> pq  = new PriorityQueue<>();
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;
	
	static void solve(int n) throws IOException {
		
		if(n!=0) {
			pq.add(-n);
			return;
		}
		
		if(pq.isEmpty()) bw.write(0+"\n");
		else bw.write(-pq.poll()+"\n");
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(bf.readLine());
		
		for(int i=0; i<n; i++) solve(Integer.parseInt(bf.readLine()));

		bw.flush(); bw.close();
	}

}
