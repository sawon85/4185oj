//
//  main.cpp
//  programmers_불량사용자
//
//  Created by sawon on 2021/05/05.
//

#include <iostream>
#include <string>
#include <vector>
#include <set>

using namespace std;

int n;
bool visited[10];
int ans = 0;
set<string> s;

bool isMatch(string &name, string match)
{
    if(name.size() != match.size()) return false;
    
    for(int i=0; i<match.size(); i++)
    {
        if(match.at(i) == '*') continue;
        if(match.at(i)!=name.at(i)) return false;
    }

    return true;
}

void dfs(int index, int cnt, vector<string> &user_id, vector<string> &banned_id)
{
    if(cnt == n)
    {
        string temp = "";
        for(int i=0; i<user_id.size(); i++)
        {
            if(!visited[i]) continue;
            temp += i;
        }
        
        s.insert(temp);
        
        return;
    }
    
    string match = banned_id.at(index);
    
    for(int i=0; i<user_id.size(); i++)
    {
        if(visited[i]) continue;
        if(!isMatch(user_id.at(i), match)) continue;
        visited[i] = true;
        dfs(index+1, cnt+1, user_id, banned_id);
        visited[i] = false;
    }
}

int solution(vector<string> user_id, vector<string> banned_id) {
    
    n = (int)banned_id.size();
    
    dfs(0, 0, user_id, banned_id);
    
    return (int)s.size();
}

int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    vector<string> user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
    vector<string> banned_id = {"*rodo", "*rodo", "******"};
    solution(user_id, banned_id);
    return 0;
}
