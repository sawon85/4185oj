//
//  main.cpp
//  20040
//
//  Created by sawon on 2021/04/22.
//

#include <iostream>
#include <vector>

using namespace std;
int parent[500001];

int n, m;

int findP(int v)
{
    if(parent[v] == v) return v;
    return findP(parent[v]);
}

bool solve(int v1, int v2)
{
    if(parent[v1] == -1 && parent[v2] == -1)
    {
        parent[v2] = v1;
        parent[v1] = v1;
    }
    

    else if(parent[v1] == -1) parent[v1] = v2;
    else if(parent[v2] == -1) parent[v2] = v1;
    
    else if(parent[v1] != parent[v2])
    {
        int pv1 = findP(v1);
        int pv2 = findP(v2);
        
        if(pv1 == pv2) return true;
        
        parent[pv2] = pv1;
    }
    
    else if(parent[v1] == parent[v2]) return true;
    
    return false;
}

int main(int argc, const char * argv[]) {

    cin >> n >> m;
    
    int v1, v2;
    
    for(int i=0; i<n; i++) parent[i] = -1;
    
    int ans = 0;
    for(int i=1; i<=m; i++)
    {
        cin >> v1 >> v2;
        if(ans==0) if(solve(v1, v2)) ans = i;
    }
    
    cout << ans;
    
    
    return 0;
}
