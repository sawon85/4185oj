//
//  main.cpp
//  1931
//
//  Created by sawon on 2021/05/01.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct info{
    int st, ed;
};

vector<info> v;

bool cmp(info a, info b)
{
    if(a.ed==b.ed) return a.st < b.st;
    return a.ed<b.ed;
}


int main(int argc, const char * argv[]) {

    int n;
    cin >> n;
    
    for(int i=0; i<n; i++)
    {
        info meeting;
        cin >> meeting.st >> meeting.ed;
        v.push_back(meeting);
    }
    
    sort(v.begin(), v.end(), cmp);
    
    int cnt = 0;
    int ed = -1;
    
    for(int i=0; i<n; i++)
    {
        if(v.at(i).st < ed) continue;
        ed = v.at(i).ed;
        cnt++;
    }
    
    cout << cnt;
    
    return 0;
}
