#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
using namespace std;
 
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int n, ans = 0;
    cin >> n;
    vector<pair<int, int>> v;
    while (n--)
    {
        int s, e;
        cin >> s >> e;
        v.push_back({ s,e });
    }
    sort(v.begin(), v.end());
 
    priority_queue<int> q;
 
    q.push(-1);
 
    for (int i = 0; i < v.size(); i++)
    {
        if (v[i].first < -q.top())
        {
            q.push(-v[i].second);
        }
        else
        {
            q.pop();
            q.push(-v[i].second);
        }
 
        int size = q.size();
        ans = max(ans, size);
    }
 
    cout << ans << endl;
    return 0;
}
