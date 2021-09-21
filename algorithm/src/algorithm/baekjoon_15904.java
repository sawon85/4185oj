package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class baekjoon_15904 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     String s = br.readLine();
	     
	     if(s.matches(".*U.*C.*P.*C.*")) bw.write("I love UCPC");
	     else bw.write("I hate UCPC");

	     bw.flush();
	     bw.close();
	}

}
