//
//  main.cpp
//  14889
//
//  Created by sawon on 2021/04/20.
//

#include <iostream>
#include <vector>
#include <math.h>

using namespace std;
int map[20][20];
int n;
int visited[20];

int ans = 400001;

void sum()
{
    for(int i=0; i<n; i++) for(int j=0; j<i; j++) map[i][j] += map[j][i];
}

void print()
{
    cout <<endl;
    
    for(int i=0; i<n; i++)
    {
        for(int j=0; j<n; j++)
        {
            cout<< map[i][j] << " ";
        }
        
        cout << endl;
    }
}

void dfs(int index, vector<int> &start, vector<int> &link)
{
    if(index == n)
    {
        int st = 0, li =0;
        
        for(int i=0; i<(int) start.size(); i++)
        {
            for(int j=i+1; j<start.size(); j++) st += map[start.at(j)][start.at(i)];
            
        }
        
        for(int i=0; i<link.size(); i++)
        {
            for(int j=i+1; j<(int) link.size(); j++) li += map[link.at(j)][link.at(i)];
            
        }
        
        int result = abs(st-li);
        
        ans = (ans < result) ? ans : result;
        
        return;
    }
    
    if(start.size() < n/2)
    {
        start.push_back(index);
        dfs(index+1, start, link);
        start.pop_back();
    }
    
    if(link.size() < n/2)
    {
        link.push_back(index);
        dfs(index+1, start, link);
        link.pop_back();
    }
}


int main(int argc, const char * argv[]) {
    // insert code here...
    
    cin >> n;
    
    for(int i=0; i<n; i++) for(int j=0; j<n; j++) cin >> map[i][j];
    
    vector<int> start;
    vector<int> link;
    
    sum();
    //print();
    dfs(0, start, link);
    
    cout << ans;
    
    return 0;
}
