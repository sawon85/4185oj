package algorithm;

import java.util.Scanner;

public class Main {
	
	
	static Scanner sc = new Scanner(System.in);
	
	 public static void main(String[] args)
	 {
		 
		 String sentence = sc.nextLine();
		 
		 
		 int l = 0, r=sentence.length()-1;
		 
		 while(l<r)
		 {
			 
			 while(sentence.charAt(l)!='(' && l<r) 
			{
				 l++;
			}
			 while(sentence.charAt(r)!=')'&& l<r) r--;
			 
			 if(l>r) break;
			 
			 System.out.println(sentence.substring(0,l) + sentence.substring(l+1,r) +sentence.substring(r+1));
			 l++;
			 r--;
			 
			 
		 }
		 
	 }

}
