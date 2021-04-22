//
//  main.cpp
//  4195
//
//  Created by sawon on 2021/04/22.
//

#include <iostream>
#include <algorithm>
#include <cstring>
#include <map>
#include <set>

using namespace std;

map<string, int> m;

int parent[200001];
int nodeCount[200001];

int cnt, n, f;

int findP(int v)
{
    if(parent[v] == v) return v;
    return parent[v] = findP(parent[v]);
}

void solve(int v1, int v2)
{
    int p1 = findP(v1);
    int p2 = findP(v2);
    
    if(p1 != p2)
    {
        if(nodeCount[p1] < nodeCount[p2]) swap(p1, p2);
        
        nodeCount[p1] += nodeCount[p2];
        parent[p2] = p1;
    }
    
}

int main(int argc, const char * argv[]) {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    cin >> n;
    
    for(int t = 0; t<n; t++)
    {
        m.clear();
        cin >> f;
        
        int p1, p2;
        string name1, name2;
        
        for(int i=0; i<200001; i++)
        {
            nodeCount[i] = 1; parent[i] = i;
        }
        
        for(int i=0; i<f; i++)
        {
            cin >> name1 >> name2;
            
            if(m.find(name1) == m.end()) m[name1] = ++cnt;
            if(m.find(name2) == m.end()) m[name2] = ++cnt;
            
            solve(m[name1],m[name2]);
            
            p1 = findP(m[name1]);
            p2 = findP(m[name2]);
            
            
            printf("%d\n",max(nodeCount[p1], nodeCount[p2]));
        }
        
    }
    
    return 0;
}
