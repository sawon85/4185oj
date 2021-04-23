//
//  main.cpp
//  2133
//
//  Created by sawon on 2020/08/14.
//  Copyright © 2020 sawon. All rights reserved.
//

#include <iostream>
using namespace std;

int n;
int tile[31];

int main(int argc, const char * argv[]) {
    
    tile[2] = 3;
    
    for(int i=4; i<31; i+=2)
    {
        tile[i] = tile[i-2]*tile[2]+2;
        for(int j=4; j<=i-2; j+=2) tile[i] = tile[i] + tile[i-j] * 2;

    }
    
    
    cin >> n;
    
    cout << tile[n];
    
    return 0;
}
