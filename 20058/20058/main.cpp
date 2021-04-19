//
//  main.cpp
//  20058
//
//  Created by sawon on 2021/04/20.
//

#include <iostream>
#include <queue>
#include <math.h>
using namespace std;

struct info{
    int x, y;
};

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int n;
int q;

void print(int map[][64])
{
    cout << endl;
    
    for(int i=0; i<n; i++)
    {
        for(int j=0; j<n; j++) cout << map[i][j] << " ";
        
        cout << endl;
    }
}

void rotate(int x, int y, int n, int map[][64], int tmp[][64])
{

    int d = 0;
    for(int j= x; j<x+n; j++)
    for(int i =y+n-1; i>=y; i--)
    {
        tmp[y + d/n][x + d%n] = map[i][j];
        d++;
        
    }
    
}

void setMap(int map[][64], int tmp[][64], int l)
{
    l = (int)pow(2, l);
    int loop = n/l;
    int block = n/loop;
    
    for(int i=0; i<loop; i++) for(int j=0; j<loop; j++)
    {
        rotate(block*j, block*i, block, map,tmp);
    }
}

void ice(int map[][64])
{
    int tmp[64][64];
    int xx, yy;
    
    for(int i=0; i<n; i++) for(int j=0; j<n; j++) tmp[i][j] = 0;
    
    
    for(int i=0; i<n; i++)
    for(int j=0; j<n; j++)
    {
        if(map[i][j] == 0) continue;
        
        int cnt = 0;
        for(int d=0; d<4; d++)
        {
            xx = j + dx[d];
            yy = i + dy[d];
            
            if(xx<0 || xx>=n || yy<0 || yy>=n) continue;
            if(map[yy][xx] > 0) cnt++;
        }
        
        if(cnt < 3) tmp[i][j]++;
    }
    
    for(int i=0; i<n; i++)
    for(int j=0; j<n; j++)
    {
        map[i][j] -= tmp[i][j];
        if(map[i][j] < 0) map[i][j] = 0;
    }
    
}

int check(int map[][64])
{
    queue<info> q;
    
    bool visited[64][64];
    int cnt = 0;
    info now;
    int xx, yy;
    int max = 0;
    
    for(int i=0; i<n; i++) for(int j=0; j<n; j++) visited[i][j] = false;
    
    for(int i=0; i<n; i++)
    for(int j=0; j<n; j++)
    {
        if(map[i][j] == 0) continue;
        if(visited[i][j]) continue;
        
        q.push(info{j, i});
        visited[i][j] = true;
        cnt = 1;
        
        while(!q.empty())
        {
            now = q.front();
            q.pop();
            
            for(int d=0; d<4; d++)
            {
                xx = now.x + dx[d]; yy = now.y + dy[d];
                
                if(xx<0 || xx>=n || yy<0 || yy>=n) continue;
                if(visited[yy][xx]) continue;
                if(map[yy][xx]  == 0 )continue;
                
                cnt++;
                
                visited[yy][xx] = true;
                q.push({xx, yy});
            }
            
        }
        
        if(max < cnt) max = cnt;
    }
    
    return max;
}

void oneTime(int l, int map[][64])
{
    int tmp[64][64];
    setMap(map, tmp, l);
    ice(tmp);
    
    for(int i=0; i<n; i++) for(int j=0; j<n; j++) map[i][j] = tmp[i][j];
}

int solution(int map[][64])
{
    int l;
    for(int i=0; i<q; i++)
    {
        cin >> l;
        oneTime(l, map);
    }
    
    int sum =0 ;
    
    for(int i=0; i<n; i++) for(int j=0; j<n; j++) sum += map[i][j];
    
    cout << sum << endl;
    
    return check(map);
    
}

int main(int argc, const char * argv[]) {

    cin >> n >> q;
    
    n = pow(2, n);
    
    int map[64][64];
    
    for(int i=0; i<n; i++) for(int j=0; j<n; j++) cin >> map[i][j];
    
    cout << solution(map);
    
    return 0;
}
