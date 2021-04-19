//
//  main.cpp
//  20056
//
//  Created by sawon on 2021/04/19.
//

#include <iostream>
#include <vector>

using namespace std;

struct info{
    int x, y, m, d, s;
    bool isMoved = false;
};

int dx[8] = {0, 1, 1, 1, 0, -1, -1, -1};
int dy[8] = {-1, -1, 0, 1, 1, 1, 0, -1};

vector<info> map[50][50];

int n, m, k;  //맵 개수 몇 번

void moveFireball(info *fire) // 파이어볼
{
    int x = fire->x, y=fire->y, d=fire->d, s=fire->s%n;
    int xx = x ; int yy = y;
    
    for(int i=0; i<s; i++)
    {
        xx += dx[d]; yy += dy[d];
        if(xx<0) xx = n-1;
        if(yy<0) yy = n-1;
        if(xx>=n) xx = 0;
        if(yy>=n) yy = 0;
        
    }
    
    fire->x = xx; fire->y = yy;
    fire -> isMoved = true;
    
}

void move()
{
    info* now;
    info newNode;
    
    for(int i=0; i<n; i++)
    for(int j=0; j<n; j++)
    {
        if(map[i][j].size() == 0) continue;
        
        for(int f=0; f<map[i][j].size(); f++)
        {
            now = &map[i][j].at(f);
            
            if(now->isMoved) continue;
            
            moveFireball(now);
            
            newNode = map[i][j].at(f);
            
            map[now->y][now->x].push_back(newNode);
            
            if((newNode.y < i) || (newNode.y ==i && newNode.x < j) ) newNode.isMoved = false;
            
            map[i][j].erase(map[i][j].begin() + f);
            
            f--;
        }
    }
}

void samePlace()
{
    int m, s, cnt;
    info *now;
    
    bool isOdd = false, isEven = false;
    
    for(int i=0; i<n; i++)
    for(int j=0; j<n; j++)
    {
        if(map[i][j].size() == 0) continue;
        
        if(map[i][j].size() == 1)
        {
            map[i][j].at(0).isMoved = false;
            continue;
        }

        
        if( map[i][j].at(0).d % 2 == 0) isEven = true;
        else isOdd = true;
        m = 0; s = 0; cnt = 0;
        
        for(int f=0; f<map[i][j].size(); f++)
        {
           now = &map[i][j].at(f);
            
            m += now->m; s += now->s;
            
            if(map[i][j].at(f).d%2 == 1 && isEven) isEven = false;
            else if(map[i][j].at(f).d%2 == 0 && isOdd) isOdd = false;
            
            map[i][j].erase(map[i][j].begin() + f);
            f--;
            
            cnt++;
        }
        
        int d;
        if(isEven || isOdd) d = -2;
        else d = -1;
        
        if(m/5 <= 0) continue;
        
        for(int f=0;f <4; f++)
        {
            info newNode;
            newNode.x = j; newNode.y=i;
            newNode.m = m/5;
            d += 2;
            newNode.d = d;
            newNode.s = s/cnt;
            map[i][j].push_back(newNode);
        }
        
    }
}

int solution()
{
    for(int i=0; i<k; i++)
    {
        move();
        samePlace();
    }
    
    int ans = 0;
    
    for(int i=0; i<n; i++)
    for(int j=0; j<n; j++)
    {
        for(int f=0;f<map[i][j].size(); f++)
        {
            ans +=map[i][j].at(f).m;
        }
    }
    
    return ans;
}

int main(int argc, const char * argv[]) {
    cin >> n >> m >> k;
    
    // ri, ci, mi, si, di

    for(int i=0; i<m; i++)
    {
        info newNode;
        cin >> newNode.y >> newNode.x >> newNode.m >> newNode.s >> newNode.d;
        newNode.y--; newNode.x--;
        map[newNode.y][newNode.x].push_back(newNode);
    }
    
    cout <<solution();
    
    return 0;
}
