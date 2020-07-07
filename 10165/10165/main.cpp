//
//  main.cpp
//  10165
//
//  Created by sawon on 2020/07/07.
//  Copyright © 2020 sawon. All rights reserved.
//

#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

vector<tuple<int ,int,int>> stop;
int bus[500000];
queue<int> q;



int main(int argc, const char * argv[]) {
    // insert code here...
    
    int S,B;
    
    cin >> S >> B;
    
    int x,y;
    for(int i=0; i<B; i++)
    {
        cin >> x >> y;
        stop.push_back(make_pair(x, i));
        stop.push_back(make_pair(y, i));
    }
    
    sort(stop.begin(),stop.end());
    
    for(int i=0; i<B; i++)
    {
        cout<<stop[i].first << stop[i].second;
    }
    
    std::cout << "Hello, World!\n";
    return 0;
}
