import sys
import heapq
N = int(sys.stdin.readline())

cup_list = []
heap = []
for i in range(N):
    deadline, cup = map(int, sys.stdin.readline().split())
    cup_list.append((deadline, cup))

#cup_list.sort(key=lambda x : (x[0], -x[1]))
cup_list.sort()
result = 0 
for i in range(N):
    now_deadline = cup_list[i][0]
    now_cup = cup_list[i][1]

    if len(heap) >= now_deadline:
        temp = heapq.heappop(heap)
        if temp > now_cup:
            heapq.heappush(heap, temp)
        else:
            heapq.heappush(heap, now_cup)
    else:
        heapq.heappush(heap, now_cup)
#print(heap)
for i in range(len(heap)):
    result += heap[i]

print(result)
