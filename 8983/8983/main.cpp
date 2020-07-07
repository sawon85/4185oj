//
//  main.cpp
//  8983
//
//  Created by sawon on 2020/07/06.
//  Copyright © 2020 sawon. All rights reserved.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int M,N;
int L;

vector<int> m;




int main(int argc, const char * argv[]) {

    cin >> M >> N>> L;
    
    int n;
    for(int i=1; i<=M; i++)
    {
        cin >> n;
        m.push_back(n);
    }
    sort(m.begin(), m.end());
    
    int x, y, dx, cnt = 0;
    
    for(int i=1; i<=N; i++)
    {
        cin >> x >> y;
        
        if(y > L) continue;
        
        
        int lower = x + y - L, higher = x - y + L, low = 0, high = M-1;
        int mid;
        while(low <= high)
        {
            mid = (low+high) / 2;
            
            if(lower <= m[mid] && m[mid] <= higher)
            {
                cnt++;
                break;
            }
            
            if(m[mid] > higher) high = mid-1;
            else low = mid+1;
            
        }
        
    }
    
    cout << cnt;
    
    return 0;
}
