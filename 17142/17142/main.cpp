//
//  main.cpp
//  17142
//
//  Created by sawon on 2021/04/16.
//

#include <iostream>
#include <vector>
#include <queue>
using namespace std;

struct info{
    int x, y;
};

vector<info> v;

int n, m; // 4<= n <= 50 // 1<=m<=10
int vCnt;  //총 바이러스 개수
bool visited[11] = {false,};
int map[51][51];  //벽 -1

int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

void copy(int tmp[51][51])
{
    for(int i=1; i<=n; i++)
    for(int j=1; j<=n; j++)
    tmp[i][j] = map[i][j];
    
}

int ans = 20000;

int bfs()
{
    int tmp[51][51];
    copy(tmp);
    
    queue<info> q;
    
    for(int i=1; i<11; i++)
    if(visited[i])
    {
        q.push(v.at(i));
        tmp[v.at(i).y][v.at(i).x] = 1;
    }
    
    
    info t;
    int xx, yy;
    int lastCnt = 1;
    int newCnt;
    bool isVirus;
    while(!q.empty())
    {
        t = q.front();
        q.pop();
        
        for(int i=0; i<4; i++)
        {
            isVirus = false;
            xx = t.x + dx[i];
            yy = t.y + dy[i];
            
            if(xx<1 || xx > n || yy<1 || yy>n) continue;
            if(tmp[yy][xx] == -1) continue;
            
            newCnt = tmp[t.y][t.x] + 1;
            
            if(newCnt >= tmp[yy][xx] && tmp[yy][xx] > 0) continue;
            
            if(tmp[yy][xx] == -2) isVirus = true;
            tmp[yy][xx] = newCnt;
            q.push(info{xx, yy});
            
            if(!isVirus) lastCnt = (lastCnt <= newCnt)? newCnt : lastCnt;
        }
    }
    
    for(int i=1; i<=n; i++)
    for(int j=1; j<=n; j++)
    {
        if(tmp[i][j] == 0 || tmp[i][j] == -2) return 20000;
    }
    
    
    return lastCnt-1;
}

void dfs(int index, int cnt)   //바이러스 인덱스, 현재 까지 선택된
{
    if(index==vCnt+1 || cnt==m)
    {
        if(cnt<m) return;
        int result = bfs();
        ans = (ans <= result) ? ans : result;
        return;
    }
        
    visited[index] = true;
    dfs(index+1, cnt+1);
    visited[index] = false;
    dfs(index+1, cnt);
    
}

int main(int argc, const char * argv[]) {

    cin >> n >> m;
    
    v.push_back({0,0});
    
    int tmp;
    for(int i=1; i<=n; i++)
    for(int j=1; j<=n; j++)
    {
        cin >> tmp;
        
        if(tmp == 1) map[i][j] = -1;
        else if(tmp==0) map[i][j] = 0;
        else
        {
            v.push_back(info{j, i});
            map[i][j] = -2;
        }
    }
    
    vCnt = (int)v.size() - 1;
    
    dfs(1,0);
    
    ans = (ans == 20000)? -1 : ans;
    
    cout << ans;
    
    return 0;
}
