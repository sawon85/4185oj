package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baekjoon_3568 {

	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void print(String value, String name) {
		
		StringBuilder v = new StringBuilder(value);
		StringBuilder n = new StringBuilder(name);
		
		char c;
		for(int i=name.length()-1; i>=0; i--) {
			
			c = name.charAt(i);
			
			if(c=='['||c==']'||c=='*'||c=='&') {
				
				if(c=='[') v.append(']');
				else if(c==']') v.append('[');
				else v.append(name.charAt(i));
				n.deleteCharAt(i);
				continue;
			}
			
			break;
		}
		
		System.out.println(v+" "+n+";");
		
	}
	
	
	public static void solution(String s) {
		
		s = s.substring(0,s.length()-1);
		s = s.replaceAll(", ", " ");
		String[] arr = s.split(" ");
		
		for(int i=1; i<arr.length; i++) print(arr[0], arr[i]);
			

	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String s = bf.readLine();
		
		solution(s);
	}

}
