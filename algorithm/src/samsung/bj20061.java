package samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class bj20061 {
	
	static ArrayList<int[]> green, blue;
	static int ans=0;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	
	static boolean canGoBlock(ArrayList<int[]> board, int y, int x) {		
		if(y==0) return false;
		if(board.get(y-1)[x]==0) return true;
		return false;
	}
	
	static boolean shouldRemove(ArrayList<int[]> board) {	
		
		int[] r= board.get(4);
		for(int i=0; i<r.length; i++) {
			if(r[i]==1) return true;
		}
		
		return false;
	}

	
	static void checkBoard(ArrayList<int[]> board) {
		
		boolean check=true;
		int[] r;
		for(int j=0; j<board.size(); j++) {
			check=true;
			r=board.get(j);
			
			for(int i=0; i<r.length; i++)
				if(r[i]==0) {
					check=false;
					break;
				}
			
			if(check) {
				board.remove(j);
				ans++;
				j--;
			}
		}
		
		while(board.size()<6) board.add(new int[4]);
	}
	
	
	static void checkLight(ArrayList<int[]> board) {
		
		while(shouldRemove(board)) {
			board.remove(0);
			board.add(new int[4]);
		}
		
	}
	
	
	
	static void twoBlock(ArrayList<int[]> board, int x) {
		
		int y=4;
		
		while(canGoBlock(board, y, x)&&canGoBlock(board, y, x+1)) {y--;};
		
		board.get(y)[x]=1;
		board.get(y)[x+1]=1;
		
	}
	
	static void threeBlock(ArrayList<int[]> board, int x) {
		
		int y=4;
		
		while(canGoBlock(board, y, x)) {y--;};
		
		board.get(y)[x]=1;
		board.get(y+1)[x]=1;
		
	}
	
	static void oneBlock(ArrayList<int[]> board, int x) {
		
		int y=4;
		
		while(canGoBlock(board, y, x)) {y--;};
		
		board.get(y)[x]=1;
		
	}
	
	static void setBlock(int type, int y, int x) {
		
		switch(type) {
		
		case 1:
			oneBlock(green, x);
			oneBlock(blue, y);
			break;
			
		case 2:
			twoBlock(green, x);
			threeBlock(blue, y);
			break;
		
		case 3:
			twoBlock(blue, y);
			threeBlock(green, x);
			break;
		
		}
		
		
	}
	
	static void init() {
		
		blue=new ArrayList<>();
		green=new ArrayList<>();
		
		for(int i=0;i<6;i++)
		{
			blue.add(new int[4]);
			green.add(new int[4]);
		}
		
	}
	
	static void solution() throws NumberFormatException, IOException {
		
		ans=0;
		int n=Integer.parseInt(br.readLine());
		int type, y, x;
		StringTokenizer st;
		init();
		for(int i=0; i<n; i++) {
			
			st=new StringTokenizer(br.readLine());
			type=Integer.parseInt(st.nextToken()); y=Integer.parseInt(st.nextToken()); x=Integer.parseInt(st.nextToken());
			setBlock(type, y, x);
			checkBoard(blue);
			checkBoard(green);
			checkLight(blue);
			checkLight(green);
			
		}
		
		System.out.println(ans);
		
		int count=0;
		for(int i=0; i<blue.size();i++)
			for(int j=0; j<4; j++)
			{
				count+=blue.get(i)[j];
				count+=green.get(i)[j];
			}
		
		System.out.println(count);
	}
	
	public static void main(String[] args) throws IOException {
		solution();
	}
	
}
