import sys

N = int(sys.stdin.readline())
sutja = list(map(int, sys.stdin.readline().split()))
yunsanja = list(map(int, sys.stdin.readline().split()))

result_max = -9999999999 # -99억
result_min = 9999999999 # 99억

def dfs(now_value, index):
    global result_max
    global result_min
    
    if index == N:
        if result_max < now_value:
            result_max = now_value
        
        if result_min > now_value:
            result_min = now_value
        
        return
    


    for i in range(4):
        #해당 연산을 할 수 없음
        if yunsanja[i] <= 0:
            continue

        yunsanja[i] -= 1
        prev = now_value
        
        if i == 0 :
            #덧셈
            now_value = now_value + sutja[index]
            dfs(now_value, index+1)
        if i == 1 :
            #뺄셈
            now_value = now_value - sutja[index]
            dfs(now_value, index+1)
        if i == 2 :
            #곱셈
            now_value = now_value * sutja[index]
            dfs(now_value, index+1)
        if i == 3 :
            #나눗셈
            if now_value < 0:
                now_value = -(-now_value // sutja[index])
            else:
                now_value = now_value // sutja[index]
            dfs(now_value, index+1)

        now_value = prev
        yunsanja[i] += 1

dfs(sutja[0],1)
print(result_max)
print(result_min)