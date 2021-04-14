//
//  main.cpp
//  15685
//
//  Created by sawon on 2021/04/15.
//

#include <iostream>
#include <vector>

using namespace std;

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, -1, 0, 1};

struct info{
    int x, y, d;
};
bool visited[101][101] = {false,};
vector<info> v[21];
int ge[21];
int n;

void oneG(vector<info> &d)
{
    int size = (int)d.size() - 1;
    info now;
    int dd;
    
    for(int i = size-1; i>=0; i--) // 0
    {
        now = d.back();
        
        info point;
        dd = d.at(i).d;
        if(dd == 0) d.back().d = 1;
        else if (dd ==1) d.back().d = 2;
        else if (dd == 2) d.back().d = 3;
        else if (dd == 3) d.back().d = 0;
        
        point.x = now.x + dx[d.back().d];
        point.y = now.y + dy[d.back().d];
        
        visited[point.y][point.x] = true;
        
        d.push_back(point);
        
    }
    
}

void run()
{
    info last;
    int dd;
    
    for(int i=0; i<n; i++)
    {
        for(int j=0; j<ge[i]; j++) oneG(v[i]);
        
    }
    
}


int main(int argc, const char * argv[]) {

    cin  >> n;
    
    int x, y, d, g;
    for(int i=0; i<n; i++)
    {
        cin >> x >> y >> d >> g;
        v[i].push_back({x , y, d});
        v[i].push_back({x + dx[d], y+dy[d], d});
        visited[y+dy[d]][x+dx[d]] = true;
        visited[y][x] = true;
        ge[i] = g;
    }
    
    run();
    int cnt = 0;
    
    for(int i=0; i<100; i++)
    for(int j=0; j<100; j++)
    {
        if(visited[i][j] && visited[i][j+1] && visited[i+1][j] && visited[i+1][j+1]) cnt++;
        
    }
    
    cout << cnt;
    
    return 0;
}
