
공 부 중.


https://sawon85.tistory.com/category/백준%20알고리즘%20_%204185


공 부 중.


https://sawon85.tistory.com/category/백준%20알고리즘%20_%204185

# 코테 0계명

1.  변수명 옆에 범위 꼭 적어 놓기
2.  index가 1부터면 1뺀 다음에 0부터 시작하지말고 범위 1 늘려서 1부터 시작하기 >> 실수했을 때 찾기 힘듦
3.  진행하다 벽이 있거나 막히는 문제다 -> 제일 먼저 BFS 생각해보기!!! BFS visited함수에 cnt를 저장할 경우. 아예 막혀서 cnt=0부터 시작할 경우 결과가 0이 된다. 하지만 0이될 경우는 없음!!!!!!! 꼭 예외처리 하기
    1.  같은 곳에서 만났을 때 작은 거 예외처리
    2.  벽에 막히는 거 항상 생각
4.  BFS queue에 넣자마자 visited함수 적기. (이 방법이 가장 실수를 줄이는 방법)
5.  N개 중에 m개를 선택한다? --> 제일 먼저 DFS생각해보기
6.  테트로미노, 드래곤 커브 처럼 길게 뻗어나가는 것 -> DFS관점에서 생각해 보기
7.  size, data같은 변수명 절대 적지 않기.
8.  cmp함수 true일 경우 왼쪽으로 보낸다.
9.  ~이해 안 가는 방식이더라도~ 꼭 문제에 나온 진행 순서 숙지하고 코드 진행시키기.
10.  문제풀기 전에 한 번 더 깊게 예외 생각해보기
11.  백트래킹으로 다시 재귀 호출하기 전에 초기화해야될 값이 남아있는 지,,, 다시 한 번 확인 하기
12.  y를 y축 방향으로만 생각하지 않기. 문제 다시 보기

