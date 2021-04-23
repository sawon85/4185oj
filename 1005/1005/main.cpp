//
//  main.cpp
//  1005
//
//  Created by sawon on 2021/04/23.
//

#include <iostream>
#include <queue>
using namespace std;

bool map[1001][1001];
int n, k, d;
int t[1001];
int visited[1001];
int degree[1001];
int maxTime[1001];  //최소값으로

queue<int> q;

int solve()
{
    
    for(int i=0; i<n; i++)
        if(degree[i] == 0)
        {
            q.push(i);
            visited[i] = t[i];
        }
    
    
    int num;
    while(!q.empty())
    {
        num = q.front();
        q.pop();
        
        for(int i=0; i<n; i++)
        {
            if(!map[num][i]) continue;
            if(degree[i] == 0) continue;
            
            if(degree[i] == 1)
            {
                visited[i] = max(maxTime[i], visited[num]) + t[i];
                q.push(i);
                if(i == d-1) break;

            }
            
            else{
                maxTime[i] = max(maxTime[i], visited[num]);
            }
            
            degree[i]--;
        }
    }
    
    
    return visited[d-1];
}

void init()
{
    for(int i=0; i<n; i++)
    for(int j=0; j<n; j++)
    map[i][j] = false;
    
    for(int i=0; i<n; i++)
    {
        degree[i] = 0;
        maxTime[i] = -1;
        visited[i] = 0;
    }
    
}
int main(int argc, const char * argv[]) {
    int tt;
    
    cin >> tt;
    
    int num1, num2;
    
    for(int T=0; T<tt ; T++)
    {
        cin >> n >> k;
        init();
        
        for(int i=0; i<n; i++) cin >> t[i];
        
        for(int i=0; i<k; i++)
        {
            cin >> num1 >> num2;
            
            num1--; num2--;
            
            map[num1][num2] = true;
            degree[num2]++;
            
        }
        
        cin >> d;
        
        cout << solve() << endl;
        
    }
    return 0;
}
