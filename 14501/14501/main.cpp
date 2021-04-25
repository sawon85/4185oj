//
//  main.cpp
//  14501
//
//  Created by sawon on 2021/04/25.
//

#include <iostream>
#include <vector>
using namespace std;

vector<int> dp[15];
int base[15][2]; // 0-> 날짜 1->페이
int result[15];
int n;


int solution()
{
    int findate = 0;
    int maxNum = -1;
    
    for(int i=0; i<n; i++)
    {
        maxNum = 0;
        for(int j=0; j<dp[i].size(); j++)
        {
            maxNum = max(maxNum, dp[i].at(j));
        }
        
        result[i] = maxNum;
        if(i>=1) result[i] += result[i-1];
        
        findate = i + base[i][0] - 1;
        if(findate >=n) break;
        if(findate == i) result[i] += base[i][1];
        
        dp[findate].push_back(result[i] + base[i][1]);
        
    }
    
    maxNum = -1;
    
    for(int i=0; i<n; i++)
    {
        maxNum = max(maxNum, result[i]);
    }
    
    return maxNum;
    
}

int main(int argc, const char * argv[]) {
    
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    cin >> n;
    
    for(int i=0; i<n; i++)
    cin >> base[i][0] >> base[i][1];
    
    cout << solution();
    
    return 0;
}
