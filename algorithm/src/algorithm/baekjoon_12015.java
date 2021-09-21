package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon_12015 {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	
	
	public static int lower_bound(int num) {
		
		int begin = 0;
	    int end = arr.size();
	    
	    while(begin < end) {
	    	int mid = (begin + end) / 2;
	        
	        if(arr.get(mid) >= num) {
	        	end = mid;
	        }
	        else {
	        	begin = mid + 1;
	        }
	    }
	    
	    return end;
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int n = Integer.parseInt(bf.readLine());
		int cnt = 0;
		s = bf.readLine(); st = new StringTokenizer(s);
		int tmp;
		arr.add(-1);
		int lower;
		
		for(int i=0;i<n; i++) {
			tmp = Integer.parseInt(st.nextToken());
			
			if(arr.get(arr.size()-1)<tmp) {
				arr.add(tmp); cnt++;
				continue;
			}
			
			lower = lower_bound(tmp);
			arr.set(lower, tmp);
			
		}

		System.out.println(cnt);

	}
	

}
