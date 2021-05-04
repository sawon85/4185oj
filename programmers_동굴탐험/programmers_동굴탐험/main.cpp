//
//  main.cpp
//  programmers_동굴탐험
//
//  Created by sawon on 2021/05/04.
//

#include <iostream>
#include <string>
#include <vector>
#include <queue>

using namespace std;

int degree[200000];
vector<int> graph[200000];
vector<int> ord[200000];
bool canGo[200000];
bool visited[200000];

bool solve(int n)
{
    if(degree[0]>0) return false;
    
    queue<int> q;
    q.push(0);
    canGo[0] = true;
    visited[0] = true;
    
    int now;
    int next;
    while(!q.empty())
    {
        now = q.front();
        q.pop();
        
        if(!ord[now].empty())
        {
            for(int i=0; i<ord[now].size(); i++)
            {
                next = ord[now].at(i);
                degree[next]--;
                
                if(degree[next] == 0 && canGo[next])
                {
                    q.push(next);
                    visited[next] = true;
                }
            }
            
            ord[now].clear();
        }
        
        for(int i=0; i<graph[now].size(); i++)
        {
            next = graph[now].at(i);
            canGo[next] = true;
            
            if(degree[next]!=0) continue;
            if(visited[next]) continue;
            
            q.push(next);
            visited[next] = true;
        }
    }
    
    for(int i=0; i<n; i++) if(!visited[i]) return false;
    
    return true;
}

bool solution(int n, vector<vector<int>> path, vector<vector<int>> order) {
    bool answer = true;
    
    for(int i=0; i<path.size(); i++)
    {
        graph[path[i][0]].push_back(path[i][1]);
        graph[path[i][1]].push_back(path[i][0]);
    }
    
    for(int i=0; i<order.size(); i++)
    {
        ord[order[i][0]].push_back(order[i][1]);
        degree[order[i][1]]++;
    }
    
    
    return solve(n);
}

int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    return 0;
}
