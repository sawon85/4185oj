//
//  main.cpp
//  1786
//
//  Created by sawon on 2021/03/16.
//
#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> enter, vector<int> leave) {
    vector<int> answer;
    
    int result[1001];
    
    vector<int> in;
    
    for(int i=0; i<enter.size(); i++)
    {
        
    }
    
    return answer;
}
    
    



/*
vector<string> split(string input, char delimiter) {
    vector<string> answer;
    stringstream ss(input);
    string temp;
 
    while (getline(ss, temp, delimiter)) {
        answer.push_back(temp);
    }
 
    return answer;
}

string solution(vector<string> table, vector<string> languages, vector<int> preference) {
    
    string answer = "";
    
    vector<vector<string>> ta;
    
    for(int i =0; i<5; i++)
    {
        string name = table.at(i);
        vector<string> tmp = split(name, ' ');
        ta.push_back(tmp);
        
        for(int i =0; i<tmp.size(); i++)
        cout << tmp.at(i);
        
    }
    
    vector<int> result;
    
    for(int i=0; i<ta.size(); i++)
    {
        for(int j=1; j<ta.at(i).size(); j++)
        {
            for(int k=0; k<languages.size(); k++)
            {
                if(languages.at(k) == ta[i][j])
                {
                    int a = result.at(i) + (6-j)*preference.at(k);
                    result.at(i) = a;
                }
                    
            }
        }
    }
    
    int max = -1;
    int index = 0;
    for(int i =0; i<result.size(); i++)
    if(max<result.at(i))
    {
        max = result.at(i);
        index = i;
    }

    cout << ta[index][0];
    
    return answer;
}
*/

int main(int argc, const char * argv[]) {

   
    
    return 0;
}
