//
//  main.cpp
//  타일채우기
//
//  Created by sawon on 03/01/2019.
//  Copyright © 2019 sawon. All rights reserved.
//

#include <iostream>
int dynamic[16];
int main(int argc, const char * argv[]) {
    int n;
    scanf("%d",&n);
    if(n%2==1)
        printf("0");
    else{
        n/=2;
        dynamic[1]=3;
        
        for(int i=2;i<=n;i++)
        {
            dynamic[i]=dynamic[i-1]*5-2;
        }
        printf("%d",dynamic[n]);
        
    }
    return 0;
}
