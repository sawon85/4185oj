package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baekjoon_10173 {
	
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        String s;

	        StringBuilder sb = new StringBuilder();
	        while (!(s = br.readLine()).equals("EOI")) {
	            if (s.matches("*[Nn][Ee][Mm][Oo]*")) {
	                sb.append("Found\n");
	            } else {
	                sb.append("Missing\n");
	            }
	        }
	        bw.write(sb.substring(0, sb.length() - 1));
	        bw.close();
	        br.close();
	    }

}
