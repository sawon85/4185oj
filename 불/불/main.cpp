//
//  main.cpp
//  불
//
//  Created by sawon on 19/12/2018.
//  Copyright © 2018 sawon. All rights reserved.
//
char map[1000][1000];
#include <iostream>
int w,h;
struct q{
    int x;
    int y;
};
q queue[1000];
int front=0;
int rear=0;

void push(int X,int Y)
{
    queue[rear].x=X;
    queue[rear++].y=Y;
}
q pop(){
    return queue[front++];
}
void BFS()
{
    
    
}
int main(int argc, const char * argv[]) {
    scanf("%d %d",&w,&h);
    for(int i=0;i<h;i++)
        for(int j=0;j<w;j++)
        {
            scanf(" %c",&map[i][j]);
            if(map[i][j]=='@')
                push(j,i);
        }
    
    return 0;
}
