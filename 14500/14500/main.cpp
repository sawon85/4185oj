//
//  main.cpp
//  14500
//
//  Created by sawon on 2020/08/03.
//  Copyright © 2020 sawon. All rights reserved.
//

#include <iostream>
#include <algorithm>

using namespace std;

int map[501][501];
bool visited[501][501];

int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};

int n, m;

int result;

void dfs(int x, int y,int sum, int cnt)
{
    
    if(cnt>4) return;

    sum += map[y][x];
    
    if(cnt==4) {
        result = max(result, sum);
        return;
    }
    
    int xx;
    int yy;
    
    for(int i=0; i<4; i++)
    {
        xx = x + dx[i];
        yy = y + dy[i];
        
        if(0<xx && xx<=m && 0<yy && yy<=n)
            if(!visited[yy][xx])
            {
                visited[yy][xx] = true;
                dfs(xx,yy,sum,cnt+1);
                visited[yy][xx] = false;
            }
        
    }
}

void t_mino(int x, int y)
{
    
     int sum_value = 0;
       // 1. ㅜ
       if(y>=1 && y+1<=n && x>=1 && x+2<=m){
           sum_value = map[y][x] + map[y][x+1] + map[y][x+2] + map[y+1][x+1];
           result = max(result, sum_value);
       }

       // 2. ㅏ
       if(y >= 1 && y+2 <=n && x>=1 && x+1<=m){
           sum_value = map[y][x] + map[y+1][x] + map[y+2][x] + map[y+1][x+1];
           result = max(result, sum_value);
       }

       // 3. ㅗ
       if(y-1 >= 1&& y <=n && x >=1 && x+2 <=m){
           sum_value = map[y][x] + map[y][x+1] + map[y][x+2] + map[y-1][x+1];
           result = max(result, sum_value);
       }

       // 4. ㅓ
       if(y-1 >= 1 && y+1 <=n && x >=1 && x+1 <=m){
           sum_value = map[y][x] + map[y][x+1] + map[y-1][x+1] + map[y+1][x+1];
           result = max(result, sum_value);
       }
    
}


int main(int argc, const char * argv[]) {
    scanf("%d %d",&n, &m);
    
    int num;
    
    for(int i=1; i<=n; i++)
        for(int j=1;j<=m; j++)
        {
            scanf("%d",&num);
            map[i][j] = num;
        }
    
    
    for(int i=1; i<=n; i++)
           for(int j=1;j<=m; j++)
           {
               visited[i][j] = true;
               dfs(j,i,0,1);
               t_mino(j,i);
               visited[i][j] = false;
           }
    
    printf("%d",result);
    
    return 0;
}
