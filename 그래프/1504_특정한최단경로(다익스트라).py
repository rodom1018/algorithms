import sys

N, E = map(int, sys.stdin.readline().split())
my_map = [ [] for i in range(N+1)]
INF = 987654321

for i in range(E):
    a, b, c = map( int, sys.stdin.readline().split() )
    my_map[a].append((b,c))
    my_map[b].append((a,c))

c1, c2 = map(int, sys.stdin.readline().split())

def get_smallest(visited, cost):
    temp = -1 
    temp_value = INF

    for i in range(1,N+1):
        # 아직 방문 안했으면서, 최소한의 비용의 노드 찾기
        if visited[i] == 0 and temp_value > cost[i]:
            temp = i
            temp_value = cost[i]
    
    return temp
        

def dijkstra(start):
    
    #초기화
    visited = [ 0 for i in range(N+1)]
    cost = [ INF for i in range(N+1)]
    cost[start] = 0

    for a in range(N):
        now_node = get_smallest(visited, cost)
        visited[now_node] = 1

        for i in range(len(my_map[now_node])):
            temp_dest, temp_cost = my_map[now_node][i][0], my_map[now_node][i][1]

            if cost[temp_dest] > cost[now_node] + temp_cost:
                cost[temp_dest] = cost[now_node] + temp_cost

    return cost

cost1 = dijkstra(1)
cost2 = dijkstra(c1)
cost3 = dijkstra(c2)

#1 - c1 - c2 - dest
result1 = cost1[c1] + cost2[c2] + cost3[N]
#1 - c2 - c1 - dest
result2 = cost1[c2] + cost3[c1] + cost2[N]

result = min(result1, result2)

if result >= INF:
    print("-1")
else:
    print(result)