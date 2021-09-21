package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class baekjoon_1264 {
	
	public static void main(String[] args) throws IOException {
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     String s;
	     Pattern pattern = Pattern.compile("[AaEeIiOoUu]");
	     Matcher matcher;
	     
	     while(!(s=br.readLine()).equals("#")) {
	    	matcher = pattern.matcher(s);
	    	int cnt = 0;
	    	while(matcher.find()) cnt++;
	    	bw.write(cnt+"\n");
	     }
		
	     bw.flush();
	     bw.close();
	 
	}

}
