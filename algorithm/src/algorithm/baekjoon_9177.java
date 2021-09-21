package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_9177 {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;

	static boolean check(String s1, String s2, String s3, int i1, int i2, int i3) {
		
		if(i3==s3.length() && i2==s2.length() && i1==s1.length()) return true;	
		
		if(i1<s1.length())
		if(s1.charAt(i1)==s3.charAt(i3)) {
			if(check(s1, s2, s3, i1+1, i2, i3+1)) return true;
		}
		
		if(i2<s2.length())
		if(s2.charAt(i2)==s3.charAt(i3)) {
			if(check(s1, s2, s3, i1, i2+1, i3+1)) return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int n = Integer.parseInt(bf.readLine());
		
		for(int i=0; i<n; i++) {
			s = bf.readLine(); st = new StringTokenizer(s);
			if(check(st.nextToken(), st.nextToken(), st.nextToken(), 0, 0, 0)) bw.write("Data set " + (i+1) + ": yes\n");
			else bw.write("Data set " + (i+1) + ": no\n");
		}

		bw.flush(); bw.close();
	}

}
