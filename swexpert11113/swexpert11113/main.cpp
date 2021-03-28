//
//  main.cpp
//  swexpert11113
//
//  Created by sawon on 2021/01/09.
//

#include <iostream>

int main(int argc, const char * argv[]) {
    double a = 100;
    
    for(int i=0; i<12; i++)
    {
        a *= 1000000000;
    }
    
    printf("%d",a);
    return 0;
}
