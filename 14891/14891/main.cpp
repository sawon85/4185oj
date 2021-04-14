//
//  main.cpp
//  14891
//
//  Created by sawon on 2021/04/14.
//

#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector<int> wheel[5];

struct ro{
    int num;
    int d;
};

queue<ro> q;
bool visited[5];

void time(vector<int> &w)
{
    int tmp = w.back();
    w.pop_back();
    w.insert(w.begin(), tmp);
}

void reverseTime(vector<int> &w)
{
    int tmp = w.front();
    w.erase(w.begin());
    w.push_back(tmp);

}

void rotateWheel(int num, int d)
{
    visited[num] = true;
    
    if(num - 1 >= 1)
        if(!visited[num-1])
            if(wheel[num].at(6) != wheel[num-1].at(2))
                rotateWheel(num-1, -1*d);
    
    if(num + 1 <= 4)
        if(!visited[num+1])
            if(wheel[num].at(2) != wheel[num+1].at(6))
                rotateWheel(num+1, -1*d);
    if(d == 1)
        time(wheel[num]);
    else
        reverseTime(wheel[num]);
    
}

void run()
{
    while(!q.empty())
    {
        ro now = q.front();
        q.pop();
        for(int i=1; i<5; i++) visited[i] =false;
        rotateWheel(now.num, now.d);
    }
}

int main(int argc, const char * argv[]) {
 
    int n;
    for(int i =1; i<5; i++)
    for(int j =0; j<8; j++)
    {
        scanf("%1d", &n);
        wheel[i].push_back(n);
    }
    
    int k, num, d;
    cin >> k;
    for(int i=0; i<k; i++)
    {
        cin >> num >> d;
        q.push({num, d});
    }
    
    run();
    
    cout << wheel[1].at(0) + wheel[2].at(0) *2 +  wheel[3].at(0) *4 +  wheel[4].at(0) * 8;
    
    return 0;
}
