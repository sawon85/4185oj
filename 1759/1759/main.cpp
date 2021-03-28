//
//  main.cpp
//  1759
//
//  Created by sawon on 2021/01/13.
//

#include <iostream>
#include <algorithm>
using namespace std;

int L,C;
char arr[15];

bool vowels[15];
int visited[15];

bool compare(char a, char b)
{
    return a<b;
}

void dfs(int st, int cnt, int conCnt)
{
    if(cnt==L)
    {
        if(conCnt >= 2)
        {
            for(int i =0;i<C;i++)
                if(visited[i] == 1)
                    printf("%c",arr[i]);
            printf("\n");
        }
        
        return;
    }
    
    
    int newConCnt;
    if(st>=C) return;
    if(C-st<L-cnt) return;
    if(visited[st]>0)
    {
        dfs(st+1,cnt,conCnt);
        return;
    }
        
    visited[st] = 1;
    newConCnt = (vowels[st]) ? conCnt : conCnt + 1;
    dfs(st+1,cnt+1,newConCnt);
    visited[st] = 0;
    dfs(st+1,cnt,conCnt);

        
    
}

bool isVowels(char c)
{
    if(c == 'a') return true;
    if(c == 'e') return true;
    if(c == 'i') return true;
    if(c == 'o') return true;
    if(c == 'u') return true;
    return false;
}

int main(int argc, const char * argv[]) {

    cin >> L >> C;
    
    for(int i=0; i<C; i++)
    {
        scanf(" %c",&arr[i]);
    }
    
    sort(arr,arr+C,compare);
    
    for(int i=0; i<C; i++)
    {
        if(!isVowels(arr[i])) continue;
        vowels[i] = true;
    }
    
    for(int i=0; i<C; i++)
    {
        if(vowels[i])
        {
            visited[i] = 1;
            dfs(0,1,0);
            visited[i] = 2;
        }
    }
    
    return 0;
}
