//
//  main.cpp
//  1939
//
//  Created by sawon on 2020/08/09.
//  Copyright © 2020 sawon. All rights reserved.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include<cstring>
using namespace std;

//int map[10000+1][10000+1];
bool visited[10000+1];

vector<pair<int,int>> map[10000+1];

int n,m;

int result = -1;

int v1,v2;

void dfs(int x, int w)
{
    visited[x] = true;
    if(x==v2) return;
    
    for(pair<int,int> v : map[x])
    {
        if(v.second<w) continue;
        if(visited[v.first]) continue;
        if(visited[v2]) return;
        dfs(v.first,w);
    }
    
}

void binary(int st, int e)
{
    int mid;
    
    while(st<=e)
    {
        mid = (st + e)/2;
        
        memset(visited,false,sizeof(visited));
        dfs(v1,mid);
        
        if(visited[v2])
        {
            result = mid;
            st = mid+1;
        }
        
        else
            e = mid-1;
        
    }
}

int main(int argc, const char * argv[]) {
    scanf("%d %d",&n,&m);

    int from,to,w;
    int _max = -1;
    
    for(int i=1;i<=m;i++)
    {
        scanf("%d %d %d",&from,&to,&w);
        pair<int,int> s;
        s.first = to;
        s.second = w;
        map[from].push_back(s);
        
        pair<int,int> e;
        e.first = from;
        e.second = w;
        map[to].push_back(e);
        
        _max = max(_max,w);
    }
    
    
    scanf("%d %d",&v1,&v2);
    
    visited[v1] = true;
    binary(1,_max);
    
    printf("%d",result);
    
    return 0;
}
