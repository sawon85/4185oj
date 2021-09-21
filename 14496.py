import sys
from collections import deque

fr, to = map(int,sys.stdin.readline().split())
n, m = map(int,sys.stdin.readline().split())

visited = [0 for _ in range(n)]
graph = [[] for _ in range(n)]

for i in range(m) :
    f, t = map(int,sys.stdin.readline().split())
    graph[f-1].append(t-1)
    graph[t-1].append(f-1)

def dfs(f, t) :
    global visited, graph
    if f==t: return 0
    visited[f] = 1
    queue = deque([f])

    while queue :
        now = queue.popleft()
        cnt = visited[now]
        
        for i in graph[now] :
            if visited[i]!=0 and visited[i] <= cnt+1 : continue
            if i == t : return cnt
            visited[i] = cnt+1
            queue.append(i)

    return -1

print(dfs(fr-1, to-1))
