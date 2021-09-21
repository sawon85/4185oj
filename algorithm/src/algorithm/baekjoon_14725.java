package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon_14725 {
	
	static Node root = new Node();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static void insert(String[] names, int index, Node parent) {
		
		if(names.length==index) return;
		
		String now = names[index];
		
		Node child;
		if(!parent.ch.containsKey(now)) {
			
			child = new Node();
			parent.ch.put(now, child);
			parent.pq.add(now);
			
		}
		
		else  child = parent.ch.get(now);
		
		insert(names, index+1, child);
		
	}
	
	static void print(Node parent, int depth) throws IOException {
		
		Node now;
		String name;
		while(!parent.pq.isEmpty()) {
			
			name = parent.pq.poll();
			
			for(int i=0; i<depth; i++) bw.write("--");
			bw.write(name+"\n");

			print(parent.ch.get(name), depth+1);
			
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
	     String s;
	     int n = Integer.parseInt(br.readLine());
	     
	     for(int i=0; i<n; i++) {
	    	 s = br.readLine();
	    	 insert(s.split(" "),1, root);
	     }
	    		 
	     print(root, 0);
	     bw.flush(); bw.close();
	}
	
	
	static class Node{
		
		HashMap<String ,Node> ch = new HashMap<>();
		PriorityQueue<String> pq = new PriorityQueue<>();
		
	}

}
