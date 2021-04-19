//
//  main.cpp
//  19238
//
//  Created by sawon on 2021/04/19.
//

#include <iostream>
#include <queue>
#include <vector>
using namespace std;

struct info{
    int x, y;
    int dx, dy;
    bool arrive = false;
};

struct taxi{
    int fuel;
    int x, y;
};

vector<info> member;
int map[20][20]; // 승객,

int n, m;
int dx[4] = {0, -1, 0, 1};
int dy[4] = {1, 0, -1, 0};

taxi t;

void bfs(int visited[20][20], queue<info> &q)
{
    info now;
    int xx;
    int yy;
    while(!q.empty())
    {
        now = q.front();
        q.pop();
        
        for(int i=0; i<4; i++)
        {
            xx = now.x + dx[i]; yy = now.y + dy[i];
            
            if(xx<0 || xx>=n || yy<0 || yy>=n) continue;
            if(visited[yy][xx] >= 0) continue;
            if(map[yy][xx] == -1) continue; //벽
            if(visited[yy][xx] <= visited[now.y][now.x] + 1 && visited[yy][xx] != -1) continue;
            
            info n;
            n.x = xx; n.y = yy;
            
            q.push(n);
            visited[yy][xx] = visited[now.y][now.x] + 1;
            
        }
    }
    
}

int findMember()
{
    int visited[20][20];
    
    for(int i=0; i<20; i++) for(int j=0; j<20; j++) visited[i][j] = -1;
    
    queue<info> q;
    info st; st.x = t.x; st.y = t.y;
    
    q.push(st);
    visited[st.y][st.x] = 0;
    
    bfs(visited, q);

    int minD = 401;
    int x = 0, y=0;
    int index = 0;
    for(int i=0; i<n; i++)
    for(int j=0; j<n; j++)
    {
        if(map[i][j] > 0 && minD > visited[i][j] && visited[i][j] > -1)
        {
            y = i; x= j;
            minD = visited[i][j];
            index = map[i][j];
        }
    }
    
    t.fuel -= minD;
    t.x = x; t.y=y;
    map[y][x] = 0;
    
    return index;
}

bool arrive(int index)
{
    int visited[20][20];
    
    for(int i=0; i<20; i++) for(int j=0; j<20; j++) visited[i][j] = -1;
    
    queue<info> q;
    info d; d.x = t.x; d.y = t.y;
    q.push(d);
    visited[d.y][d.x] = 0;
    
    bfs(visited, q);
    
    if(visited[member.at(index).dy][member.at(index).dx] == -1) return false;
    t.fuel -= visited[member.at(index).dy][member.at(index).dx];
    
    if(t.fuel < 0) return false;
    
    member.at(index).arrive = true;
    t.fuel += 2*visited[member.at(index).dy][member.at(index).dx];
    
    t.y = member.at(index).dy;
    t.x = member.at(index).dx;
    
    return true;
}

bool track()
{
    int index = findMember() - 1;
    if(t.fuel<0 || index < 0) return false;
    if(!arrive(index)) return false;
    
    return true;
}

int solution()
{

    for(int i=0; i<member.size(); i++) if(!track()) return -1;

    for(int i=0; i<member.size(); i++) if(!member.at(i).arrive) return -1;
    
    return t.fuel;
}

int main(int argc, const char * argv[]) {
    
    cin >> n >> m >> t.fuel;
    for(int i=0; i<n; i++)
    for(int j=0; j<n; j++)
    {
        cin >> map[i][j];
        if(map[i][j] == 1) map[i][j] = -1;
    }
    
    cin >> t.y >> t.x;
    t.y --; t.x --;
    
    int x, y, dx, dy;
    for(int i=0; i<m; i++)
    {
        cin >> y >> x >> dy >> dx;
        map[y-1][x-1] = i+1;
        member.push_back(info{x-1, y-1, dx-1, dy-1});
        
    }
    
    cout << solution();
    
    return 0;
}
