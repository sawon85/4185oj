package algorithm;

import java.util.Scanner;

public class baekjoon_1062 {
	
	static Scanner sc = new Scanner(System.in);
	static int n, k;
	static String sen[] = new String[50];
	
	static boolean visited[] = new boolean[26];
	static int ans = 0;
	
	static void dfs(int cnt, int st)
	{
		if(cnt == k)
		{
			
			int result = 0;
			
			for(int i=0; i<n; i++)
			{
				result++;
				for(int j=0; j<sen[i].length(); j++)
				{
					if(!visited[sen[i].charAt(j) - 'a']) {
						result--;
						break;
					}
				}
				
			}
			
			ans = (ans < result) ? result : ans;
			
			return;
		}
		
		for (int c = st; c < 26; c++)
		{
			if(visited[c]) continue;
			visited[c] = true;
			dfs(cnt+1, c+1);
			visited[c] = false;

		}
   
	}
	
	public static void main(String[] args) 
	{
		n = sc.nextInt();
		k = sc.nextInt();
		
		for(int i = 0; i<n; i++)
		{
			
			sen[i] = sc.next();
			sen[i] = sen[i].replaceAll("[a,n,t,i,c]", "");
		}
		
		if(k<5)
		{
			System.out.println("0");
			return;
		}
		
		if(k==26)
		{
			System.out.println(n);
			return;
		}
		
		visited['a' - 'a'] = true; 
		visited['n' - 'a'] = true; 
		visited['t' - 'a'] = true;
		visited['i' - 'a'] = true;
		visited['c' - 'a'] = true;
		
		k -= 5;
		
		
		dfs(0,0);
		
		System.out.println(ans);
	}
}
