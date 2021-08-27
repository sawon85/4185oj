package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_9935 {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;
	static String string;
	static String bomb;
	static StringBuilder result = new StringBuilder();
	static int length;
	
	static boolean check() {
		
		if(result.length()<length) return false;	
		if(!result.substring(result.length()-length).equals(bomb)) return false;
		
		result.delete(result.length()-length, result.length());
		return true;

	}
	
	public static void solution() {
		length = bomb.length();
	
		for(int i=0; i<string.length(); i++) {	
			result.append(string.charAt(i));
			while(check());
		}
	}
	
	public static void main(String[] args) throws IOException {
		string = bf.readLine();
		bomb = bf.readLine();
		solution();
		if(result.length()==0) bw.write("FRULA");
		else bw.write(new String(result));
		bw.flush();
		bw.close();

	}

}
