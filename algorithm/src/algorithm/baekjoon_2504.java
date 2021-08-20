package algorithm;

import java.util.Scanner;
import java.util.Stack;

public class baekjoon_2504 {
	

	static Scanner sc = new Scanner(System.in);
	static String str;
	static Stack<Character> stack = new Stack<>();

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		str = sc.next();
		
		
		int ans = 0;
		int buffer = 1;
		boolean canCacul = true;
		
		for(int i=0; i<str.length(); i++) {
			
			switch(str.charAt(i)) {
			
			case '(' :
				stack.push(str.charAt(i));
				buffer *= 2;
				canCacul = true;
				break;
				
			case ')' :
				if(stack.empty() || stack.peek() != '(') {
					System.out.print(0);
					return;
				}
				stack.pop();
				if(canCacul) ans += buffer;	
				buffer /= 2;
				canCacul = false;
				break;
				
			case '[' :
					stack.push(str.charAt(i));
					buffer *= 3;
					canCacul = true;
				break;
				
				
			case ']' :
				if(stack.empty() || stack.peek() != '[') {
					System.out.print(0);
					return;
				}
				stack.pop();
				if(canCacul) ans += buffer;	
				buffer /= 3;
				canCacul = false;
				break;
			
			}
			
		}
		
		if(!stack.empty()) System.out.print(0);	
		else System.out.println(ans);
		
	}

}
