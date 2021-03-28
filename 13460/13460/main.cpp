//
//  main.cpp
//  13460
//
//  Created by sawon on 2021/01/10.
//

#include <stdio.h>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

typedef struct data{
    int rx, ry, bx, by, cnt, dir;
} data;

typedef struct position{
    int x, y, dis;
} position;


int map[10][10];
bool visited[10][10][10][10] = {0};
int w,h;
int xx[4] = {1, -1 ,0, 0};
int yy[4] = {0, 0, 1, -1};

queue<data> q;

data st;

position move(int x, int y, int direction)
{
    position po;
    po.dis = 0;
    int newX=x, newY=y;
    for(int i=0;i<10;i++)
    {
        newX += xx[direction];
        newY += yy[direction];
        po.dis++;
        
        if(map[newY][newX]==-1)
        {
            newX -= xx[direction];
            newY -= yy[direction];
            po.dis--;
            break;
        }
        
        else if(map[newY][newX]==1)
        {
            break;
        }
    }
    
    po.x = newX;
    po.y = newY;
    
    return po;
    
}

void back(int *x, int *y, int direction)
{
    *x = *x - xx[direction];
    *y = *y - yy[direction];
}

void checkSamePo(position *r, position *b,int direction)
{
    if(r->x==b->x && r->y == b->y)
    {
        int *x = (r->dis>b->dis) ? &r->x : &b->x;
        int *y = (r->dis>b->dis) ? &r->y : &b->y;
        back(x,y,direction);
    }
}


bool isGoal(position ball)
{
    if(map[ball.y][ball.x] == 1) return true;
    return false;
}

data setData(position r_po, position b_po, int cnt, int direction)
{
    data d;
    visited[r_po.y][r_po.x][b_po.y][b_po.x] = true;
    d.rx = r_po.x;
    d.ry = r_po.y;
    d.bx = b_po.x;
    d.by = b_po.y;
    d.cnt = cnt+1;
    d.dir = direction;

    
    return d;
}

int bfs()
{

    position r_po, b_po;
    for(int i=0; i<4; i++)
    {
        r_po = move(st.rx,st.ry,i);
        b_po = move(st.bx,st.by,i);
        if(isGoal(b_po)) continue;
        if(isGoal(r_po)) return 1;
        checkSamePo(&r_po, &b_po, i);
        if(visited[r_po.y][r_po.x][b_po.y][b_po.x]) continue;
        q.push(setData(r_po, b_po, 0, i));
        
    }
    
    
    while(!q.empty())
    {
        
        data now = q.front();
        q.pop();
        
        int direction = (now.dir>=2) ? 0 : 2;
        for(int i = direction ; i<direction+2; i++)
        {
            r_po = move(now.rx,now.ry,i);
            b_po = move(now.bx,now.by,i);
            if(isGoal(b_po)) continue;
            if(isGoal(r_po)) return now.cnt+1;
            checkSamePo(&r_po, &b_po, i);
            if(visited[r_po.y][r_po.x][b_po.y][b_po.x]) continue;
            if(now.cnt<9) q.push(setData(r_po, b_po, now.cnt, i));
            
        }
        
    }
    
    return -1;
}

int main(int argc, const char * argv[]) {
    
    cin>> h >> w;
    
    char c;
    for(int i=0;i<h;i++)
        for(int j=0;j<w;j++)
        {
            scanf(" %c",&c);
            if(c=='#') map[i][j] = -1;
            else if(c=='.') map[i][j] = 0;
            else if(c=='O') map[i][j] = 1;
            else if(c=='R')
            {
                st.rx = j;
                st.ry = i;
            }
            else if(c=='B')
            {
                st.bx = j;
                st.by = i;
            }
            
        }
    
    printf("%d",bfs());
    
    return 0;
}
