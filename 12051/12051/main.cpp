//
//  main.cpp
//  12051
//
//  Created by sawon on 2021/04/23.
//

#include <iostream>
#include <vector>
using namespace std;

vector<int> v;

void binary(int n)
{
    
    int l = 0, r = (int) v.size()-1;
    
    if( r==-1)
    {
        v.push_back(n);
        return;
    }
    
    int mid;
    
    while(l<=r)
    {
        mid = (l+r)/2;
        
        if(v.at(mid) == n) return;
        
        if(v.at(mid) > n)
        {
            r = mid -1;
        }
        
        else
        {
            l = mid + 1;
        }
        
    }

    
    if(l>=v.size()) v.push_back(n);
    else v.insert(v.begin()+l, n);
}

int main(int argc, const char * argv[]) {
    
    int n;
    int num;
    scanf("%d", &n);
    for(int i=0; i<n; i++)
    {
        scanf("%d", &num);
        binary(num);
    }

    printf("%d",(int)v.size());
    
    return 0;
}
