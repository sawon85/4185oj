//
//  main.cpp
//  16235
//
//  Created by sawon on 2021/04/15.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
struct tree{
    int age;
    bool isAlive = true;
};

struct ground{
    vector<tree> trees;
    int e;
};

int n, m, k;
ground map[10][10];
int winter[10][10];

bool cmp(const tree&x , const tree&y)
{
    return x.age < y.age;
}

int dx[8] = {-1, 0, 1, -1, 1, -1, 0, 1};
int dy[8] = {-1, -1, -1, 0, 0, 1, 1, 1};

void s()
{
    bool flag;
    for(int i=0; i<n; i++)
    for(int j=0; j<n; j++)
    {
        
        if(map[i][j].trees.empty()) continue;
        
        flag = true;
        
        for(int t=0; t<map[i][j].trees.size(); t++)
        {
            
            if(!flag)
            {
                map[i][j].e += map[i][j].trees.at(t).age/2;
                map[i][j].trees.erase(map[i][j].trees.begin()+t);
                t--;
                continue;
            }
            
            map[i][j].e -= map[i][j].trees.at(t).age;
            
            if(map[i][j].e < 0)
            {
                flag = false;
                map[i][j].e += map[i][j].trees.at(t).age;
                map[i][j].e += map[i][j].trees.at(t).age/2;
                map[i][j].trees.erase(map[i][j].trees.begin()+t);
                t--;
                continue;
            }
            
            map[i][j].trees.at(t).age++;
        }
    }
}

void f()
{
    int xx;
    int yy;
    tree tr;
    for(int i=0; i<n; i++)
    for(int j=0; j<n; j++)
    {
        
        if(map[i][j].trees.empty()) continue;
        for(int t=0; t<map[i][j].trees.size(); t++)
        {
            tr = map[i][j].trees.at(t);
            if(tr.age%5 != 0) continue;
            
            for(int d=0; d<8; d++)
            {
                xx = j + dx[d];
                yy = i + dy[d];
                
                if(xx<0 || xx >=n || yy <0 || yy>=n) continue;
                
                tree newTree;
                newTree.age = 1;
                
                map[yy][xx].trees.insert(map[yy][xx].trees.begin(), newTree);
                
            }
        }
    }
}

void w()
{
    for(int i=0; i<n; i++)
    for(int j=0; j<n; j++)
    {
        map[i][j].e += winter[i][j];
    }
    
}

int count()
{
    int cnt = 0;
    
    for(int i=0; i<n; i++)
    for(int j=0; j<n; j++)
    {
        cnt += map[i][j].trees.size();
    }
    
    return cnt;
}

int main(int argc, const char * argv[]) {

    cin >> n >> m >> k;
    
    for(int i=0; i<n; i++) for(int j=0; j<n; j++)
    {
        cin >> winter[i][j];
        map[i][j].e = 5;
    }
    
    int r, c, a;
    
    for(int i=0; i<m; i++)
    {
        cin >> r >> c >> a;
        
        map[r-1][c-1].trees.push_back(tree{a, true});
        
    }
    for(int i=0; i<n; i++)
    for(int j=0; j<n; j++)
        if(!map[i][j].trees.empty()) sort(map[i][j].trees.begin(),map[i][j].trees.end(), cmp);

    
    for(int i=0; i<k; i++)
    {
        s(); f(); w();
    }
    
    cout << count();
    
    return 0;
}
