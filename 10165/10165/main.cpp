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

#define  MAX  1000000001
#define MIN  -1

int bus[500000];
queue<int> q;

typedef struct {
    int index, start, end;
    bool removed;
} point;

vector<point> stop;

bool cmp(const point & a, const point & b)
{
    if(a.start == b.start) return a.end > b.end;
    return a.start  < b.start;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    
    int S,B;
    
    cin >> S >> B;
    
    int x,y;
    
    int zeroEnd=MIN;
    
    for(int i=0; i<B; i++)
    {
        scanf("%d %d",&x, &y);
        point p;
        p.index = i;
        p.start = x;
        p.end = y;
        p.removed = false;
        
        if(p.start>p.end)
        {
            zeroEnd = max(zeroEnd,p.end);
            p.end += S;
        }
        
        stop.push_back(p);
    }
    
    sort(stop.begin(),stop.end(), cmp);

    
    point pivot;
    pivot.start = MAX;
    pivot.end = -1;
    
    for(int i=0; i<B; i++)
    {
        if(stop[i].end <= zeroEnd)
        {
            stop[i].removed = true;
            continue;
        }
        
        if(pivot.start <= stop[i].start && pivot.end >= stop[i].end)
        {
            stop[i].removed=true;
            
        }

        pivot.start = stop[i].start;
        pivot.end = stop[i].end;
        
    }
    
 for(int i=0; i<B; i++) if(!stop[i].removed) cout << stop[i].index + 1 << " ";

    return 0;
}
