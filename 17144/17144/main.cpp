//
//  main.cpp
//  17144
//
//  Created by sawon on 2021/03/10.
//

#include <iostream>
using namespace std;

int r, c, t;
int map[50][50];
int a1 = -1, a2 = -1;

int tmp[50][50];

int xx[4] = {-1, 1, 0, 0};
int yy[4] = {0, 0, 1, -1};

void setTmp(int x, int y)
{
    int newX;
    int newY;
    int diff = map[y][x]/5;
    
    for(int i=0; i<4; i++)
    {
        newX = x + xx[i];
        newY = y + yy[i];
        if(newX<0 || newX>=c || newY<0 || newY>=r) continue;
        if( (newY == a1 && newX==0)  || (newY == a2 && newX==0)) continue;
        
        tmp[y][x] -= diff;
        tmp[newY][newX] += diff;
        
    }
    
}

void setMenji()
{
    for(int i=0 ; i<r; i++)
        for(int j=0; j<c; j++)
        {
            if(map[i][j] <= 0) continue;
            
            setTmp(j, i);
        }
    
    for(int i=0 ; i<r; i++)
        for(int j=0; j<c; j++)
        {
            map[i][j] += tmp[i][j];
            tmp[i][j] = 0;
        }
        
    
}

void setGongi()
{
    for(int i=a1-1; i>=1; i--)
    {
        map[i][0] = map[i-1][0];
    }
    
    for(int i=a2+1; i<=r-1; i++)
    {
        map[i][0] = map[i+1][0];
    }
    
    for(int i=0;i<=c-2;i++)
    {
        map[0][i] = map[0][i+1];
        map[r-1][i] = map[r-1][i+1];
        
    }
    
    for(int i=0; i<=a1-1;i++)
    {
        map[i][c-1] = map[i+1][c-1];
    }
    
    for(int i=r-1; i>=a2+1; i--)
    {
        map[i][c-1] = map[i-1][c-1];
    }
    
    for(int i=c-1; i>=2; i--)
    {
        map[a1][i] = map[a1][i-1];
        map[a2][i] = map[a2][i-1];
        
    }
    
    map[a1][1] = 0;
    map[a2][1] = 0;
    
}

void doSceond()
{
    setMenji();
    setGongi();
}


int run()
{
    for(int i=0; i<t; i++) doSceond();
    
    int cnt=0;
    for(int i=0 ; i<r; i++)
        for(int j=0; j<c; j++)
                cnt += map[i][j];
    
    return cnt+2;
    
}


int main(int argc, const char * argv[]) {
    
    ios::sync_with_stdio(false);
    cin.tie(NULL);cout.tie(NULL);
    
    cin >> r >> c >> t;
    
    for(int i=0 ; i<r; i++)
        for(int j=0; j<c; j++)
        {
            cin >> map[i][j];
            
            if(map[i][j] == -1)
            {
                if(a1 == -1) a1 = i;
                else a2 = i;
            }
            
        }
        
    
    cout << run();
    
    return 0;
}
