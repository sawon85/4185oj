//
//  main.cpp
//  듣보잡
//
//  Created by sawon on 02/01/2019.
//  Copyright © 2019 sawon. All rights reserved.
//

#include <iostream>
#include<string>
#include<algorithm>
#include<vector>
using namespace std;
int n,m;
vector <string> cannot;
bool binaray(int st, int ed,string name)
{
    if(ed<st) return 0;
    else{
        int pivot=(st+ed)/2;
        int decide=cannot[pivot].compare(name);
        
        if(decide==0)
            return 1;
        else if(decide>0)
            return binaray(st,pivot-1,name);
        else
           return binaray(pivot+1,ed,name);
    }

}
int main(int argc, const char * argv[]) {
    scanf("%d %d",&n,&m);
    string name;
    for(int i=0;i<n;i++)
    {
        cin>>name;
        cannot.push_back(name);
    }

    sort(cannot.begin(),cannot.end());
    
    vector<string> result;
    for(int i=0;i<m;i++)
    {
        cin>>name;
        if(binaray(0,(int)cannot.size()-1,name)==1)
            result.push_back(name);
        
    }

    cout<<result.size()<<endl;
    sort(result.begin(),result.end());
    for(int i=0;i<result.size();i++)
        cout<<result[i]<<endl;
  
    return 0;
}
