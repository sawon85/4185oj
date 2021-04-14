//
//  main.cpp
//  15863
//
//  Created by sawon on 2021/04/15.
//

#include <iostream>
#include <queue>
using namespace std;

int n, m;

struct info{
    int x, y, camera;
};

info c[8];
int cnum = 0;

int minNum = 100000;

void Up(int x, int y, int map[8][8])
{
    while(true)
    {
        y--;
        if(y < 0 ) break;
        if(map[y][x] == 6) break;
        if(map[y][x] > 0) continue;
        
        map[y][x] = -1;
    }
}

void Down(int x, int y, int map[8][8])
{
    while(true)
    {
        y++;
        if(y >= n ) break;
        if(map[y][x] == 6) break;
        if(map[y][x] > 0) continue;
        
        map[y][x] = -1;
    }
}

void Left(int x, int y, int map[8][8])
{
    while(true)
    {
        x--;
        if(x < 0 ) break;
        if(map[y][x] == 6) break;
        if(map[y][x] > 0) continue;
        
        map[y][x] = -1;
    }
}

void Right(int x, int y, int map[8][8])
{
    while(true)
    {
        x++;
        if(x >= m ) break;
        if(map[y][x] == 6) break;
        if(map[y][x] > 0) continue;
        
        map[y][x] = -1;
    }
}

void camera1(int i, int x, int y, int map[8][8])
{
    switch (i) {
        case 0:
            Up(x, y, map);
            break;
            
        case 1:
            Down(x, y, map);
            break;
        case 2:
            Left(x, y, map);
            break;
        case 3:
            Right(x, y, map);
            break;
    }
    
}

void camera2(int i, int x, int y, int map[8][8])
{
    switch (i) {
        case 0:
            Up(x, y, map);
            Down(x, y, map);
            break;
            
        case 1:
            Left(x, y, map);
            Right(x, y, map);
            break;
    }
    
}

void camera3(int i, int x, int y, int map[8][8])
{
    switch (i) {
        case 0:
            Up(x, y, map);
            Right(x, y, map);
            break;
            
        case 1:
            Right(x, y, map);
            Down(x, y, map);
            break;
        case 2:
            Down(x, y, map);
            Left(x, y, map);
            break;
        case 3:
            Left(x, y, map);
            Up(x, y, map);
            break;
    }
    
}

void camera4(int i, int x, int y, int map[8][8])
{
    switch (i) {
        case 0:
            Up(x, y, map);
            Right(x, y, map);
            Down(x, y, map);
            break;
            
        case 1:
            Right(x, y, map);
            Down(x, y, map);
            Left(x, y, map);
            break;
        case 2:
            Up(x, y, map);
            Down(x, y, map);
            Left(x, y, map);
            break;
        case 3:
            Left(x, y, map);
            Up(x, y, map);
            Right(x, y, map);
            break;
    }
    
}

void camera5(int x, int y, int map[8][8])
{
    Left(x, y, map);
    Up(x, y, map);
    Right(x, y, map);
    Down(x, y, map);
}

void  copyMap(int map[8][8], int tmp[8][8])
{
    for(int i=0; i<n; i++)
    for(int j=0; j<m; j++)
    tmp[i][j] = map[i][j];
    
}

int count(int map[8][8])
{
    int cnt = 0;
    for(int i=0; i<n; i++)
    for(int j=0; j<m; j++)
    if(map[i][j] == 0) cnt++;
    return cnt;
}

void dfs(int num, int map[8][8])
{
    if(num == cnum)
    {
        int cnt = count(map);
        minNum = (minNum > cnt) ? cnt : minNum;
        return;
    }
    
    info now = c[num];
    int x = now.x;
    int y = now.y;
    
    switch (now.camera) {
        case 1:
            for(int i=0; i<4; i++)
            {
                int tmp[8][8];
                copyMap(map, tmp);
                camera1(i, x, y, tmp);
                dfs(num+1, tmp);
            }
            break;
            
        case 2:
            for(int i=0; i<2; i++)
            {
                int tmp[8][8];
                copyMap(map, tmp);
                camera2(i, x, y, tmp);
                dfs(num+1, tmp);
            }
            break;
            
        case 3:
            for(int i=0; i<4; i++)
            {
                int tmp[8][8];
                copyMap(map, tmp);
                camera3(i, x, y, tmp);
                dfs(num+1, tmp);
            }
            break;
            
        case 4:
            for(int i=0; i<4; i++)
            {
                int tmp[8][8];
                copyMap(map, tmp);
                camera4(i, x, y, tmp);
                dfs(num+1, tmp);
            }
            break;
            
        case 5:
            int tmp[8][8];
            copyMap(map, tmp);
            camera5(x, y, tmp);
            dfs(num+1, tmp);
            break;

            
    }
    
}

int main(int argc, const char * argv[]) {
    int map[8][8];
    
    cin >> n >> m;
    
    for(int i=0; i<n; i++)
    for(int j=0; j<m; j++)
    {
        cin >> map[i][j];
        
        if(map[i][j] > 0 && map[i][j] < 6) c[cnum++] = {j, i, map[i][j]};
    }
    
    dfs(0, map);
    
    cout << minNum;
    
    return 0;
}
