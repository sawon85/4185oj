//
//  main.cpp
//  1261
//
//  Created by sawon on 2020/08/16.
//  Copyright © 2020 sawon. All rights reserved.
//

#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;

const int MAX = 100001;

int map[101][101];
int tmp[101][101] = {MAX};

queue<pair<int, int>> q;

void bfs()
{
    tmp[1][1] = map[1][1];
    q.push({0,0});
    
    int first,second;
    while(!q.empty())
    {
        first = q.front().first;
        second = q.front().second;
        
        
        
    }
    
}

int n,m;

int main(int argc, const char * argv[]) {
    
    scanf("%d %d",&n, &m);
    
    for(int j=1;j<=m;j++) for(int i=1;i<=n;i++) tmp[j][i] = MAX;
    for(int j=1;j<=m;j++) for(int i=1;i<=n;i++) scanf("%1d",&map[j][i]);
    
    
    
    
    return 0;
}
