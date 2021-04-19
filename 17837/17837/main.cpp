//
//  main.cpp
//  17837
//
//  Created by sawon on 2021/04/17.
//

#include <iostream>
#include <vector>
using namespace std;
struct horse{
    int x, y, d, num;  //num 0부터 시작
};

vector<horse*> v[12][12];
int map[12][12];

horse h[10]; //인덱스 0부터 시작

bool isFinished = false;

//1부터 순서대로 →, ←, ↑, ↓의 의미
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, -1, 1};

int n, k;

void blue(int index)
{
    int d = h[index].d;
    
    if(d==0) h[index].d = 1;
    else if(d==1) h[index].d = 0;
    else if(d==2) h[index].d = 3;
    else if(d==3) h[index].d = 2;
}


void red(int index, int x1, int y1, int x2, int y2)
{
    int i;
    for(i=0; i<v[y1][x1].size(); i++) if(v[y1][x1].at(i)->num == index) break;
    
    int size = (int)v[y1][x1].size() -1;
    
    for(int j=size; j>=i; j--)
    {
        v[y1][x1].at(j)->x = x2;
        v[y1][x1].at(j)->y = y2;
        v[y2][x2].push_back(v[y1][x1].at(j));
        v[y1][x1].erase(v[y1][x1].begin() + j);
    }
    
    if(v[y2][x2].size()>=4) isFinished = true;
}


void white(int index, int x1, int y1, int x2, int y2)
{
    bool flag = false;
    for(int i=0; i<v[y1][x1].size(); i++)
    {
        if(!flag && v[y1][x1].at(i)->num == index) flag = true;
        if(!flag) continue;
        
        v[y1][x1].at(i)->x = x2;
        v[y1][x1].at(i)->y = y2;
        v[y2][x2].push_back(v[y1][x1].at(i));
        v[y1][x1].erase(v[y1][x1].begin() + i);
        i--;
    }
    
    if(v[y2][x2].size()>=4) isFinished = true;
}


//0은 흰색, 1은 빨간색, 2는 파란색이다.
bool move(int index, bool flag)
{
    horse *now = &h[index];
    
    int x = now->x;
    int y = now->y;
    
    int xx = now->x + dx[now->d];
    int yy = now->y + dy[now->d];

    
    if(xx<0 || xx>=n || yy<0 || yy>=n)
    {
        if(flag) blue(index);
        return false;
    }
    
    if(map[yy][xx] == 0)
    {
        white(index, x, y, xx, yy);
        return true;
    }
    
    if(map[yy][xx] == 1)
    {
        red(index, x, y, xx, yy);
        return true;
    }
    
    if(map[yy][xx] == 2)
    {
        if(flag) blue(index);
        return false;
    }
    
    return true;
}

int solution()
{
    for(int t=1; t<=1000; t++)
    {
        for(int i=0 ;i<k; i++)
        {
            
            if(!move(i, true)) move(i, false);
            
            if(isFinished) return t;
        }
    }
    
    return -1;
}

int main(int argc, const char * argv[]) {

    cin  >> n >> k;
    
    for(int i=0; i<n; i++) for(int j=0; j<n; j++) cin >> map[i][j];
    
    
    int x, y, d;
    for(int i=0; i<k; i++)
    {
        cin >> y >> x >> d;
        h[i].x = x-1; h[i].y = y-1; h[i].d = d-1; h[i].num = i;
        v[y-1][x-1].push_back(&h[i]);
    }
    
    cout << solution();
    
    
    return 0;
}
