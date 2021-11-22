package samsung;
import java.io.*;
import java.util.*;

public class bj27837 {

	static ArrayList<H>[][] map;
	static int[][] board;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1 ,1};
	static int n, k;
	static H[] hs;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	
	static void white(int num, ArrayList<H>from, ArrayList<H> to, int y, int x) {
		
		boolean meet = false;
		H tmp;
		for(int i=0; i<from.size(); i++) {
			if(from.get(i).num==num) meet=true;
			if(!meet) continue;
			tmp = from.get(i);
			tmp.y=y;
			tmp.x=x;
			to.add(tmp);
			from.remove(i);
			i--;
		}	
	}
	
    static void red(int num, ArrayList<H>from, ArrayList<H> to, int y, int x) {
    	
		H tmp;
		
		while(true) {		
			tmp = from.get(from.size()-1);
			tmp.y=y;
			tmp.x=x;
			to.add(tmp);
			from.remove(from.size()-1);
			if(tmp.num==num) break;
		}
	}
    
    static void blue(H h) {
    	if(h.d%2==0) h.d++;
    	else h.d--;
	}
    
    static int move(H k, boolean already) {
    	
    	int nx, ny;
    	
    	nx = k.x+dx[k.d];
    	ny = k.y+dy[k.d];
    	
    	
    	if(nx<0||nx>=n||ny<0||ny>=n||board[ny][nx]==2)
    	{
    		if(!already) blue(k);
    		return 1; 
    	}
    	
    	if(board[ny][nx]==0) white(k.num, map[k.y][k.x], map[ny][nx], ny, nx);
    	else red(k.num, map[k.y][k.x], map[ny][nx], ny, nx);
    	
    	if(map[ny][nx].size()>=4) return 2;
    	
    	return 0;
    }
    
    static void init() throws IOException {
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
    	board = new int[n][n];
    	map = new ArrayList[n][n];
    	
    	for(int i=0; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<n; j++) {
    			board[i][j]=Integer.parseInt(st.nextToken());
    			map[i][j] = new ArrayList<>();
    		}
    		
    	}
    	
    	hs = new H[k];
    	for(int i=0; i<k; i++) {
    		st = new StringTokenizer(br.readLine());
    		hs[i]=new H(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    		map[hs[i].y][hs[i].x].add(hs[i]);
    	}
  
    }
    
    static int solution() {
    	
    	int time=0;
    	int num;
    	while(true){
    		
    		time++;
    		for(int i=0; i<k; i++) {   			
    			num = move(hs[i], false); 			
    			if(num==1) num=move(hs[i],true);
    			if(num==2) return time;
    			
    		}
    	
    		if(time>1000) break;
    	}
    	
    	return -1;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
    	init();
    	System.out.println(solution());
    	
    }
	
	static class H{
		int y, x;
		int num;
		int d;
		
		H(int num, int y, int x, int d){
			this.num=num;
			this.y=y-1;
			this.x=x-1;
			this.d=d-1;
		}
	}
}
