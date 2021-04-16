//
//  main.cpp
//  17140
//
//  Created by sawon on 2021/04/16.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct info{
    int num, cnt;
};

int r = 3;
int c = 3;

int a, b, k;

bool compare(info &x1, info &x2)
{
    if(x1.cnt<x2.cnt) return true;
    if(x1.cnt>x2.cnt) return false;
    
    return x1.num<x2.num;
}

int map[100][100];

vector<info> v;

int tmp[101];

void reset()
{
    v.clear();
    for(int i=0; i<101; i++) tmp[i] = 0;
}

void toV()
{
    for(int i=1; i<101; i++)
    {
        if(tmp[i] > 0) v.push_back(info{i, tmp[i]});
    }
    sort(v.begin(), v.end(), compare);
}

void print()
{
    cout <<endl;
    for(int i=0; i<r; i++)
    {
        for(int j=0; j<c; j++)
        cout << map[i][j] << " ";
        cout <<endl;
    }
}

void solution()
{
    if(r>=c)
    {
        int max = 0;
        
        for(int i=0;i<r;i++)
        {
            reset();
            
            for(int j=0; j<c; j++) tmp[map[i][j]]++;
            
            toV();
            
            int index = 0;
            
            for(int k = 0; k<v.size(); k++)
            {
                map[i][index++] = v.at(k).num;
                map[i][index++] = v.at(k).cnt;
                
                if(index >= 100) break;
            }
            
            for(int k = index; k<100; k++) map[i][k] = 0;
            
            max = (max < index) ? index : max;
        }
        
        c = max;
        
        return;
    }
    

        int max = 0;
        
        for(int i=0;i<c;i++)
        {
            reset();
            
            for(int j=0; j<r; j++) tmp[map[j][i]]++;
            
            toV();
            
            int index = 0;
            
            for(int k = 0; k<v.size(); k++)
            {
                map[index++][i] = v.at(k).num;
                map[index++][i] = v.at(k).cnt;
                
                if(index >= 100) break;
            }
            
            for(int k = index; k<100; k++) map[k][i] = 0;
            
            max = (max < index) ? index : max;
        }
        
        r = max;
        
        return;
    
}

int run()
{
    int t=0;
    for(int i=0; i<=100; i++)
    {
        if(map[a][b] == k) return t;
        solution();
        //print();
        t++;
    }
    
    return -1;
}

int main(int argc, const char * argv[]) {
    
    cin >> a >> b >> k;
    
    a--;
    b--;
    
    for(int i=0; i<3; i++)
    for(int j=0; j<3; j++)
    cin >> map[i][j];
    
    cout << run();
    
    return 0;
}
