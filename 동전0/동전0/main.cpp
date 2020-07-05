//
//  main.cpp
//  동전0
//
//  Created by sawon on 18/12/2018.
//  Copyright © 2018 sawon. All rights reserved.
//

#include <iostream>
int n[100];
int k=0;
int a,b;
void r(int count,int now)
{
    if(now>a) return;
    if(count>=b)
    {
        if(count==b)
            k++; return;
    }
    if(now==a)
    {
        if((b-count)%n[a]==0)
            k++;
            return;
    }
    else
    {
        int a=b-count;
        a/=n[now];
        for(int i=0;i<=a;i++)
            r(count+i*n[now],now+1);
    }
}
int main(int argc, const char * argv[]) {
    
    scanf("%d",&a);
    scanf("%d",&b);
    for(int i=1;i<=a;i++)
        scanf("%d",&n[i]);
    n[0]=0;
    r(0,1);
    printf("%d\n",k);
    return 0;
}
