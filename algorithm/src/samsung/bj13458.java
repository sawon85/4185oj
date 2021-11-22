package samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj13458 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int n;
	static int[] arr;
	static int b, c;
	
	static void init() throws NumberFormatException, IOException {
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

		}
		
		st = new StringTokenizer(br.readLine());
		b = Integer.parseInt(st.nextToken()); c = Integer.parseInt(st.nextToken());
	}
	
	static long check(int cnt) {
		cnt-=b;
		if(cnt<=0) return 1L;
		
		return ((long) Math.ceil((float)cnt/(float)c))+1;
	}

	static long solution() throws NumberFormatException, IOException {
		init();
		long ans=0;
		for(int i=0; i<n; i++) ans+=check(arr[i]);
		return ans;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println(solution());
	}

}
