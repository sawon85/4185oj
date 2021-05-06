//
//  main.cpp
//  programmers_호텔방배정
//
//  Created by sawon on 2021/05/05.
//

#include <iostream>
#include <string>
#include <vector>
#include <map>

using namespace std;

map<long long, long long> m;

long long findP(long long v)
{
    if(m[v] == 0 ) return v;
    
    return m[v] = findP(m[v]);
}

vector<long long> solution(long long k, vector<long long> room_number) {
    
    vector<long long> answer;
    
    long long p;
    for(auto room : room_number)
    {
        if(m[room]==0)
        {
            m[room] = findP(room+1);
            answer.push_back(room);
        }
        
        else{
            p = findP(room);
            m[p] = findP(p+1);
            answer.push_back(p);
        }
    }
    
    return answer;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    return 0;
}
