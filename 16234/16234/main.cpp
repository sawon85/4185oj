//
//  main.cpp
//  16234
//
//  Created by sawon on 2021/04/15.
//

#include <iostream>
#include <vector>
#include <queue>
#include <math.h>

using namespace std;

int n;
int l, r;

int map[50][50];
bool visited[50][50];

struct info{
    int x, y;
};

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

bool bfs()
{
    info tmp;
    int xx;
    int yy;
    int total;
    queue<info> q;   //현재 정점부터 판단하는 큐
    queue<info> result;   // 탐색 결과
    bool flag = false;
    
    for(int i=0; i<n; i++)
    for(int j=0; j<n; j++)
    {
        if(visited[i][j]) continue;
        
        total = 0;
        
        q.push(info{j, i});
        visited[i][j] = true;
        
        while(!q.empty())
        {
            tmp = q.front();
            q.pop();
            
            result.push(tmp);
            total += map[tmp.y][tmp.x];
            
            for(int i=0; i<4; i++)
            {
                xx = tmp.x + dx[i];
                yy = tmp.y + dy[i];
                
                if(xx < 0 || xx >=n || yy < 0 || yy >= n ) continue;
                if(visited[yy][xx]) continue;
                if(abs(map[tmp.y][tmp.x]-map[yy][xx]) < l ) continue;
                if(abs(map[tmp.y][tmp.x]-map[yy][xx]) > r ) continue;
                
                flag = true;
                
                q.push(info{xx,yy});
                visited[yy][xx] = true;
            }
        }
        
        int average = total/result.size();
        
        while(!result.empty())
        {
            tmp = result.front();
            result.pop();
            
            map[tmp.y][tmp.x] = average;
        }
    }
    
    return flag;
}

int solution()
{
    
    int cnt = 0;
    while(true)
    {
        for(int i=0; i<n; i++) for(int j=0; j<n; j++) visited[i][j] = false;
        if(!bfs()) return cnt;
        cnt++;
    }
}

int main(int argc, const char * argv[]) {
    
    cin >> n >> l >> r;
    
    for(int i=0; i<n; i++)
    for(int j=0; j<n; j++)
    cin >> map[i][j];
    
    cout << solution();
    
    return 0;
}
