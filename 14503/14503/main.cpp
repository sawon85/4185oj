//
//  main.cpp
//  14503
//
//  Created by sawon on 2021/03/12.
//

#include <iostream>

using namespace std;

int n, m;

int dx[4] = {-1, 0, 1, 0}; //서남동북
int dy[4] = {0, 1, 0, -1};

int map[50][50];

int cnt = 0;

int run(int x, int y, int d, int cnt)
{
    int newCnt = (map[y][x] == 0) ? cnt+1 : cnt;
    
    map[y][x] = 2;

    int newX;
    int newY;
    int newD;
    
    for(int i=0; i<4; i++)
    {
        newD = (d+i+1)%4;
        newX = x + dx[newD];
        newY = y + dy[newD];
        
        if(map[newY][newX] > 0) continue;
        
        return run(newX, newY, newD, newCnt);
        
    }
    
    newX = x + dx[(d+2)%4];
    newY = y + dy[(d+2)%4];
    
    if(map[newY][newX] == 1) return newCnt;
    
    return run(newX, newY, d, newCnt);
    
}

int main(int argc, const char * argv[]) {

    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int x, y, d;
    
    cin >> n >> m ;
    cin >> y >> x >> d;
    
    for(int i=0; i<n; i++) for(int j=0; j<m; j++) cin >> map[i][j];
    
    cout << run(x, y, 3-d, 0);
    

    return 0;
}
