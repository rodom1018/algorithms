import sys

N = int(sys.stdin.readline())

current_intent = list(map(int, sys.stdin.readline().split()))
ideal_intent = list(map(int, sys.stdin.readline().split()))
diff_intent = []
result = 0

for i in range(N):  
    diff_intent.append(current_intent[i] - ideal_intent[i])

for i in range(1,N):
    if diff_intent[i-1] * diff_intent[i] < 0:
        result += abs(diff_intent[i-1])
    else:
        if abs(diff_intent[i-1]) > abs(diff_intent[i]):
            result += abs(diff_intent[i-1] - diff_intent[i])
    #print(result)

result += abs(diff_intent[N-1])
print(result)

