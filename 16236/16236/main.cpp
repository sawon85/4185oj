//
//  main.cpp
//  16236
//
//  Created by sawon on 2021/04/15.
//

#include <iostream>
#include <queue>
using namespace std;

struct info{
    int x, y, t;
};

int map[20][20];

int dx[4] = {0, -1, 1, 0};
int dy[4] = {-1, 0, 0, 1};

info shark;
int sharkSize = 2;
int eaten = 0;

int n;

bool bfs()
{
    int visited[20][20];
    
    for(int i=0; i<n; i++) for(int j=0; j<n; j++)  visited[i][j] = 200000000;
    
    
    info s = shark;
    queue<info> q;
    q.push(s);
    visited[s.y][s.x] = shark.t;
    
    int xx, yy;
    info tmp;
    while(!q.empty())
    {
        tmp = q.front();
        q.pop();
        
        for(int i=0; i<4; i++)
        {
            
            xx = tmp.x + dx[i];
            yy = tmp.y + dy[i];
            
            if(xx < 0 || xx>=n || yy<0 || yy>=n) continue;
            
            if(visited[yy][xx] != 200000000) continue;
            if(map[yy][xx] > sharkSize) continue;
            
            q.push(info{xx,yy, tmp.t+1});
            visited[yy][xx] = tmp.t+1;
            
        }
    }
    
    int min = 200000;

    for(int i=0; i<n; i++)
    for(int j=0; j<n; j++)
    {
        if(0 < map[i][j] &&map[i][j] < sharkSize)
        {
            if(min > visited[i][j])
            {
                min = visited[i][j];
                tmp.x = j;
                tmp.y = i;
                tmp.t = visited[i][j];
                
            }
        }
    }
    
    if(min < 200000)
    {
        shark = tmp;
        
        map[tmp.y][tmp.x] = 0;
        
        if(++eaten == sharkSize)
        {
            sharkSize++;
            eaten = 0;
        }
        
        return true;
        
    }
    
    return false;
}

void solution()
{
    while(true)
    {
 
        if(!bfs()) return;
        
    }
}

int main(int argc, const char * argv[]) {

    cin >> n;
    
    for(int i=0; i<n; i++)
    for(int j=0; j<n; j++)
    {
        cin >> map[i][j];
        
        if(map[i][j] == 9)
        {
            shark = info{j, i, 1};
            map[i][j] = 0;
        }
    }
    
    solution();
    
    cout << shark.t-1;

    return 0;
}
