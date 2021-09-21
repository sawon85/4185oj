package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon_1920 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   
    public static int binarySearch(int[] arr, int num) {
		int low = 0;
		int high = arr.length-1;
		int mid = 0;
		
		while(low<=high) {
			mid = (low + high) / 2;
			if(arr[mid]==num) return 1;
			
			else if(arr[mid]>num) high = mid-1;
			else if(arr[mid]<num) low = mid + 1;
		}
		return 0;
	}

	
	public static void main(String[] args) throws IOException {
		
	     String s;
	     int n = Integer.parseInt(br.readLine());
	     int[] arr = new int[n];
	     StringTokenizer st;
	     
	     s = br.readLine();
    	 st = new StringTokenizer(s);
    	 int num;
	     for(int i=0; i<n; i++) arr[i] = (Integer.parseInt(st.nextToken()));
	     
	     Arrays.sort(arr);
	     
	     n = Integer.parseInt(br.readLine());
	     s = br.readLine();
    	 st = new StringTokenizer(s);
	     for(int i=0; i<n; i++) {
	    	 num = Integer.parseInt(st.nextToken());
	    	 bw.write(binarySearch(arr, num)+"\n");
	     }
	     
	     bw.flush();
	     bw.close();
	}
}
