 //
//  main.cpp
//  숨바꼭질3
//
//  Created by sawon on 18/12/2018.
//  Copyright © 2018 sawon. All rights reserved.
//
//

#include <stdio.h>
#include <iostream>
#define MAX 99999
int me;
int sister;
int visit[100001]={MAX,};
int front=0;
int rear=0;
int queue[10000000];
void reset()
{
    for(int i=0;i<100001;i++)
        visit[i]=MAX;
}
void enqueue(int key,int place,int mul)
{
    if(key<0||key>100000) return;
    if(visit[key]<=visit[place]) return;
    
    queue[rear++]=key;
    
    if(mul==1)
        visit[key]=visit[place];
    
    else
        visit[key]=visit[place]+1;
}
int dequeue()
{
    return queue[front++];
}
bool queueempty()
{
    return rear-front;
}
void insertqueue(int place)
{
    
    enqueue(place*2,place,1);
    enqueue(place+1,place,0);
    enqueue(place-1,place,0);
}
void BFS()
{
    int min=-2;
    visit[me]=0;
    insertqueue(me);
    while(queueempty())
    {
        if(visit[queue[front]]==min+1) return;
        insertqueue(dequeue());
        if(visit[sister]!=MAX)
            min=visit[sister];
    } 
}
int main(int argc, const char * argv[]) {
    
    reset();
    scanf("%d",&me);
    scanf("%d",&sister);
    BFS();
    printf("%d",visit[sister]);
    return 0;
}
