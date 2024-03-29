package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_2617_2 {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;
	static int[] map;
	static ArrayList<Integer>[] arr;
	static Queue<Integer> q = new LinkedList<>();
	static int n;
	
	void solutiont(int st) {
		
		q.add(st);
		int ball;
		
		while(!q.isEmpty()) {
		
			ball = q.poll();
		
			for(int heavier: arr[ball]) {
				map[heavier]--;
				
				if(map[heavier] == 0) q.add(heavier);
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		
		
		
	}

}
