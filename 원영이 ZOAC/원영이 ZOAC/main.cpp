//
//  main.cpp
//  원영이 ZOAC
//
//  Created by sawon on 30/12/2018.
//  Copyright © 2018 sawon. All rights reserved.
//

#include <iostream>
int t;
int main(int argc, const char * argv[]) {
    scanf("%d",&t);
    int a=1;
   unsigned long long int sum=0;
   //t가 홀수면 항상 2, 짝수면 최소 4.
   int div;
    
    for(int i=1;i<=29;i++)
    {
        a*=2;
        div=t/a;   // t보다 작은 수중에 a로 나누어 떨어지는 수가 몇개 있는 가?
        if(div==0)
            break; //a가 t보다 커져버리면 break;
        sum+=a*div;
// 그 개수에 a를 곱해서 더해준다 (이유 : t가 4로 나누어 떨어지면 2t 는 8로 나누어 떨어진다는 의미이다. 즉 8과 4의 갭인 4에 개수를 곱해서 더해준다.
    }
    
    sum=sum+t*2;
    
    printf("%llu",sum);
   
    return 0;
}

