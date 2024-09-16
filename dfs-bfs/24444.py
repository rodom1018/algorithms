import sys
from collections import deque

input = sys.stdin.readline
N, M, R = map(int, input().split())

bfs_map = [[] for i in range(N+1)]
bfs_visited = [0] * (N+1)
count = 1

for i in range(M):
    a, b = map(int, input().split())
    bfs_map[a].append(b)
    bfs_map[b].append(a)

for i in range(N+1):
    bfs_map[i].sort()


def bfs(R):
    global count

    queue = deque()
    queue.append(R)
    bfs_visited[R] = count
    count += 1

    while queue :
        now = queue.popleft()
        now_len = len(bfs_map[now])

        for i in range(now_len):
            temp = bfs_map[now][i]

            if bfs_visited[temp] == 0:
                bfs_visited[temp] = count
                count += 1
                queue.append(temp)
        

bfs(R)

for i in range(1,N+1):
    print(bfs_visited[i])