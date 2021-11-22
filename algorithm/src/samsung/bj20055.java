package samsung;

import java.io.*;
import java.util.*;

public class bj20055 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String s; static StringTokenizer st;
	
	static int n, k;
	static Square[] belt;
	static int time=0;
	static int nposition;
	static int zeroposition;
	static ArrayList<Robot> robots = new ArrayList<>();
	
	static void setPotistion() {
		
		if(time==0) {
			nposition=n-1;
			zeroposition=0;
		}
		
		else {		
			if(--nposition<0) nposition=2*n-1;	
			if(--zeroposition<0) zeroposition=2*n-1;
		}	
	}
	
	static boolean check(Robot robot) {
		if(robot.index==nposition) return true;
		return false;
	}
	
	static boolean next(Robot robot) {
		int nextIndex = (robot.index+1)%(2*n);
		if(belt[nextIndex].hp==0) return false;
		if(belt[nextIndex].robot!=null) return false;
		belt[robot.index].robot = null;
		robot.index=nextIndex;
		belt[nextIndex].robot=robot;
		belt[nextIndex].hp--;
		if(belt[nextIndex].hp==0) return true;
		return false;
	}
	
	static boolean newRobot() {
		
		if(belt[zeroposition].hp<=0) return false;
		if(belt[zeroposition].robot!=null) return false;
		belt[zeroposition].hp--;
		belt[zeroposition].robot=new Robot(zeroposition);
		robots.add(belt[zeroposition].robot);
		if(belt[zeroposition].hp==0) return true;
		return false;
	}
	
	static int solution() {
		
		int zero=0;
		setPotistion();
		
		Robot tmp;
		while(zero<k) {
			time++;
			setPotistion();
			if(belt[nposition].robot!=null) {
				tmp = belt[nposition].robot;
				robots.remove(tmp);
				belt[nposition].robot=null;
			}
			
			for(int i=0; i<robots.size(); i++) {
				if(next(robots.get(i))) zero++;
				if(check(robots.get(i))) {
					belt[nposition].robot=null;
					robots.remove(i);
					i--;
				}
			}
			
			if(newRobot()) zero++;
			
		}
		
		return time;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken()); k=Integer.parseInt(st.nextToken());
		belt = new Square[n*2];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<belt.length; i++) belt[i] = new Square(Integer.parseInt(st.nextToken()));
		bw.append(Integer.toString(solution()));
		bw.flush();
		bw.close();
		
	}
	
	//로봇  
	static class Robot{
		int index;
		Robot(int index) {
			this.index = index;
		}
	}
	
	static class Square{
		int hp;
		Robot robot;
		
		Square(int hp){
			this.hp=hp;
			robot = null;
		}
	}

}
