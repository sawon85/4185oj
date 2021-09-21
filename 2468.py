import sys
from copy import deepcopy

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

n = int(sys.stdin.readline())
_map = [list(map(int,sys.stdin.readline().split())) for _ in range(n)]


def dfs(water) : 
    global _map
    cnt = 0
    for i in range(n) :
        for j in range(n) :
            if _map[i][j] <= water : continue
            bfs(i, j, water)
            cnt += 1

    return cnt


def bfs(y, x, water) :
    global dx, dy, n, _map

    queue = [(y, x)]
    _map[y][x] = 0

    while queue :
        now = queue.pop(0)
        xx = now[1]
        yy = now[0]
        for i in range(4) :
            nx = xx+dx[i]
            ny = yy+dy[i]

            if nx < 0 or nx>=n or ny<0 or ny>=n: continue
            if _map[ny][nx]<=water: continue
            queue.append((ny, nx))
            _map[ny][nx] = -1


maxNum = max(map(max, _map))
ans = 1

tmp = deepcopy(_map)

for i in range(1, maxNum+1) :
    ans = max(ans, dfs(i))
    _map = deepcopy(tmp)

print(ans)
