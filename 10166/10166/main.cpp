//
//  main.cpp
//  10166
//
//  Created by sawon on 2020/07/06.
//  Copyright © 2020 sawon. All rights reserved.
//

#include <iostream>

using namespace std;

bool visited[36000000 + 1];

int small, big;

int setVisited(int seat)
{
    float angle;
    int index;
    int cnt = 0;
    for(int i = 1; i<=seat; i++)
    {
        angle = (float)360*i/seat;
        index = (int)(angle * 100000);
        if(visited[index]) continue;
        visited[index] = true;
        ++cnt;
    }
    
    return cnt;
}


int main(int argc, const char * argv[]) {

    cin >> small >> big;
    
    int sum=0;
    
    for (int i = small; i <= big; i++)
        sum += setVisited(i);
    
    cout << sum;
    
    return 0;
}
