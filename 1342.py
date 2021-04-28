
visited = [0 for i in range(ord('z') - ord('a') + 1)]
length = 0
sentence = ""
ans = 0

def dfs(cnt,now):
    global sentence, ans, visited

    if cnt == len(sentence):
        ans += 1
        return

    for i in range(len(visited)):
        if(visited[i]==0): continue
        c = chr(ord('a')+i)
        if(now[-1:]==c): continue
        visited[i] -= 1
        dfs(cnt+1, now+c)
        visited[i] += 1

sentence = input()

for c in sentence:
    visited[ord(c)-ord('a')] += 1

dfs(0,"")
print(ans)