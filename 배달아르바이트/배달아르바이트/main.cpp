#include <iostream>
#include <queue>
#include <stack>
#include <cstdio>
#include <vector>
#include <cstring>
#include <string>
#include <math.h>
#include <algorithm>
#include <map>

using namespace std;

#define INF 1001

int N = 0, M = 0, K = 0, S = 0;

int Map[1001][1001] = { INF, };

bool visit[1001] = { false, };

vector<int> p;

int main(void)
{
    int T = 0, from = 0, to = 0, path = 0;
    
    scanf("%d %d %d %d", &N, &M, &K, &S);
    
    
    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= N; j++)
        {
            Map[i][j] = (i == j) ? 0 : INF;
        }
    }
    
    for (int i = 0; i < K; i++)
    {
        scanf("%d", &path);
        
        p.push_back(path);
    }
    
    for (int i = 0; i < M; i++)
    {
        scanf("%d %d", &from, &to);
        Map[from][to] = 1;
        Map[to][from] = 1;
    }
    
    for (int k = 1; k <= N; k++)
    {
        for (int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= N; j++)
            {
                if (i == j) continue;
                
                if (Map[i][j] > Map[i][k] + Map[k][j])
                {
                    Map[i][j] = Map[i][k] + Map[k][j];
                }
            }
        }
    }
    
    int result = 0;
    int start = S;
    int last = 0;
    int cnt = p.size();

    while (cnt)
    {
        int min_index = INT32_MAX;
        int min_weight = INT32_MAX;
        for (int i = 0; i < p.size(); i++)
        {
            if (visit[p.at(i)] || start == p.at(i)) continue;
            
            if (min_weight > Map[start][p.at(i)])
            {
                min_weight = Map[start][p.at(i)];
                min_index = p.at(i);
            }
    }
        
        printf("방문 순서 = %d\n", min_index);
        
        result += min_weight;
        visit[min_index] = true;
        start = last = min_index;
        --cnt;
    }
    
    result += Map[last][S];
    
    printf("%d\n", result);
    
    return 0;
}
