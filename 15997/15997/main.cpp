//
//  main.cpp
//  15997
//
//  Created by sawon on 2021/04/21.
//
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string.h>
using namespace std;
float game[6][5];
float init[4] = {1.0, 1.0, 1.0, 1.0};
float result[4] = {0.0, 0.0, 0.0, 0.0};

void copy(float original[4], float temp[4])
{
    for(int i=0; i<4; i++) temp[i] = original[i];
    
}

void dfs(int index, int score[4])
{
    if(index == 6)
    {
        int maxCnt = 0, max2Cnt = 0;
        float maxn = 0, max2n = 0;
        
        for(int i=0; i<4; i++)
        {
            if(maxn < score[i])
            {
                max2n = maxn;
                max2Cnt = maxCnt;
                maxn = score[i];
                maxCnt = 1;
            }
            
            else if(maxn == score[i])
            {
                maxCnt++;
            }
            
            else if(score[i] > max2n)
            {
                max2n = score[i];
                max2Cnt = 1;
            }
            
            else if(max2n == score[i])
            {
                max2Cnt++;
            }
        }
        
        
        if(maxCnt == 1)
        {
            for(int i=0; i<4; i++)
            {
                if(maxn == score[i]) result[i] = result[i] + init[i];
                if(max2n == score[i]) result[i] = result[i] + init[i]/max2Cnt;
            }
        }
        
        if(maxCnt > 1)
        {
            for(int i=0; i<4; i++)
            {
                if(maxn == score[i]) result[i] = result[i] + 2*init[i]/maxCnt;
            }
        }
        
        return;
    }

    int team1 = game[index][0];
    int team2 = game[index][1];
    
    float temp[4];
    
    //team1 win
    if(game[index][2] != 0)
    {
        copy(init, temp);
        score[team1] += 3;
        for(int i=0; i<4; i++) init[i] *= game[index][2];
        dfs(index+1, score);
        score[team1] -= 3;
        copy(temp, init);
    }

    //draw
    if(game[index][3] != 0)
    {
        score[team1] += 1;
        score[team2] += 1;
        copy(init, temp);
        for(int i=0; i<4; i++) init[i] *= game[index][3];
        dfs(index+1, score);
        score[team1] -= 1;
        score[team2] -= 1;
        copy(temp, init);
    }
    
    //team2 win
    if(game[index][4] != 0)
    {
        score[team2] += 3;
        copy(init, temp);
        for(int i=0; i<4; i++) init[i] *= game[index][4];
        dfs(index+1, score);
        score[team2] -= 3;
        copy(temp, init);
    }
    
}

int main(int argc, const char * argv[]) {
    
    char name[4][10];
    
    for(int i=0; i<4; i++) cin >> name[i];
    
    char c1[10], c2[10];
    for(int i=0; i<6; i++)
    {
        cin >> c1 >> c2;
        
        for(int j=0; j<4; j++)
        {
            if(strcmp(name[j], c1) == 0) game[i][0] = j;
            if(strcmp(name[j], c2) == 0) game[i][1] = j;
        }

        scanf("%f %f %f", &game[i][2], &game[i][3], &game[i][4]);
    }
    
    int score[4]  = {0,0,0,0};
    dfs(0, score);
    
    for(int i=0; i<4; i++) printf("%f\n", result[i]);
    
    return 0;
}
