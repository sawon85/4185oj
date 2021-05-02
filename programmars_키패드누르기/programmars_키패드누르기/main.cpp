//
//  main.cpp
//  programmars_키패드누르기
//
//  Created by sawon on 2021/05/03.
//

#include <iostream>
#include <string>
#include <vector>
#include <math.h>

using namespace std;

int key[4][3] =
{
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9},
    {-1, 0, -2}
};

struct position{
    int y, x;
};

position getPosition(int key)
{
    if(key == 0) return position{3, 1};
    if(key == -1) return position{3, 0};
    if(key == -2) return position{3, 2};
    return position({ (key-1)/3, (key-1)%3});
}

int distance(position key1, position key2)
{
    return abs(key1.y-key2.y) + abs(key2.x-key1.x);
}

string solution(vector<int> numbers, string hand) {
    string answer = "";
    
    position left = getPosition(-1), right = getPosition(-2);
    
    int leftd, rightd;
    position number;
    bool isLeft = hand == "left";
    for(int i = 0; i<numbers.size(); i++)
    {
        number = getPosition(numbers.at(i));
        leftd = distance(left, number);
        rightd = distance(right, number);
        
        if(numbers.at(i) == 1 || numbers.at(i) == 4 || numbers.at(i) == 7)
        {
            left = number;
            answer.push_back('L');
            continue;
        }
        
        if(numbers.at(i) == 3 || numbers.at(i) == 6 || numbers.at(i) == 9)
        {
            right = number;
            answer.push_back('R');
            continue;
        }
        
        if(leftd < rightd)
        {
            left = number;
            answer.push_back('L');
        }
        else if(leftd > rightd)
        {
            right = number;
            answer.push_back('R');
        }
        else if(isLeft) {
            left = number;
            answer.push_back('L');
        }
        else {
            right = number;
            answer.push_back('R');
        }
    }
    
    return answer;
}

int main(int argc, const char * argv[]) {

    vector<int> v = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    
    cout << solution(v, "left");
    return 0;
}
