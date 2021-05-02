#include<iostream>
#include<queue>
#include<string>
#include<cstring>
#include<algorithm>
#include<set>
 
#define endl "\n"
#define MAX 210
using namespace std;
 
string MAP;
vector<string> Answer;
vector<pair<int, int>> GwalHo;
set<string> Visit;
bool Select[10];
bool Express_MAP[MAX];
 
void Input()
{
    cin >> MAP;
    deque<int> Q;
    for (int i = 0; i < MAP.length(); i++)
    {
        if (MAP[i] == '(') Q.push_back(i);
        else if (MAP[i] == ')')
        {
            int P = Q.back();
            Q.pop_back();
            GwalHo.push_back(make_pair(P, i));
        }
    }
}
 
void DFS(int Idx, int Cnt)
{
    if (Cnt >= 1)
    {
        string S = "";
        for (int i = 0; i < MAP.length(); i++)
        {
            if (Express_MAP[i] == true) continue;
            S = S + MAP[i];
        }
        
        if (Visit.find(S) == Visit.end())
        {
            Visit.insert(S);
            Answer.push_back(S);
        }
    }
 
    for (int i = Idx; i < GwalHo.size(); i++)
    {
        if (Select[i] == true) continue;
 
        Select[i] = true;
        Express_MAP[GwalHo[i].first] = true;
        Express_MAP[GwalHo[i].second] = true;
        DFS(i, Cnt + 1);
        Select[i] = false;
        Express_MAP[GwalHo[i].first] = false;
        Express_MAP[GwalHo[i].second] = false;
    }
}
 
void Solution()
{
    DFS(0, 0);
    sort(Answer.begin(), Answer.end());
    for (int i = 0; i < Answer.size(); i++)
    {
        cout << Answer[i] << endl;
    }
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

