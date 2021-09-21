package algorithm;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class baekjoon_6087_2{   

   static StringBuilder sb = new StringBuilder();
   static int w, h;
   static String[][] map;
   static int[][] mirror;
   static int[] dh = { 1, 0, -1, 0};
   static int[] dw = { 0, 1, 0, -1};
   
   static Integer startR = null, startC = null, endR = null, endC = null;
   
   static int parseInt(String string) {
      return Integer.parseInt(string);
   }
   
   long parseLong(String string) {
      return Long.parseLong(string);
   }
   
   public static void main(String[] args) throws IOException{
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      
      StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
      w = parseInt(st.nextToken());
      h = parseInt(st.nextToken());
      
      map = new String[h][w];
      mirror = new int[h][w];
      for(int i = 0 ; i < h ; i++) {         
         String[] split = bufferedReader.readLine().split("");
         for(int j = 0 ; j < w ; j++) {
            map[i][j] = split[j];
            
            if(map[i][j].equals("C")) {
               
               if(startR == null && startC == null) {
                  startR = i;
                  startC = j;
               }
               else {
                  endR = i;
                  endC = j;
               }
            }
            
            mirror[i][j] = Integer.MAX_VALUE;
         }
      }
      
      BFS();
      
      System.out.println(mirror[endR][endC]);
   }
   
   static class node{
      int r, c;
      int count;
      int direction;
      
      node(int r, int c, int count, int direction){
         this.r = r;
         this.c = c;
         this.count = count;
         this.direction = direction;
      }
   }
   
   static void print(int y, int x) {
	   
	   System.out.println();
	   for(int i=0; i<mirror.length; i++) {
		   for(int j=0; j<mirror[i].length; j++) {
			   if(map[i][j].equals("*")) System.out.print("*");
			   else if(mirror[i][j]==Integer.MAX_VALUE) System.out.print("x");
			   else System.out.print(mirror[i][j]+"");
			   
			   if(y==i && x==j) System.out.print("<");
			   else System.out.print(" ");
		   }
		   System.out.println();
	   }
	   
   }
   
   static void BFS() {
      
      Queue<node> queue = new LinkedList<>();
      
      queue.add(new node(startR, startC, 0, -1));
      mirror[startR][startC] = 0;
      
      while(!queue.isEmpty()) {
         
         node now = queue.poll();
         
         mirror[now.r][now.c] = Math.min(mirror[now.r][now.c],  now.count);
         if(now.r == endR && now.c == endC) {
            continue;
         }
         
         for(int i = 0 ; i < 4 ; i++) {
            int nr = now.r + dh[i];
            int nc = now.c + dw[i];
            
            if(nr < 0 || nc < 0 || nr >= h || nc >= w) continue;
            
            if(map[nr][nc].equals("*")) continue;
            
            if(mirror[nr][nc] <= now.count) continue;
                     
            if(now.direction == - 1) {
            	mirror[nr][nc] = 0;
               queue.add(new node(nr, nc, 0, i));
            }
            else if( (i % 2) == (now.direction % 2)) {
            	   mirror[nr][nc] = now.count;
                  queue.add(new node(nr, nc, now.count, i));
            }
            else {
               if(mirror[nr][nc] > now.count + 1) {
            	   mirror[nr][nc] = now.count+1;
                  queue.add(new node(nr, nc, now.count + 1, i));
               }
            }
            
           print(nr, nc);
            
         }
      }
   }
}