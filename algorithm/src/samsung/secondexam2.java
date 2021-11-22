package samsung;

import java.io.*;
import java.util.*;

public class secondexam2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int sy, sx;
	static int n,m;
	static int[][] map;
	static Queue<Integer> q = new LinkedList<>();
	static Queue<I> bq = new LinkedList<>();
	static int[] ans;
	
	static void init() throws IOException {
		
		q.clear();
		bq.clear();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		sy=n/2; sx=sy;
		map=new int[n][n];
		ans = new int[4];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) map[i][j]=Integer.parseInt(st.nextToken());
		}
		
	}
	
	static void magic(int d, int s) {
		
		d--;
		
		int nx, ny;
		
		for(int i=1; i<=s; i++) {
			
			ny = sy+i*dy[d]; nx = sx+i*dx[d];
			
			if(ny<0||ny>=n||nx<0||nx>=n) continue;
			map[ny][nx]=0;
		}
		
	}
	
	static void move() {
		
		q.clear();
		
		int y=sy, x=sx;
		int nn=1;
		
		while(nn<n) {
			
			for(int i=0; i<nn; i++) if(map[y][--x]!=0) q.add(map[y][x]);
			for(int i=0; i<nn; i++) if(map[++y][x]!=0) q.add(map[y][x]);
			
			nn++;
			
			for(int i=0; i<nn; i++) if(map[y][++x]!=0) q.add(map[y][x]);
			for(int i=0; i<nn; i++) if(map[--y][x]!=0) q.add(map[y][x]);
			
			if(nn==n-1) for(int i=0; i<nn; i++) if(map[y][--x]!=0) q.add(map[y][x]);
			nn++;
			
		}
		
		y=sy; x=sx;
		nn=1;
		
		while(nn<n) {
			
			for(int i=0; i<nn; i++) {
				--x;
				if(q.isEmpty()) map[y][x]=0;
				else map[y][x]=q.poll();
				
			}
			
			for(int i=0; i<nn; i++) {
				++y;
				if(q.isEmpty()) map[y][x]=0;
				else map[y][x]=q.poll();
				
			}
				
			
			nn++;
			
			for(int i=0; i<nn; i++) {
				++x;
				if(q.isEmpty()) map[y][x]=0;
				else map[y][x]=q.poll();
				
			}
				
			for(int i=0; i<nn; i++) {
				--y;
				if(q.isEmpty()) map[y][x]=0;
				else map[y][x]=q.poll();
				
			}
			
			if(nn==n-1) {
				
				for(int i=0; i<nn; i++) {
					--x;
					if(q.isEmpty()) map[y][x]=0;
					else map[y][x]=q.poll();
					
				}
			}
			nn++;
			
		}
		
	}
	
	public static void afterZip() {
		
		
		int y=sy, x=sx;
		int nn=1;
		I now = null;
		
		while(nn<n) {
			
			for(int i=0; i<nn; i++) {
				--x;
				
				if(now==null&bq.isEmpty()) map[y][x]=0;
				else {
					
					if(now==null) {
						now=bq.poll();
						map[y][x]=now.cnt;
					}
					
					else {
						map[y][x]=now.num;
						now=null;
					}
				}
				
			}
			
			for(int i=0; i<nn; i++) {
				++y;
				
				if(now==null&bq.isEmpty()) map[y][x]=0;
				else {
					
					if(now==null) {
						now=bq.poll();
						map[y][x]=now.cnt;
					}
					
					else {
						map[y][x]=now.num;
						now=null;
					}
				}
					
				
			}
				
			
			nn++;
			
			for(int i=0; i<nn; i++) {
				++x;
				if(now==null&bq.isEmpty()) map[y][x]=0;
				else {
					
					if(now==null) {
						now=bq.poll();
						map[y][x]=now.cnt;
					}
					
					else {
						map[y][x]=now.num;
						now=null;
					}
				}
				
				
			}
				
			for(int i=0; i<nn; i++) {
				--y;
				if(now==null&bq.isEmpty()) map[y][x]=0;
				else {
					
					if(now==null) {
						now=bq.poll();
						map[y][x]=now.cnt;
					}
					
					else {
						map[y][x]=now.num;
						now=null;
					}
				}
				
			}
			
			if(nn==n-1) {
				
				for(int i=0; i<nn; i++) {
					--x;
					if(now==null&bq.isEmpty()) map[y][x]=0;
					else {
						
						if(now==null) {
							now=bq.poll();
							map[y][x]=now.cnt;
						}
						
						else {
							map[y][x]=now.num;
							now=null;
						}
					}
					
				}
			}
			nn++;
			
		}
		
	}
	
	public static void afterBurn() {
		
		
		int y=sy, x=sx;
		int nn=1;
		int cnt=0;
		I now = null;
		
		while(nn<n) {
			
			for(int i=0; i<nn; i++) {
				--x;
				
				if(!bq.isEmpty()&&y==bq.peek().y&&x==bq.peek().x) {
					now=bq.poll();
					cnt=0;
				}
				
				if(now!=null&&cnt<now.cnt) {
					cnt++;
					ans[map[y][x]]++;
					map[y][x]=0;
					
					if(cnt==now.cnt) now=null;
				}	
			}
			
			for(int i=0; i<nn; i++) {
				++y;
				
				if(!bq.isEmpty()&&y==bq.peek().y&&x==bq.peek().x) {
					now=bq.poll();
					cnt=0;
				}
				
				if(now!=null&&cnt<now.cnt) {
					cnt++;
					ans[map[y][x]]++;
					map[y][x]=0;
					
					if(cnt==now.cnt) now=null;
				}	
				
			}
				
			
			nn++;
			
			for(int i=0; i<nn; i++) {
				++x;
				if(!bq.isEmpty()&&y==bq.peek().y&&x==bq.peek().x) {
					now=bq.poll();
					cnt=0;
				}
				
				if(now!=null&&cnt<now.cnt) {
					cnt++;
					ans[map[y][x]]++;
					map[y][x]=0;
					
					if(cnt==now.cnt) now=null;
				}	
				
			}
				
			for(int i=0; i<nn; i++) {
				--y;
				if(!bq.isEmpty()&&y==bq.peek().y&&x==bq.peek().x) {
					now=bq.poll();
					cnt=0;
				}
				
				if(now!=null&&cnt<now.cnt) {
					cnt++;
					ans[map[y][x]]++;
					map[y][x]=0;
					
					if(cnt==now.cnt) now=null;
				}	
			}
			
			if(nn==n-1) {
				
				for(int i=0; i<nn; i++) {
					--x;
					if(!bq.isEmpty()&&y==bq.peek().y&&x==bq.peek().x) {
						now=bq.poll();
						cnt=0;
					}
					
					if(now!=null&&cnt<now.cnt) {
						cnt++;
						ans[map[y][x]]++;
						map[y][x]=0;
						
						if(cnt==now.cnt) now=null;
					}	
					
				}
			}
			nn++;
			
		}
		
	}
	
	public static boolean burn() {
		
		bq.clear();
		
		int y=sy, x=sx;
		int nn=1;
		int sty = y,stx=x;
		I now=null;
		
		while(nn<n) {
			
			for(int i=0; i<nn; i++) {
				--x;
				
				if(map[y][x]==0) break;
				if(now==null) now = new I(y, x, map[y][x]);
				else if(now.num==map[y][x]) now.cnt++;
				else {
					
					if(now.cnt>=4) {
						bq.add(now);
					}
					now = new I(y, x, map[y][x]);
				}
			}
			
			if(map[y][x]==0) break;
			
			for(int i=0; i<nn; i++) {
				++y;
				
				if(map[y][x]==0) break;
				if(now==null) now = new I(y, x, map[y][x]);
				else if(now.num==map[y][x]) now.cnt++;
				else {
					
					if(now.cnt>=4) {
						bq.add(now);
					}
					now = new I(y, x, map[y][x]);
				}
			}
			
			if(map[y][x]==0) break;
			
			nn++;
			
			for(int i=0; i<nn; i++) {
				++x;
				
				if(map[y][x]==0) break;
				if(now==null) now = new I(y, x, map[y][x]);
				else if(now.num==map[y][x]) now.cnt++;
				else {
					
					if(now.cnt>=4) {
						bq.add(now);
					}
					now = new I(y, x, map[y][x]);
				}
			}
			
			if(map[y][x]==0) break;
				
			for(int i=0; i<nn; i++) {
				--y;
				
				if(map[y][x]==0) break;
				if(now==null) now = new I(y, x, map[y][x]);
				else if(now.num==map[y][x]) now.cnt++;
				else {
					
					if(now.cnt>=4) {
						bq.add(now);
					}
					now = new I(y, x, map[y][x]);
				}
			}
			
			if(map[y][x]==0) break;
			
			if(nn==n-1) {
				
				for(int i=0; i<nn; i++) {
					--x;
					
					if(map[y][x]==0) break;
					if(now==null) now = new I(y, x, map[y][x]);
					else if(now.num==map[y][x]) now.cnt++;
					else {
						
						if(now.cnt>=4) {
							bq.add(now);
						}
						now = new I(y, x, map[y][x]);
					}
				}
				
				if(map[y][x]==0) break;
			}
			nn++;
		}
		
		
		if(now!=null&&now.cnt>=4) bq.add(now);
		
		if(bq.isEmpty()) return false;
		afterBurn();
		return true;
	}
	
	
	
	public static void zip() {
		
		bq.clear();
		
		int y=sy, x=sx;
		int nn=1;
		int sty = y,stx=x;
		I now=null;
		
		while(nn<n) {
			
			for(int i=0; i<nn; i++) {
				--x;
				
				if(map[y][x]==0) break;
				if(now==null) now = new I(y, x, map[y][x]);
				else if(now.num==map[y][x]) now.cnt++;
				else {
					bq.add(now);
					now = new I(y, x, map[y][x]);
				}
			}
			
			if(map[y][x]==0) break;
			
			for(int i=0; i<nn; i++) {
				++y;
				
				if(map[y][x]==0) break;
				if(now==null) now = new I(y, x, map[y][x]);
				else if(now.num==map[y][x]) now.cnt++;
				else {
					bq.add(now);
					now = new I(y, x, map[y][x]);
				}
			}
			
			if(map[y][x]==0) break;
			
			nn++;
			
			for(int i=0; i<nn; i++) {
				++x;
				
				if(map[y][x]==0) break;
				if(now==null) now = new I(y, x, map[y][x]);
				else if(now.num==map[y][x]) now.cnt++;
				else {
					bq.add(now);
					now = new I(y, x, map[y][x]);
				}
			}
			
			if(map[y][x]==0) break;
				
			for(int i=0; i<nn; i++) {
				--y;
				
				if(map[y][x]==0) break;
				if(now==null) now = new I(y, x, map[y][x]);
				else if(now.num==map[y][x]) now.cnt++;
				else {
					bq.add(now);
					now = new I(y, x, map[y][x]);
				}
			}
			
			if(map[y][x]==0) break;
			
			if(nn==n-1) {
				
				for(int i=0; i<nn; i++) {
					--x;
					
					if(map[y][x]==0) break;
					if(now==null) now = new I(y, x, map[y][x]);
					else if(now.num==map[y][x]) now.cnt++;
					else {
						bq.add(now);
						now = new I(y, x, map[y][x]);
					}
				}
				
				if(map[y][x]==0) break;
			}
			nn++;
		}
		
		if(now!=null) bq.add(now);
		afterZip();
		
	}
	
	public static void print() {
		
		System.out.println();
		for(int i=0; i<n; i++) {
			
			for(int j=0; j<n; j++) {
				
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	public static int solution() throws IOException {
		
		init();
		StringTokenizer st;
		
		int d, s;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken()); s = Integer.parseInt(st.nextToken());
			magic(d, s);
			move();
			//print();
			while(burn()) move();
			//print();
			zip();
			//print();
		}
		
		return ans[1]+2*ans[2]+3*ans[3];
	}

	public static void main(String[] args) throws IOException {
		System.out.println(solution());

	}
	
	public static class I{
		
		int y,x, num, cnt=1;
		
		I(int y, int x, int num) {
			this.y=y; this.x=x; this.num=num;
		}
		
	}

}
