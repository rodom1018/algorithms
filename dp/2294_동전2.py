import sys

input = sys.stdin.readline()
n, k = map(int, input.split())

coin_list = []
dp = [999999 for i in range(k+1)]
dp[0] = 0
for i in range(n):
    coin_list.append(int(sys.stdin.readline()))

for i in range(k+1):
    for now_coin in coin_list:
        if i - now_coin >= 0:
            dp[i] = min(dp[i], dp[i-now_coin] + 1)

print(dp)
if dp[k] == 999999:
    print(-1)
else:
    print(dp[k])