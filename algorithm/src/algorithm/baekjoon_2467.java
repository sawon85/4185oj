package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon_2467 {
	
	static class number implements Comparable<number> {
		
	    public int num;
	    public boolean isPlus ;
	    
	    public number(int n) {
	    	
	    	isPlus = true;
	    	
	    	if(n<0) {
	    		n *= -1;
	    		isPlus = false;
	    	}
	    	
	    	num = n;
	    }
	    
	    public int getNum() {
	    	if(isPlus) return num;
	    	return num*-1;
	    }
	    
		@Override
		public int compareTo(number o) {
			if (this.num < o.num) {
	            return -1;
	        } else if (this.num > o.num) {
	            return 1;
	        }
	        return 0;
		}
	}
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static List<number> list = new ArrayList<number>();

	

	public static void main(String[] args) throws IOException {
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		int n = Integer.parseInt(bf.readLine());
		
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		for(int i=0; i<n; i++)
		{
			int num = Integer.parseInt(st.nextToken()); 
			list.add(new number(num));
		}
		
		Collections.sort(list);

		int ans = 2000000001;
		int index = -1;
		
		int result;
		
		for(int i=0; i<n-1; i++) {
			
			result = Math.abs(list.get(i).getNum()+list.get(i+1).getNum());
			if(ans>result)
			{
					ans = result;
					index = i;
					
			}
		}
		
		int ans1 = list.get(index).getNum();
		int ans2 = list.get(index+1).getNum();
		
		if(ans1>ans2) {
			int temp = ans1;
			ans1 = ans2;
			ans2 = temp;
		}
		
		bw.write(ans1 + " " + ans2);
		bw.flush();
		bw.close();
	}

}
