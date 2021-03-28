//
//  main.cpp
//  swexpert11112
//
//  Created by sawon on 2021/02/23.
//

#include <iostream>
#include <cmath>

using namespace std;

int p,q,r;

int a,b,c,d;

int main(int argc, const char * argv[]) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int t;
    cin >> t;
    
    for(int i=1; i<=t; i++)
    {
        cin >> p >> q >> r ;
        cin >> a >> b >> c >> d;
        
        cout << "#" << i << " ";
        
        //RED
        if(a>p-r || p+r>c || b>q-r || q+r>d) cout << "Y";
        else cout << "N";
        
        if(pow(a-p,2)+pow(b-q,2) > r*r||pow(a-p,2)+pow(d-q,2) > r*r||pow(c-p,2)+pow(b-q,2) > r*r||pow(c-p,2)+pow(d-q,2) > r*r) cout <<"Y\n";
        else cout << "N\n";
        
    }

    return 0;
}
