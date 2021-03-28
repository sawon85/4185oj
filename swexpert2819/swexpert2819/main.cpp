//
//  main.cpp
//  swexpert2819
//
//  Created by sawon on 2021/01/19.
//

#include <iostream>
#include<cstring>

using namespace std;

int map[4][4];

int xx[4] = {1 , -1, 0, 0};
int yy[4] = {0, 0, 1, -1};

bool visited[9999999];

int c  = 0;

bool isOut(int x, int y)
{
    if(x<0 || x>3 || y<0 || y>3) return true;
    
    return false;
}

void dfs(int x, int y, int cnt, int result)
{
    if(cnt == 7)
    {
        if(visited[result]) return;
        
        visited[result] = true;
        c++;
        return;
    }
    
    int newX;
    int newY;
    for(int i=0; i<4; i++)
    {
        newX = x + xx[i];
        newY = y + yy[i];
        if(isOut(newX, newY)) continue;
        dfs(newX, newY, cnt+1,result*10 + map[newY][newX]);
    }
    
}

int main(int argc, const char * argv[]) {
    
    int T;
    
    cin >> T;
    
    for(int t = 0; t<T; t++)
    {
    
        c = 0;
        memset(visited, false, sizeof(visited));
        
        for(int i=0 ; i<4; i++)
        for(int j=0; j<4; j++)
        {
            cin >> map[i][j];
        }
        
        for(int i=0 ; i<4; i++)
        for(int j=0; j<4; j++)
        {
            dfs(j, i, 1, map[i][j]);
        }
        
        cout << "#" << t+1 << " " << c << endl;
    }

    return 0;
}

