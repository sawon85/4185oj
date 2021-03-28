//
//  main.cpp
//  1525
//
//  Created by sawon on 2021/03/09.
//

#include <iostream>
#include <string>
#include <map>
#include <queue>
using namespace std;

int xx[4] = { 0,0,1,-1 };
int yy[4] = { 1,-1,0,0 };

map<int, int> h;
queue<int> q;

int bfs()
{
    
    while (!q.empty())
    {
        int nowNum = q.front();
        q.pop();
        
        
        string s = to_string(nowNum);

        int blank = s.find('9');
        int x = blank / 3;
        int y = blank % 3;

        for (int i = 0; i < 4; i++)
        {
            int newX = x + xx[i];
            int newY = y + yy[i];
            
            if (newX < 0 || newX > 2 || newY < 0 || newY > 2) continue;
            
            string next = s;
            
            swap(next[x * 3 + y], next[newX * 3 + newY]);
            
            int num = stoi(next);
            
            if(num == 123456789) return h[nowNum] + 1;
            
            if (h.count(num) == 0)
            {
                h[num] = h[nowNum] + 1;
                q.push(num);
            }
            
        }
    }
    
    return -1;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);

    int st = 0;
    
    int temp;
    for(int i=0; i<9; i++)
    {
        cin >> temp;
        if(temp == 0) temp = 9;
        st = st*10 + temp;
    }

    if(st == 123456789)
    {
        cout << 0;
        return 0;
    }
    
    q.push(st);
    h[st] = 0;

    cout << bfs();

    return 0;
}

