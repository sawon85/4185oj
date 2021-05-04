//
//  main.cpp
//  programmers_튜플
//
//  Created by sawon on 2021/05/05.
//

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;
 
 
vector<int> solution(string s) {
    
    map<int,int> m;
    string tmp;
    
    for(int i=2; i<s.size()-1; i++){
        if(s[i] >= '0'&& s[i] <= '9'){
            tmp += s[i];
        } else{
            if(tmp.size()){
                m[stoi(tmp)]++;
                tmp.clear();
            }
        }
    }
    
    vector<int> answer(m.size());
    for(auto a:m){
        answer[abs(int(a.second - m.size()))] = a.first;
    }
    
        
    return answer;
}
int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    return 0;
}
