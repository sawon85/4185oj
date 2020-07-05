//
//  main.cpp
//  로봇 청소기
//
//  Created by sawon on 06/01/2019.
//  Copyright © 2019 sawon. All rights reserved.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
int width,height;
int cnt;
int arr[21][21];
int minway[11][11];
struct spot{
    int x;
    int y;
};
spot v[11];
int xx[4]={1,0,-1,0};
int yy[4]={0,1,0,-1};
queue <spot> q;
void clearqueue()
{
    queue <spot> empty;
    swap(q,empty);
}
bool enqueue(spot p,spot to,int map[][21])
{
    spot temp;
    int way=map[p.y][p.x]+1;
    for(int i=0;i<4;i++)
    {
        temp.x=p.x+xx[i];
        temp.y=p.y+yy[i];
        if(temp.x<1||temp.x>width||temp.y<1||temp.y>height||map[temp.y][temp.x]>-1) continue;
        if(arr[temp.y][temp.x]==-2) continue;
        else
        {
            map[temp.y][temp.x]=way;
            if(temp.x==to.x&&temp.y==to.y) return 1;
            else
                q.push(temp);
        }
    }
    
    return 0;
}
int BFS(spot from, spot to)
{
    int map[21][21];
    fill(&map[0][0], &map[20][21], -1);
    map[from.y][from.x]=0;
    if(enqueue(from,to,map)) return map[to.y][to.x];
    spot temp;
    while(!q.empty())
    {
        temp=q.front();
        if(enqueue(temp,to,map)) return map[to.y][to.x];
        q.pop();
    }
    return -1;
}
int visit[11]={0,};
int minimum=99999;
int temp=0;
bool allvisit()
{
    for(int i=1;i<=cnt;i++)
    if(visit[i]==0)
        return 0;
    return 1;
}
void dfs(int from)
{
    
    for(int to=1;to<=cnt;to++)
    {
        if(visit[to]==1) continue;
        visit[to]=1;
        temp+=minway[from][to];
        if(temp<minimum)
        dfs(to);
        temp-=minway[from][to];
        visit[to]=0;
    }
    
    if(allvisit())
        minimum=(minimum<temp)? minimum:temp;
    
}
void swap(int *a, int *b){int temp=*a;*a=*b;*b=temp;}
int main(int argc, const char * argv[]) {
    
    while(1)
    {
        char write;
       cnt=0;
        scanf("%d %d",&width,&height);
        if(width==0&&height==0) return 0;
        for(int i=1;i<=height;i++)
            for(int j=1;j<=width;j++)
            {
                arr[i][j]=0;
                scanf(" %1c",&write);
                
                if(write=='x')
                    arr[i][j]=-2;
                else if(write=='o')
                {
                    v[0].x=j;
                    v[0].y=i;
                }
                else if(write=='*')
                {
                    v[++cnt].x=j;
                    v[cnt].y=i;
                }
            }
        
        bool check=0;
        for(int from=0;from<=cnt;from++)
        {
            for(int to=from+1;to<=cnt;to++)
            {
                clearqueue();
                minway[from][to]=BFS(v[from],v[to]);
                minway[to][from]=minway[from][to];
                if(minway[from][to]==-1)
                {
                    check=1;
                    break;
                }
                
            }
        }
        
        if(check)
        {
            printf("-1\n");
            continue;
        }
            
        fill(&visit[0], &visit[11], 0);
        minimum=99999;
        temp=0;
        dfs(0);
        printf("%d\n",minimum);
        
     
    }
    return 0;
}

