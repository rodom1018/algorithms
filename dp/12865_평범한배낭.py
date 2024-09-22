import sys

input = sys.stdin.readline
N, K = map(int, input().split())

item_list = [(0,0)]
my_dp = [ [0] * (K+1) for i in range(N+1) ]

for i in range(N):
    input = sys.stdin.readline
    W, V = map(int, input().split())
    item_list.append((W,V))

for i in range(1,N+1):

    now_weight = item_list[i][0]
    now_value = item_list[i][1]

    for j in range(1,K+1):
        
        temp_j = j - now_weight
        if temp_j < 0 :
            my_dp[i][j] = my_dp[i-1][j]
            continue
        
        #점화식
        my_dp[i][j] = max(my_dp[i-1][temp_j]+now_value, my_dp[i-1][j])

print(my_dp[N][K])