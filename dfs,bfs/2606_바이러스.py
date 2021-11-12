n = int(input())
com_list = [[0 for i in range(n+1)]for i in range(n+1)]
visited = [0 for i in range(n+1)]
result = 0
k = int(input())

for i in range(k):
    a,b = map(int, input().split())
    com_list[a][b] = 1
    com_list[b][a] = 1
    
def dfs(v):
    global result
    visited[v] = 1
    result+=1
    for i in range(n+1):
        if com_list[v][i] ==1 and visited[i] ==0:
            dfs(i)
dfs(1)
print(result-1)