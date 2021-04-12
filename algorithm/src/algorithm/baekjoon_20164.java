package algorithm;

import java.util.Scanner;

public class baekjoon_20164 {
	
	static int max = -1;
	static int min = 1000000000;
	
	static Scanner sc = new Scanner(System.in);
	
	
	static int howManyHaveOdd(int num)
	{
		String strNum = String.valueOf(num);
		int length = strNum.length();
		
		int result = 0;
		
		for(int i=0; i<length; i++)
		{
			if((strNum.charAt(i) - '0')%2==1) result++;
			
		}
		
		
		return result;
	}
	
	
	
	static void dfs(int nowNum, int result)
	{
		String strNum = String.valueOf(nowNum);
		int length = strNum.length();

		int num1;
		int num2;
		int num3;
		int sum = 0;
		
		if(length == 1)
		{
			max = Math.max(max, result);
			min = Math.min(min, result);		
			return;
		}
		
		if(length == 2)
		{
			sum = nowNum%10 + nowNum/10;
			dfs(sum, result + howManyHaveOdd(sum));
			return;
		}
		
		
		for(int first = 1; first <= length-1-1; first++)	
			for(int second = first+1; second<=length-1; second++)
			{
					num1 = Integer.parseInt(strNum.substring(0, first));
					num2 = Integer.parseInt(strNum.substring(first, second));
					num3 = Integer.parseInt(strNum.substring(second, length));
					
					sum = num1 + num2 + num3;
					
					dfs(sum, result + howManyHaveOdd(sum));
			}
	}

	public static void main(String[] args)
	{
		int num;
		
		num = sc.nextInt();
		
		dfs(num, howManyHaveOdd(num));
		
		System.out.print(min + " " + max);
		
	}
}
