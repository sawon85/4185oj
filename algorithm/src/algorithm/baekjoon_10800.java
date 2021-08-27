package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon_10800 {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;
	static Player[] players;
	static int n;
	static int[] ans;
	static boolean[] visited;
	
	static Comparator<Player> sizeCom = new Comparator<Player>() {
	    @Override
	    public int compare(Player a, Player b) {
	        return a.size - b.size;
	    }
	};
	
	static Comparator<Player> colorCom = new Comparator<Player>() {
	    @Override
	    public int compare(Player a, Player b) {
	        return a.color - b.color;
	    }
	};
			
	static Comparator<Player> indexCom = new Comparator<Player>() {
	    @Override
	    public int compare(Player a, Player b) {
	        return a.index - b.index;
	    }
	};
		
	
	public static void main(String[] args) throws IOException {
		
		n = Integer.parseInt(bf.readLine());
		visited = new boolean[n]; players = new Player[n];
		
		
		for(int i=0;i<n;i++) {
			s = bf.readLine(); st = new StringTokenizer(s);
			players[i] = new Player(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); 
			
		}
		
		Arrays.sort(players, sizeCom);
		Stack<Integer> st = new Stack<>();
		
		players[0].sum = 0;
		for(int i=1; i<players.length; i++) {
			
			if(players[i].size==players[i-1].size) {
				players[i].sum = players[i-1].sum;
				st.add(i-1);
				continue;		
			}
			
			players[i].sum = players[i-1].sum + (st.size()+1)*players[i-1].size;
				
			if(!st.isEmpty()) st.clear();
			
		}
		
		st.clear();
		Arrays.sort(players, colorCom);
		ArrayList<Integer> arr = new ArrayList<>();
		
		
		for(int i=1; i<players.length; i++) {
			
			if(players[i].color==players[i-1].color) {
				arr.add(i-1);
				
				for(Integer index : arr) {
					
					if(players[index].size==players[i].size) continue;
					
					players[i].sum -= players[index].size;
					
				}
			
				
				continue;
				
			}
	
			if(!arr.isEmpty()) arr.clear();
			
		}
		
		Arrays.sort(players, indexCom);
		
		for(int i=0; i<players.length; i++) bw.write(players[i].sum+"\n");
		
		
		bw.flush();
		bw.close();
		
	}
	
	static class Player{
		
		int index;
		int color;
		int size;
		int sum;
		
		Player(int index, int color, int size){
			this.index = index; this.color=color; this.size=size;
		}

	}
}
