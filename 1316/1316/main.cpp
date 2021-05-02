//
//  main.cpp
//  1316
//
//  Created by sawon on 2021/05/01.
//

#include <iostream>
#include <cstring>
using namespace std;
int visited['z'-'a'+1];
int len = 'z'-'a'+1;

void init()
{
    for(int i=0 ;i<len; i++) visited[i] = 0;
}

int main(int argc, const char * argv[]) {

    int t;
    
    cin >> t;
    
    char ch = 0, before;
    int ans = 0;
    bool isgroupNumber;
    
    for(int i=0; i<t; i++)
    {
        string sentence;
        cin >> sentence;
        
        init();
        ch = 0;
        isgroupNumber = true;
        
        for(int c=0; c<sentence.size(); c++)
        {
            before = ch;
            ch = sentence.at(c);
            
            if(before!=ch)
            {
                if(visited[ch-'a'] > 0)
                {
                    isgroupNumber = false;
                    break;
                }
                
                visited[ch-'a']++;
            }
        }
        
        if(isgroupNumber) ans++;
        
    }
    
    cout << ans;
    
    return 0;
}
