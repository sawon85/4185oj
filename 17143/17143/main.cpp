//
//  main.cpp
//  17143
//
//  Created by sawon on 2021/04/16.
//

#include <iostream>
#include <vector>
using namespace std;

struct info{
    int x, y, s, d, z ; //속도 방향 사이즈
    bool catched = false;
};

vector<info> shark;

int r, c, m;
int map[100][100];

int dx[4] = {0, 0, 1, -1};
int dy[4] = {-1, 1, 0, 0};

int ans = 0;

void move()
{
    
    info* tmp;
    int xx;
    int yy;
    for(int i=0; i<m; i++) //상어마다
    {
        tmp = &shark.at(i);
        if(tmp->catched) continue;
        xx = tmp->x;
        yy = tmp->y;
        
        for(int t=0; t<tmp->s; t++) // 이동
        {
 
            if(tmp->d == 0 && yy==0) tmp->d = 1;
            else if(tmp->d == 1 && yy==r-1) tmp->d = 0;
            else if(tmp->d == 2 && xx==c-1) tmp->d = 3;
            else if(tmp->d == 3 && xx==0) tmp->d = 2;
                
            xx += dx[tmp->d];
            yy += dy[tmp->d];
            
        }
        
        tmp->x = xx;
        tmp->y = yy;
    
        
        if(map[tmp->y][tmp->x] > -1)
        {
            if(shark.at(map[yy][xx]).z > tmp->z)  // 원래 있던 상어 크기가 더 큰 경우
            {
                tmp->catched = true;
                continue;
            }
            
            shark.at(map[yy][xx]).catched = true;
        }
        
        map[yy][xx] = i;
    }
}


void solution()
{
    for(int i=0; i<c; i++) //x방향
    {
        for(int j=0; j<r; j++)
        {
            if(map[j][i] <= -1) continue;
            if(shark.at(map[j][i]).catched) continue;
                
            shark.at(map[j][i]).catched = true;
            ans += shark.at(map[j][i]).z ;
            break;
        }
        
        if(i==c-1) break;
        
        for(int a=0;a<r;a++) for(int b=0; b<c; b++) map[a][b] = -1;
        move();
    }
}

int main(int argc, const char * argv[]) {

    cin >> r >> c >> m;
    
    int x, y, s, d, z;
    
    for(int a=0;a<r;a++) for(int b=0; b<c; b++) map[a][b] = -1;
    
    int cnt = 0;
    for(int i=0; i<m; i++)
    {
        cin >> y >> x >> s >> d >> z;
        
        if(d>2) s = s%(2 +2*(c-2));   //x방향
        else s = s%(2 + 2*(r-2));
        
        shark.push_back(info{x-1,y-1,s,d-1,z,false});
        map[y-1][x-1] = cnt++;
        
    }
    
    solution();
    
    cout << ans;
    
    return 0;
}
