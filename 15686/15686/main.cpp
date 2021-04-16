//
//  main.cpp
//  15686
//
//  Created by sawon on 2021/04/15.
//

#include <iostream>
#include <vector>
#include <math.h>

using namespace std;

struct info{
    int x, y;
};

int map[50][50];
int m;
int n;

info chicken[13];
bool visited[13] = {false,};
int chickenCnt = 0;
int ans = 100000000;
vector<info> home;


void dfs(int cnt, int now)  // visited개수 now 인덱스
{
    if(chickenCnt == now || cnt == m)  // 마지막 치킨집이랑 인덱스가 같을때나 m개 돌았을때
    {
        if(cnt == 0) return;
        
        info h;
        info c;
        int min;
        int d;
        int result = 0;
        for(int i=0; i<home.size(); i++)
        {
            h = home.at(i);
            min = 3000;
            for(int j=0; j<chickenCnt; j++)
            {
                if(!visited[j]) continue;
                c = chicken[j];
                d = abs(h.x-c.x) + abs(h.y - c.y);
                min = (min < d) ? min : d;
            }
            
            result += min;
        }
        
        ans = (ans<result) ? ans : result;
        return;
    }

    visited[now] = true;
    dfs(cnt+1, now+1);
    
    visited[now] = false;
    dfs(cnt, now+1);
}


int main(int argc, const char * argv[]) {

    cin >> n >> m;
    
    for(int i=0; i<n; i++)
    {
        for(int j=0; j<n; j++)
        {
            cin >> map[i][j];
            
            if(map[i][j] == 1) home.push_back({j, i});
            if(map[i][j] == 2) chicken[chickenCnt++] = info{j, i};
        }
        
    }
    
    dfs(0,0);
    
    cout << ans;
    
    return 0;
}
