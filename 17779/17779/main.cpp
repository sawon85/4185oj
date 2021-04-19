//
//  main.cpp
//  17779
//
//  Created by sawon on 2021/04/16.
//

#include <iostream>
using namespace std;


int x, y, d1, d2;
int topx, topy, bottomx, bottomy;
int n; //<=20
int tmp[21][21];
int people[21][21];
int sum[6];

int ans =20*20*100 + 1;

void reset()
{
    for(int c=1; c<=n; c++)
    for(int r=1; r<=n; r++)
    tmp[c][r] = 0;
}

void set()
{
    /*
     1번 선거구: 1 ≤ r < x+d1, 1 ≤ c ≤ y
     2번 선거구: 1 ≤ r ≤ x+d2, y < c ≤ N
     3번 선거구: x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
     4번 선거구: x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N
     */
    
    for(int c=1; c<=n; c++)
    for(int r=1; r<=n; r++)
    {
        if(tmp[c][r] == 5) continue;
        else if(x+d2 < r && y-d1+d2 <= c) tmp[c][r] = 4;
        else if(r<=x+d2 && y<c) tmp[c][r] = 2;
        else if(x+d1 <= r && c < y-d1+d2) tmp[c][r] = 3;
        else if(r<x+d1 && c<=y) tmp[c][r] = 1;
    }
    
    
}

void result()
{
    for(int i=0; i<6; i++) sum[i] = 0;
    
    int min = 20*20*100 + 1;
    int max = -1;
    
    for(int c=1; c<=n; c++)
    for(int r=1; r<=n; r++)
    {
        sum[tmp[c][r]] += people[r][c];
    }
    
    for(int i=1; i<6; i++)
    {
        min = (min < sum[i]) ? min : sum[i];
        max = (max > sum[i]) ? max : sum[i];
    }
    
    ans = (ans > max - min) ? max - min : ans;

}

void set5()
{
    /*
    (x, y), (x+1, y-1), ..., (x+d1, y-d1)
    (x, y), (x+1, y+1), ..., (x+d2, y+d2)
    (x+d1, y-d1), (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2)
    (x+d2, y+d2), (x+d2+1, y+d2-1), ..., (x+d2+d1, y+d2-d1)
    */
    
    for(int i=0;i<=d1;i++)
    {
        tmp[y-i][x+i] = 5;
        tmp[y+d2-i][x+d2+i] = 5;
    }
    
    for(int i=0;i<=d2;i++)
    {
        tmp[y+i][x+i] = 5;
        tmp[y-d1+i][x+d1+i] = 5;
    }
    
    bool flag = false;
    for(int i=1; i<=n; i++)
    for(int j=1; j<=n; j++)
    {
        if(tmp[i][j]!=5 && !flag) continue;
        if(i==topy && j==topx) continue;
        if(i==bottomy && j==bottomx) continue;
        if(tmp[i][j]==5) flag = !flag;
        else tmp[i][j] = 5;
    }
    
}

bool isOk()
{
    //d2 ≥ 1, 1 ≤ x < x+d1+d2 ≤ N, 1 ≤ y-d1 < y < y+d2 ≤ N
    if(d1<1 || d2<1) return false;
    if(x<1) return false;
    if(x>=x+d1+d2) return false;
    if(x+d1+d2>n) return false;
    if( 1 > y-d1) return false;
    if(y-d1 >= y) return false;
    if(y >= y+d2) return false;
    if( y+d2 > n) return false;
    
    return true;
}

void solution()
{
    for(int X=1; X<=n-2; X++)
    for(int D1=1;D1<=n-X-1;D1++)
    for(int D2=1;D2<=n-X-D1;D2++)
    for(int Y=D1+1;Y<=n-D2;Y++)
    {
        x = X; y = Y; d1 = D1; d2=D2;
        if(!isOk()) continue;
        topx = x+d1; topy = y-d1; bottomx=x+d2; bottomy=y+d2;
        reset();
        set5();
        set();
        result();
    }
    
}


int main(int argc, const char * argv[]) {

    cin >> n;
    for(int c=1; c<=n; c++)
    for(int r=1; r<=n; r++)
    cin >> people[c][r];
    
    solution();
    
    cout << ans;
    
    return 0;
}
