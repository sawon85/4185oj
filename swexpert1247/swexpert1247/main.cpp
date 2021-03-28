//
//  main.cpp
//  swexpert1247
//
//  Created by sawon on 2021/02/23.
//

#include <iostream>
#include <cmath>

using namespace std;

int T, N;

typedef struct {
    int x,y;
}point ;

point data[13];
bool visited[13];

int result;

int diff(point a, point b)
{
    return abs(a.x - b.x) + abs(a.y - b.y);
}

void DFS(int now, int cnt, int sum)
{
    if(sum >= result) return;
    
    if(now == 1)
    {
        result = sum;
        return;
    }
    
    if(cnt == N-2)
    {
        DFS(1, cnt+1, sum + diff(data[1],data[now]));
        return;
    }
    
    for(int i=2 ; i<N; i++)
    {
        if(now == i) continue;
        
        if(visited[i]) continue;
    
        visited[i] = true;
        DFS(i,cnt+1, sum + diff(data[now], data[i]));
        visited[i] = false;
        
    }
    
}

void initDFS()
{
    result = 20000;
    
    for(int i=0; i<N; i++) visited[i] = false;
    
    for(int i=2; i<N; i++)
    {
        visited[i] = true;
        DFS(i, 1, diff(data[0],data[i]));
        visited[i] = false;
    }
    
}

int main(int argc, const char * argv[]) {
    
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> T;
    
    for(int t=1 ; t<=T; t++)
    {
        cin >> N;
        
        N += 2;
        
        for(int i=0; i<N ; i++)
        {
            cin >> data[i].x >> data[i].y;
            
        }
        
        initDFS();
        
        cout << "#" << t << " " << result << "\n";
    }
    
    return 0;
}
