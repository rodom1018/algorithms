import heapq, sys

intput = sys.stdin.readline
N = int(input())

intput = sys.stdin.readline
M = int(input())

cost_map = [[] for i in range(N+1)]
visit_map = [ 0 for i in range(N+1)]

for i in range(M):
    input = sys.stdin.readline
    a, b, c = map(int, input().split())

    cost_map[a].append((c,b))
    cost_map[b].append((c,a))

heap = [(0,1)]
result = 0 

while heap:
    cost, node = heapq.heappop(heap)
    
    if visit_map[node] == 1:
        continue

    visit_map[node] = 1
    result += cost

    now_len = len(cost_map[node])

    for i in range(now_len):
        heapq.heappush(heap, cost_map[node][i])
    

print(result)
