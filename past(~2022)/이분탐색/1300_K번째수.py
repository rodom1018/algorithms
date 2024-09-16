n = int(input())
k = int(input())

MAX = n*n
start = 1
end = MAX
answer = 0 
while start <= end:
    count = 0
    mid = (start+end)//2
    
    for i in range(1,n+1):
        count += min((mid//i), n)
    
    if count >= k:
        end = mid -1
        answer =mid
    else:
        start = mid + 1

print(answer)

    