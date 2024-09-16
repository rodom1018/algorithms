import heapq
from sys import stdin

n = int(stdin.readline())
my_heap = []
for i in range(n):
    temp = int(stdin.readline())
    
    if temp == 0 :
        if len(my_heap) !=0:
            print(heapq.heappop(my_heap))
        else:
            print("0")
    else:
        heapq.heappush(my_heap, temp)