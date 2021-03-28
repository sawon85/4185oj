//
//  main.cpp
//  14890
//
//  Created by sawon on 2021/03/15.
//

#include <iostream>
using namespace std;

int N,L;
int map1[100][100];
int map2[100][100];
int map3[100][100];
int map4[100][100];

bool canGo(int n[10])
{
    int tmp = n[0];
    int cnt = 1;
    
    for(int i=1; i<N; i++)
    {
        if(tmp!=n[i])
        {
            if(tmp-1 == n[i])
            {
                i++;
                for(;i<=i+L-1;i++) if(tmp-1 != n[i]) return false;
                i = i + L-1;
                tmp = n[L-1];
            }
            
            else if(tmp+1 == n[i])
            {
                if(cnt < L) return false;
            }
            
            
            
        }
        
        cnt++;
        
    }
    
    cout <<endl;
    for(int i=0; i<N; i++)
    cout <<n[i] << " ";
    
    return true;
}

int run()
{
    int result = 0;
    for(int i=0; i<N; i++)
    {
        if(canGo(map1[i])) result++;
        else if(canGo(map3[i])) result++;
        if(canGo(map2[i])) result++;
        else if(canGo(map4[i])) result++;
    }
    
    return result;
}


int main(int argc, const char * argv[]) {
    
    cin >> N >> L;
    
    for(int i=0; i<N; i++)
    for(int j=0; j<N; j++)
    {
        cin  >> map1[i][j];
        map2[j][i] = map1[i][j];
        map3[i][N-1-j] = map1[i][j];
        map4[j][N-1-i] = map2[j][i];
    }
    
    cout << run();
    
    
    return 0;
}
