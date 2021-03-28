//
//  main.cpp
//  swexpert9788
//
//  Created by sawon on 2021/01/08.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
#include <queue>
using namespace std;

vector<int> city[20+1];
bool visited[20+1];
int n,m,k,d;
long long int r = 0;
queue<int> q;

void dfs(int c, int s, int visit)
{
    
    if(s==d)
    {
        if(visit != k) return;
        r++;
        return;
    }
    
    for(int i=0; i<city[c].size();i++)
    {
        int next = city[c].at(i);
        int newVisit = visit;
        
        if(!visited[next]&&next<=k)
        {
            ++newVisit;
            if(d-s<k-newVisit) continue;
            visited[next] = true;
            
        }
        
        dfs(next,s+1,newVisit);
        if(newVisit != visit) visited[next] = false;
    }
    
}

int main(int argc, const char * argv[]) {
    
    int test;
    scanf("%d",&test);
    int now = 0;
    
    while(now!=test)
    {
        int c1, c2;
        r = 0;
        
        scanf("%d %d %d %d",&n,&m,&k,&d);
        
        for(int i =1;i<=n;i++) city[i].clear();
        memset(visited, false, sizeof(visited));
        
        for(int i=0;i<m;i++)
        {
            scanf("%d %d",&c1, &c2);
            city[c1].push_back(c2);
            city[c2].push_back(c1);
        }

        
        for(int i=1; i<=n;i++)
        {
            visited[i] = true;
            if(i<=k) dfs(i,1,1);
            else dfs(i,1,0);
            visited[i] = false;
        }
        
        printf("#%d %d",++now,r%1000000009);
        
    }
    
    return 0;
}
