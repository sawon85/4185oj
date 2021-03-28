//
//  main.cpp
//  swexpert10994
//
//  Created by sawon on 2021/02/23.
//

#include <iostream>
using namespace std;
#define MAX 500000

struct coin {
    int own;
    int value;
};
 
coin coins[MAX];
 
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
 
    int test_case;
    int N, K;
 
    cin >> test_case;
 
    for (int i = 1; i <= test_case; i++) {
        int sum;
        int count;
 
        cin >> N >> K;
 
        for (int j = 0; j < N; j++) {
            cin >> coins[j].value >> coins[j].own;
        }
 
        sum = 0;
        count = 0;
 
        for (int a = 0; a < N; a++) {
            if (sum + coins[a].value >= K) {
                break;
            }
            if (coins[a].own == 0) {
                if (sum + coins[a].value < coins[a + 1].value || a == N - 1) {
                    //중복해봤자 다음값보다 크지 않으면 의미가 없음. 어차피 중복은 1개로 치니까. 최대한 다양성이 우선
                    
                    cout << sum << " " << coins[a].value <<" ";
                    sum += coins[a].value;
                    count++;
                }
            }
        }
        if (sum == 0) { //아무것도 못 샀을 경우 1원이라도 사게 만든다.
            sum = 1;
        }
        cout << "#" << i << ' ' << count << ' ' << K - sum << endl;
    }
    return 0;
}
