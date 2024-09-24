import sys
import heapq
N = int(sys.stdin.readline())

cup_list = [ [] for i in range(N+1)]

for i in range(N):
    deadline, cup = map(int, sys.stdin.readline().split())
    heapq.heappush(cup_list[deadline],-cup)

#print(cup_list)
result = 0 
for i in range(1,N+1):
    # 각 시간마다 최고치를 검색한다. 
    # 1번째 시간의 제일 높은 컵라면 주는 문제 vs 2번째 시간의 2번째 높은 컵라면 주는 문제
    # vs 3번째 시간의 세번째 높은 컵라면 주는 문제 ... 중 가장 높은 것 추출.
    now_max_deadline = 0
    now_max_cup = 0

    for j in range(i,N+1):
        #N+K 시간에 K번째 높은 컵라면을 탐색해야 하는데 그런 문제가 없는 경우 예외처리.
        if len(cup_list[j]) < (j-i+1):
            continue

        if now_max_cup <  -cup_list[j][j-i]:
            now_max_deadline = j
            now_max_cup = -cup_list[j][j-i]
    
    # max로 집을 task 가 없는 경우 
    if now_max_deadline == 0 and now_max_cup == 0 :
        continue

    result += (-heapq.heappop(cup_list[now_max_deadline]))

print(result)
