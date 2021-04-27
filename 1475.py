
visited= [0 for i in range (10)]


def visit(s) :
    num = ord(s) - ord('0')

    if num == 9 :
        visited[6]+=1
    else :
        visited[num]+=1

sentence = input()

while sentence != "" :
    s = sentence[-1:]
    sentence = sentence[:-1]
    visit(s)

visited[6] = int(visited[6]/2.0 + 0.5)

maxNum = max(visited)

print(maxNum)
