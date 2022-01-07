import heapq
from sys import stdin

n = int(stdin.readline())

#큰 수보관
min_heap = []
#작은 수 보관
max_heap = []

len_min = 0
len_max = 0

mid = int(stdin.readline())
print(mid)
for i in range(n-1):
    temp = int(stdin.readline())
    if temp >mid:
        heapq.heappush(min_heap,temp)
        len_min +=1
        
        if len_min>=len_max+2:
            #mid를 작은쪽에 보내고, 큰거 거에서 하나 pop
            heapq.heappush(max_heap, -mid)
            len_max +=1
            mid = heapq.heappop(min_heap)
            len_min -=1
            print(mid)
        else:
            print(mid)
        
    else:
        heapq.heappush(max_heap,-temp)
        len_max +=1
        
        if len_max>=len_min+1:
            #mid를 큰쪽에 보내고, 작은 거에서 하나 pop
            heapq.heappush(min_heap, mid)
            len_min +=1
            mid = -heapq.heappop(max_heap)
            len_max-=1
            print(mid)
        else:
            print(mid)
        