package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class baekjoon_16500 {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s;
	
	public static boolean remove(String a) {
		
		if(s=="") return false;
		
		Pattern pattern = Pattern.compile(a);
		Matcher matcher = pattern.matcher(s);
		
		if(!matcher.find()) return false;
		
		int st = matcher.start();
		int end = matcher.end();
		
		s = s.substring(0, st) + s.substring(end);
		
		return true;
		
	}

	public static void main(String[] args) throws IOException {
		PriorityQueue<Node> pq= new PriorityQueue<>();
		PriorityQueue<Node> temp= new PriorityQueue<>();
		
		s = bf.readLine();
		
		
		int n = Integer.parseInt(bf.readLine());
		
		for(int i=0; i<n; i++) {
			pq.add(new Node(bf.readLine()));
			
		}
		
		boolean ans = true;
		Node now;
		while(!pq.isEmpty()) {
			now = pq.poll();
			if(!remove(now.s)) {
				ans = false;
				break;
			}
			temp.add(now);
		}
		
		if(ans) {
			
			
			
		}
		
		if(ans&&s==""&&pq.isEmpty()) System.out.println(1+"\n");
		else System.out.println(0+"\n");

	}
	
	static class Node implements Comparable<Node>{
		
		String s;
		int length;
		
		Node(String s){
			this.s =s;
			length = s.length();
		}

		@Override
		public int compareTo(Node o) {
			return o.length - this.length;
		}
		
	}

}
