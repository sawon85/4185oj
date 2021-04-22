//
//  main.cpp
//  1806
//
//  Created by sawon on 2021/04/21.
//

#include <iostream>
#include <vector>

using namespace std;

int main(int argc, const char * argv[]) {
    int n, s ;
    vector<int> v;
    
    cin >> n >> s;
    
    int num;
    
    for(int i=0; i<n; i++)
    {
        cin >> num;
        v.push_back(num);
    }
    
    v.push_back(0);
    int low = 0;
    int high = 0;
    int sum = v.at(0);
    int length = 100001;
    
    while(low<=high && high<n){
        if(sum < s)
        {
            sum += v.at(++high);
        }
        
        else if( sum == s)
        {
            length = min(length, high - low + 1);
            sum += v.at(++high);
        }
        
        else if( s < sum)
        {
            length = min(length, high-low+1);
            sum -= v.at(low++);
        }
        
    }
    
    if(length == 100001) cout << "0";
    else cout << length;
    
    
    
    
    return 0;
}
