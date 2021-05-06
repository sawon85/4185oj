
#include <string>
#include <vector>
#include <queue>
using namespace std;
 
int solution(vector<int> stones, int k)
{
    int answer = 987654321;
    deque<pair<int, int>> DQ;
 
    for (int i = 0; i < stones.size(); i++)
    {
        while (DQ.empty() == false && DQ.front().second < i - k + 1) DQ.pop_front();
        while (DQ.empty() == false && DQ.back().first < stones[i]) DQ.pop_back();
        DQ.push_back(make_pair(stones[i], i));
        if (i >= k - 1 && DQ.front().first < answer) answer = DQ.front().first;
    }
    return answer;
}
