//
//  main.cpp
//  1655
//
//  Created by sawon on 2021/04/22.
//

#include <iostream>
#include <vector>
using namespace std;

int n;
vector<int> v;

int binary(int n)
{
    int l=0, r=(int)v.size()-1;
    
    if(v.size() == 0)
    {
        v.push_back(n);

        return n;
    }
    
    
    int mid;
    
    while(l<=r)
    {
        
        mid = (l+r)/2;
        
        if(v.at(mid) > n)
        {
            r = mid-1;
        }
        
        else
        {
            l = mid +1;
        }
    }
    
    if(r < l) v.insert(v.begin() +l, n);
    else v.insert(v.begin() +r, n);
    
    
    mid = (int) v.size()/2 ;
    if(v.size()%2 == 0) mid--;
    
    //cout << "<<" << mid << " >>";
    
    return v.at(mid);
}

int main(int argc, const char * argv[]) {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int n;
    
    scanf("%d", &n);
    
    int num;
    for(int i=0; i<n; i++)
    {
        cin >> num;
        cout << binary(num) <<"\n";
    }
    
    return 0;
}
