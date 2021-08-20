#include <string>
#include <vector>
#include <stack>

using namespace std;
vector<stack<int>> s;
int N;

int root = -1;

bool isAllstackEmpty()
{
    for(int i=0; i<(int)s.size(); i++)
    {
        if((int)s[i].size() != 1) return false;
        return true;
    }
    return false;
}




vector<int> solution(int n, vector<vector<int>> queries) {
    vector<int> answer;
    bool isFirst = true;
    
    for(int i=0; i<n; i++) s[i].push(-1);
    
    
    for(int i=0; i<queries.size(); i++)
    {
        if(queries[i][1] == -1)
        {
            if( s[queries[i][0]-1].top() == -1)
            {
                if(isAllstackEmpty()) answer.push_back(-1);
                
                else{
                    
                    for(int j=1; j<n; j++)
                    {
                        if( s[(queries[i][0]-1+j)%n].top() == -1 ) continue;
                        
                        answer.push_back(s[(queries[i][0]-1+j)%n].top());
                        s[(queries[i][0]-1+j)%n].pop();
                        
                        continue;
                    }
                }
                
            }
            
            else if(s[queries[i][0]-1].size() > 1 && queries[i][0]-1!=root)
            {
                answer.push_back(s[queries[i][0]-1].top());
                s[queries[i][0]-1].pop();
            }
            
            
            else if(s[queries[i][0]-1].size() == 2 && queries[i][0]-1==root)
            {
                for(int j=0; j<n; j++)
                {
                    if( s[(queries[i][0]-1+j)%n].top() == -1 ) continue;
                    
                    answer.push_back(s[(queries[i][0]-1+j)%n].top());
                    s[(queries[i][0]-1+j)%n].pop();
                    
                    continue;
                }
            }
        }
        
        else {
            
            if(isAllstackEmpty()) root = queries[i][0]-1;
            
            
            s[queries[i][0]-1].push(queries[i][0]);
            
        }
        
    }
    
    return answer;
}
