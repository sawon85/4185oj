//
//  main.cpp
//  14499
//
//  Created by sawon on 2021/04/20.
//

#include <iostream>

using namespace std;

int dice [7] = {0, 0, 0, 0, 0, 0, 0};
int map[20][20];
int n, m, k;
int x, y;
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, -1, 1};


void roll(int d)
{
    int tmp[7];
    for(int i=1; i<7; i++) tmp[i] = dice[i];
    
  //동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
    switch (d) {
            
        case 0:
            dice[1]=tmp[4];
            dice[2]=tmp[2];
            dice[3]=tmp[1];
            dice[4]=tmp[6];
            dice[5]=tmp[5];
            dice[6]=tmp[3];
            break;
            
        case 1:
            dice[1]=tmp[3];
            dice[2]=tmp[2];
            dice[3]=tmp[6];
            dice[4]=tmp[1];
            dice[5]=tmp[5];
            dice[6]=tmp[4];
            break;
            
        case 2:
            dice[1]=tmp[5];
            dice[2]=tmp[1];
            dice[3]=tmp[3];
            dice[4]=tmp[4];
            dice[5]=tmp[6];
            dice[6]=tmp[2];
            break;
            
        case 3:
            dice[1]=tmp[2];
            dice[2]=tmp[6];
            dice[3]=tmp[3];
            dice[4]=tmp[4];
            dice[5]=tmp[1];
            dice[6]=tmp[5];
            break;
            
    }
    
}

void solution()
{
    int d;
    int xx = x;
    int yy = y;
    
    for(int i=0; i<k; i++)
    {
        cin >> d;
        
        xx = x+dx[--d]; yy = y + dy[d];
        
        if(xx<0 || xx >=m || yy<0 || yy>=n) continue;
        
        x = xx; y= yy;
        
        roll(d);

        if(map[yy][xx] == 0) map[yy][xx] = dice[6];
        else
        {
            dice[6] = map[yy][xx];
            map[yy][xx] = 0;
        }
        
        cout << dice[1] << endl;
        
    }
    
}

int main(int argc, const char * argv[]) {
    
    cin >> n >> m >> y >> x >> k;
    
    for(int i=0;i<n;i++)
    for(int j=0;j<m;j++)
    cin >> map[i][j];
    
    solution();
    
    return 0;
}
