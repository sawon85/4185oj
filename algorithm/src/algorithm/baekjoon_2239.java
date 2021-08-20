package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class baekjoon_2239 {

	static StringBuilder board = new StringBuilder();
	
	static PriorityQueue<String> q = new PriorityQueue<>();
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	
	static boolean checkBlock(int index) {
		
		Set<Integer> set = new HashSet<>();
		Point check = new Point(index);
		Point tmp; int num;
		
		int pivotX = check.x/3; int pivotY = check.y/3;
		
		for(int i=pivotY*3; i<pivotY*3+3; i++)
			for(int j=pivotX*3; j<pivotX*3+3; j++) {
				tmp = new Point(i, j);
				num = board.charAt(tmp.index) - '0';
				if(num==0) continue;
				if(set.contains(num)) return false;
				set.add(num);
			}
		
		return true;
	}
	
	static boolean checkLine(int index) {
			
		Set<Integer> set = new HashSet<>();
		Point check = new Point(index);
		Point tmp;
		int num;
		
		for(int i=0; i<9; i++)
		{
			tmp = new Point(i, check.x);
			num = board.charAt(tmp.index) - '0';
			if(num==0) continue;
			if(set.contains(num)) return false;
			set.add(num);
		}
	
		set.clear();
		
		for(int i=0; i<9; i++)
		{
			tmp = new Point(check.y, i);
			num = board.charAt(tmp.index) - '0';
			if(num==0) continue;
			if(set.contains(num)) return false;
			set.add(num);
		}
		
		return true;
	}
	
	static void solution(int index) {
		
		if(index>=81) {
			q.add(board.toString());
			return;
		}
		
		Point now = new Point(index);
		int num = board.charAt(now.index) - '0';
		
		if(num == 0) {
			
			for(int i=1; i<=9; i++) {
				
				board.setCharAt(now.index, (char) ('0' + i));
				if(!checkLine(now.index)) continue;
				if(!checkBlock(now.index)) continue;
				if(!q.isEmpty()) if(q.peek().compareTo(board.toString()) < 0) continue;
				solution(index+1);
	
			}
			
			board.setCharAt(now.index, (char) ('0'));
			return;
		}
		
		solution(index+1);
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String s;
		
		for(int i=0; i<9; i++) {
			s = bf.readLine();
			for(int j=0; j<9; j++) board.append(s.charAt(j));
		}
		
		
		solution(0);
		
		String sb = q.peek();
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) bw.write(sb.charAt(i*9+j));
			bw.write('\n');
		}
		
		bw.flush();
		bw.close();

	}
	
	static class Point {
		
		public int x, y, index;
		
		Point(int index){
			x = index%9; y = index/9;
			this.index = index;
		}
		
		Point(int y, int x){
			this.y = y; this.x = x;
			index = y*9+x;
			
		}
		
	}

}
