//
//  main.cpp
//  14502
//
//  Created by sawon on 2021/03/12.
//

#include <iostream>
#include <queue>

using namespace std;

typedef struct point{
    int x,y;
}point;

int n,m;

int map[8][8];
int tmp[8][8];
int p_map[8][8];
int p_n = 0;

point poison[10];

int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};

int result = 0;

void copy(int original[8][8], int tmp[8][8])
{
    for(int i=0; i<n; i++) for(int j=0; j<m; j++) tmp[i][j] = original[i][j];
}


int BFS()
{
    queue<point> q;
    
    for(int i=0; i<p_n; i++) q.push(poison[i]);
    
    point now;
    while(!q.empty())
    {
        now = q.front();
        q.pop();
        
        int newX;
        int newY;
        
        for(int i=0; i<4; i++)
        {
            newX = now.x + dx[i];
            newY = now.y + dy[i];
            
            if(newX<0 || newX>=m || newY<0 || newY>=n) continue;
            if(tmp[newY][newX] > 0) continue;
                    
            point newPoint;
            
            newPoint.x = newX;
            newPoint.y = newY;
            
            tmp[newY][newX] = 2;
            
            q.push(newPoint);
            
        }
    }
    
    int cnt = 0;
    for(int i=0; i<n; i++) for(int j=0; j<m; j++) if(tmp[i][j] == 0) cnt++;
    
    return cnt;
    
}

void setWall(int cnt)
{
    if(cnt == 3)
    {
        copy(map, tmp);
        int newResult = BFS();
        result = newResult < result ? result : newResult;
        return;
    }
    
    for(int i=0; i<n; i++)
    for(int j=0; j<m; j++)
    {
        if(map[i][j] > 0) continue;
        map[i][j] = 1;
        setWall(cnt+1);
        map[i][j] = 0;
    }
}

void run()
{
    setWall(0);
}


int main(int argc, const char * argv[]) {
   
    cin >> n >> m;
    
    
    for(int i=0; i<n; i++)
    for(int j=0; j<m; j++)
    {
        cin >> map[i][j];
        
        if(map[i][j] == 2)
        {
            poison[p_n].x = j;
            poison[p_n++].y = i;
        }
        
    }
    
    run();
    
    cout << result;
    
    return 0;
}
