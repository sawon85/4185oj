import itertools

sentence = input()
diff = ord('Z') - ord('A')+1
visited = [0 for i in range(diff)]
for ch in sentence:
    visited[ord(ch)-ord('A')] += 1

odd = 0
odd_chr = ""
answer = ""
for i in range(diff):
    if(visited[i]%2==1):
        odd+=1
        odd_chr = chr(ord('A') + i)
    answer += visited[i]//2 * chr(ord('A') + i)

result = list()

for tup in list(itertools.permutations(answer)):
    temp = ''.join(tup)
    if temp not in result:
        result.append(temp)

for ans in result:
    print(ans+odd_chr+ans[::-1])