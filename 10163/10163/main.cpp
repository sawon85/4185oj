//
//  main.cpp
//  10163
//
//  Created by sawon on 2020/08/03.
//  Copyright © 2020 sawon. All rights reserved.
//

#include <iostream>

int box[101][101];

int n;

int size[101];

void update(int x, int y, int w, int h, int number)
{
    for(int j = y; j< y+h; j++)
        for(int i = x; i<x+w; i++)
            box[j][i] = number;
}

int main(int argc, const char * argv[]) {
    
    scanf("%d", &n);
    
    int x, y, w, h;
    
    for(int i = 1; i<=n; i++)
    {
        scanf("%d %d %d %d", &x, &y, &w, &h);
        update(x,y,w,h,i);
    }
    
    for(int j=0; j<101;j++) for(int i=0; i<101; i++) ++size[box[j][i]];
        
    for(int i=1; i<=n; i++) printf("%d\n",size[i]);
    
    
    return 0;
}
