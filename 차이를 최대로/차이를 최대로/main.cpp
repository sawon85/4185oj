//
//  main.cpp
//  차이를 최대로
//
//  Created by sawon on 10/01/2019.
//  Copyright © 2019 sawon. All rights reserved.
//

#include <iostream>
int n;
int number[8];
int visit[8]={0,};
int maximum=-99999;
int temp=0;
bool allvisit()
{
    for(int i=0;i<n;i++)
        if(visit[i]==0)
            return 0;
    
    return 1;
}
void dfs(int in1)
{
    for(int in2=0;in2<n;in2++)
    {
        if(visit[in2]==1) continue;
        visit[in2]=1;
        temp+=abs(number[in1]-number[in2]);
        dfs(in2);
        visit[in2]=0;
        temp-=abs(number[in1]-number[in2]);
    }
    
    if(allvisit())
        maximum=(maximum>temp) ? maximum:temp;
}
void startdfs()
{
    for(int st=0;st<n;st++)
    {
        visit[st]=1;
        dfs(st);
        visit[st]=0;
    }
    
}
int main(int argc, const char * argv[]) {
    scanf("%d",&n);
    
    
    for(int i=0;i<n;i++)
        scanf("%d",&number[i]);
    
    startdfs();
    
    printf("%d",maximum);
    
    return 0;
}
