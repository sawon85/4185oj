//
//  main.cpp
//  programmers_크레인인형뽑기
//
//  Created by sawon on 2021/05/05.
//

#include <iostream>
#include <string>
#include <vector>
#include <stack>

using namespace std;
int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0;
    stack<int> s;
    
    int now;
    for(auto cr:moves)
    {
        for(int i=0; i<board.size(); i++)
        {
            if(board[i][cr-1]==0) continue;
            now = board[i][cr-1];
            board[i][cr-1] = 0;
            if(!s.empty())
                if(s.top() == now)
                {
                    s.pop();
                    answer+=2;
                    break;
                }
            s.push(now);
            break;
        }
    }
    
    return answer;
}

int main(int argc, const char * argv[]) {
    vector<vector<int>> board = {
        {0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}
    };
    vector<int> moves = {1,5,3,5,1,2,1,4};
    
    solution(board, moves);
    
    return 0;
}
