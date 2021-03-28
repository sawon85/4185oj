//
//  main.cpp
//  swexpert4112
//
//  Created by sawon on 2021/01/10.
//

#include <iostream>
#include <vector>
 
using namespace std;
 
vector<pair<int,int>> layer;

void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

void makeLayer()
{
    int nowLayer = 1;
    int nowRoom =0;
    for(int i=0;i<10000;i++)
    {
        layer.push_back(pair<int,int>(nowLayer,nowRoom++));
        
        if(nowLayer == nowRoom)
        {
            ++nowLayer;
            nowRoom = 0;
        }
    }
}
 
int main()
{
    makeLayer();
    
    int test;
    cin >> test;
    
    for(int i=0; i<test; i++)
    {
        int a, b;
        int result;
        
        cin >> a >> b;
        
        if(a>b) swap(&a, &b);
        
        pair<int,int> start = layer.at(a-1);
        pair<int,int> end = layer.at(b-1);
        
        int layer_diff = end.first - start.first;
        int room_diff = end.second - start.second;
        
        if(0<=room_diff && room_diff <= layer_diff) result = layer_diff;
        else if (0 > room_diff) result = layer_diff + abs(room_diff);
        else result = room_diff;
        
        cout << "#" << i+1 << " " << result << endl;
    }
    return 0;
}
