//
//  main.cpp
//  swexpert1767
//
//  Created by sawon on 2021/03/24.
//

#include <iostream>
#define go 2
#define reback 0

using namespace std;

int map[12][12];
int tmp[12][12];

int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};

typedef struct po{
    
    int x, y;
    
} po;

po mac[12];

int macCnt = 0;

int clost = 0;


int N;

bool canVisit(int x, int y, int ind)
{
    int xx = x;
    int yy = y;
    
    for(int i=0; i<N; i++)
    {
        xx += dx[ind];
        yy += dy[ind];
        
        if(xx>=N || yy>=N || xx<0 || yy<0) return true;
        if(tmp[yy][xx] > 0) return false;
        
    }
    
    return true;
}

int visit(int x, int y, int ind, int value)
{
    int xx = x;
    int yy = y;
    
    int cnt = 0;
    
    for(int i=0; i<N; i++)
    {
        xx += dx[ind];
        yy += dy[ind];
        
        if(xx>=N || yy>=N || xx<0 || yy<0) return cnt;
        
        tmp[yy][xx] = value;
        cnt++;
        
    }

    return cnt;
}

int maxMac = -1;
int minLine = 99999;


void dfs(int now, int line, int result)
{
    if(now == macCnt)
    {
        if(maxMac < result)
        {
            maxMac = result;
            minLine = line;
            return;
        }
        
        if(maxMac == result)
        {
            minLine = (minLine > line) ? line : minLine;
            return;
        }
        
        return;
    }
    
    po _now = mac[now];

    for(int i=0; i<4; i++)
    {
        if(!canVisit(_now.x, _now.y, i)) continue;
        dfs(now+1, line + visit(_now.x, _now.y, i, go), result+1);
        visit(_now.x, _now.y, i, reback);

    }
    
    dfs(now+1, line, result);
    
}


int main(int argc, const char * argv[]) {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int T;
    cin >> T;
    
    for(int t=0; t<T; t++)
    {
        maxMac = -1;
        minLine = 99999;
        macCnt = 0;
        
        cin >> N;
        
        for(int i=0; i<N; i++)
        for(int j=0; j<N; j++)
        {
            cin >> map[i][j];
            tmp[i][j] = map[i][j];
            
            if(map[i][j] > 0)
            {
                if(i==0 || i==N-1 || j==0 || j==N-1)
                {
                    clost++;
                    continue;
                }
                
                mac[macCnt].x = j;
                mac[macCnt++].y = i;
            }
        
        }
        
        dfs(0,0,0);
        
        cout << "#" << t+1<< " " << minLine << "\n";
    }
    
    return 0;
}
