//
//  main.cpp
//  11404
//
//  Created by sawon on 2021/05/01.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
const int MAX = 100 + 1;
const int INF =  100*100000+1;
int map[MAX][MAX];
int n;

void init()
{
    for(int i=1; i<=n; i++)
    for(int j=1; j<=n; j++)
    {
        map[i][j] = INF;
    }
}

void floyd()
{
    
    for(int mid=1; mid<=n; mid++)
    for(int i=1; i<=n; i++)
    for(int j=1; j<=n; j++)
    {
        if(mid==i||mid==j||i==j) continue;
        map[i][j] = min(map[i][j], map[i][mid] + map[mid][j]);
    }
    
}


int main(int argc, const char * argv[]) {
    
    int m;
    cin >> n >> m;
    
    int from, to, w;
    init();
    for(int i=0; i<m; i++)
    {
        cin >> from >> to >> w;
        map[from][to] = min(w, map[from][to]);
    }
    
    floyd();
    
    for(int i=1; i<=n; i++)
    {
        for(int j=1; j<=n; j++)
        {
            if(map[i][j] == INF) cout << "0 ";
            else cout<<map[i][j] <<" ";
            
        }
        cout << "\n";
    }
    
    return 0;
}
