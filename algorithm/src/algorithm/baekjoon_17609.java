package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baekjoon_17609 {
	
	
	static int check(String s, int l, int r, boolean alreayRemove) {
		
		while(l<r) {
			
			if(s.charAt(l)==s.charAt(r)) {
				l++;
				r--;
				continue;
			}
			
			if(alreayRemove) return 2;
			
			int ans1 = check(s, l+1, r, true);
			int ans2 = check(s, l, r-1, true);
			
			return  Math.min(ans1, ans2);
			
		}
		
		if(alreayRemove) return 1;
		return 0;
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     String s;
	     int n = Integer.parseInt(br.readLine());
	     
	     for(int i=0; i<n; i++) {
	    	 s = br.readLine();
	    	 bw.write(check(s, 0, s.length()-1, false)+"\n");
	    	 
	     }
	     
	     bw.flush(); bw.close();
	     
	}

}
