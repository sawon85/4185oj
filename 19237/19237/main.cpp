//
//  main.cpp
//  19237
//
//  Created by sawon on 2021/03/25.
//

#include <iostream>

using namespace std;

typedef struct shark{
    int power;
    int direction;
    int x;
    int y;
    bool isLive = true;
    
}shark;

shark sharks[400];

typedef struct point{
    int time;
    int power;
    
}point;

point map[20][20];

int dx[4] = {0, 0, -1, 1};
int dy[4] = {-1, 1, 0, 0};

int direction[400][4][4];

int k;
int N, m;

int sharckCnt;

void moveShark() // 상어 이동
{
    shark now;
    int xx;
    int yy;
    int power;
    int di;
    
    int d;
    
    point next;
    
    int myPoint;
    
    for(int i=0; i<m; i++)     // 상어마다
    {
        now = sharks[i];
        if(!now.isLive) continue;
        xx = now.x;
        yy = now.y;
        power = now.power;
        di = now.direction;
        myPoint = -1;
        
        for(int j=0; j<4; j++)  //방향
        {
            d = direction[power-1][di][j];
            xx = now.x + dx[d];
            yy = now.y + dy[d];
            
            if(xx< 0 || yy < 0 || xx >=N || yy>=N) continue;
            
            next = map[yy][xx];
            if(next.power == now.power && myPoint == -1)
            {
                myPoint = d;
                continue;
                
            }
            
            if(next.power > 0) continue;
            
            // 상어 이동
            
            sharks[i].direction = d;
            sharks[i].x = xx;
            sharks[i].y = yy;
            myPoint = -1;
            
            break;
        }
        
        if(myPoint >= 0)
        {
 
            xx = now.x + dx[myPoint];
            yy = now.y + dy[myPoint];
            
            sharks[i].direction = myPoint;
            sharks[i].x = xx;
            sharks[i].y = yy;
            
            
        }
        
    }
    
}


void eatShark()
{
    for(int i=0; i<m; i++)
    {
        if(!sharks[i].isLive) continue;
        
        for(int j = i+1; j < m; j++)
        {
            if(!sharks[j].isLive) continue;
            
            if(sharks[i].x == sharks[j].x && sharks[i].y == sharks[j].y)
            {
                sharks[j].isLive = false;
                --sharckCnt;
            }
        
        }
        
    }
    
}

void resetMap()
{
    for(int i=0; i<m ;i++)
    {
        if(!sharks[i].isLive) continue;
        
        map[sharks[i].y][sharks[i].x].power = sharks[i].power;
        map[sharks[i].y][sharks[i].x].time = k + 1;
        
    }
    
    for(int i=0; i<N; i++)
    for(int j=0; j<N; j++)
    {
        if(map[i][j].power > 0)
        {
            --map[i][j].time;
            
            if(map[i][j].time == 0) map[i][j].power = 0;
            
        }
        
    }
}

int run()
{
    for(int time = 0; time <1000; time++)
    {
        moveShark();
        eatShark();
        resetMap();
        if(sharckCnt == 1) return time+1;
    }
    
    return -1;
}


int main(int argc, const char * argv[]) {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    cin >> N >> m >> k;
    
    sharckCnt = m;
    
    int number;
    for(int i=0 ; i<N; i++)
    for(int j=0; j<N; j++)
    {
        cin >> number;
        
        if(number > 0)
        {
            map[i][j].power = number;
            map[i][j].time = k;
            
            sharks[number-1].power = number;
            sharks[number-1].x = j;
            sharks[number-1].y = i;
            sharks[number-1].isLive = true;
            
        }
        
    }
    
    int dire;
    for(int i=0; i<m; i++)
    {
        cin >> dire;
        sharks[i].direction = dire-1;
    }
    
    
    for(int i = 0; i < m; i++) //상어마다
    for(int j = 0; j < 4; j++) //방향마다
    for(int d = 0; d < 4; d++) //우선순위
    {
        cin >> dire;
        direction[i][j][d] = dire-1;
        
    }
    
    cout << run();
    
    
    return 0;
}
