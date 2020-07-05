//
//  main.cpp
//  숨바꼭질2
//
//  Created by sawon on 18/12/2018.
//  Copyright © 2018 sawon. All rights reserved.
//

/*굳이 c로 구현하기*/
#include <stdio.h>
#include <iostream>
#define MAX -1 //움직이는 거
int me;
int sister;
int visit[100001];
int visitcount[100001]={0,};
int front=0;
int rear=0;
int queue[100000];
void reset()
{
    for(int i=0;i<100001;i++)
        visit[i]=MAX;
}
void enqueue(int key,int place)
{
    if(key<0||key>100000) return;
    if(visit[key]==visit[place]+1)
    {
        visitcount[key]+=visitcount[place];
        return;
    }
   else if(visit[key]!=MAX) return;
    queue[rear++]=key;
    visit[key]=visit[place]+1;
    visitcount[key]=visitcount[place];
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
    enqueue(place+1,place);
    enqueue(place-1,place);
    enqueue(place*2,place);
}
void BFS()
{
    int min=-2;
    visit[me]=0;
    visitcount[me]=1;
    insertqueue(me);
    while(queueempty())
    {
        if(visit[queue[front]]==min+1) return;
        insertqueue(dequeue());
        if(visit[sister]!=MAX) min=visit[sister];
    }
}
int main(int argc, const char * argv[]) {
    
    reset();
    scanf("%d",&me);
    scanf("%d",&sister);
    BFS();
    printf("%d\n%d",visit[sister],visitcount[sister]);
    return 0;
}
