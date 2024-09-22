from collections import deque
import sys

input = sys.stdin.readline
K = int(input())
result = 1
my_map = []
my_visited = []

def bfs(start):
    global result
    global my_map
    global my_visited
    queue = deque()
    queue.append(start)
    my_visited[start] = 1

    while queue:
        now = queue.popleft()
        now_len = len(my_map[now])

        for i in range(now_len):
            temp = my_map[now][i]
            
            if my_visited[temp] == 0:
                my_visited[temp] = my_visited[now] * (-1)
                queue.append(temp)
            else :
                if my_visited[temp] == my_visited[now]:
                    result = 0
                    return


for i in range(K):
    input = sys.stdin.readline
    V, E = map(int, input().split())

    my_map = [[] for i in range(V+1)]
    my_visited = [0] * (V+1)
    result = 1

    for i in range(E):
        input = sys.stdin.readline
        a, b = map(int, input().split())
        my_map[a].append(b)
        my_map[b].append(a)
    
    for i in range(1,V+1):
        if my_visited[i] == 0:
            bfs(i)

    if result:
        print("YES")
    else:
        print("NO")