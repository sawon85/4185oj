//
//  main.cpp
//  14888
//
//  Created by sawon on 2021/03/25.
//

#include <iostream>

using namespace std;

int N;

int number[11];
int cacul[4];
int visited[4];
int maxN = -1000000001;
int minN = 2000000000;

int caculator(int number1, int number2, int ca)
{
    if(ca == 0) return number1 + number2;
    if(ca == 1) return number1 - number2;
    if(ca == 2) return number1 * number2;
    if(ca == 3) return number1 / number2;
    return 0;
}

void dfs(int st, int nextIndex)
{
    if(nextIndex == N)
    {
        maxN = (st > maxN) ? st : maxN;
        minN = (st < minN) ? st : minN;
        
        return;
    }
    
    for(int i=0; i<4; i++)
    {
        if(cacul[i] == visited[i]) continue;
        visited[i]++;
        
        dfs(caculator(st, number[nextIndex], i) , nextIndex+1);
        
        visited[i]--;
        
    }
    
}

int main(int argc, const char * argv[]) {
    
    cin >> N;
    
    for(int i=0; i<N; i++) cin >> number[i];
    
    for(int i=0; i<4; i++) cin >> cacul[i];
    
    dfs(number[0], 1);
    
    cout << maxN << "\n" << minN;
    
    
    return 0;
}
