//
//  main.cpp
//  programmers_수식최대화
//
//  Created by sawon on 2021/05/03.
//

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>

using namespace std;
vector<int> numbers;
vector<int> oper; // 0 + 1 * 2 -

void set(string &expression)
{
    int temp = 0;
    for(auto c: expression)
    {
        if(c == '+')
        {
            numbers.push_back(temp);
            oper.push_back(0);
            temp = 0;
            continue;
        }
        
        if(c == '*')
        {
            numbers.push_back(temp);
            oper.push_back(1);
            temp = 0;
            continue;
        }
        
        if(c == '-')
        {
            numbers.push_back(temp);
            oper.push_back(2);
            temp = 0;
            continue;
        }
        
        temp = temp*10 + (c - '0');
    }
    
    numbers.push_back(temp);
}

void cacul(vector <long long> &tmpnum,vector <int> &tempop, int op)
{
    long long result = 0;
    for(int i=0; i<tempop.size(); i++)
    {
        if(tempop.at(i) != op) continue;
        
        switch (op) {
                
            case 0:
                result = tmpnum.at(i) + tmpnum.at(i+1);
                break;
            case 1:
                result = tmpnum.at(i) * tmpnum.at(i+1);
                break;
            case 2:
                result = tmpnum.at(i) - tmpnum.at(i+1);
                break;
                
        }
        
        tmpnum.at(i) = result;
        tmpnum.erase(tmpnum.begin() + (i+1));
        tempop.erase(tempop.begin() + i);
        i --;
        
    }
}

void copy(vector <long long> &tmpnum,vector <int> &tempop)
{
    tmpnum.clear(); tempop.clear();
    for(int i=0; i<numbers.size(); i++) tmpnum.push_back( (long long) numbers.at(i));
    for(int i=0; i<oper.size(); i++) tempop.push_back(oper.at(i));
}

long long solution(string expression) {
    long long answer = 0;
    set(expression);
    
    vector <long long> tmpnum;
    vector <int> tempop;
    
    copy(tmpnum, tempop);
    cacul(tmpnum, tempop, 0);
    cacul(tmpnum, tempop, 1);
    cacul(tmpnum, tempop, 2);
    answer = max(answer, abs(tmpnum[0]));
    
    copy(tmpnum, tempop);
    cacul(tmpnum, tempop, 0);
    cacul(tmpnum, tempop, 2);
    cacul(tmpnum, tempop, 1);
    answer = max(answer, abs(tmpnum[0]));
    
    copy(tmpnum, tempop);
    cacul(tmpnum, tempop, 1);
    cacul(tmpnum, tempop, 0);
    cacul(tmpnum, tempop, 2);
    answer = max(answer, abs(tmpnum[0]));
    
    copy(tmpnum, tempop);
    cacul(tmpnum, tempop, 1);
    cacul(tmpnum, tempop, 2);
    cacul(tmpnum, tempop, 0);
    answer = max(answer, abs(tmpnum[0]));
    
    copy(tmpnum, tempop);
    cacul(tmpnum, tempop, 2);
    cacul(tmpnum, tempop, 1);
    cacul(tmpnum, tempop, 0);
    answer = max(answer, abs(tmpnum[0]));
    
    copy(tmpnum, tempop);
    cacul(tmpnum, tempop, 2);
    cacul(tmpnum, tempop, 0);
    cacul(tmpnum, tempop, 1);
    answer = max(answer, abs(tmpnum[0]));
    
    return answer;
}

