//
//  main.cpp
//  17825
//
//  Created by sawon on 2021/04/17.
//

#include <iostream>
#include <vector>

using namespace std;

vector<int> map1 = {0, 2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40};
vector<int> map2 = {0, 13, 16, 19, 25, 30, 35, 40};
vector<int> map3 = {0, 22, 24, 25, 30, 35, 40};
vector<int> map4 = {0, 28, 27, 26, 25, 30, 35, 40};

int dices[10];

struct horse{
    vector<int> *map = &map1;
    int index;
    int nowBoard = 0;
    bool start = false;
    bool arrive = false;
};

horse h[4];

void copy (horse *original, horse *tmp)
{
    tmp -> map = original->map;
    tmp -> index = original->index;
    tmp -> start = original -> start;
    tmp -> arrive = original -> arrive;
    tmp -> nowBoard = original->nowBoard;
    
}

int canGo(int dice, horse *a)
{
    horse tmp;
    
    copy(a, &tmp);
    
    tmp.index = tmp.index + dice;
    
    if(tmp.map->size()<=tmp.index)
    {
        a->arrive = true;
        return 0;
    }
    
    int score = tmp.map->at(tmp.index);
    
    if(tmp.map==&map1 && score == 10) {
        tmp.map = &map2;
        tmp.index = 0;
    }
    
    if(tmp.map==&map1 && score == 20) {
        tmp.map = &map3;
        tmp.index = 0;
    }
    
    if(tmp.map==&map1 && score == 30) {
        tmp.map = &map4;
        tmp.index = 0;
    }
    
    tmp.nowBoard = score;
    
    for(int i=0; i<4; i++)
    {
        if(&h[i] == a) continue;
        if(h[i].arrive) continue;
        if(!h[i].start) continue;
        if(h[i].map==tmp.map && h[i].index == tmp.index) return -1;
        if(h[i].nowBoard == tmp.nowBoard)
            if( h[i].map->size()-h[i].index == tmp.map->size()-tmp.index) return -1;

    }
    
    copy(&tmp, a);
    if(!a->start) a->start = true;
    
    return score;
    
}

int ans = -1;

void dfs(int now, int result)
{
   // cout << result << endl;
    
    if(now == 10)
    {
        ans = (ans<result) ? result : ans;
        return;
        
    }
    
    int dice = dices[now];
    bool startHorseGo = false;
    int score;
    horse tmp;
    
    for(int i=0; i<4; i++)
    {
        if(!h[i].start && startHorseGo) continue;
        if(!h[i].start) startHorseGo = true;
        if(h[i].arrive) continue;
        copy(&h[i], &tmp);
        score = canGo(dice, &h[i]);
        if(score == -1) continue;
        dfs(now+1, result+score);
        copy(&tmp, &h[i]);
    }
    
}

int main(int argc, const char * argv[]) {

    for(int i=0; i<10; i++) cin >> dices[i];
    
    dfs(0,0);
    
    cout << ans;
    return 0;
}
