import sys, heapq

N, E = map(int, sys.stdin.readline().split())
my_map = [ [] for i in range(N+1)]
INF = 987654321

for i in range(E):
    a, b, c = map( int, sys.stdin.readline().split() )
    my_map[a].append((b,c))
    my_map[b].append((a,c))

c1, c2 = map(int, sys.stdin.readline().split())    

def dijkstra(start):
    
    #초기화
    cost = [ INF for i in range(N+1)]
    heap = []
    heapq.heappush(heap, (0, start))
    
    while heap:
        temp = heapq.heappop(heap)
        temp_value = temp[0]
        temp_point = temp[1]
        
        if cost[temp_point] < temp_value:
            continue
        
        cost[temp_point] = temp_value
        
        for i in range(len(my_map[temp_point])):
            now_value = my_map[temp_point][i][1]
            now_point = my_map[temp_point][i][0]
            if temp_value + now_value < cost[now_point]:
                cost[now_point] = temp_value + now_value
                heapq.heappush(heap, (cost[now_point], now_point))
                
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