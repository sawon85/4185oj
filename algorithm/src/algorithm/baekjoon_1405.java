package algorithm;

import java.util.Scanner;

public class baekjoon_1405 {
	
	static boolean[][] map = new boolean[100][100];
	static double[] direction = new double[4]; //e,w,s,n
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	static double probablity=0.0;
	
	static int n;
	
	static Scanner sc = new Scanner(System.in);
	
	static void dfs(int y, int x, double pro, int turn)
	{
	    if(n==turn)
	    {
	        probablity+=pro;
	        return;
	    }
	    
	    map[y][x]=true;
	    
	    for(int i=0;i<4;i++)
	    {
	        if(!map[y+dy[i]][x+dx[i]]&&direction[i]>0)
	            dfs(y+dy[i],x+dx[i],pro*direction[i],turn+1);
	    }
	    
	    map[y][x]=false;
	    
	}
	
	public static void main(String[] args) {
		
		n = sc.nextInt();
	   
	    int p;
	    for(int i=0;i<4;i++)
	    {
	        p = sc.nextInt();
	        direction[i]=(double)p*0.01;
	    }
	    
	    dfs(50,50,1,0);
	    
	    System.out.println(probablity);
	    
	}

}
