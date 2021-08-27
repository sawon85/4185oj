import java.util.PriorityQueue;

class Solution {
	
	PriorityQueue<Info> q = new PriorityQueue<>();
	
	public int solve(long k) {
		
		long rank = 0;
		Info temp;
		
		while(true) {
			
			if(q.isEmpty()) return -1;
			temp = q.peek(); // 현재 먹을 음
			temp.food -= rank; // 현재 음식에 먹을 음식에 지금까지 돈 바퀴 수를 뺀다.
			
			if(k>q.size()) { // 남은 음식이 한 바퀴보다 많다	
				
				//지금 음식이 완전히 소비될 바퀴수와 남은 초 바퀴 중 작은 바퀴 
				long min = Math.min((long) temp.food, k/q.size());
				System.out.println(min);
				k -= min*q.size();
				rank += min;
			}
				
			else k--;
			
			if(k<0) return temp.index; 
		
			q.poll();
			
		}
		
	}
	
	 public int solution(int[] food_times, long k) {
	       int answer = 0;
	       
	       for(int i=0; i<food_times.length; i++) q.add(new Info(i+1, food_times[i]));
	       
	       answer = solve(k);
	       
	       return answer;
  }
	
	public class Info implements Comparable<Info>{
		int index, food;
		
		Info(int index, int food){
			this.index = index;
			this.food = food;
		}

		@Override
		public int compareTo(Solution.Info o) {
			if(o.food == this.food) return this.index -  o.index;
			return this.food - o.food;
		}
		
	}
}