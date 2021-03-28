//
//  main.cpp
//  4179
//
//  Created by sawon on 2021/03/25.
//

#include <iostream>
#include <queue>
using namespace std;

int R, C;

struct dt{
    bool isBlock = false;
    int f;
    int j;
    
};

dt map[1000][1000];


struct node{
    
    int x, y;
    int cnt;
    
};


int dx[4] = {0, 0, -1, 1};
int dy[4] = {1, -1, 0, 0};


int bfs(queue<node> q, bool isHuman)
{
    node now;
    int xx;
    int yy;
    
    while(!q.empty())
    {
        
        now = q.front();
        q.pop();
        
        if(isHuman) if(now.y==R-1 || now.y==0 || now.x==0 || now.x==C-1) return 1;
            
        for(int i=0; i<4; i++)
        {
            xx = now.x + dx[i];
            yy = now.y + dy[i];
            
            if(xx <0 || xx >= C || yy <0 || yy >= R) continue;
            if(map[yy][xx].isBlock) continue;
            
            node newNode;
            newNode.cnt = now.cnt + 1;
            newNode.x = xx;
            newNode.y = yy;
            
            if(isHuman)
            {
                if(map[yy][xx].f >0 &&map[yy][xx].f <= newNode.cnt) continue;
                if(map[yy][xx].j > 0) continue;
                if(yy==R-1 || yy==0 || xx==0 || xx==C-1) return newNode.cnt ;
                map[yy][xx].j= newNode.cnt;
            
            }
            
            else
            {
                if(map[yy][xx].f > 0) continue;
                map[yy][xx].f= newNode.cnt;
            }
            
            q.push(newNode);
        }
        
    }
    
    return -1;
    
}

int main(int argc, const char * argv[]) {
    
    cin >> R >> C;

    queue<node> f;
    queue<node> _j;
    
    char c;
    for(int i=0; i<R; i++)
    for(int j=0; j<C; j++)
    {

        cin >> c;
        
        if(c == '#') map[i][j].isBlock = true;
        else if(c == 'F'){
            map[i][j].f = 1;
            node newNode;
            newNode.x = j;
            newNode.y = i;
            newNode.cnt = 1;
            f.push(newNode);
            
        }
        else if(c == 'J'){
            map[i][j].j = 1;
            node newNode;
            newNode.x = j;
            newNode.y = i;
            newNode.cnt = 1;
            _j.push(newNode);
        }
    
    }

    
    bfs(f,false);
    
    int ans = bfs(_j,true);

    
    if(ans == -1) cout << "IMPOSSIBLE";
    else cout << ans;
    
    return 0;
}
