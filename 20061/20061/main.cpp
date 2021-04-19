//
//  main.cpp
//  20061
//
//  Created by sawon on 2021/04/18.
//

#include <iostream>
#include <vector>
using namespace std;

vector<vector<int>> blue, green;

int score = 0;

int n;

void init(vector<vector<int>> &a)
{
    for(int i=0; i<6; i++)
    {
        vector<int> b;
        a.push_back(b);
        for(int j=0; j<4; j++)
            a.at(i).push_back(0);
    }
}

void print(vector<vector<int>> &a)
{
    cout << endl;
    
    for(int i=0; i<6; i++)
    {
        cout << endl;
        for(int j=0; j<4; j++)
        cout << a[i][j] << " ";
    }
}


void go(int x, vector<vector<int>> &a, bool is2block)  //block 하나
{
    int i = 0;
    for(i=0; i<5; i++)
    {
        if( a[i+1][x] > 0) break;
        
    }
    
    a[i][x] = 1;
    if(is2block) a[i-1][x] = 1;
}


void go2(int x1, int x2, vector<vector<int>> &a)  //block 2개
{
    int i = 0;
    for(i=0; i<5; i++)
    {
        if(a[i+1][x1] > 0 || a[i+1][x2] > 0) break;
        
    }
    
    a[i][x1] = 1;
    a[i][x2] = 1;
}

void scoreCheck(vector<vector<int>> &a)
{
    
    bool check;
    for(int i=5; i>=0; i--)
    {
        check = true;
        for(int j=0; j<4; j++)
        {
            if(a[i][j] == 1) continue;
            check = false;
            break;
        }
        
        if(check)
        {
            a.erase(a.begin()+i);
            i++;
            vector<int> b = {0,0,0,0};
            a.insert(a.begin(), b);
            score++;
        }
    }
}

void clear(vector<vector<int>> &a)
{
    for(int i=0; i<2; i++)
    {
        if(a[1][0]!=0||a[1][1]!=0||a[1][2]!=0||a[1][3]!=0)
        {
            a.pop_back();
            vector<int> b = {0,0,0,0};
            a.insert(a.begin(), b);
        }
    }
}

/*
 t = 1: 크기가 1×1인 블록을 (x, y)에 놓은 경우
 t = 2: 크기가 1×2인 블록을 (x, y), (x, y+1)에 놓은 경우  // blue go1
 t = 3: 크기가 2×1인 블록을 (x, y), (x+1, y)에 놓은 경우  //blue go2
 */

void game(int t, int x, int y)
{
    if(t==1)
    {
        go(y,blue,false);
        go(x,green,false);
    }
    
    else if (t==2)
    {
        go(y,blue, true);
        go2(x,x+1, green);
    }
    
    else if (t==3)
    {
        go2(y,y+1, blue);
        go(x,green,true);
    }
    
    scoreCheck(blue); scoreCheck(green);
    clear(blue); clear(green);
    
}

int result(vector<vector<int>> &a)
{
    int sum = 0;
    for(int i=0; i<6; i++)
    {
        for(int j=0; j<4; j++)
            sum += a[i][j];
    }
    
    return sum;
}

int solution()
{
    init(blue); init(green);
    
    int y, x, t;
    for(int i=0; i<n; i++)
    {
        cin >> t >> y >> x ;
    
        game(t,x, y);
    }
    
    return result(blue) + result(green);
    
}

int main(int argc, const char * argv[]) {

    cin >> n;
    
    int result = solution();
    cout << score << "\n" << result;
    return 0;
}
