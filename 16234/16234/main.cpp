//
//  main.cpp
//  16234
//
//  Created by sawon on 2021/01/14.
//

#include <iostream>
using namespace std;

int N,L,R;
int cnt[1251][3];
//0 그룹
//1 인원
//2 그룹개수
int A[50][50];
int visited[50][50];
int num;

void check(int x1, int y1, int x2, int y2)
{
    int diff = A[y1][x1] - A[y2][x2];
    
    if(diff<L || diff >R) return;

    if(visited[y1][x1] == 0 && visited[y2][x2] == 0)
    {
        visited[y1][x1] = ++num;
        visited[y2][x2] = num;
        cnt[num][0] = num;
        cnt[num][1] = A[y1][x1] + A[y2][x2];
        cnt[num][2] += 2;
        return;
    }
    
    int group1 = cnt[visited[y1][x1]][0];
    int group2 = cnt[visited[y2][x2]][0];
    
    if(cnt[group1][0] == cnt[group2][0]) return ;
    
    if(visited[y1][x1] == 0)
    {
        visited[y1][x1] = group2;
        cnt[group2][1] += A[y1][x1];
        cnt[group2][2]++;
        return;
    }
    
    if(visited[y2][x2] == 0)
    {
        visited[y2][x2] = group1;
        cnt[group1][1] += A[y2][x2];
        cnt[group1][2]++;
        return;
    }
    
    if(group2 < group1)
    {
        cnt[group1][0] = group2;
        cnt[group2][1] += cnt[group1][1];
        cnt[group2][2] += cnt[group1][2];
        return;
    }
        
    if(group2 > group1)
    {
        cnt[group2][0] = group1;
        cnt[group1][1] += cnt[group2][1];
        cnt[group1][2] += cnt[group2][2];
        return;
    }
}

void checkAll()
{
    num = 0;
    for(int j=0;j<N;j++)
        for(int i=0;i<N;i++)
        {
            if(i+1<N-1) check(i,j,i+1,j);
            if(j+1<N-1)check(i,j,i,j+1);
            
        }
    
    
    
    for(int j=0;j<N;j++)
        for(int i=0;i<N;i++)
        {
            
            
        }
    
}

int main(int argc, const char * argv[]) {

    cin >> N >> L >> R;
    
    for(int j=0;j<N;j++)
        for(int i=0;i<N;i++)
            cin >> A[j][i];
    
    
    
    return 0;
}
