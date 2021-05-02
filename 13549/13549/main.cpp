//
//  main.cpp
//  13549
//
//  Created by sawon on 2021/05/01.
//

#include <iostream>
#include <queue>
using namespace std;

int subin[100001];
queue<int> q;
int k;

void init()
{
    for(int i=0; i<100001; i++) subin[i] = 200000;
}

bool isOk(int num)
{
    if(num < 0 || num > 100000) return false;
    return true;
}

void push(int num, int cnt)
{
    if(subin[num] <= cnt) return;
    q.push(num);
    subin[num] = cnt;
}

int bfs(int from)
{
    q.push(from);
    subin[from] = 0;
    
    int now;
    while(!q.empty()){
        
        now = q.front();
        q.pop();
        
        //if(now==k) return subin[k];
        
        if(isOk(now*2)) push(now*2, subin[now]);
        if(isOk(now+1)) push(now+1, subin[now]+1);
        if(isOk(now-1)) push(now-1, subin[now]+1);
        
    }
    
    return subin[k];
}

int main(int argc, const char * argv[]) {
    
    int from;
    cin >> from >> k;
    
    init();
    cout << bfs(from);
    
    return 0;
}
