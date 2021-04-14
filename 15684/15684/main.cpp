//
//  main.cpp
//  15684
//
//  Created by sawon on 2021/04/15.
//

#include <iostream>

using namespace std;

int n, m, h;
bool map[31][11];

bool go()
{
    int now;
    int pre;
    for(int i=1; i<=n; i++)
    {
        now = i;
        
        for(int j=1; j<=h; j++)
        {
            pre = now - 1;
            
            if(pre > 0)
            {
                if(map[j][pre])
                {
                    now = pre;
                    continue;
                }
            }
            
            if(now < n)
            {
                if(map[j][now]) now = now + 1;
            }
        
        }
        
        if(now!=i) return false;
    }
    
    return true;
}

int minNum = 200;
void run()
{
    if(go())
    {
        minNum = 0;
        return;
    }
    
    
    for(int i = 0; i<=(n-1)*h; i++)
    {
        int x1 = i%(n-1) + 1;
        int y1 = i/(n-1) + 1;
        if(map[y1][x1]) continue;
        map[y1][x1] = true;

        if(go())
        {
            minNum = 1;
            return;
        }
        
        for(int j=i; j<=(n-1)*h; j++)
        {
            int x2 = j%(n-1) + 1;
            int y2 = j/(n-1) + 1;
            if(map[y2][x2]) continue;
            if(y1 == y2 && x2 == x1+1) continue;
            map[y2][x2] = true;
            
            if(go()) minNum = (minNum < 2) ? minNum : 2;
            
            for(int k=j; k<=(n-1)*h; k++)
            {
                int x3 = k%(n-1) + 1;
                int y3 = k/(n-1) + 1;
                if(map[y3][x3]) continue;
                if(y2==y3 && x3 == x2+1) continue;
                map[y3][x3] = true;
                
                if(go()) minNum = (minNum < 3) ? minNum : 3;
                
                map[y3][x3] = false;
            }
            
            map[y2][x2] = false;
        }
        
        map[y1][x1] = false;
    }
    
}

int main(int argc, const char * argv[]) {

    cin >> n >> m >> h;
    
    int a, b;
    
    for(int i=1; i<=h; i++)
    for(int j=1; j<=n; j++)
    {
        map[i][j] = false;
    }
    
    for(int i=0; i<m; i++)
    {
        cin >> a >> b;
        map[a][b] = true;
    }
    
    
    run();
    
    if(minNum == 200) minNum = -1;
    
    cout << minNum;
    
    return 0;
}
