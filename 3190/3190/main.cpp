//
//  main.cpp
//  3190
//
//  Created by sawon on 2021/04/14.
//

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct info{
    int x, y;
};

int n;
int k;

vector<info> snake;
int map[100][100];

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

struct direction{
    int t;
    int d;
};

queue<direction> q;

int run()
{
    info head;
    info tmp;
    int d = 0;
    int t = 0;
    int xx;
    int yy;
    
    while(true)
    {

        head = snake.front();
        xx = head.x + dx[d];
        yy = head.y + dy[d];
        
        t++;
        if(xx < 0 || xx >= n || yy < 0 || yy >= n) break;  //벽
        if(map[yy][xx] == 1) break;
        
        snake.insert(snake.begin(), {xx, yy});
        
        // 사과 아니면
        if(map[yy][xx] != 2)
        {
            tmp = snake.back();
            map[tmp.y][tmp.x] = 0;
            snake.pop_back();
        }
        
        map[yy][xx] = 1;
        
        if(!q.empty())
            if(t == q.front().t)
            {
                d = (4 + d + q.front().d)%4;
                q.pop();
            }
            
    }
    
    return t;
    
}

int main(int argc, const char * argv[]) {
    
    snake.push_back({0,0});
    map[0][0] = 1;
    
    cin >> n >> k;
    
    int x, y;
    
    for(int i=0; i<k; i++)
    {
        cin >> y >> x;
        y--;
        x--;
        map[y][x] = 2;
    }
    
    int L, X;
    char C;
    
    cin >> L;
    for(int i=0; i<L; i++)
    {
        cin >> X >> C;
        
        if(C == 'D')
            q.push({X, 1});
        else
            q.push({X, -1});
        
    }
    
    cout << run();

    return 0;
}
