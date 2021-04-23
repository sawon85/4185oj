//
//  main.cpp
//  1927
//
//  Created by sawon on 2021/04/23.
//

#include <iostream>
#include <queue>
using namespace std;

priority_queue<int, vector<int>, greater<int>> q;

int main(int argc, const char * argv[]) {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    int t;
    int x;
    
    cin >> t;
    
    for(int i=0; i<t; i++)
    {
        cin >> x;
        
        if(x > 0)
        {
            q.push(x);
        }
        
        else if(x==0)
        {
            if(q.empty()) cout << 0 << "\n";
            
            else {
                
                cout << q.top() << "\n";
                q.pop();
            }
        }
    }
    
    return 0;
}
