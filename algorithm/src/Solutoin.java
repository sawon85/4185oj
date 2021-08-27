import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	String s;
	StringTokenizer st;
	Map<String,String> names = new HashMap<>();
	Queue<Movement> q = new LinkedList<>();
	
	
	
	public void enter(String uuid, String name) {
		names.put(uuid, name);
		q.add(new Movement(0, uuid));
	}
	
	public void leave(String uuid) {
		q.add(new Movement(1, uuid));
	}
	
	public void change(String uuid, String name) {
		names.put(uuid, name);
	}
	
	public String[] getAns() {
		String[] answer = new String[q.size()];
		Movement temp;
		
		int i = 0;
		while(!q.isEmpty()) {
			temp = q.poll();
			System.out.println(temp.what);
			if(temp.what==0) answer[i] = names.get(temp.uuid)+ "님이 들어왔습니다.";
			else if(temp.what==1) answer[i] = names.get(temp.uuid)+ "님이 나갔습니다.";
			
			i++;
		}
		
		return answer;
	}
	
	
	public String[] solution(String[] record) {
        String[] answer = {};
        
        String[] temp;
        for(int i=0; i<record.length; i++) {
        	temp = record[i].split(" ");
        	
        	switch(temp[0]) {
        	
        	case "Enter": enter(temp[1], temp[2]);break;
        	case "Leave": leave(temp[1]);break;
        	case "Change": change(temp[1], temp[2]); break;
        	
        	}
        	
        }
        
       answer =  getAns();
        
        return answer;
    }
	
	static class Movement{
		public int what; String uuid; // 0 enter 1 leave 2 change
		Movement(int what, String uuid){
			this.what = what;
			this.uuid = uuid;
		}
	}
	
	
}
