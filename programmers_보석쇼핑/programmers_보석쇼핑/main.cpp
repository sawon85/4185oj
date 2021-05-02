
//  main.cpp
//  programmers_보석쇼핑
//
//  Created by sawon on 2021/05/03.
//
#include<iostream>
#include <string>
#include <vector>
#include <set>
#include <unordered_map>
#include <map>

using namespace std;

vector<int> solution(vector<string> gems) {
    vector<int> answer;
    
    set<string> s;
    
    for(auto gem : gems) s.insert(gem);
    
    answer.push_back(1);
    answer.push_back((int)gems.size());
    
    unordered_map<string, int> m;

    int start = 0, end = 0;
    int dist= (int)gems.size();
    
    while(end < gems.size())
    {

        while(m.size() != s.size() && end < gems.size()) m[gems.at(end++)]++;
        if(m.size() != s.size() && end >= gems.size()) break;
        while(m.size() == s.size() && start <= end)
        {
            m[gems.at(start)]--;
            if(m[gems.at(start)] == 0) m.erase(gems.at(start));
            start++;
            
        }
        

        if(dist > end - start + 1)
        {
            dist = end - start + 1;
            answer[0]= start;
            answer[1] = end;
        }
    }
    
    return answer;
}

int main(int argc, const char * argv[]) {
    return 0;
}
