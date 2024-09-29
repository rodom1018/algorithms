import sys

N = int(sys.stdin.readline())
k = int(sys.stdin.readline())

start= 1
end = N*N # k로 해도 됨(k번째 요소는 k 보다 작음.)
result = -1

while start <= end:

    mid = ( start + end ) // 2

    now_count = 0

    for i in range(1,N+1):
        now_count += min(mid // i, N)

    if now_count >= k:
        result = mid
        end = mid -1  
    else:
        start = mid + 1

print(result)
    
