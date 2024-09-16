from collections import deque

n, m = map(int, input().split())

info = [[] for i in range(n+1)]
degree = [0 for i in range(n+1)]
queue = deque()

for i in range(m):
    a,b = map(int, input().split())
    info[a].append(b)
    degree[b]+=1
    
for i in range(1,n+1):
    if degree[i] == 0 :
        queue.append(i)

while len(queue) >0 :
    now = queue.popleft()
    print(now,end= " ")
    
    for i in range(len(info[now])):
        degree[info[now][i]] -=1
        if degree[info[now][i]] == 0 :
            queue.append(info[now][i])
    
        

