//
//  main.cpp
//  17822
//
//  Created by sawon on 2021/04/17.
//

#include <iostream>
#include <vector>
#include <queue>
using namespace std;

struct info{
    int i, j;
};

int di[4] = {0, 0, 1, -1};
int dj[4] = {1, -1, 0, 0};

int n, m, t; // n개의 원 M개의 숫자 <=50

vector<int> cicle[51];

int x[50], d[50], k[50];

bool visited[51][50];

bool isReset;

int sum, cnt;

int nowIndex;

void reset()
{
    for(int i=1 ; i<=n; i++) for(int j=0; j<m; j++) visited[i][j] = false;
}

void rotateTime(vector<int> &c)
{
    int a = c.back();
    c.insert(c.begin(), a);
    c.pop_back();
    
}

void rotateReverseTime(vector<int> &c)
{
    int a = c.front();
    c.push_back(a);
    c.erase(c.begin());
}

void bfs()
{
    
    int tmp;
    queue<info> q;
    
    int ii;
    int jj;
    
    info now;
    
    bool flag;
    
    isReset = false;
    
    cnt = 0;
    sum = 0;
    
    reset();
    
    for(int i=1 ; i<=n; i++) //원
    {
        for(int j=0; j<m; j++) // 숫자
        {
            if(cicle[i][j] == -1) continue;
            if(visited[i][j]) continue;
            
            tmp = cicle[i][j];
            
            q.push(info{i, j});
            visited[i][j] = true;
            
            flag = false;
    
            while(!q.empty())
            {
                now = q.front();
                q.pop();
                
                for(int dd = 0; dd<4; dd++)
                {
                    ii =  now.i + di[dd];
                    if(ii<1 || ii>n) continue;
                    
                    jj = (m + now.j + dj[dd])%m;
                    
                    if(cicle[ii][jj] == -1) continue;
                    
                    if(tmp == cicle[ii][jj])
                    {
                        cicle[ii][jj] = -1;
                        q.push(info{ii, jj});
                        visited[ii][jj] = true;
                        flag = true;
                    }
                    
                }
            }
            
            if(flag)
            {
                cicle[i][j] = -1;
                isReset = true;
            }
            
            if(!isReset)
            {
                cnt++;
                sum += cicle[i][j];
                
            }
        }
    }
}
void rotate()
{
    for(int i=1; i<=n; i++)
    {
        if(i%x[nowIndex] == 0)
        {
            if(d[nowIndex]==0) for(int j=0; j<k[nowIndex]; j++) rotateTime(cicle[i]);
            else for(int j=0; j<k[nowIndex]; j++) rotateReverseTime(cicle[i]);
        }
    }
    
}

void update()
{

   if(cnt == 0 ) return;
   float avg = (float) sum/cnt;
    
    for(int i=1 ; i<=n; i++) //원
    {
        for(int j=0; j<m; j++)
        {
            if(cicle[i][j] == -1) continue;
            if(avg > (float)cicle[i][j]) cicle[i][j]++;
            else if(avg < (float)cicle[i][j]) cicle[i][j]--;
        }
    }
    
}

void print()
{
    
    for(int i=1 ; i<=n; i++)
    {
        cout <<endl;
        for(int j=0; j<m; j++){
            cout << cicle[i][j] << " ";
        }
    }
    cout <<endl;
}

int solution()
{
    for(int tt=1; tt<=t; tt++)
    {
        nowIndex = tt-1;
        rotate();
        bfs();
        if(!isReset) update();
    }
    
    sum = 0;
    
    for(int i=1 ; i<=n; i++) //원
    {
        for(int j=0; j<m; j++)
        {
            if(cicle[i][j] == -1) continue;
            
            sum += cicle[i][j];
        }
    }
    
    return sum;
}

int main(int argc, const char * argv[]) {

    cin >> n >> m >> t;
    
    int num;
    for(int i=1 ; i<=n; i++) //원
    {
        for(int j=0; j<m; j++)
        {
            cin >> num;
            cicle[i].push_back(num);
        }
    }
    
    for(int i=0; i<t; i++) cin >> x[i] >> d[i] >> k[i];
    
    cout << solution();
    
    return 0;
}
