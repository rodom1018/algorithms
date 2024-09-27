import sys

N, C = map(int, sys.stdin.readline().split())

house_list = []

for i in range(N):
    house_list.append(int(sys.stdin.readline()))

house_list.sort()

start = 1
result = 1
end = max(house_list)

while start <= end:

    mid = (start + end) // 2

    prev_pointer = 0
    count = 1
    for i in range(N):
        if house_list[i] - house_list[prev_pointer] >= mid:
            count += 1
            prev_pointer = i
    
    if count >= C:
        result = mid
        start = mid + 1
    else:
        end = mid - 1

print(result)