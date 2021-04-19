//
//  main.cpp
//  19236
//
//  Created by sawon on 2021/04/18.
//

#include <iostream>
#include <vector>

using namespace std;

struct info{
    int x, y, d, num, isAlive = true;    //없는 상어 d = -1
};

vector<info> fishes;
int map[4][4];
info shark;

// 1부터 순서대로 ↑, ↖, ←, ↙, ↓, ↘, →, ↗ 를 의미
int dx[8] = {0, -1, -1, -1, 0, 1, 1, 1};
int dy[8] = {-1, -1, 0, 1, 1, 1, 0, -1};

int ans = -1;

void printD(int d)
{
    switch (d) {
        case 0:
            printf("↑");
            break;
        case 1:
            printf("↖");
            break;
        case 2:
            printf("←");
            break;
        case 3:
            printf("↙");
            break;
        case 4:
            printf("↓");
            break;
        case 5:
            printf("↘");
            break;
        case 6:
            printf("→");
            break;
        case 7:
            printf("↗");
            break;
            
    }
}

void print(int map [4][4], vector<info> &fishes)
{
    cout << endl;
    cout << shark.y << " " << shark.x << endl;
    for(int i=0; i<4; i++)
    {
        for(int j=0; j<4; j++)
        {
            if(i==shark.y && j==shark.x && map[i][j] == -1)
            {
                cout << " *  ";
                continue;
            }
            
            printf("%2d", map[i][j]);
            if(map[i][j]>=0) printD(fishes.at(map[i][j]).d);
            else cout << " ";
            cout << "  ";
            
        }
        cout << endl;
    }
}

bool canGo(int x, int y)
{
    if(x<0 || x>=4 || y<0 || y>=4) return  false;
    return true;
}

void swap(int x, int y, int x2, int y2, int map[4][4])
{
    int tmp = map[y][x];
    map[y][x] = map[y2][x2];
    map[y2][x2] = tmp;
    
}

void go(vector<info> &fishes, info* fish, int map[4][4])
{
    int d;
    int xx;
    int yy;
    
    for(int i=0; i<8; i++)
    {
        
        d = (fish->d + i) % 8;
        xx = fish -> x + dx[d];
        yy = fish -> y + dy[d];
        
        if(!canGo(xx, yy)) continue;
        
        if(xx==shark.x && yy==shark.y) continue;
        
        int tmpX, tmpY;
        
        tmpX = fish -> x;
        tmpY = fish -> y;
        
        fish -> x = xx;
        fish -> y = yy;
        
        if(map[yy][xx] >= 0)
        {
            fishes.at(map[yy][xx]).x = tmpX;
            fishes.at(map[yy][xx]).y = tmpY;
            
        }
        
        swap(fish->x, fish->y, tmpX, tmpY, map);
        
        fish -> d = d;
        break;
    }
}

void moveFish(vector<info> &fishes, int map[4][4])
{
    info* now;
    
    for(int i=0; i<16; i++)
    {
        if(!fishes.at(i).isAlive) continue;
        now = &fishes.at(i);
        go(fishes, now, map);
    }
}

int moveShark(vector<info> &fishes, int i, int map[4][4])  // 상어가 못 갈 경우 return -1. 1<=i<4
{
    int xx, yy;

    xx = shark.x + i*dx[shark.d];
    yy = shark.y + i*dy[shark.d];
    
    if(!canGo(xx, yy)) return -1;
    if(map[yy][xx] == -1) return -1;
    if(!fishes.at(map[yy][xx]).isAlive) return -1;
    
    shark.d = fishes.at(map[yy][xx]).d;
    int num = map[yy][xx] + 1;
    
    fishes.at(map[yy][xx]).isAlive = false;
    
    map[yy][xx] = -1;
    
    shark.x = xx;
    shark.y = yy;
 
    return num;
}

void copyF(vector<info> &original, vector<info> &copy)
{
    for(int i=0; i<original.size(); i++) copy.push_back(original.at(i));
}


void copyM( int map[4][4], int tmp[4][4] )
{
    for(int i=0; i<4; i++) for(int j=0; j<4; j++) tmp[i][j] = map[i][j];
}

void dfs(vector<info> &fishes, int map[4][4], int score)
{
    
    info save = shark;
    int result;
    vector<info> newFishes; int tmp[4][4];
    copyF(fishes, newFishes);
    copyM(map, tmp); //기존 맵에서 물고기 이동

    moveFish(newFishes, tmp);

    for(int i=1; i<4; i++)
    {
        int newTmp[4][4];
        vector<info> newnewFishes;  //물고기 이동 -> 상어에게 잡아먹힌 후
        copyF(newFishes, newnewFishes);
        copyM(tmp, newTmp);
        
        shark = save;
        result = moveShark(newnewFishes, i, newTmp);
        
        if(result == -1)
        {
            ans = (ans < score) ? score : ans;
            continue;
        }
        
        dfs(newnewFishes, newTmp, score + result);
        shark = save;
    }
    
}

void solution()
{
    int st = map[0][0] + 1;
    shark.d = fishes.at(map[0][0]).d;
    shark.y = 0;
    shark.x = 0;
    fishes.at(map[0][0]).isAlive = false;
    map[0][0] = -1;
    dfs(fishes, map, st);
    
}

int main(int argc, const char * argv[]) {
    
    int num, d;
    
    for(int i=0; i<16; i++) fishes.push_back(info{0, 0, 0});
    
    for(int i=0; i<4; i++)
    for(int j=0; j<4; j++)
    {
        cin >> num >> d;
        map[i][j] = num-1;
        fishes.at(num-1).d = d-1; fishes.at(num-1).x = j;
        fishes.at(num-1).y = i;
    }
    
    solution();
    
    cout << ans;
    
    return 0;
}
