package samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj14891 {
	
	static int k;
	static T[] ts;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	
	public static void init() throws IOException {
		ts = new T[4];
		for(int i=0; i<4; i++) ts[i]=new T();
		
		for(int i=0; i<4; i++) {
			
			String s = br.readLine();
			
			for(int j=0; j<8; j++) ts[i].arr[j] = s.charAt(j)-'0';
		}
		
	}
	
	public static void wheel(int index, int d, boolean l, boolean h) {
		
		if(index>0&&l) {
			if(ts[index].get(6)!=ts[index-1].get(2)) {
				wheel(index-1, -d,true, false);
			}
		}
		
		if(index<3&&h) {
			if(ts[index].get(2)!=ts[index+1].get(6)) {
				wheel(index+1, -d,false, true);
			}
		}
		
		ts[index].wheel(d);
	}
	
	public static int solution() throws NumberFormatException, IOException {
		
		init();
		
		k = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			wheel(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()), true, true);
		}
		
		
		return ts[0].get(0)+2*ts[1].get(0)+4*ts[2].get(0)+8*ts[3].get(0);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println(solution());

	}
	
	static class T{
		
		int st = 0;
		int[] arr = new int[8];
		
		void wheel(int d) {
			
			if(d==1) {
				st--;
				if(st<0) st=7;
				return;
			}
			
			st++;
			if(st==8) st=0;
			
		}
		
		int getIdx(int i) {
			int num = st+i;
			if(num>=8) num-=8;
			return num;
		}
		
		int get(int i) {
			return arr[getIdx(i)];
		}
		
	}

}
