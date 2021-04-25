//
//  main.cpp
//  1976
//
//  Created by sawon on 2021/04/23.
//

#include <iostream>
#include <vector>

using namespace std;
int n, m;
int parent[200];  //자기 v로 초기화
int cnt[200];  //1로 초기화

vector<int> v;
int findP(int v)
{
    if(v==parent[v]) return v;
    
    return parent[v] = findP(parent[v]);
}

void set(int v1, int v2)
{
    int p1 = parent[v1]; int p2 = parent[v2];  //항상 p2 -> p1에 속하게
    
    if(p1 == p2) return;
    
    if(cnt[p2] > cnt[p1]) swap(p1, p2);
    
    cnt[p1] += cnt[p2];
    parent[p2] = p1;
    parent[v2] = p1;
}

void init()
{
    for(int i=0; i<n; i++)
    {
        parent[i] = i;
        cnt[i] = 1;
    }
    
}

bool solve()
{
    if(v.empty()) return true;
    
    int v1, v2;
    int p1, p2;
    v1 = v.at(0);
    p1 = findP(v1);
    
    for(int i=1; i<v.size(); i++)
    {
        v2 = v.at(i);
        p2 = findP(v2);
        
        if(p1 != p2) return false;
        
        p1 = p2;
        v1 = v2;
        
    }
    
    return true;
}

int main(int argc, const char * argv[]) {

    cin >> n >> m;
    
    int v1, li;
    
    init();
    
    for(int i=0; i<n; i++)
    for(int j=0; j<n; j++)
    {
        cin >> li;
        if(li==1) set(i, j);
    }
    
    for(int i=0; i<m; i++)
    {
        cin >> v1;
        v.push_back(v1-1);
    }
    
    if(solve()) cout << "YES";
    else cout << "NO";
    
    return 0;
}
