//
//  main.cpp
//  2133
//
//  Created by sawon on 2020/08/14.
//  Copyright © 2020 sawon. All rights reserved.
//

#include <iostream>

int n;
int tile[31];

int main(int argc, const char * argv[]) {
    
    scanf("%d",&n);
    
    tile[2] = 3;

    tile[4] = 2 + tile[2]*tile[2];
    
    tile[6] = tile[4]*tile[2]*2 + 2;
    
    tile[8] = tile[6]*tile[2]*2
    
    for(int i=4; i<=n; i+=2)
        tile[i] = tile[i-2]*3;
    
    
    printf("%d",tile[n]);
    
    return 0;
}
