import sys

input = sys.stdin.readline()
n,k = map(int, input.split())

coin_list = []
for i in range(n):
    input = int(sys.stdin.readline())
    coin_list.append(input)

#print(coin_list)
dp = [0] * (k+1)
dp[0] = 1

for now_coin in coin_list:
    for j in range(now_coin, k+1):
        dp[j] += dp[j-now_coin]

print(dp[k])
