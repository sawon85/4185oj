package samsung;

import java.io.*;
import java.util.*;

public class bj10875 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int l, n;
	static int[] dx = {1, 0, -1, 0}; //시계방향 R R 
	static int[] dy = {0, 1, 0, -1};
	static B b;
	static int hy, hx, hd;
	static Queue<C> q = new LinkedList<>();
	
	static void init() throws NumberFormatException, IOException {
		q.clear();
		l = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		b=new B(l);
		
		String s;
		int t;
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			t=Integer.parseInt(st.nextToken()); s = st.nextToken(); 
			q.add(new C(s, t));
		}
		hy=0; hx=0; hd=0;
		b.visit(0, 0);
	}
	
	public static int solution() throws NumberFormatException, IOException {
		
		init();
		
		int time=0;
		int t=0;
		
		while(true) {
			
			time++;
			t++;
			if(!move()) return time;
			
			if(!q.isEmpty())
				if(q.peek().t==t) {
					hd = (hd+4+q.poll().d)%4;
					t=0;
				}
			
		}
	}
	
	
	public static boolean move() {
		hy = hy+dy[hd];
		hx = hx+dx[hd];
		
		if(hy<-l||hy>l||hx<-l||hx>l) return false;
		if(b.get(hy, hx)) return false;
		b.visit(hy, hx);
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println(solution());

	}
	
	static class B{
		
		int[] map;
		int n;
		
		
		B(int n){
			this.n=n;
			map = new int[n*2+1];
			
		}
		
		int getIdx(int i) {
			return i+n;
		}
		
		boolean get(int y, int x) {
			
			int a = map[getIdx(y)];
			int b = 1<<getIdx(x);
			if((a&b)==b) return true;
			return false;
		}
		
		void visit(int y, int x) {
			int a = map[getIdx(y)];
			int b = 1<<getIdx(x);
			map[getIdx(y)] = a|b;
		}
	}
	
	static class C{
		
		int d, t;
		
		C(String d, int t){
			
			if(d.equals("L")) this.d = -1;
			else this.d = 1;
			this.t=t;
		}
		
	}

}
