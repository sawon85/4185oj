//
//  main.cpp
//  1082
//
//  Created by sawon on 2021/04/22.
//

#include <iostream>
#include <algorithm>
using namespace std;


int main(int argc, const char * argv[]) {
    
    int n;
    int price[10];
    int coin, save;
    
    int min = 51, min2 = 51;
    int minindex = -1 , minindex2 = -1;
    
    cin >> n;
    
    
    for(int i=0; i<n; i++)
    {
        cin >> price[i];
        
        if(min == price[i])
        {
            minindex2 = minindex;
            minindex = i;
            
            min2 = min;
        }
        
        else if(price[i] < min)
        {
            min2 = min;
            minindex2 = minindex;
            
            min = price[i];
            minindex = i;
            
        }
        
        else if(price[i] < min2 && minindex!=i)
        {
            min2 = price[i];
            minindex2 = i;
        }
    }

    cin >> coin;
    save = coin;
    
    if(n==1 || (min2 > coin && minindex == 0 ))
    {
        cout << "0";
        return 0;
    }
    
    int cnt=0;
    int change = 0;
    
    while(save>=0)
    {
        change = save;
        if(cnt == 0 && minindex == 0) save -= price[minindex2];
        else save -= price[minindex];
        
        if(save < 0 ) break;
        
        cnt++;
    }
    
    
    int now;
    for(int i=0; i<cnt; i++)
    {
        if(i == 0 && minindex == 0) now = price[minindex2];
        else now = price[minindex];

        for(int j = n-1; j>=0; j--)
        if(price[j]-now<=change)
        {
            change -= (price[j] - now);
            cout<< j;
            break;
        }
    }
    
    return 0;
}
