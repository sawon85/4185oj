//
//  main.cpp
//  10164
//
//  Created by sawon on 2020/07/06.
//  Copyright © 2020 sawon. All rights reserved.
//
//격자상의 경로
#include <iostream>
#include <stdio.h>
using namespace std;

const int MAX = 15+1;
int map[MAX][MAX];

int w,h, o;

int DP(int x1, int y1, int x2, int y2)
{
    for(int y =y1; y<=y2; y++)
        for(int x = x1; x<=x2; x++)
        {
            if (x==x1 || y ==y1) map[y][x] = 1;
            else map[y][x] = map[y][x-1] + map[y-1][x];
        }
        
    return map[y2][x2];
}

int main(int argc, const char * argv[]) {

    cin >> h >> w >> o;
    
    if(o == 0)
    {
        cout << DP(1, 1, w, h);
    }
    else
    {
        int ox,oy;
        
        if(o%w == 0)
        {
            ox = w;
            oy = o/w;
        }
        else
        {
            ox = o%w;
            oy = o/w+1;
        }
        
        cout << DP(1, 1, ox, oy) * DP(ox, oy, w, h);
    }

    
    return 0;
}


