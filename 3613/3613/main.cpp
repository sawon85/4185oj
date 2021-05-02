//
//  main.cpp
//  3613
//
//  Created by sawon on 2021/05/01.
//

#include <iostream>
#include <cstring>

using namespace std;

int main(int argc, const char * argv[]) {
    
    ios_base::sync_with_stdio(false);
    cout.tie(NULL); cin.tie(NULL);
    
    string name;
    
    cin >> name;
    
    char a;
    for(int i=0; i<name.size(); i++)
    {
        a = name.at(i);
        
        if(a>='A' && a<='Z')
        {
            name.erase(name.begin()+i);
            name.insert(name.begin()+i, '_');
            i++;
            name.insert(name.begin()+i, 'a'+a-'A');
        }
        
        else if(a =='_')
        {
            char next = name.at(i+1);
            name.erase(name.begin()+i,name.begin()+i+2);
            name.insert(name.begin()+i, 'A'+next-'a');
            
        }
        
    }
    
    cout << name << '\n';
    
    return 0;
}
