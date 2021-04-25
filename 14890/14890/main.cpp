//
//  main.cpp
//  14890
//
//  Created by sawon on 2021/04/25.
//

#include <iostream>
using namespace std;

int map[100][100];
int n, l;

void init()
{
    for(int i=0; i<n; i++)
    for(int j=0; j<n; j++)
    cin >> map[i][j];
}

bool sero(int col)
{
    int cnt = 1;
    int pre = map[0][col];
    for(int i=1; i<n; i++)
    {
        if(pre==map[i][col])
        {
            cnt++;
            continue;
        }
        
        if(pre + 1 < map[i][col]|| pre -1  > map[i][col])
        {
            return false;
        }
        
        if(pre + 1 == map[i][col])
        {
            if(cnt < l) return false;
            
            cnt = 1;
            pre = map[i][col];
            
            continue;
        }
        
        if(pre - 1 == map[i][col])
        {
            for(int j=0; j<l; j++)
            {
                if(i+j >= n) return false;
                if(map[i+j][col]!= pre-1) return false;
            }
            
            i += l-1;
            pre = map[i][col];
            cnt = 0;
        }
        
    }
    
    return true;
}

bool garo(int row)
{
    int cnt = 1;
    int pre = map[row][0];
    for(int i=1; i<n; i++)
    {
        if(pre==map[row][i])
        {
            cnt++;
            continue;
        }
        
        if(pre + 1 < map[row][i]|| pre -1  > map[row][i])
        {
            return false;
        }
        
        if(pre + 1 == map[row][i])
        {
            if(cnt < l) return false;
            
            cnt = 1;
            pre = map[row][i];
            
            continue;
        }
        
        if(pre - 1 == map[row][i])
        {
            for(int j=0; j<l; j++)
            {
                if(i+j >= n) return false;
                if(map[row][i+j]!= pre-1) return false;
            }
            
            i += l-1;
            cnt = 0;
            pre = map[row][i];
        }
        
    }
    
    return true;
}

int solution()
{
    int ans = 0;
    for(int i=0; i<n; i++)
    {
        if(garo(i)) ans++;
        if(sero(i)) ans++;
    }
    
    return ans;
    
}


int main(int argc, const char * argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    cin >> n >> l;
    init();
    
    cout << solution();
    
    
    
    return 0;
}
