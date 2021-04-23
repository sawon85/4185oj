//
//  main.cpp
//  10844
//
//  Created by sawon on 2021/04/23.
//

#include <iostream>

using namespace std;

long long board[2][10];

int n;

void dp(int cnt)
{
    if(cnt == n-1) return;
    
    for(int i=0; i<10; i++) board[0][i] = board[1][i];
    for(int i=0; i<10; i++) board[1][i] = 0;
    
    for(int i=0; i<10; i++)
    {
        if(i>0) board[1][i] += board[0][i-1]%1000000000;
        if(i<9) board[1][i] += board[0][i+1]%1000000000;

    }
    
    dp(cnt+1);
}


int main(int argc, const char * argv[]) {
    
    cin >> n;
    if(n==1)
    {
        cout << 9;
        return 0 ;
    }
    
    
    
    board[1][0] = 1; board[1][1] = 1;
    board[1][2] = 1; board[1][3] = 1;
    board[1][4] = 1; board[1][5] = 1;
    board[1][6] = 1; board[1][7] = 1;
    board[1][8] = 1; board[1][9] = 1;
    
    long long ans = 0;
    dp(0);
    
    for(int i=1; i<10; i++) ans+=board[1][i];
    
    cout << ans%1000000000;
    
    return 0;
}
