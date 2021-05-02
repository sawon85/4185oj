#include <string>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;
int ans[5000][2]; // 0 가격 //시간

bool cmp (vector<int>& v1, const vector<int>& v2)
{
    return v1[0] < v2[0];
}

void dp(int st, int index)
{
    if(index < 0) return;
    
    if(
    
    
}

int solution(vector<vector<int>> ads) {
    int answer = 0;
    
    for(int i=0; i)
    
    return answer;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    return 0;
}
