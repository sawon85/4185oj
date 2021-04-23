//
//  main.cpp
//  2193
//
//  Created by sawon on 2021/04/23.
//

#include <iostream>
using namespace std;
int n;
long long board[2][2];
void dp(int cnt)
{
    if(cnt == n-1) return;
    
    for(int i=0; i<2; i++) board[0][i] = board[1][i];
    for(int i=0; i<2; i++) board[1][i] = 0;
    
    board[1][0] = board[0][0] + board[0][1];
    board[1][1] = board[0][0];
    
    dp(cnt+1);
}


int main(int argc, const char * argv[]) {
    
    cin >> n;
    
    if(n==1)
    {
        cout << 1;
        return 0 ;
    }
    
    
    board[1][0] = 1; board[1][1] = 1;
    
    dp(0);
    
    cout << board[1][1];
    
    return 0;
}
