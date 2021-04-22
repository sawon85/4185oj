//
//  main.cpp
//  1766
//
//  Created by sawon on 2021/04/22.
//

#include<iostream>
#include<vector>
#include<queue>
 
#define endl "\n"
using namespace std;
 
int N, M;
int Entry[32001];
vector<int> Node[32001];
bool visited[32001];
 
void Input()
{
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int a, b; cin >> a >> b;
        Entry[b]++;
        Node[a].push_back(b);
    }
}
 
void Solution()
{
    queue<int> Q;
    for (int i = 1; i <= N; i++)
    {
        if (Entry[i] == 0)
        {
            Q.push(i);
            visited[i] = true;
            break;
        }
    }
    
    while (Q.empty() == 0)
    {
        int Cur = Q.front();
        Q.pop();
 
        cout << Cur << " ";
        
        for (int i = 0; i < Node[Cur].size(); i++)
        {
            int Next = Node[Cur][i];
            Entry[Next]--;
            
        }
        
        for (int i = 1; i <= N; i++)
        {
            if(visited[i]) continue;
            
            if (Entry[i] == 0)
            {
                Q.push(i);
                visited[i] = true;
                break;
            }
        }
        
    }
    cout << endl;
}
 
void Solve()
{
    Input();
    Solution();
}
 
int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
 
    Solve();
 
    return 0;
}
