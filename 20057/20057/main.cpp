//
//  main.cpp
//  20057
//
//  Created by sawon on 2021/04/19.
//

#include <iostream>
using namespace std;
int map[500][500];
int n;

int leftM[5][5] = {
    {0, 0, 2, 0, 0},
    {0, 10, 7, 1, 0},
    {5, -1, 0, 0, 0},
    {0, 10, 7, 1, 0},
    {0,  0, 2, 0, 0}
};

int rightM[5][5];
int upM[5][5];
int downM[5][5];

int ans;

void print(int a[][5])
{
    cout << endl;
    for(int i=0; i<5; i++)
    {
        for(int j=0; j<5; j++) cout << a[i][j] << " ";
        cout << endl;
    }
}

void printM()
{
    cout << endl;
    for(int i=0; i<n; i++)
    {
        for(int j=0; j<n; j++) cout << map[i][j] << " ";
        cout << endl;
    }
}

void reversex(int a[][5], int b[][5])
{
    for(int i=0; i<5; i++)
    for(int j=0; j<5; j++)
    {
        b[i][j] = a[i][4-j];
    }
}

void rotate45(int a[][5], int b[][5])
{
    for(int i=0; i<5; i++)
    for(int j=0; j<5; j++)
    {
        b[i][j] = a[j][i];
    }
}

void cacul(int a[][5], int x, int y) // y좌표로 준다.
{
    int send = map[y][x];
    int temp;
    int total = 0;
    int pivotx = x-2, pivoty = y-2;
    int nowx, nowy;
    
    int ax=0, ay=0;
    
    for(int i=0; i<5; i++)
    for(int j=0; j<5; j++)
    {
        if(a[i][j] == -1)
        {
            ax = pivotx+j; ay = pivoty+i;
            continue;
        }
        
        temp = a[i][j]*send/100; // 날리는
        
        if(temp == 0) continue;
        
        nowx = pivotx + j; nowy = pivoty + i;
        total += temp;
        
        if(nowx < 0 || nowx >=n || nowy < 0 || nowy >=n )
        {
            ans += temp;
            continue;
        }
        
        map[nowy][nowx] += temp;
        
    }
    
    map[y][x] = 0;
    
    if(ax < 0 || ax >=n || ay < 0 || ay >=n )
    {
        ans += (send - total);
        return;
    }
    
    
    map[ay][ax] += (send - total);
}

void solution()
{
    reversex(leftM, rightM);
    rotate45(leftM, upM);
    rotate45(rightM, downM);
    
    int x = n/2, y = n/2;
    
    int rotate = n/2;
    
    int block = 0;
    
    for(int i=0; i<rotate; i++)
    {
        block++;
        
        //왼
        for(int j =0 ; j<block; j++)cacul(leftM, --x, y);

        //아
        
        for(int j=0; j<block; j++) cacul(downM,x,++y);

        block++;
        
        //오
        
        for(int j=0; j<block; j++) cacul(rightM,++x,y);

        //위
        
        for(int j=0; j<block; j++)  cacul(upM,x,--y);
        
    }
    
    for(int j =0 ; j<block; j++)
    {
        cacul(leftM, --x, y);
    }
    
}


int main(int argc, const char * argv[]) {
    cin  >> n;
    
    for(int i=0; i<n; i++)
    for(int j=0; j<n; j++)
    {
        cin >> map[i][j];
    }
    
    solution();
    
    cout << ans;
    
    return 0;
}
