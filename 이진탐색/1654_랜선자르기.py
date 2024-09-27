import sys

K, N = map(int, sys.stdin.readline().split())

lan_list = []
lan_max = 0

for i in range(K):
    lan_now = int(sys.stdin.readline())
    
    lan_list.append(lan_now)

    if lan_now > lan_max:
        lan_max = lan_now

start = 1
end = lan_max
result = 0

while start <= end:
    mid = (start+end) // 2
    now_count = 0

    for i in range(len(lan_list)):
        now_count += lan_list[i] // mid
    
    if now_count >= N:
        result = mid
        start = mid + 1
    else:
        end = mid - 1

print(result)