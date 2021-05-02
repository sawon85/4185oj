//
//  main.cpp
//  2493
//
//  Created by sawon on 2021/05/01.
//

#include <iostream>
#include <stack>
using namespace std;
int n;

struct info{
    int in,va;
};

int top[500001];
int ans[500001];


int main(int argc, const char * argv[]) {
    
    cin >> n;
    
    for(int i=1; i<=n; i++) cin >> top[i];
    
    stack<info> s;
    info tmp;
    for(int i=n; i>0; i--)
    {
        
        while(!s.empty())
        {
            tmp = s.top();
            if(top[i] < tmp.va) break;
            ans[tmp.in] = i;
            s.pop();
        }
        
        info newinfo;
        newinfo.in = i;
        newinfo.va = top[i];
        s.push(newinfo);
        
    }
    
    for(int i=1; i<=n; i++) cout << ans[i] << " ";
    
    return 0;
}
