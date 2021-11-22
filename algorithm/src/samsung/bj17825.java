package samsung;

import java.io.*;
import java.util.*;

public class bj17825 {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Horse[] horses = new Horse[4];
	static int[] board1;
	static int[] board2 = {10, 13, 16, 19};
	static int[] board3 = {20, 22, 24};
	static int[] board4 = {30, 28, 27, 26};
	static int[] board5 = {25, 30, 35, 40};
	
	static boolean Check(int h, Horse newHorse) {
		
		for(int i=0; i<horses.length; i++) {
			if(i==h) continue;		
			if(horses[h].isEnd) continue;
			if(horses[h].board==newHorse.board && horses[h].nowIndex==newHorse.nowIndex) return false;
		}
		
		return true;
	}
	
	static Horse move(int idx, int cnt) {
		
		Horse now = horses[idx];
		int ni=now.nowIndex+cnt;
		
		if(now.board==board1) {
			//
			if(ni>=board1.length) return new Horse(board1,board1.length-1, true);
			
			if(ni==5) return new Horse(board2,0, false);
			if(ni==10) return new Horse(board3,0, false);
			if(ni==15) return new Horse(board3,0, false);
			
			return new Horse(board1, ni, false);
		}
		
		if(now.board==board2) {
			
			if(ni>=board2.length) {
				int nextIdx = ni-board2.length;
				
			}
			
			
		}
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Horse{
		int[] board = board1;
		int nowIndex=0;
		boolean isEnd=false;
		
		Horse() {
			
		}
		
		Horse(int[] board, int nowIndex, boolean isEnd) {
			this.board=board;
			this.nowIndex=nowIndex;
			this.isEnd=isEnd;
		}
	}

}
