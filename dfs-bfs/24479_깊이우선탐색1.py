import sys
sys.setrecursionlimit(10**6) # 이번 문제에서는 넣어줘야 했다

input = sys.stdin.readline
N, M, R = map(int, input().split())

dfs_map = [[] for i in range(N+1)]
dfs_visited = [0] * (N+1)

step = 1 
for i in range(M):
    a, b = map(int, input().split())
    dfs_map[a].append(b) 
    dfs_map[b].append(a)

for i in range(N+1):
    dfs_map[i].sort()

def dfs(start):
    global step
    global dfs_visited
    dfs_visited[start] = step
    step += 1
    for i in dfs_map[start]:
        if dfs_visited[i] == 0:
            dfs(i)

dfs(R)

for i in range(1,N+1):
    print(dfs_visited[i])