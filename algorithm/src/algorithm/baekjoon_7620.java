package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_7620 {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		
		String a=bf.readLine(), b=bf.readLine();
		int length = Math.min(a.length(), b.length());
		
		for(int i=0; i<length; i++) {
			
			if(a.charAt(i)==b.charAt(i)) bw.write("c "+b.charAt(i)+"\n");
			else bw.write("m "+b.charAt(i)+"\n");
			
		}
		
		if(a.length()>b.length()) for(int i=length;i<a.length();i++) bw.write("d "+a.charAt(i)+"\n");
		else if(a.length()<b.length()) for(int i=length;i<b.length();i++) bw.write("a "+b.charAt(i)+"\n");
		
		bw.flush();
		bw.close();
	}

}
